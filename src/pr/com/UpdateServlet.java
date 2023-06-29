package pr.com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class UpdateServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String id =req.getParameter("id");
		String name = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String mobno = req.getParameter("Mobileno");
		String emailid = req.getParameter("email");
		String address = req.getParameter("Address");
		String password = req.getParameter("password");
	

	
	
			try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/vaibhav","root","root");
	             
	           PreparedStatement ps = con.prepareStatement("update addemp set firstname = ?, lastname = ? ,Mobileno = ?, email = ?, Address = ?, password = ?  where id = ?");
	           
	             ps.setString(1, name);
	             ps.setString(2, lastname);
	             ps.setString(3, mobno);
	             ps.setString(4, emailid);
	             ps.setString(5, address);
	             ps.setString(6, password);
	             ps.setString(7, id);
	             
	             
	             entities e=  new entities(id,name,lastname,mobno,emailid,address,password );
	           
	             req.setAttribute("empData",e);
				int rs = ps.executeUpdate();
				
				if (rs == 1) {
					req.setAttribute("SuccessMsg", "Employee Updated Successfully...!");
				} else {
					req.setAttribute("error", "Uneble to Update data");
				}
	            System.out.println(rs);
	            con.close();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	      
	        RequestDispatcher rd = req.getRequestDispatcher("updateemp.jsp");
                rd.forward(req, res);
	    }
	}


