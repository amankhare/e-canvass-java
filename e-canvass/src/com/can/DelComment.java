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
 * Servlet implementation class DelComment
 */
@WebServlet("/DelComment")
public class DelComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	ResultSet rs=null,rs1=null;
	PreparedStatement ps,ps1;
	HttpSession hs=null;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("yo yo");
		HttpSession hs=request.getSession(false);
		String postiduser=(String)hs.getAttribute("clickedid");
		//String userid=(String)hs.getAttribute("loginid");
		String q=(String)hs.getAttribute("id1");
		System.out.println("query string="+q);
		String s1="delete from comments where comment=?";
		System.out.println("message id to be deleated is="+q);
		con=CRUDOperation.createConection();
		try
		{
			ps=con.prepareStatement(s1);
			ps.setString(1, q);
		System.out.println(ps.executeUpdate());
			
		response.sendRedirect("/e-canvass/jsp/posts.jsp?"+postiduser);
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
	}

}
