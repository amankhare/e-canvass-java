package com.can;

import java.io.IOException;

import com.dbutil.*;

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

/**
 * Servlet implementation class Mail
 */
@WebServlet("/Mail")
public class Mail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Statement st=null;
	Connection con=null;
	ResultSet rs=null,rs1=null;
	PreparedStatement ps,ps1;
	HttpSession hs=null; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mail() {
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
		HttpSession hs=request.getSession(false);
		String userid=(String)hs.getAttribute("loginid");
		String s=request.getQueryString();
		/*String ui=request.getParameter("");
		System.out.println("........."+ui);
		*/
		String rid=request.getParameter("id");
		System.out.println(rid);
		String message=request.getParameter("message");
		System.out.println(message);
		String sub=request.getParameter("subject");
		con=CRUDOperation.createConection();
		String strsql="insert into messages values(?,?,?,?,?,?,?,?)";
		System.out.println("mail hai bhai");
		int rw=0;
		try {
			
			con.setAutoCommit(false);
			ps=con.prepareStatement(strsql);//prepare set has setter and getter methods
			int msgid=(userid.length()+rid.length()+message.length()+sub.length())*((int)Math.floor(Math.random()*100));
			ps.setInt(1, msgid);
			ps.setString(2,userid);
			ps.setString(3,rid);
			ps.setString(4,sub);
			ps.setString(5,message);
			java.util.Date d=new java.util.Date();
			java.sql.Date sd=new java.sql.Date(d.getTime());
			System.out.println(sd);
			ps.setDate(6,sd);
			ps.setString(7,"true");
			ps.setString(8,"true");
			rw=ps.executeUpdate();
			System.out.println(rw);
			if(rw>0)
			con.commit();
			response.sendRedirect("/e-canvass/jsp/"+s+".jsp");	
			
		} catch (SQLException e) {System.out.print(e);
			// TODO: handle exception
		}
		
	}
	}


