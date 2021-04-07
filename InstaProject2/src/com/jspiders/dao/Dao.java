package com.jspiders.dao;

import java.sql.SQLException;

import com.jspiders.models.User;

public interface Dao 
{
   public void initDB()throws SQLException;
   
   public int insert(User us)throws SQLException;
     
   public void closeDB()throws SQLException;
}
