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
<title>Welcome admin....</title>
<script>
function showpendingrequest()
{
	document.getElementById("hid").style.display="none";
	document.getElementById("hdid").style.display="block";
	}
function deleteuser()
{
	document.getElementById("hdid").style.display="none";
	document.getElementById("hid").style.display="block";
	}

</script>

</head>
<body style="background-image: url('/e-canvass/images/14.jpg');background-position:right; background-repeat: no-repeat;height:100%;width:100%;background-attachment: fixed;">
<div style="float: left;">E-CANVASS...</div>
<div style="float: right;"><a href="/e-canvass/LogOut" style="color:purple;text-decoration: underline;">Log out</a></div>
<h1 style="text-align: center;text-decoration: overline;">Welcome Admin....</h1>
<div>
<table  style="width: 100%;"><tr>
<th><a href="#" style="color: blue;float:left; ;text-decoration: underline;" onmousedown="showpendingrequest()" >Pending Request</a></th>
<th><a  href="#" style="color: blue;text-decoration: underline;" onmousedown="deleteuser()" >Current User</a></th></tr>
</table>
</div>
<div id="hdid" style="display: none;">
<form action="/e-canvass/admin" method="post">
<table  style="width: 100%;">
<tr><th>Select</th>
<th>Admission Num</th>
<th>Name</th>
<th>User Type</th>
<th>Branch</th>
<th>University RollNo.</th>
<th>Contact No.</th>
</tr>
<%HttpSession hs=request.getSession(false);
String userid=(String)hs.getAttribute("loginid");
hs.setAttribute("type1", "admin");
Connection con=null;PreparedStatement ps=null,ps1=null;ResultSet rs=null,rs1=null;
String strsql="select * from registrationdetail where status=?";
String strsql2="select * from registrationdetail where status=?";
con=CRUDOperation.createConection();
	try
	{ 
		ps=con.prepareStatement(strsql);
		ps1=con.prepareStatement(strsql2);
		ps.setString(1, "false");
		ps1.setString(1, "true");
		rs=ps.executeQuery();
		rs1=ps1.executeQuery();
			while(rs.next())
			{
				
%>
<tr>
<td style="text-align: center;"><input type="checkbox" name="chk" value="<%=rs.getString("admissionNum") %>@<%= rs.getString("type") %>"></td>
<td style="text-align: center;"><%= rs.getString("admissionNum") %></td>
<td style="text-align: center;"><%= rs.getString("name") %></td>
<td style="text-align: center;"><%= rs.getString("type") %></td>
<td style="text-align: center;"><%= rs.getString("branch") %></td>
<td style="text-align: center;"><%= rs.getString("universityno") %></td>
<td style="text-align: center;"><%= rs.getString("phoneNum") %></td>
</tr>
<%
             }
			
		%>
<tr>
<td style="text-align:center;"><input type="submit" value="Accept"></td>
</tr>
</table>
</form>
</div>
<div id="hid" style="display: none;">
<form action="/e-canvass/admin" method="Get">
<table style="width: 100%;">
<tr><th>Select</th>
<th>Admission Num</th>
<th>Name</th>
<th>User Type</th>
<th>Branch</th>
<th>University RollNo.</th>
<th>Contact No.</th>
</tr>
		<% 
		if(rs1.next())//when message is recieved
		{
			while(rs1.next())
			{
				if((rs1.getString("type")).equals("admin"))
					continue;
				else
				{
					hs.setAttribute("type", rs1.getString("type") );
		%>
		
<tr>
<td style="text-align: center;"><input type="checkbox" name="chk" value="<%=rs1.getString("admissionNum") %>"></td>
<td style="text-align: center;"><a href="/e-canvass/jsp/composeMail.jsp?<%= rs1.getString("admissionNum") %>"><%= rs1.getString("admissionNum") %></a></td>
<td style="text-align: center;"><%= rs1.getString("name") %></td>
<td style="text-align: center;"><%= rs1.getString("type") %></td>
<td style="text-align: center;"><%= rs1.getString("branch") %></td>
<td style="text-align: center;"><%= rs1.getString("universityno") %></td>
<td style="text-align: center;"><%= rs1.getString("phoneNum") %></td>
</tr>
<%
			}}
		}
	}
	catch(SQLException se)
	{
	System.out.println(se);}
	%>
<tr>
<td style="text-align: center;"><input type="submit" value="Delete"></td>
</tr>
</table>
</form>
</div>
</body>
</html>