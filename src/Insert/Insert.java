package Insert;


import javax.swing.*;

import Update.Update;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class Insert extends JFrame{
	String tableName;
	JTextField field[]=null;
	String a[]=null;
	Update update;
	public void setTableName(String s){
		tableName=s.trim();
	}
	public void setField(JTextField s[]){
		field=s;
	}
	public void setA(String e[]){
		a=e;
	}
	public Insert(){
		
	}
	public void  Execute_Insert(int mark){
		String SQL;
		Connection con;
		Statement sql;
		try{
			String url,userName,userPwd;
			url="jdbc:mysql://localhost:3307/StudentManager?serverTimezone=UTC&autoReconnect=true";
			userName="root";
			userPwd="test";
			SQL="insert "+tableName+"("+a[mark]+") values ('"+field[mark].getText().toString()+"')";
			con=DriverManager.getConnection(url,userName,userPwd);
			sql=con.createStatement();
			sql.execute(SQL);
			con.close();
			update =new Update();
			update.setTableName(tableName);
			update.setField(field);
			update.setA(a);
			update.Execute_Update(mark);
			JOptionPane.showMessageDialog(this, "添加成功！！！","消息对话框",JOptionPane.WARNING_MESSAGE);
			for(int i=0;i<field.length;i++)
				field[i].setText(null);;
		}
		catch(SQLException ex){
			System.out.println(ex);
		}
	}
}

























