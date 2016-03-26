<%@ page language="java" contentType="text/html; charset=ISO-8859-1" errorPage="/e-canvass/jsp/errorPage.jsp"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ page import="java.sql.*,com.dbutil.*,com.can.*"  %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/e-canvass/bootstrap/bootstrap.css">
<link rel="stylesheet" type="text/css" href="/e-canvass/bootstrap/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/e-canvass/bootstrap/bootstrap-responsive.css">
<link rel="stylesheet" type="text/css" href="/e-canvass/bootstrap/bootstrap-responsive.min.css">
<link rel="stylesheet" type="text/css" href="/e-canvass/bootstrap/bootstrap.js">
<link rel="stylesheet" type="text/css" href="/e-canvass/bootstrap/bootstrap.min.js">
</head>
<body style="background-image: url('/e-canvass/images/6.jpg');background-position:center; background-repeat: no-repeat;height:100%;width:100%;background-attachment: fixed;">
<%HttpSession hs=request.getSession(false);
String s1=(String)hs.getAttribute("whoItIs");
System.out.println(s1);
Connection con=null;PreparedStatement ps=null;ResultSet rs=null;
String strsql="select * from messages where messageid=?";
String s=request.getQueryString();
con=CRUDOperation.createConection();
try
{   hs=request.getSession();
	ps=con.prepareStatement(strsql);
	ps.setString(1, s);
	rs=ps.executeQuery();
    rs.next();
		%>
		<a href="/e-canvass/jsp/<%=(String)hs.getAttribute("whichbox") %>.jsp?<%=s1 %>" style="float:left;">Back....</a>
	<h3 style="text-align: center;text-decoration: underline;color: white;"><%=rs.getString("subject") %></h3>
<title><%=rs.getString("subject") %></title>
<div style="left:350px;right:300px;width:50%;position:relative;background-color: white;"><%=rs.getString("messageText")%></div>
<%
}
	catch(SQLException se)
	{
	System.out.println(se);}
	%>
</body>
</html>