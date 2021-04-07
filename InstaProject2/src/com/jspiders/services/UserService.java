package com.jspiders.services;

import java.sql.SQLException;

import com.jspiders.dao.MySqlImpl;
import com.jspiders.models.User;

public class UserService {

	private MySqlImpl ms = new MySqlImpl();
	
	public void login(String entEmail,String entPwd)
	{
	  /*Step1 : getUserByEmail(email) --> 
		Step2 : get email and pwd from the ResultSet
		Step3 : compare entEmil with email AND entPwd pwd
		Step4 : if->match-> login done
		          ->not match -> invalid email OR pwd
		*/

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
	
	public void deleteProfile()
	{
		
	}
	
	public void showProfile(String email)
	{
	  //getUserByEmail(email)	
	}
	
	
}
