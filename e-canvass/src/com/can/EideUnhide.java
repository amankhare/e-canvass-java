package com.can;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dbutil.CRUDOperation;

/**
 * Servlet implementation class EideUnhide
 */
@WebServlet("/EideUnhide")
public class EideUnhide extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	ResultSet rs=null,rs1=null;
	PreparedStatement ps,ps1;
	HttpSession hs=null;
           
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EideUnhide() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession hs=request.getSession(false);
		String q=(String)hs.getAttribute("id");
		String chkbx[]=request.getParameterValues("chkbx1");
		String strsql="DELETE FROM security WHERE hidefrom=?";
		con=CRUDOperation.createConection();
		int i=0;
		try
		{  
			ps=con.prepareStatement(strsql);
			for(i=0;i<chkbx.length;i++)
			{System.out.println(chkbx[i]);
			ps.setString(1, chkbx[i]);
			ps.executeUpdate();
			}
			response.sendRedirect("/e-canvass/jsp/security.jsp?"+q);	
			}				
		 catch (SQLException e) {System.out.print(e);
		// TO	DO: handle exception
	}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HttpSession hs=request.getSession(false);
		String chkbx[]=request.getParameterValues("chkbx");
		String strsql="insert into security values(?,?)";
		String q=request.getQueryString();
		con=CRUDOperation.createConection();
		int i=0;
		try
		{   hs=request.getSession();
			ps=con.prepareStatement(strsql);
			for(i=0;i<chkbx.length;i++)
			{
				ps.setString(1,q);
			ps.setString(2, chkbx[i]);
			ps.executeUpdate();
			}
			response.sendRedirect("/e-canvass/jsp/security.jsp?"+q);	
			}				
		 catch (SQLException e) {System.out.print(e);
		// TO	DO: handle exception
	}
	}
}


