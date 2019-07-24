package StudentManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class loginView extends JFrame implements ActionListener {
 private JTextField namefield;
 private JTextField numfield;
 private JButton button;
 private String number;
 private AbstractButton button1;
 private JComboBox box;
 
 public static String url = "jdbc:mysql://localhost:3307/StudentManager?serverTimezone=UTC&autoReconnect=true";;
	public static String user = "root"; // mysql登录名
	public static String pass = "test";// mysql登录密码（写自己之前设置的）
 public static Connection con;
 public loginView() {
  init();
 }

 private void init() {
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  setBounds(200, 200, 450, 400);
  setResizable(false);
  setLayout(null);
  //setTitle("登录界面");

  JLabel label = new JLabel("欢迎使用学生管理系统!",JLabel.CENTER);
  label.setFont(new Font("宋体", Font.BOLD, 18));
  add(label);
  label.setBounds(130, 5, 200, 200);
  
 

  JLabel label2 = new JLabel("账号");
  add(label2);
  label2.setBounds(150, 150, 100, 100);

  namefield = new JTextField();
  namefield.setBounds(200, 190, 100, 20);
  add(namefield);

  JLabel label3 = new JLabel("密码");
  add(label3);
  label3.setBounds(150, 180, 100, 100);

  numfield = new JPasswordField();
  add(numfield);
  numfield.setBounds(200, 220, 100, 20);

  JLabel label4 = new JLabel("选择身份");
  add(label4);
  label4.setBounds(130, 210, 100, 100);

  box = new JComboBox();
  box.addItem("教师");
  box.addItem("学生");
  box.addItem("教务处");
  add(box);
  box.setBounds(200, 250, 100, 20);

  button = new JButton("登录");
  add(button);
  button.setBounds(80, 300, 80, 25);
  button.addActionListener(this);

  button1 = new JButton("退出");
  add(button1);
  button1.setBounds(300, 300, 100, 25);
  button1.addActionListener(this);}
 
 public static void main(String[] args) {
	  new loginView().setVisible(true);
	 }

	 @Override
	 public void actionPerformed(ActionEvent e) {
		 String name=namefield.getText();
		 String	pwd=numfield.getText();
		 Object source = e.getSource();
		try {
			con=DriverManager.getConnection(url,user,pass);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("数据库连接成功！");
		
		
	   if (box.getSelectedItem().equals("教师")) 
		   if(source==button)
		    {
		    		String sql ="select * from teacher where tid ='"+name+"' and password='"+pwd+"'and tid like '100%'";
					PreparedStatement ptmt = null;
					try {
						ptmt = con.prepareStatement(sql);
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					ResultSet rs = null;
					try {
						rs = ptmt.executeQuery();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				int q=0;
				try {
					if(rs.next())
						q++;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(q>0){
					JOptionPane.showMessageDialog(this, "登录成功！","消息对话框",JOptionPane.WARNING_MESSAGE);
					this.dispose();
					new CommFrame2();
		     }
				else
					JOptionPane.showMessageDialog(this, "账号或者密码错误!","消息对话框",JOptionPane.WARNING_MESSAGE);
		    }
	if(box.getSelectedItem().equals("教务处")) {
	    if(source==button)
	    {
	    		String sql ="select * from teacher where tid ='"+name+"' and password='"+pwd+"'and tid like '110%'";
				PreparedStatement ptmt = null;
				try {
					ptmt = con.prepareStatement(sql);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				ResultSet rs = null;
				try {
					rs = ptmt.executeQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			int q=0;
			try {
				if(rs.next())
					q++;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(q>0){
				JOptionPane.showMessageDialog(this, "登录成功！","消息对话框",JOptionPane.WARNING_MESSAGE);
				this.dispose();
				new CommFrame();
	     } 
			else
				JOptionPane.showMessageDialog(this, "账号或者密码错误!","消息对话框",JOptionPane.WARNING_MESSAGE);
	    }
	   }
	   
	  if ((box.getSelectedItem().equals("学生"))) 
	     {  if (source == button){
	    	 String sql ="select * from student where id ='"+name+"' and password='"+pwd+"'";
				PreparedStatement ptmt = null;
				try {
					ptmt = con.prepareStatement(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResultSet rs = null;
				try {
					rs = ptmt.executeQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			int q=0;
			try {
				if(rs.next())
					q++;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(q>0){
				JOptionPane.showMessageDialog(this, "登录成功！","消息对话框",JOptionPane.WARNING_MESSAGE);
				this.dispose();
				new CommFrame1();
				
	     }
			else
				JOptionPane.showMessageDialog(this, "账号或者密码错误!","消息对话框",JOptionPane.WARNING_MESSAGE);
			}
	    } 
	    
	  if (source == button1) {
	   this.dispose();
	  }

	 }
}

