package pr.com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaibhav", "root", "root");

			PreparedStatement ps = con.prepareStatement("delete from addemp where id = ?");
		    ps.setString(1, id);
			int result = ps.executeUpdate();

			if (result == 1) {
				req.setAttribute("SuccessMsg", "Delete Employee  Successfully...!");
			} else {
				req.setAttribute("error", "Uneble to delete data");
			}

		} catch (Exception e) {
			System.out.println(e);
			req.setAttribute("error", "Uneble to delete data ");

		}
		RequestDispatcher rd = req.getRequestDispatcher("Delete.jsp");
		rd.forward(req, res);
		}
		
	}


