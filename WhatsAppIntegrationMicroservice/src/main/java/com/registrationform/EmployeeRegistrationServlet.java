package com.registrationform;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeRegistrationServlet
 */
@WebServlet("/EmployeeRegistrationServlet")
public class EmployeeRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ename = request.getParameter("name");
		String eDateOfBirth = request.getParameter("dateOfBirth");
		String eContactNo = request.getParameter("contactNo");
		String eDateOfJoining = request.getParameter("dateOfJoining");
		String eEmailAddress = request.getParameter("emailAddress");
		RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeDetails.jsp");
		Connection con = null;
		String redirectURL = "";		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "YOUR USER NAME", "PASSWORD");
			
			PreparedStatement pst = con.prepareStatement(
					"insert into employee(ename, eDateOfBirth, eContactNo, eDateOfJoining, eEmailAddress) values(?,?,?,?,?)");

			pst.setString(1, ename);
			pst.setString(2, eDateOfBirth);
			pst.setString(3, eContactNo);
			pst.setString(4, eDateOfJoining);
			pst.setString(5, eEmailAddress);

			int rowCount = pst.executeUpdate();
			if (rowCount > 0) {
				// Pass the data as URL parameters to EmployeeDetails.jsp
//				redirectURL = "/EmployeeDetails.jsp" + "?ename=" + ename
//						+ "&eDateOfBirth=" + eDateOfBirth + "&eContactNo=" + eContactNo + "&eDateOfJoining="
//						+ eDateOfJoining + "&eEmailAddress=" + eEmailAddress;
				//request.setAttribute("status", "failed");
				
				
				request.setAttribute("ename", ename);
				request.setAttribute("eContactNo",eContactNo);
				request.setAttribute("eDateOfBirth",eDateOfBirth);
				request.setAttribute("eDateOfJoining",eDateOfBirth);
				request.setAttribute("eEmailAddress",eEmailAddress);
				
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("status", "failed");
				
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		

	}
}
