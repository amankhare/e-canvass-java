<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
<title>Security......</title>
<script>
function show1()
{
	document.getElementById("show1").style.display="block";
	document.getElementById("show2").style.display="none";
	}
function show2()
{
	document.getElementById("show1").style.display="none";
	document.getElementById("show2").style.display="block";
	}

</script>
</head>
<body>
<body  style="background-image: url('/e-canvass/images/3.jpg');background-position:center; background-repeat: no-repeat;height:100%;width:100%;background-attachment: fixed;">
<h3 style="text-align: center;">Security....</h3>
<%Connection con=null; ResultSet rs,rs1,rs2; PreparedStatement ps,ps1,ps2;
HttpSession hs=request.getSession(false);
hs.setAttribute("type1", "Teacher");
%>
<a href="/e-canvass/jsp/myposts.jsp" ><span>Back....</span></a>
<%
String userid=(String)hs.getAttribute("loginid");
System.out.println("loginid is "+userid);
String q=request.getQueryString();
hs.setAttribute("id", q);
System.out.println("messageid="+q);
String s1="select * from a"+userid+" where messageid=?";
con=CRUDOperation.createConection();
try
{
ps=con.prepareStatement(s1);
ps.setString(1 , q);
rs=ps.executeQuery();
while(rs.next())
{ 
	System.out.println(" reached");
%>
<div style="left:300px;right:300px;width:50%;position:relative;">
<%=rs.getString("post")%>
</div>
<div style="left:300px;right:300px;width:50%;position:relative;">
<%
System.out.println("at security end the id is="+q);
%>
<form action="/e-canvass/DeleteRec" method="get">
<input type="submit" value="Delete"></form>
<table style="width:100%;">
<tr><th><a onclick="show1()">Hide From....</a></th><th><a onclick="show2()">Hidden From....</a></th></tr>
</table>
</div>
<% 
}
}
catch(Exception se)
{
	System.out.println(se);
	}
	%>
	<div id="show1" style="display:none;">
	<form action="/e-canvass/EideUnhide?<%=q %>" method="post">
	<table style="width:100%;">
	<tr><th>Select<th>Name</th><th>Branch</th><th>Status</th></tr>
	<%String s2="select * from follow where followedto=?";
	String s3="select * from security where messageid=?";
	System.out.println(" reached2");
	int flag=0;
	try
	{
	ps1=con.prepareStatement(s2);
    ps1.setString(1, userid);
    ps2=con.prepareStatement(s3);
    ps2.setString(1, q);
    rs1=ps1.executeQuery();
    rs2=ps2.executeQuery();
    while(rs1.next())
	{System.out.println("inse hide karsakte hai....?"+rs1.getString("followedby"));
	flag=0;
    	System.out.println("outerwhile");
    	while(rs2.next())
    	{
    		System.out.println("innerwhile.....inse hidden hai:"+rs2.getString("hidefrom"));
		if((rs1.getString("followedby")).equals(rs2.getString("hidefrom")))
		{   flag=1;
			System.out.println(rs1.getString("followedby"));
		}}
		if(flag==0)
		{
    	%>
    	<tr><td style="text-align: center;"><input type="checkbox" value="<%=rs1.getString("followedby") %>" name="chkbx" ></td><td style="text-align: center;"><%=rs1.getString("followedby") %></td><td style="text-align: center;"><%=rs1.getString("teachbranch") %></td><td>Visible</td></tr>
    	<%}
    	rs2.beforeFirst();
	}
    }	
  catch(Exception se)
	{
		System.out.println(se);
		} %>
		<tr><th><input type="submit" value="HIDE"></th><td></td><td></td></tr>
	</table>
	</form>
	</div>
	<%//second table show2 for hideen from..... %>
	<div id="show2" style="display:none;">
	<form action="/e-canvass/EideUnhide" method="get">
	<table style="width:100%;">
	<tr><th >Select<th>Name</th><th>Branch</th><th>Status</th></tr>
	<% 
	String ss="select * from security where messageid=?";
	try
	{
		System.out.println("userid="+userid);
	ps2=con.prepareStatement(ss);
    ps2.setString(1, q);
    rs2=ps2.executeQuery();
	while(rs2.next())
		{ 
	
	%>
	<tr><td style="text-align: center;"><input type="checkbox" value="<%=rs2.getString("hidefrom") %>" name="chkbx1" ></td><td style="text-align: center;"><%=rs2.getString("hidefrom") %></td><td style="text-align: center;"><%=rs2.getString("hidefrom") %></td><td>Hidden</td></tr>
	<%}}
	catch(Exception se)
	{
		System.out.println(se);
		} %>
	<tr><th><input type="submit" value="UNHIDE"></th><td></td><td></td></tr>
	</table></form></div>
</body>
</html>