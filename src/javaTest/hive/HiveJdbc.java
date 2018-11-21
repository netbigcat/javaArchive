package javaTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;  
import java.sql.Statement;



public class HiveJdbc{
	private static String HiveDriver="org.apache.hive.jdbc.HiveDriver";
	private static String url="jdbc:hive2://172.18.51.126:10000/default";
	private static String name="cloud";
	private static String password="";
	public static void main(String[] args){
		try{
			Class.forName(HiveDriver);
			Connection conn=DriverManager.getConnection(url,name,password);
			Statement stat=conn.createStatement();
			String sql1="show tables";
			//String sql2="select * from pv";
			ResultSet rs=stat.executeQuery(sql1);
			//while(rs.next()){
			//	System.out.println(rs.getString(1));
			//} 
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}