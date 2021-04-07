package com.jspiders.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jspiders.models.User;

public class MySqlImpl implements Dao {

	private String url = "jdbc:mysql://localhost:3306/";
	private String dbname = "usersdb";
	private String dbusername = "root";
	private String dbuserpwd = "root";
	private Statement stmt;
	private PreparedStatement pms;
	private Connection con;
	
	private String insertUser = "insert into usersdb.instausers values(?,?,?,?,?,?,?,?)";
	
	@Override
	public void initDB()throws SQLException
	{
		con  = DriverManager.getConnection(url+dbname,dbusername,dbuserpwd);
		stmt = con.createStatement();
	}

	@Override
	public void closeDB()throws SQLException 
	{
	  con.close();
	}

	@Override
	public int insert(User us) throws SQLException 
	{
	   pms = con.prepareStatement(insertUser);
	   pms.setInt(1,0);
	   pms.setString(2,us.getName());
	   pms.setString(3,us.getEmail());
	   pms.setString(4,us.getMob());
	   pms.setString(5,us.getPwd());
	   pms.setString(6,us.getDob());
	   pms.setString(7,us.getGender());
	   pms.setString(8,us.getBio());
	   	   
	   int count = pms.executeUpdate();
	   
	   return count;
	}

	@Override
	public int update(User us) throws SQLException 
	{
		
		return 0;
	}

	@Override
	public int deleteByEmail(String email) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByMob(String mob) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getUserByEmail(String Email) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}










