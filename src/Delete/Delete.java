package Delete;


import javax.swing.*;
 
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class Delete extends JFrame{
	String tableName;
	JTextField field[]=null;
	String a[]=null;
	public void setTableName(String s){
		tableName=s.trim();
	}
	public void setField(JTextField s[]){
		field=s;
	}
	public void setA(String e[]){
		a=e;
	}
	public Delete(){
		
	}
	public void  Execute_Delete(int n){
		String SQL="";
		Connection con;
		Statement sql;
		SQL="delete from "+tableName+" where "+a[n]+" ='"+field[n].getText().toString()+"'";
		try{
			String url,userName,userPwd;
			url="jdbc:mysql://localhost:3307/StudentManager?serverTimezone=UTC&autoReconnect=true";
			userName="root";
			userPwd="test";
			con=DriverManager.getConnection(url,userName,userPwd);
			sql=con.createStatement();
			sql.executeUpdate(SQL);
			con.close();
			JOptionPane.showMessageDialog(this, "删除成功","消息对话框",JOptionPane.WARNING_MESSAGE);
			for(int i=0;i<field.length;i++)
				field[i].setText(null);;
		}
		catch(SQLException ex){
			System.out.println(ex);
		}
	}


}
