package pr.com;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.PreparableStatement;

public class selectemp extends HttpServlet {

	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

       int id= Integer.parseInt(req.getParameter("id"));
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaibhav", "root", "root");

			PreparedStatement ps = con.prepareStatement("select * from addemp where id = ?");
			
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			String id1 = rs.getString("id");		
			String firstname = rs.getString("firstname");
			String lastname = rs.getString("lastname");
			
			
			
			String mobileno = rs.getString("mobileno");
			String email = rs.getString("email");
			String address = rs.getString("address");
			String password = rs.getString("password");
			
			
			entities e = new entities(id1,firstname,lastname,mobileno,email,address,password);

			
			req.setAttribute("addemp", e);
			System.out.println(rs);
			System.out.println(rs.getString("id"));
			con.close();
		}catch (Exception e){
			System.out.println(e);
		}
		RequestDispatcher rd = req.getRequestDispatcher("selectemp.jsp");
		rd.forward(req, res);
	}
	
}
			

		


