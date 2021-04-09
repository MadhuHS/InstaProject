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
	private String getUser = "select email,pwd from usersdb.instausers where email = ?";
	private String delteUserbyemail = "delete from usersdb.instausers where email = ?";
	private String getUserProfile = "select * from usersdb.instausers where email = ?";
	private String getAllUserProfiles = "select * from usersdb.instausers";

	@Override
	public void initDB() throws SQLException {
		con = DriverManager.getConnection(url + dbname, dbusername, dbuserpwd);
		stmt = con.createStatement();
	}

	@Override
	public void closeDB() throws SQLException {
		con.close();
	}

	@Override
	public int insert(User us) throws SQLException {
		pms = con.prepareStatement(insertUser);
		pms.setInt(1, 0);
		pms.setString(2, us.getName());
		pms.setString(3, us.getEmail());
		pms.setString(4, us.getMob());
		pms.setString(5, us.getPwd());
		pms.setString(6, us.getDob());
		pms.setString(7, us.getGender());
		pms.setString(8, us.getBio());

		int count = pms.executeUpdate();

		return count;
	}

	@Override
	public int update(User us) throws SQLException {

		return 0;
	}

	@Override
	public int deleteByEmail(String email) throws SQLException {
		pms = con.prepareStatement(delteUserbyemail);
		pms.setNString(1, email);
		int count = pms.executeUpdate();
		return count;
	}

	@Override
	public int deleteByMob(String mob) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getUserByEmail(String email) throws SQLException {
		pms = con.prepareStatement(getUser);
		pms.setString(1, email);

		ResultSet rs = pms.executeQuery();
		rs.next();

		String userEmail = rs.getString(1);
		String userPwd = rs.getString(2);

		User u1 = new User();
		u1.setEmail(userEmail);
		u1.setPwd(userPwd);

		return u1;
	}

	@Override
	public User getUserProfileByEmail(String email) throws SQLException {
		pms = con.prepareStatement(getUserProfile);
		pms.setString(1, email);

		ResultSet rs = pms.executeQuery();
		rs.next();

		User u1 = new User();
		u1.setName(rs.getString(2));
		u1.setEmail(rs.getString(3));
		u1.setMob(rs.getString(4));
		u1.setDob(rs.getString(6));
		u1.setGender(rs.getString(7));
		u1.setBio(rs.getString(8));

		return u1;
	}

	@Override
	public User[] getAllUsers() throws SQLException
	{
		pms = con.prepareStatement(getAllUserProfiles);
		
	    ResultSet rs = pms.executeQuery();
	    
	    String countRecords = "select count(*) from usersdb.instausers";
	   
	    PreparedStatement pms2 = con.prepareStatement(countRecords);
	    ResultSet rs2 = pms2.executeQuery();
	    
	    rs2.next();
	    int len = rs2.getInt(1);

	    User[] users = new User[len];
	    
	    int index = 0;
	    while(rs.next() == true)
	    {
        
	    users[index]  = new User();
	    users[index].setName(rs.getString(2));
	    users[index].setEmail(rs.getString(3));
	    users[index].setMob(rs.getString(4));
	    users[index].setDob(rs.getString(6));
	    users[index].setGender(rs.getString(7));
	    users[index].setBio(rs.getString(8));
	    
	    index++;
	    }
	    
	    
	    return users;

	}
}
