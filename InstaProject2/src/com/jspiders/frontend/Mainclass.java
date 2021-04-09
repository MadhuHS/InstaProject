package com.jspiders.frontend;

import java.sql.SQLException;
import java.util.Scanner;

import com.jspiders.models.User;
import com.jspiders.services.UserService;

public class Mainclass 
{
	public static void showMenu()
	{
		UserService us = new UserService();

		Scanner sc1 = new Scanner(System.in);
		
		System.out.println("1. Menu");
		System.out.println("Any key to Exit");
		
		String optn = sc1.next();
		
		if(optn.equals("1") == false)
		{
			System.out.println("Thank you");
			System.exit(0);
		}
		
		
		while(true)
		{
		
		try
		{
		  System.out.println("1. Signup");
		  System.out.println("2. Login");
		  System.out.println("3. Delete Profile");
		  System.out.println("4. Edit Profile");
		  System.out.println("5. Show Profile");
		  System.out.println("Any Key for Logout");
		  
		  String choice = sc1.next();
		 
		  switch(choice)
		  {
		  case "1" :User u1 = new User();
			        System.out.println("enter name "); 
			        u1.setName(sc1.next());
			        
			        System.out.println("enter email "); 
			        u1.setEmail(sc1.next());
			        
			        System.out.println("enter pwd "); 
			        u1.setPwd(sc1.next());
			        
			        System.out.println("enter mob "); 
			        u1.setMob(sc1.next());
			        
			        System.out.println("enter DOB "); 
			        u1.setDob(sc1.next());
			        
			        System.out.println("enter Gender "); 
			        u1.setGender(sc1.next()); 
			        
			        System.out.println("enter Bio "); 
			        u1.setBio(sc1.next()); 
			        
			        us.signup(u1);
			        
			        break;	
		  
		  case "2": System.out.println("enter email");
		            String entEmail = sc1.next();
		        
		            System.out.println("enter pwd");
		            String entPwd = sc1.next();
		    
			        us.login(entEmail,entPwd); 
		            break;
		            
		  case "3"://us.deleteProfile("a@gmail.com");
			         break;
		  case "4"://us.editprofile(u1);
			         break;
		  case "5" ://us.showProfile("a@gmail.com");
			        break;
			        
		  default :System.out.println("User Logged Out"); 
			       System.exit(0);        
		  }	
		
		}
		catch (Exception sqle) 
		{
		  sqle.printStackTrace();
		}
	}	
	}
	
	public static void loadDummyData(int id)
	{
		UserService us = new UserService();
		
		int n= id+100000000;
		
		User u1 = new User();
		
		for(int i=id; i<=n; i++)
		{
		try
		{
		  String name = "user";
		  name = name + i;

		  String email = name+"@gmail.com";
		  String mob = "98765432";
		  String pwd = name;
		  String gender = "male";
		  String dob = "-1-87";
		  
		  
		  mob = mob + i;
		  dob = i+dob;
		  
		  u1.setName(name);
		  u1.setEmail(email);
		  u1.setMob(mob);
		  u1.setPwd(pwd);
		  u1.setGender(gender);
		  u1.setDob(dob);
		  
		  us.signup(u1);
		  
		  
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		}
	
	}
	
	
	public static void main(String[] args) 
	{
		loadDummyData(1);
		UserService us = new UserService();
		try 
		{
			us.showAllUsers();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}




