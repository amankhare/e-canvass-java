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
 * Servlet implementation class editinfo
 */
@WebServlet("/editinfo")
public class EditInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Statement st=null;
	Connection con=null;
	ResultSet rs=null,rs1=null;
	PreparedStatement ps,ps1;
	HttpSession hs=null;
	
    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditInfo() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("/e-canvass/jsp/temp.jsp");
		HttpSession hs=request.getSession(false);
		String userid=(String)hs.getAttribute("loginid");
		String upass=request.getParameter("us");
		System.out.print(upass+" this is on server end");
		con=CRUDOperation.createConection();
		try
	    {
	    String strsql="select * from registrationdetail where admissionNum=?,password=? ";
	    PrintWriter out=response.getWriter();
	    ps=con.prepareStatement(strsql);
	    ps.setString(1,userid);
	    ps.setString(2,upass);
	    rs=ps.executeQuery();
		if(!rs.next())
		{
			out.println("N");
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
		String userid=(String)hs.getAttribute("senderid");
		System.out.println("in edit info "+userid);
		String pn=request.getParameter("phonenumber");
		String n=request.getParameter("Name");
		System.out.println(n);
		String ad=request.getParameter("address");
		String sk=request.getParameter("skills");
		String exp=request.getParameter("experience");
		String strsql="update members set phoneno=?,name=?,experience=?,address=?,skill=? where userid=?";
		con=CRUDOperation.createConection();
		try
		{   
			ps=con.prepareStatement(strsql);
			ps.setString(1, pn);
			ps.setString(2, n);
			ps.setString(3, exp);
			ps.setString(4, ad);
			ps.setString(5, sk);
			ps.setString(6, userid);
			ps.executeUpdate();
		    response.sendRedirect("/am/jsp/user.jsp");	
			}				
		 catch (SQLException e) {System.out.print(e);
		// TODO: handle exception
	}
	}

}
