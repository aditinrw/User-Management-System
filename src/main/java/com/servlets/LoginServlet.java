package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email1 = req.getParameter("email");
		String password1 = req.getParameter("password");
		PrintWriter out =resp.getWriter();
		HttpSession session = req.getSession();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/UserSecond","root","Student@321");
			PreparedStatement ps =c.prepareStatement("select * from userssecond where email=? and password=?");
			ps.setString(1, email1);
			ps.setString(2, password1);
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next()) {
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String mobNo = rs.getString("mobNo");
				String dob = rs.getString("dob");
				String gender = rs.getString("gender"); //value male/female
				int semester = rs.getInt("semester");
				int class10 = rs.getInt("class10Percentage");
				int class12 = rs.getInt("class12Percentage");
				int graduation = rs.getInt("graduationPercentage");
				String specaial = rs.getString("specialization");
				String status = rs.getString("experienceStatus"); //value fresher/experienced
				
			    session.setAttribute("firstName", firstName);
			    session.setAttribute("lastName", lastName);
			    session.setAttribute("email", email);
			    session.setAttribute("password", password);
			    session.setAttribute("mobNo", mobNo);
			    session.setAttribute("dob", dob);
			    session.setAttribute("gender", gender);
			    session.setAttribute("semester", semester);
			    session.setAttribute("class10", class10);
			    session.setAttribute("class12", class12);
			    session.setAttribute("graduation", graduation);
			    session.setAttribute("specaial", specaial);
			    session.setAttribute("status", status);
				
			    RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
			    rd.forward(req, resp);
			}else {
				session.setAttribute("errorMessage","Invalid username or password");
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			    rd.include(req, resp);
			}
		}catch(ClassNotFoundException e) {
			out.print("Server Error");
		} catch (SQLException e) {
			out.print("Server Error");
		}
	}

}
