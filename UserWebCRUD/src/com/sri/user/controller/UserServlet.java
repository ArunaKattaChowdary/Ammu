package com.sri.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sri.user.Model.User;
import com.sri.user.dao.UserDAO;
import com.sri.user.dao.impl.UserDAOImpl;
@WebServlet("/")
public class UserServlet extends HttpServlet{
	
	private UserDAO udi =null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		udi = new UserDAOImpl();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DoPost Method Called");
		
		try
		{
			String action = request.getServletPath();
			
			System.out.println("action: "+action);
			
			switch(action)
			{
				case "/new":
						newUsersList(request,response);
						break;
					
				case "/insert":
						newUserInsert(request,response);
						break;
					
				case "/edit":
						editUser(request,response);
						break;
				case "/update":
					userUpdate(request,response);
					break;
				case "/delete":
					userDelete(request,response);
					break;
				default:
					System.out.println("Default method called in switch case");
					
					showUsersList(request,response);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	private void userDelete(HttpServletRequest request, HttpServletResponse response) {
		try
		{
			int uid = Integer.parseInt(request.getParameter("id"));
			
			udi.DeleteUser(uid);
			
			response.sendRedirect("uList");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	private void userUpdate(HttpServletRequest request, HttpServletResponse response) {
		try
		{
			int uid = Integer.parseInt(request.getParameter("uid"));
			
			//System.out.println(uid);
			
			String name = request.getParameter("name");
			
			//System.out.println(name);
			
			String email = request.getParameter("email");
			
			//System.out.println(email);
			
			String country = request.getParameter("country");
			
			//System.out.println(country);
			
			User user = new User();
			
			user.setUserId(uid);
			user.setUserName(name);
			user.setUserEmail(email);
			user.setUserCountry(country);
			
			udi.updateUser(user);
			
			response.sendRedirect("uList");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	private void editUser(HttpServletRequest request, HttpServletResponse response) {
		try
		{
			int userid = Integer.parseInt(request.getParameter("id"));
			
			User user=udi.editUser(userid);
			
			request.setAttribute("user", user);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("UserEditForm.jsp");
			
			requestDispatcher.include(request, response);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public void showUsersList(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			List<User> usersList = udi.getUsersList();
			
			System.out.println(usersList);
			
			request.setAttribute("uList", usersList);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("UsersList.jsp");
		
			requestDispatcher.include(request, response);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private void newUsersList(HttpServletRequest request, HttpServletResponse response) {
		
		try
		{
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("UserForm.jsp");
			
			requestDispatcher.include(request, response);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	private void newUserInsert(HttpServletRequest request, HttpServletResponse response) {
		
		try
		{
			User user = new User();
			
			user.setUserName(request.getParameter("name"));
			user.setUserEmail(request.getParameter("email"));
			user.setUserCountry(request.getParameter("country"));
			
			udi.insertList(user);
			
			response.sendRedirect("uList");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("DoGet Method Called");
		doPost(request, response);
	}

}
