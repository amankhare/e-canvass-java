package com.dbutil;
import java.sql.*;
public class CRUDOperation
{
	private static Connection con = null;
	public static Connection createConection()
	{
		try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e-canvass","root","root");
		System.out.println(con);
		}
	catch(ClassNotFoundException |SQLException cse){
		System.out.println(cse);
	}
	return con;
	
}
}
