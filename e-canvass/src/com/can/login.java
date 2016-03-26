//THIS PAGE WILL CHECK FOR ADMIN,TEACHER OR STUDENT TYPE LOGIN AND REDIRECT ACCORDINGLY
package com.can;

import java.io.IOException;
import java.sql.*;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dbutil.CRUDOperation;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	Connection con=null;
	ResultSet rs;
	PreparedStatement ps;
	HttpSession hs=null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginid=request.getParameter("loginid");
		System.out.println(loginid);
		String password=request.getParameter("password");
		String strsql="select * from registrationdetail where admissionNum=? and password=?";
		con=(Connection)CRUDOperation.createConection();
		try
	    {
			con.setAutoCommit(false);
			ps=con.prepareStatement(strsql);
			ps.setString(1, loginid);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next())
			{
				System.out.print("rs value is="+rs);
				hs=request.getSession();
				hs.setAttribute("loginid", loginid);
				hs.setAttribute("name", rs.getString("name"));
				String p=rs.getString("type");
				if(("true").equals(rs.getString("status")))
				{
					if(p.equals("admin"))
						response.sendRedirect("/e-canvass/jsp/admin.jsp");
				else
					if(p.equals("teacher"))
							response.sendRedirect("/e-canvass/jsp/Teacher.jsp");
					else
					response.sendRedirect("/e-canvass/jsp/student.jsp");
				}
			else
				response.sendRedirect("/e-canvass/html/index.html?unauthorized access");
	    }
			else
				response.sendRedirect("/e-canvass/html/index.html?unauthorized access");
			}
		catch(SQLException e)
		{
		System.out.print(e);
		}			
			}
	    }
		