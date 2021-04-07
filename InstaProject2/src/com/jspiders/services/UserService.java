package com.jspiders.services;

import java.sql.SQLException;

import com.jspiders.dao.MySqlImpl;
import com.jspiders.models.User;

public class UserService {

	private MySqlImpl ms = new MySqlImpl();
	
	public void login(String email,String pwd)
	{
		
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
	}
	
	public void editProfile()
	{
		
	}
	
	public void deleteProfile()
	{
		
	}
	
}
