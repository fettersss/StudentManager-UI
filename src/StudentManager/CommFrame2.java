package StudentManager;
	import java.awt.color.*;
	import java.awt.*;
	import java.awt.event.*;

	import javax.swing.JFrame;
	import javax.swing.JMenu;
	import javax.swing.JMenuBar;
	import javax.swing.JMenuItem;
	import javax.swing.JPanel;

import Delete.Delete_gra;
import Insert.Insert_gra;
import Log.Loggable;
import Search.Search_cou;
import Search.Search_gra;
import Update.Update_cou;
import Update.Update_gra;
import Update.Update_tea;

import Log.MyLog;
import Log.Loggable;
	
	public class CommFrame2 extends JFrame implements ActionListener{
		JMenuBar bar;
		JMenu menu;
		JMenuItem scanItem,deleteItem,updateItem,insertItem,searchItem;
		JMenuItem updateItem2,searchItem2,updateItem3;
		Search_cou search2;//���ҿγ���Ϣ
		Delete_gra delete;//ɾ��ѧ���ɼ�
		Update_gra update;//����ѧ���ɼ�
		Insert_gra insert;//����ѧ���ɼ�
		Search_gra search;//����ѧ���ɼ�
		Update_cou update2;//���¿γ���Ϣ
		Update_tea update3;//�޸�����
		
		MyLog mylog = new MyLog();
		
		CardLayout card=null;
		JPanel pCenter;
		CommFrame2(){
			setLayout(new FlowLayout());
			deleteItem=new JMenuItem("ɾ���ɼ�");
			updateItem=new JMenuItem("�޸ĳɼ�");
			insertItem =new JMenuItem("��ӳɼ�");
			searchItem=new JMenuItem("���ҳɼ�");
			searchItem2=new JMenuItem("���ҿγ�");
			updateItem2=new JMenuItem("�޸Ŀγ�");
			updateItem3=new JMenuItem("�޸�����");
			
			
			bar=new JMenuBar();
			menu=new JMenu("�˵�");
			
			menu.add(deleteItem);
			menu.add(updateItem);
			menu.add(insertItem);
			menu.add(searchItem);
			menu.add(searchItem2);
			menu.add(updateItem2);
			menu.add(updateItem3);
			
			
			bar.add(menu);
			setJMenuBar(bar);
			deleteItem.addActionListener(this);
			updateItem.addActionListener(this);
			insertItem.addActionListener(this);
			searchItem.addActionListener(this);
			searchItem2.addActionListener(this);
			updateItem2.addActionListener(this);
			updateItem3.addActionListener(this);
			
			
			update=new Update_gra();
			delete=new Delete_gra();
			insert=new Insert_gra();
			search=new Search_gra();
			search2=new Search_cou();
			update2=new Update_cou();
			update3=new Update_tea();
			
			
			
			card=new CardLayout();
			pCenter=new JPanel();
			pCenter.setLayout(card);
			
			pCenter.add("deleteItem",delete);
			pCenter.add("updateItem",update);
			pCenter.add("insertItem",insert);
			pCenter.add("searchItem",search);
			
			pCenter.add("searchItem2",search2);
			pCenter.add("updateItem2",update2);
			
			pCenter.add("updateItem3",update3);
			
			
			add(pCenter,BorderLayout.SOUTH);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			setBounds(400,150,550,400);
			setTitle("ѧ����Ϣ����ϵͳ");
			validate();
			
			mylog.addLog(Loggable.TYPE.INFORMATION,  "��ͨ��ʦִ���˲���\n");
		}
		public void actionPerformed(ActionEvent e){
			 if(e.getSource()==searchItem2)
				card.show(pCenter, "searchItem2");
			 else if(e.getSource()==updateItem2)
					card.show(pCenter, "updateItem2");
			 else if(e.getSource()==deleteItem)
					card.show(pCenter, "deleteItem");	
				else if(e.getSource()==updateItem)
					card.show(pCenter, "updateItem");
				else if(e.getSource()==insertItem)
					card.show(pCenter, "insertItem");
				else if(e.getSource()==searchItem)
					card.show(pCenter, "searchItem");
				else if(e.getSource()==updateItem3)
					card.show(pCenter, "updateItem3");
		}
}