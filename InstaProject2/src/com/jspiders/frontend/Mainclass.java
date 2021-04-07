package com.jspiders.frontend;

import java.sql.SQLException;
import java.util.Scanner;

import com.jspiders.models.User;
import com.jspiders.services.UserService;

public class Mainclass
{
	public static void main(String[] args) 
	{
		UserService us = new UserService();

		User u1 = new User();
		
		Scanner sc1 = new Scanner(System.in);
		
		
		
		while(0==0)
		{
		
		System.out.println("1. Signup");
		System.out.println("2. Login");
		System.out.println("3. Edit Profile");
		System.out.println("4. Delete Profile");
		System.out.println("Any Key to Logout");
		
		int choice = sc1.nextInt();
		
		switch (choice) 
		{
		case 1: System.out.println("Enter name");
			    String name = sc1.next();
			    u1.setName(name);
			    
			    System.out.println("Enter email");
		        u1.setEmail(sc1.next());
		        
		        System.out.println("Enter mob");
		        u1.setMob(sc1.next());
		        
		        System.out.println("Enter pwd");
		        u1.setPwd(sc1.next());
		        
		        System.out.println("Enter dob");
		        u1.setDob(sc1.next());
		        
		        System.out.println("Enter gender");
		        u1.setGender(sc1.next());
		            
			try 
			{
				us.signup(u1);
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
			break;
	
		default: System.out.println("User logout");
			    System.exit(0);
			break;
		}
		
		System.out.println(u1.toString());

	}
		

		

		
	}
}
