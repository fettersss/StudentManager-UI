package StudentManager;
import java.awt.color.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Delete.Delete_cou;
import Delete.Delete_stu;
import Insert.Insert_cou;
import Insert.Insert_stu;
import Log.Loggable;
import Log.MyLog;
import Search.Search_cou;
import Search.Search_stu;
import Update.Update_cou;
import Update.Update_stu;
import Update.Update_tea;

public class CommFrame extends JFrame implements ActionListener{
	private JButton button;
	
	JMenuBar bar;
	JMenu menu;
	JMenuItem scanItem,scanItem2,deleteItem,updateItem,insertItem,searchItem;
	JMenuItem deleteItem2,updateItem2,insertItem2,searchItem2,updateItem3;
	Scan_stu scan;//查看所有学生信息
	Delete_stu delete;//删除学生信息
	Update_stu update;//更新学生信息
	Insert_stu insert;//插入学生信息
	Search_stu search;//查找学生信息
	Delete_cou delete2;//删除课程信息
	Update_cou update2;//更新课程信息
	Insert_cou insert2;//插入课程信息
	Search_cou search2;//查找课程信息
	Scan_gra scan2;//查看成绩信息
	Update_tea update3;//修改密码
		
	CardLayout card=null;
	JPanel pCenter;
	MyLog mylog = new MyLog();
	
	private void init() {
		button = new JButton("退出");
		  add(button);
		  button.setBounds(300, 300, 100, 25);
		  button.addActionListener(this);
		  }
	
	CommFrame(){
		setLayout(new FlowLayout());
		scanItem=new JMenuItem("学生信息浏览");
		scanItem2=new JMenuItem("成绩浏览");
		deleteItem=new JMenuItem("删除学生信息");
		updateItem=new JMenuItem("修改学生信息");
		insertItem =new JMenuItem("添加学生信息");
		searchItem=new JMenuItem("查找学生信息");
		deleteItem2=new JMenuItem("删除课程");
		updateItem2=new JMenuItem("修改课程");
		insertItem2 =new JMenuItem("添加课程");
		searchItem2=new JMenuItem("查找课程");
		updateItem3=new JMenuItem("修改密码");
		bar=new JMenuBar();
		menu=new JMenu("菜单");
		menu.add(scanItem);
		menu.add(scanItem2);
		menu.add(deleteItem);
		menu.add(updateItem);
		menu.add(insertItem);
		menu.add(searchItem);
		menu.add(deleteItem2);
		menu.add(updateItem2);
		menu.add(insertItem2);
		menu.add(searchItem2);
		menu.add(updateItem3);
		bar.add(menu);
		setJMenuBar(bar);
		scanItem.addActionListener(this);
		scanItem2.addActionListener(this);
		deleteItem.addActionListener(this);
		updateItem.addActionListener(this);
		insertItem.addActionListener(this);
		searchItem.addActionListener(this);
		deleteItem2.addActionListener(this);
		updateItem2.addActionListener(this);
		insertItem2.addActionListener(this);
		searchItem2.addActionListener(this);
		updateItem3.addActionListener(this);
		
		scan=new Scan_stu();
		scan2=new Scan_gra();
		update=new Update_stu();
		delete=new Delete_stu();
		insert=new Insert_stu();
		search=new Search_stu();
		update2=new Update_cou();
		delete2=new Delete_cou();
		insert2=new Insert_cou();
		search2=new Search_cou();
		update3=new Update_tea();
		
		card=new CardLayout();
		pCenter=new JPanel();
		pCenter.setLayout(card);
		pCenter.add("scanItem", scan);
		pCenter.add("scanItem2", scan2);
		
		pCenter.add("deleteItem",delete);
		pCenter.add("updateItem",update);
		pCenter.add("insertItem",insert);
		pCenter.add("searchItem",search);
		
		pCenter.add("deleteItem2",delete2);
		pCenter.add("updateItem2",update2);
		pCenter.add("insertItem2",insert2);
		pCenter.add("searchItem2",search2);
		
		pCenter.add("updateItem3",update3);
		
		
		add(pCenter,BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(400,150,550,400);
		setTitle("学生信息管理系统");
		validate();
		
		mylog.addLog(Loggable.TYPE.INFORMATION,  "普通老师执行了操作\n");
	}
	public static void main(String[] args) {
		  new loginView().setVisible(true);
		 }
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==scanItem)
			card.show(pCenter, "scanItem");
		else if(e.getSource()==scanItem2)
			card.show(pCenter, "scanItem2");
		else if(e.getSource()==deleteItem)
			card.show(pCenter, "deleteItem");	
		else if(e.getSource()==updateItem)
			card.show(pCenter, "updateItem");
		else if(e.getSource()==insertItem)
			card.show(pCenter, "insertItem");
		else if(e.getSource()==searchItem)
			card.show(pCenter, "searchItem");
		else if(e.getSource()==deleteItem2)
			card.show(pCenter, "deleteItem2");	
		else if(e.getSource()==updateItem2)
			card.show(pCenter, "updateItem2");
		else if(e.getSource()==insertItem2)
			card.show(pCenter, "insertItem2");
		else if(e.getSource()==searchItem2)
			card.show(pCenter, "searchItem2");
		else if(e.getSource()==updateItem3)
			card.show(pCenter, "updateItem3");
		
		
		Object source = e.getSource();if (source == button) {
			   this.dispose();
			  }
	}
}

