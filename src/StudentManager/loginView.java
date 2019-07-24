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
	public static String user = "root"; // mysql��¼��
	public static String pass = "test";// mysql��¼���루д�Լ�֮ǰ���õģ�
 public static Connection con;
 public loginView() {
  init();
 }

 private void init() {
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  setBounds(200, 200, 450, 400);
  setResizable(false);
  setLayout(null);
  //setTitle("��¼����");

  JLabel label = new JLabel("��ӭʹ��ѧ������ϵͳ!",JLabel.CENTER);
  label.setFont(new Font("����", Font.BOLD, 18));
  add(label);
  label.setBounds(130, 5, 200, 200);
  
 

  JLabel label2 = new JLabel("�˺�");
  add(label2);
  label2.setBounds(150, 150, 100, 100);

  namefield = new JTextField();
  namefield.setBounds(200, 190, 100, 20);
  add(namefield);

  JLabel label3 = new JLabel("����");
  add(label3);
  label3.setBounds(150, 180, 100, 100);

  numfield = new JPasswordField();
  add(numfield);
  numfield.setBounds(200, 220, 100, 20);

  JLabel label4 = new JLabel("ѡ�����");
  add(label4);
  label4.setBounds(130, 210, 100, 100);

  box = new JComboBox();
  box.addItem("��ʦ");
  box.addItem("ѧ��");
  box.addItem("����");
  add(box);
  box.setBounds(200, 250, 100, 20);

  button = new JButton("��¼");
  add(button);
  button.setBounds(80, 300, 80, 25);
  button.addActionListener(this);

  button1 = new JButton("�˳�");
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
		System.out.println("���ݿ����ӳɹ���");
		
		
	   if (box.getSelectedItem().equals("��ʦ")) 
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
					JOptionPane.showMessageDialog(this, "��¼�ɹ���","��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);
					this.dispose();
					new CommFrame2();
		     }
				else
					JOptionPane.showMessageDialog(this, "�˺Ż����������!","��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);
		    }
	if(box.getSelectedItem().equals("����")) {
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
				JOptionPane.showMessageDialog(this, "��¼�ɹ���","��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);
				this.dispose();
				new CommFrame();
	     } 
			else
				JOptionPane.showMessageDialog(this, "�˺Ż����������!","��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);
	    }
	   }
	   
	  if ((box.getSelectedItem().equals("ѧ��"))) 
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
				JOptionPane.showMessageDialog(this, "��¼�ɹ���","��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);
				this.dispose();
				new CommFrame1();
				
	     }
			else
				JOptionPane.showMessageDialog(this, "�˺Ż����������!","��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);
			}
	    } 
	    
	  if (source == button1) {
	   this.dispose();
	  }

	 }
}

