package ѧ����Ϣ����ϵͳ;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

class loginFrame extends JFrame implements ActionListener{
	Box box1,box2,baseBox;
	JLabel userName,userPwd,tubiao;
	JTextField nameField;
	JPasswordField pwdField;
	JButton button;
	JTabbedPane choose;
	JPanel panel1,panel2;
	loginFrame(){
		setBackground(Color.green);
		tubiao=new JLabel(new ImageIcon("image/4.png"));
		add(tubiao,BorderLayout.NORTH);
		userName=new JLabel("�˺�",JLabel.CENTER);
		userPwd=new JLabel("����",JLabel.CENTER);
		nameField=new JTextField(8);
		pwdField=new JPasswordField(8);
		panel1=new JPanel();
		panel2=new JPanel();
		choose=new JTabbedPane();
		choose.add("��ʦ��½",panel1);
		choose.add("ѧ����½",panel2);
		panel1.setLayout(new GridLayout(2,2));
		panel1.add(userName);panel1.add(nameField);
		panel1.add(userPwd);panel1.add(pwdField);
		add(choose,BorderLayout.CENTER);
		button=new JButton("��½");
		add(button,BorderLayout.SOUTH);
		button.addActionListener(this);
		ImageIcon tubiao=new ImageIcon("image/3.png");
		setIconImage(tubiao.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(400,150,300,250);
		setTitle("��½");
		validate();
	}
	public void actionPerformed(ActionEvent e){
		String name,pwd;
		name=nameField.getText();
		pwd=pwdField.getText();
		//try{
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//}
		//catch(ClassNotFoundException ex){
		//System.out.println(ex);
		//}
		try{
			Connection con;
			Statement sql;
			ResultSet rs;
			String url,userName,userPwd;
			url="jdbc:mysql://localhost:3307/StudentManager?serverTimezone=UTC&autoReconnect=true";
			userName="root";
			userPwd="test";
			con=DriverManager.getConnection(url,userName,userPwd);
			sql=con.createStatement();
			rs=sql.executeQuery("select * from student where name ='"+name+"' and password='"+pwd+"'");
			int q=0;
			while(rs.next()){
				q++;
			}
			if(q>0){
				JOptionPane.showMessageDialog(this, "��½�ɹ���","��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);
				this.dispose();
				new Frame();
				
			}
			else
				JOptionPane.showMessageDialog(this, "�˺Ż����������!","��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);
		}
		catch(SQLException exp){
			System.out.println(exp);
		}
	}
}