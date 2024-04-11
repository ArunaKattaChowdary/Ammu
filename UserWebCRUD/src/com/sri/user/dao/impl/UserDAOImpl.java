package com.sri.user.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sri.user.Model.User;
import com.sri.user.dao.UserDAO;

public class UserDAOImpl implements UserDAO{
	
	private PreparedStatement prepareStatement = null;
	
	private Connection connection =null;
	
	private List<User> list = null;
	 
	private static final  String driver_Name = "com.mysql.cj.jdbc.Driver";
	
	private static final  String driver_url = "jdbc:mysql://localhost:3306/ammu?useSSL=false";
	
	private static final String sid = "root";
	
	private static final String pwd = "root";
	
	private String selectQuery = "Select * from Users";
	
	private String insertQuery = "insert into Users(name,email,country) values(?,?,?)";
	
	private String editQuery = "select * from users where id = ?";
	
	private String updateQuery = "update users set name=?,email=?,country=? where id=? ";
	
	private String deleteQuery = "delete from users where id = ? ";
	
	private Connection getconnection()
	{
		
		try
		{
			Class.forName(driver_Name);
			
			System.out.println("Driver Loaded");
			
			connection= DriverManager.getConnection(driver_url, sid , pwd);
			
			System.out.println("Driver Connected");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return connection;
		
	}
	
	public List<User> getUsersList()
	{
		
		try
		{
			list = new ArrayList<User>();
			
			connection = getconnection();
			
			 prepareStatement = connection.prepareStatement(selectQuery);
			
			ResultSet resultSet = prepareStatement.executeQuery();
			while(resultSet.next())
			{
				User user = new User();
				
				user.setUserId(resultSet.getInt(1));
				user.setUserName(resultSet.getString(2));
				user.setUserEmail(resultSet.getString(3));
				user.setUserCountry(resultSet.getString(4));
				
				list.add(user);
				
				System.out.println(user);
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		return list;
	}

	@Override
	public void insertList(User user) {
		
		
		try
		{
			
			connection = getconnection();
		
			prepareStatement = connection.prepareStatement(insertQuery);
			
			prepareStatement.setString(1, user.getUserName());
			prepareStatement.setString(2, user.getUserEmail());
			prepareStatement.setString(3, user.getUserCountry());
			
			prepareStatement.executeUpdate();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public User editUser(int userid) {
		
		User user = null;
		try
		{
			
			connection = getconnection();
			
			prepareStatement = connection.prepareStatement(editQuery);
			
			prepareStatement.setInt(1, userid);
			
			ResultSet resultSet = prepareStatement.executeQuery();
			
			resultSet.next();
			
			 user = new User();
			
			user.setUserId(resultSet.getInt(1));
			user.setUserName(resultSet.getString(2));
			user.setUserEmail(resultSet.getString(3));
			user.setUserCountry(resultSet.getString(4));
			
			System.out.println(user);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean updateUser(User user) {
		
		boolean rowUpdate = false ;
		
		try
		{
			connection = getconnection();
			
			prepareStatement = connection.prepareStatement(updateQuery);
			
			prepareStatement.setString(1, user.getUserName());
			prepareStatement.setString(2, user.getUserEmail());
			prepareStatement.setString(3, user.getUserCountry());
			prepareStatement.setInt(4, user.getUserId());
			 rowUpdate = prepareStatement.executeUpdate()>0;
			
			System.out.println("Rows are updated: "+rowUpdate);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rowUpdate;
	}

	@Override
	public boolean DeleteUser(int uid) {
		
		boolean rowdelete = false;
		
		try
		{
			
			connection = getconnection();

			prepareStatement = connection.prepareStatement(deleteQuery);
			
			prepareStatement.setInt(1, uid);
			 rowdelete = prepareStatement.executeUpdate()>0;
			
			System.out.println("Rows are updated: "+rowdelete);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rowdelete;
	}

}
