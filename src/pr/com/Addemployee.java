package pr.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Addemployee extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String name = req.getParameter("firstname");
		String lname = req.getParameter("lastname");
		String phone = req.getParameter("Mobileno");
		String email = req.getParameter("email");
		String address = req.getParameter("Address");
		String pass = req.getParameter("password");

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaibhav", "root", "root");

			PreparedStatement ps = con.prepareStatement(
					"insert into addemp (`firstname`,`lastname`,`Mobileno`,`email`,`Address`,`password`) values( ?,?,?,?,?,? )");
			ps.setString(1, name);
			ps.setString(2, lname);
			ps.setString(3, phone);
			ps.setString(4, address);
			ps.setString(5, email);
			ps.setString(6, pass);
			
		

			int result = ps.executeUpdate();

			if (result == 1) {
				req.setAttribute("SuccessMsg", "Employee Added Successfully...!");
			} else {
				req.setAttribute("error", "Uneble to add data");
			}

		} catch (Exception e) {
			System.out.println(e);
			req.setAttribute("error", "Uneble to add data ");

		}
		RequestDispatcher rd = req.getRequestDispatcher("add.jsp");
		rd.forward(req, res);

		System.out.println(name);
		System.out.println(lname);
		System.out.println(phone);
		System.out.println(address);
		System.out.println(email);
		System.out.println(pass);

	}

}
