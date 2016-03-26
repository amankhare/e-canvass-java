package com.can;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import com.dbutil.CRUDOperation;

/**
 * Servlet implementation class registration
 */
@WebServlet("/registration")
public class registration extends HttpServlet {
	Connection con=null;
	PreparedStatement reginsert,pslogin,psreg=null,ps;
       ResultSet rs;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registration() {
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
	String name=request.getParameter("name");
	String password=request.getParameter("password");
	String branch=request.getParameter("department");
	String type=request.getParameter("type");
	String phone=request.getParameter("phonenumber");
	String admissionno=request.getParameter("admissionno");
	String universityno=request.getParameter("universityroll");
	String reginsert="insert into registrationdetail values(?,?,?,?,?,?,?,?)";
    con=(Connection)CRUDOperation.createConection();
    try
    {
    	con.setAutoCommit(false);
    	pslogin=con.prepareStatement(reginsert);
    	pslogin.setString(1, admissionno);
    	pslogin.setString(2, branch);
    	pslogin.setLong(3, Long.parseLong(phone));
    	pslogin.setString(4, password);
    	pslogin.setString(5, name);
    	pslogin.setLong(6,Long.parseLong(universityno));
    	pslogin.setString(7, "false");
    	pslogin.setString(8, type);
    	int rw=pslogin.executeUpdate();
    	if(rw>0)
    	{
    		con.commit();
    		response.sendRedirect("/e-canvass/html/temp.html");
	}
    } catch (SQLException e) {
    	System.out.print(e);
    	}
	
}
}