package com.jdbc.movie;
import java.sql.*;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class MovieDatabase {

	private static Connection connection = null;
	private static Scanner scanner = new Scanner("System.in");
	public static void main(String[] args) {
	MovieDatabase moviedatabase = new MovieDatabase();	
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String dbURL = "jdbc:mysql://localhost:3306/jdbcdb";
		String username= "root";
		String password = "1234";
		
		connection = DriverManager.getConnection(dbURL, username, password);
		Statement stmt=connection.createStatement();
		ResultSet rs;
	 stmt.executeUpdate("insert into movies values(1,'Godzilla vs Kong','Alexander','Millie Bobby',2021,'Adam Wingard')");
	 stmt.executeUpdate("insert into movies values(2,'Home Alone','Macaulay Culkin','Catherine O Hara',1991,'ChrisColumbus')");
	 stmt.executeUpdate("insert into movies values(3,'Dont Breath','Stephen Lang','Jane Levy',2016,'Fede Alvarez')");
	 stmt.executeQuery("select * from movies;");
	 rs = stmt.executeQuery("SELECT m_name FROM movies WHERE year=2016");
	 while (rs.next()) {
		 String m_name=rs.getString("m_name");
		 System.out.println(m_name);
	 }
	 
	 connection.close();
		if(connection.isClosed())
		{
			System.out.println("Connection is closed");
		}else
		{
			System.out.println("Connection is created");
		}
		} catch(Exception e) 
		{ 
		e.printStackTrace();
		}

	}
	
	
}
