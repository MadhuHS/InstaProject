package com.jspiders.dao;

import java.sql.SQLException;

import com.jspiders.models.User;

public interface Dao 
{
   public void initDB()throws SQLException;
   
   public int insert(User us)throws SQLException;
   public int update(User us)throws SQLException;
   public int deleteByEmail(String email)throws SQLException;
   public int deleteByMob(String mob)throws SQLException;
   
   public User getUserByEmail(String Email)throws SQLException;
  
   public User getUserProfileByEmail(String Email)throws SQLException;
   
   public User[] getAllUsers() throws SQLException;
   
   
     
   public void closeDB()throws SQLException;
}
