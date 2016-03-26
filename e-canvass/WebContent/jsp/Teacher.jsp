<%@ page language="java" contentType="text/html; charset=ISO-8859-1" errorPage="/jss_nba/jsp/errorPage.jsp"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.*,com.dbutil.*,com.can.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/jss_nba/bootstrap/bootstrap.css">
<link rel="stylesheet" type="text/css" href="/jss_nba/bootstrap/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/jss_nba/bootstrap/bootstrap-responsive.css">
<link rel="stylesheet" type="text/css" href="/jss_nba/bootstrap/bootstrap-responsive.min.css">
<link rel="stylesheet" type="text/css" href="/jss_nba/bootstrap/bootstrap.js">
<link rel="stylesheet" type="text/css" href="/jss_nba/bootstrap/bootstrap.min.js">
</head>
<body style="background-image: url('/jss_nba/images/14.jpg');background-position:right; background-repeat: no-repeat;height:100%;width:100%;background-attachment: fixed;">  <!-- style="background-image: url('/jss_nba/images/5.jpg');background-position:center; background-repeat: no-repeat;height:100px;width:100%;background-attachment: fixed;" -->
<div style="background-image:url('/jss_nba/images/9.jpg');background-repeat:no-repeat; height:130px;"></div>
<%Connection con=null; ResultSet rs,rs1,rs0,rs2; PreparedStatement ps,ps1,ps0,ps2;
HttpSession hs=request.getSession(false);
hs.setAttribute("type1", "Teacher");
String userid=(String)hs.getAttribute("loginid");
String inbox="select count(receiverid) from messages where receiverid=? and rstatus=?";
String sent="select count(senderid) from messages where senderid=? and sstatus=?";
String strsql="select * from registrationdetail where admissionNum=?";
String strsql1="select DISTINCT * from follow where followedby=? and status=?";
con=CRUDOperation.createConection();
int flag=0,flag1=0;
try
{
	ps2=con.prepareStatement(sent);
	ps2.setString(1, userid);
	ps2.setString(2, "true");
	rs2=ps2.executeQuery();	
	if(rs2.next())
		flag1=1;
	ps0=con.prepareStatement(inbox);
	ps0.setString(1, userid);
	ps0.setString(2, "true");
	rs0=ps0.executeQuery();	
	if(rs0.next())
		flag=1;
ps=con.prepareStatement(strsql);
ps.setString(1, userid);
rs=ps.executeQuery();
while(rs.next())
{
%>
<div style="float:left;width:200px;height:100%;text-align: center;text-decoration: underline;position:absolute;">Welcome <%= rs.getString("name") %>
<div><a href="/jss_nba/jsp/uploadpic.jsp"><img style="height:150px;width:150px;" src="/jss_nba/images/unknown_male_profile.jpg"></a></div>
<div><a href="/jss_nba/jsp/Teacher.jsp">Home</a></div>
<div><a href="/jss_nba/jsp/myposts.jsp">My Posts</a></div>
<div><a href="/jss_nba/jsp/availableteacher.jsp?Teacher">Teachers</a></div>
<div><a href="/jss_nba/jsp/composeMail.jsp?Teacher">Compose</a></div>
<% if(flag1!=1)
{%>
<div><a href="/jss_nba/jsp/sentbox.jsp?Teacher">Sentbox(0)</a></div>
<%}else{ %>
<div><a href="/jss_nba/jsp/sentbox.jsp?Teacher">Sentbox(<%=rs2.getInt(1) %>)</a></div><%} %>
<% if(flag!=1)
{%>
<div><a href="/jss_nba/jsp/inbox.jsp?Teacher">Inbox(0)</a></div>
<%}else{ %>
<div><a href="/jss_nba/jsp/inbox.jsp?Teacher">Inbox(<%=rs0.getInt(1) %>)</a></div><%} %>
<div><a href="/jss_nba/jsp/editinfo.jsp?Teacher">Edit info</a></div>
<div><a href="/jss_nba/jsp/join.jsp?Teacher">Join</a></div>
<div><a href="/jss_nba/LogOut">Log Out</a></div>
</div>
<div style="left:200px;width:100%;height:100%;text-align: center;text-decoration: underline;position: absolute;"></div>
<%
}
%>
<h4 style="text-align: center;">Post Something....</h4>
<form action="/jss_nba/Post_text" method="Get">
<table  style="left:300px;width:700px;position:relative;">
<tr><td>
<textarea style="width:800px;" rows="4" cols="50" name="post_text">
</textarea>
</td></tr>
<tr><td><input type="submit" value="Post"/></td></tr>
</table>
</form>
<h5 style="text-align: center;">Teacher's You Follow.....</h5>
<table border="1" style="left:530px;width:300px;position:relative;background-color: white;">
<tr><th>Faculty</th>
<th>Department</th>
</tr>
<%
ps1=con.prepareStatement(strsql1);
ps1.setString(1, userid);
ps1.setString(2, "true");
rs1=ps1.executeQuery();
System.out.println(rs1);
while(rs1.next())
{
%>
<tr><th><a href="/jss_nba/jsp/posts.jsp?<%=rs1.getString("followedto") %>"><%=rs1.getString("name") %></a></th>
<th><%=rs1.getString("teachbranch") %></th>
</tr>
<%
}	
}
catch(SQLException se)
{
	System.out.println(se);
	}
%>
</table>
</body>
</html>