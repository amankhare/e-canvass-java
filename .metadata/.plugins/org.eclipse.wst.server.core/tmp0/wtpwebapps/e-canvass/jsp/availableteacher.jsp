<%@ page language="java" contentType="text/html; charset=ISO-8859-1" errorPage="/e-canvass/jsp/errorPage.jsp"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.*,com.dbutil.*,com.can.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<body style="background-image: url('/e-canvass/images/14.jpg');background-position:right; background-repeat: no-repeat;height:100%;width:100%;background-attachment: fixed;">
<div style="background-image:url('/e-canvass/images/9.jpg');background-repeat:no-repeat; height:130px;">
</div>
<%Connection con=null; ResultSet rs,rs1; PreparedStatement ps,ps1;
HttpSession hs=request.getSession(false);
String userid=(String)hs.getAttribute("loginid");
String strsql="select * from registrationdetail where admissionNum=?";
String strsql1="select * from registrationdetail where type=?";
con=CRUDOperation.createConection();
try
{
ps=con.prepareStatement(strsql);
ps.setString(1, userid);
rs=ps.executeQuery();
while(rs.next())
{
%>
<div style="float:left;width:200px;height:100%;text-align: center;text-decoration: underline;position:absolute;">Welcome <%= rs.getString("name") %>
<div><a href="/e-canvass/jsp/uploadpic.jsp"><img style="height:150px;width:150px;" src="/e-canvass/images/unknown_male_profile.jpg"></a></div>
<div><a href="/e-canvass/jsp/Teacher.jsp">Home</a></div>
<div><a href="/e-canvass/jsp/myposts.jsp">My Posts</a></div>
<div><a href="/e-canvass/jsp/availableteacher.jsp?Teacher">Teachers</a></div>
<div><a href="/e-canvass/jsp/composeMail.jsp?Teacher">Compose</a></div>
<div><a href="/e-canvass/jsp/sentbox.jsp?Teacher">Sentbox</a></div>
<div><a href="/e-canvass/jsp/inbox.jsp?Teacher">Inbox</a></div>
<div><a href="/e-canvass/jsp/editinfo.jsp?Teacher">Edit info</a></div>
<div><a href="/e-canvass/jsp/join.jsp?Teacher">Join</a></div>
<div><a href="/e-canvass/LogOut">Log Out</a></div>
</div>
<div style="left:200px;width:100%;height:100%;text-align: center;text-decoration: underline;position: absolute;"></div>
<%
}
%>
<h5 style="text-align: center;">Teacher's On Portal.....</h5>
<table border="1" style="left:530px;width:300px;position:relative;background-color: white;">
<tr><th>Faculty</th>
<th>Department</th>
</tr>
<%
ps1=con.prepareStatement(strsql1);
ps1.setString(1, "teacher");
rs1=ps1.executeQuery();
System.out.println(rs1);
while(rs1.next())
{
%>
<tr><th><a href="/e-canvass/jsp/composeMail.jsp?<%=rs1.getString("admissionNum") %>"><%=rs1.getString("name") %></a></th>
<th><%=rs1.getString("branch") %></th>
</tr>

<%
}}
catch(SQLException se)
{
	System.out.println(se);
	}
%>
</table>
</body>
</html>