package pr.com;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.x.protobuf.MysqlxSql.StmtExecute;

public class GetAll extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaibhav", "root", "root");
		    java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from addemp");
			
			ArrayList<entities> userList = new ArrayList<>();
			
			while (rs.next()) {
				String id=rs.getString("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String mobileno = rs.getString("mobileno");
				String email = rs.getString("email");
				String address = rs.getString("Address");
				String password = rs.getString("password");	
				
				entities e = new entities( id,firstname,lastname,mobileno,email,address,password);
				userList.add(e);
				
			}
			
			req.setAttribute("userList", userList);
			
			RequestDispatcher rd = req.getRequestDispatcher("GetAll.jsp");
			rd.forward(req, res);
			
			
		}
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	


	}

