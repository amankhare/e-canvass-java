package com.can;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dbutil.CRUDOperation;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Statement st=null;
	Connection con=null;
	ResultSet rs=null,rs1=null;
	PreparedStatement ps,ps1;
	HttpSession hs=null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession hs=request.getSession(false);
		String userid=(String)hs.getAttribute("loginid");
		String upass=request.getParameter("p");
		System.out.print(upass+" this is on server end");
		con=CRUDOperation.createConection();
		try
	    {
	    String strsql="select * from registrationdetail where admissionNum=?";
	    PrintWriter out=response.getWriter();
	    ps=con.prepareStatement(strsql);
	    ps.setString(1,userid);
	    rs=ps.executeQuery();
		if(rs.next())
		{
			System.out.print((rs.getString("password").equals(upass)));
			if((rs.getString("password")).equals(upass))
			out.println("right password&block");
			else
				out.println("wrong password&none");
			}
	    }
		catch(SQLException se)
	    {
	    	System.out.print(se);
	    }
		// TODO Auto-generated method stub
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession hs=request.getSession(false);
		String userid=(String)hs.getAttribute("loginid");
		String n=request.getParameter("name");
		System.out.println(n);
		String pass=request.getParameter("pass");
		String strsql="update registrationdetail set name=?,password=? where admissionNum=?";
		con=CRUDOperation.createConection();
		try
		{   
			ps=con.prepareStatement(strsql);
			ps.setString(1, n);
			ps.setString(2, pass);
			ps.setString(3, userid);
			ps.executeUpdate();
			response.sendRedirect("/e-canvass/jsp/congo.jsp?student.jsp");	
			}				
		 catch (SQLException e) {System.out.print(e);
		// TODO: handle exception
	}
	
	}

}
