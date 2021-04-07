package com.jspiders.frontend;

import java.sql.SQLException;

import com.jspiders.models.User;
import com.jspiders.services.UserService;

public class Mainclass
{
	public static void main(String[] args) 
	{
		UserService us = new UserService();

		User u1 = new User();

		u1.setName("user1");
		u1.setEmail("user1@gmail.com");
		u1.setMob(9891289128l);
		u1.setPwd("1234");
		u1.setDob("12-Dec-82");
		u1.setGender("Male");

		try {
			us.signup(u1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
