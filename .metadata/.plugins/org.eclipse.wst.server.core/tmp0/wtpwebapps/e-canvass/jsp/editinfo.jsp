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
<title>Edit Info...</title>
<script type="text/javascript">
var upass;
function checkpass(upass)
{	if(XMLHttpRequest)
		{
		x=new XMLHttpRequest();
		}
	x.onreadystatechange=function()
	{
		if(x.readyState==4 && x.status==200)
		{
		k=(x.responseText).split("&");
		   document.getElementById("msgtxt").innerHTML=k[0];
			document.getElementById("msgtxt").style.color="green";
			
			document.getElementById("mepass").style.display=k[1];
			
			
		
				
		}
	}
	
	x.open("GET","/e-canvass/Edit?p="+upass,true);
	x.send(null);
	
	}
function shownpass()
{
	document.getElementById("pass").style.display="block";
	document.getElementById("passtxt").style.display="block";
	//document.write("i am here");
}
</script>
</head>
<body style="background-image :url('/e-canvass/images/7.jpg');background-attachment: fixed;height: 100%;width: 100%;background-position:center; background-repeat: repeat;">
<h1 style="text-align: center;text-decoration: overline;">Edit Info</h1>
<%HttpSession hs=request.getSession(false);
String userid=(String)hs.getAttribute("loginid");
System.out.println("id is ="+userid);
Connection con=null;PreparedStatement ps=null;ResultSet rs=null;
String strsql="select * from registrationdetail where admissionNum=?";
con=CRUDOperation.createConection();
	try
	{
        hs=request.getSession();
		ps=con.prepareStatement(strsql);
		ps.setString(1, userid);
		hs=request.getSession();
		hs.setAttribute("senderid", userid);
		rs=ps.executeQuery();
		if(rs.next())
		{
         System.out.println("yoda");
			%>
<form action="/e-canvass/Edit" method="POST">
<table  style="top:10%;left:34%;height:500px;width:500px;position:absolute;">
<tr><td>Admission Number </td><td colspan="2"><%=rs.getString("admissionNum") %></td></tr>
<tr><td>Name </td><td colspan="2"><input type="text" value="<%=rs.getString("name") %>" name="name"/></td></tr>
<tr><td>Password </td><td colspan="2">*******<br/><p style="text-decoration: underline;" onclick="shownpass()">Change Password</p></td></tr>
<tr><td></td><td><input type="text" id="mepass" style="display: none;" value="<%=rs.getString("password") %>"  name="pass"/></td></tr>
<tr><td></td>
<td id="passtxt" style="display:none;">Verify password</td>
<td colspan="2" id="pass" style="display:none;"><input type="password" value="" onblur="checkpass(this.value)"/>
<p id="msgtxt" style="color:red;"></p>
</td>
</tr>
<tr><td >UniversityNumber</td><td colspan="2"><%=rs.getString("universityno")%></td></tr>
<tr><td >Branch</td><td colspan="2"><%=rs.getString("branch")%></td></tr>
<tr><td>User Type</td><td colspan="2"><%=rs.getString("type")%></td></tr>
<tr><td><input type="submit"></td></tr>
</table></form>
<%     }}
		catch(SQLException se)
		{
			System.out.println(se);}
			
%>
</body>
</html>