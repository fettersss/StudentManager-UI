package StudentManager;
	import java.awt.color.*;
	import java.awt.*;
	import java.awt.event.*;

	import javax.swing.JFrame;
	import javax.swing.JMenu;
	import javax.swing.JMenuBar;
	import javax.swing.JMenuItem;
	import javax.swing.JPanel;

import Search.Search_gra;
import Search.Search_stu;
import Update.Update_stu;


	public class CommFrame1 extends JFrame implements ActionListener{
		JMenuBar bar;
		JMenu menu;
		JMenuItem searchItem,searchItem2,updateItem;
		
		Search_stu search;//����ѧ����Ϣ
		Search_gra search2;//��ѯ�ɼ�
		Update_stu update;//�޸�����
		
		
		CardLayout card=null;
		JPanel pCenter;
		CommFrame1(){
			setLayout(new FlowLayout());
			searchItem2=new JMenuItem("��ѯ���˳ɼ�");
			searchItem=new JMenuItem("���Ҹ�����Ϣ");
			updateItem=new JMenuItem("�޸�����");
			
			bar=new JMenuBar();
			menu=new JMenu("�˵�");
			menu.add(searchItem2);
			menu.add(searchItem);
			menu.add(updateItem);
			
			bar.add(menu);
			setJMenuBar(bar);
			
			searchItem.addActionListener(this);
			searchItem2.addActionListener(this);
			updateItem.addActionListener(this);
			
			search=new Search_stu();
			search2=new Search_gra();
			update=new Update_stu();
			
			card=new CardLayout();
			pCenter=new JPanel();
			pCenter.setLayout(card);
			
			pCenter.add("searchItem",search);
			pCenter.add("searchItem2",search2);
			pCenter.add("updateItem",update);
			
			add(pCenter,BorderLayout.SOUTH);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			setBounds(400,150,550,400);
			setTitle("ѧ����Ϣ����ϵͳ");
			validate();
			
			
		}
		public void actionPerformed(ActionEvent e){
			 if(e.getSource()==searchItem)
				card.show(pCenter, "searchItem");
			 else if(e.getSource()==searchItem2)
					card.show(pCenter, "searchItem2");
			 else if(e.getSource()==updateItem)
					card.show(pCenter, "updateItem");
		}
}
