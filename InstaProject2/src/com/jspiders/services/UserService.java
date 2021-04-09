package com.jspiders.services;

import java.sql.SQLException;

import com.jspiders.dao.MySqlImpl;
import com.jspiders.models.User;

public class UserService {

	private MySqlImpl ms = new MySqlImpl();
	
	public void login(String entEmail,String entPwd) throws SQLException
	{
	  /*Step1 : getUserByEmail(email) --> 
		Step2 : get email and pwd from the ResultSet
		Step3 : compare entEmil with email AND entPwd pwd
		Step4 : if->match-> login done
		          ->not match -> invalid email OR pwd
		*/
		
		ms.initDB();
		
		User u1  = ms.getUserByEmail(entEmail);
		
		String dbEmail = u1.getEmail();
		String dbpwd   = u1.getPwd();
		
		if(entEmail.equals(dbEmail) && entPwd.equals(dbpwd))
		{
			System.out.println("User Logged in");
		}
		else
		{
			System.out.println("Invalid Email or Password");
		}
		
		ms.closeDB();
	}
	
	public void signup(User us) throws SQLException
	{
		ms.initDB();
		
		int count = ms.insert(us);
		
		if(count > 0)
		{
			System.out.println("User Profile Created");
		}
		else
		{
			System.out.println("Error whil Creating User Profile");
		}
		
		ms.closeDB();
	}
	
	public void editProfile(User u1)
	{
	 //after update 
	}
	
	public void deleteProfile(String email) throws SQLException
	{
         ms.initDB();
		
        int count = ms.deleteByEmail(email);
		
		if(count > 0)
		{
			System.out.println("User Profile DELETED");
		}
		else
		{
			System.out.println("Error while deleting User Profile");
		}
		
		ms.closeDB();
	  
	}
	
	public void showProfile(String email)throws SQLException
	{
	    ms.initDB();
		
		User u1  = ms.getUserProfileByEmail(email);
		
		System.out.println(u1.toString());
		
		ms.closeDB();
	}
	
	public void showAllUsers() throws SQLException
	{
		ms.initDB();
		User[] users = ms.getAllUsers();
		
		for (int i = 0; i < users.length; i++) 
		{
			System.out.println(users[i]);
		}
		ms.closeDB();
		
		
	}
	
	
	
	public void logout() throws SQLException
	{
	  ms.closeDB();
	}
	
	
}





