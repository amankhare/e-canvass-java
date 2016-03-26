package com.can;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbutil.CRUDOperation;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	PreparedStatement reginsert,pslogin,psreg=null,ps;
       ResultSet rs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uid=request.getParameter("us");
		System.out.print(uid+"aman khare");
		con=CRUDOperation.createConection();
		try
	    {
	    String strsql="select * from registrationdetail where admissionNum=?";
	    PrintWriter out=response.getWriter();
	    ps=con.prepareStatement(strsql);
	    ps.setString(1,uid);
	    rs=ps.executeQuery();
		if(rs.next())
		{
			out.println("User with this Admission No. already exists...");
			}
		}
		catch(SQLException se)
	    {
	    	System.out.print(se);
	    }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
