package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ForgotServlet")
public class ForgotServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String newPassword = req.getParameter("newPassword");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/UserSecond","root","Student@321");
			PreparedStatement ps = c.prepareStatement("update usersSecond set password=? where email=? ");
			ps.setString(1, newPassword);
			ps.setString(2, email);
			
			int i =ps.executeUpdate();
			if(i>0) {
				resp.sendRedirect("login.jsp");
			}
			else {
				resp.sendRedirect("forget.html");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}


