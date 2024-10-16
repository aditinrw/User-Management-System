package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/RegistrationFormServlet")
public class RegistrationFormServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("first-name"); 
		String lastName = req.getParameter("last-name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String mobNo = req.getParameter("mob-no");
		String dob = req.getParameter("dob");
		String gender = req.getParameter("gender");
		int semester = Integer.parseInt(req.getParameter("semester"));
		int class10Percentage = Integer.parseInt(req.getParameter("class10-percentage"));
		int class12Percentage = Integer.parseInt(req.getParameter("class12-percentage"));
		int graduationPercentage = Integer.parseInt(req.getParameter("graduation-percentage"));
		String specialization = req.getParameter("specialization");
		String experienceStatus = req.getParameter("experience-status");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/UserSecond","root","Student@321");
			PreparedStatement ps = c.prepareStatement("insert into usersSecond(firstName, lastName, email, password, mobNo, dob, gender, semester, class10Percentage, class12Percentage, graduationPercentage,  specialization, experienceStatus) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,firstName);
			ps.setString(2,lastName);
			ps.setString(3,email);
			ps.setString(4,password);
			ps.setString(5,mobNo);
			ps.setString(6,dob);
			ps.setString(7, gender); //value male/female
			ps.setInt(8, semester);
			ps.setInt(9,class10Percentage);
			ps.setInt(10,class12Percentage);
			ps.setInt(11, graduationPercentage);
			ps.setString(12,specialization );
			ps.setString(13,experienceStatus); //value fresher/experienced
			
			int i =ps.executeUpdate();
			if(i>0) {
				resp.sendRedirect("login.jsp");
			}
			else {
				resp.sendRedirect("index.html");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
