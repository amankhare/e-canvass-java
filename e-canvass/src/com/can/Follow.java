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
import javax.servlet.http.HttpSession;

import com.dbutil.CRUDOperation;

/**
 * Servlet implementation class Follow
 */
@WebServlet("/Follow")
public class Follow extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Connection con=null;PreparedStatement ps=null;ResultSet rs=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Follow() {
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
		String teacherid=request.getParameter("p");
		String[] s2 = teacherid.split( "@" );
		//String teachbranch=request.getParameter("k");
		System.out.print("on server end  "+teacherid+" rec");
		con=CRUDOperation.createConection();
		String strsql="insert into follow values(?,?,?,?,?)";
		try
	    {
	    PrintWriter out=response.getWriter();
	    ps=con.prepareStatement(strsql);
	    System.out.println(teacherid+"sasasasasas");
	    ps.setString(1,userid);
	    ps.setString(2,s2[0]);
	    ps.setString(3,"true");
	    ps.setString(4, s2[2]);
	    ps.setString(5, s2[1]);
	    ps.executeUpdate();
		out.println("Joined");
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
