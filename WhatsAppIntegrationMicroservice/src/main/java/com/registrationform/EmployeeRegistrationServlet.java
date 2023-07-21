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
		RequestDispatcher dispatcher = null;
		Connection con = null;

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Registration Form</title>");
		// Add any required CSS or other header content here
		out.println("</head>");
		out.println("<body>");

		out.println("<div class=\"container\">");
		out.println("<h1 class=\"inline-heading\">Employment Registration Form</h1>");

		out.println("<form method=\"post\" action=\"EmployeeRegistrationServlet\">");

		out.println("<div class=\"outer-form-group\">");
		out.println("<div class=\"inner-form-group\">");
		out.println("<label for=\"name\" class=\"form-label\">Name</label>");
		out.println("<input type=\"text\" class=\"form-control\" id=\"name\" name=\"name\">");
		out.println("</div>");
		out.println("</div>");

		out.println("<div class=\"outer-form-group\">");
		out.println("<div class=\"inner-form-group\">");
		out.println("<label for=\"dateOfBirth\" class=\"form-label\">Date Of Birth</label>");
		out.println("<input type=\"date\" class=\"form-control\" id=\"dateOfBirth\" name=\"dateOfBirth\">");
		out.println("</div>");
		out.println("</div>");

		out.println("<div class=\"outer-form-group\">");
		out.println("<div class=\"inner-form-group\">");
		out.println("<label for=\"contactNo\" class=\"form-label\">Contact No.</label>");
		out.println("<input type=\"tel\" class=\"form-control\" id=\"contactNo\" name=\"contactNo\">");
		out.println("</div>");
		out.println("</div>");

		out.println("<div class=\"outer-form-group\">");
		out.println("<div class=\"inner-form-group\">");
		out.println("<label for=\"dateOfJoining\" class=\"form-label\">Date Of Joining</label>");
		out.println("<input type=\"date\" class=\"form-control\" id=\"dateOfJoining\" name=\"dateOfJoining\">");
		out.println("</div>");
		out.println("</div>");

		out.println("<div class=\"outer-form-group\">");
		out.println("<div class=\"inner-form-group\">");
		out.println("<label for=\"emailAddress\" class=\"form-label\">Email Address</label>");
		out.println("<input type=\"email\" class=\"form-control\" id=\"emailAddress\" name=\"emailAddress\">");
		out.println("</div>");
		out.println("</div>");

		out.println("<div style=\"display: flex\">");
		out.println("<button type=\"submit\" class=\"btn btn-primary\">Save</button>");
		out.println("</div>");

		out.println("</form>");
		out.println("</div>");

		out.println("</body>");
		out.println("</html>");

		out.close();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "Godsaveus57");
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
				
				String redirectURL = "/WhatsAppIntegrationMicroservice/EmployeeDetails.jsp" + "?ename=" + ename + "&eDateOfBirth=" + eDateOfBirth
						+ "&eContactNo=" + eContactNo + "&eDateOfJoining=" + eDateOfJoining + "&eEmailAddress="
						+ eEmailAddress;
				response.sendRedirect(redirectURL);
			} else {
				request.setAttribute("status", "failed");
				dispatcher = request.getRequestDispatcher("EmployeeDetails.jsp");
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
