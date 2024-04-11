package com.sri.user.dao;

import java.util.List;

import com.sri.user.Model.User;

public interface UserDAO {
	
	public abstract List<User> getUsersList();

	public abstract void insertList(User user);

	public abstract User editUser(int userid);

	public abstract boolean updateUser(User user);

	public abstract boolean DeleteUser(int uid);


}
