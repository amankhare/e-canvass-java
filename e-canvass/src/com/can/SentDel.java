package com.can;
import java.io.IOException;
//import java.io.PrintWriter;
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
 * Servlet implementation class SentDel
 */
@WebServlet("/SentDel")
public class SentDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Statement st=null;
	Connection con=null;
	ResultSet rs=null,rs1=null;
	PreparedStatement ps,ps1;
	HttpSession hs=null;
       	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SentDel() {
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
		// TODO Auto-generated method stub
		String chkbx[]=request.getParameterValues("chkbx");
		String strsql="update messages set sstatus=? where messageid=? ";
		String s=request.getQueryString();
		System.out.println("this is"+s);
		con=CRUDOperation.createConection();
		int i=0;
		try
		{   hs=request.getSession();
			ps=con.prepareStatement(strsql);
			for(i=0;i<chkbx.length;i++)
			{
			ps.setString(1, "false");
			ps.setString(2, chkbx[i]);
			ps.executeUpdate();
			}
			System.out.println("this is"+s);
			response.sendRedirect("/e-canvass/jsp/sentbox.jsp?"+s);	
			}				
		 catch (SQLException e) {System.out.print(e);
		// TODO: handle exception
	}
		// TODO Auto-generated method stub
	}

	}

