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
<style type="text/css">
span{color:purple;
     }
</style>
</head>
<body  style="background-image: url('/e-canvass/images/3.jpg');background-position:center; background-repeat: no-repeat;height:100%;width:100%;background-attachment: fixed;">
<h3 style="text-align: center;">My Posts....</h3>
<%Connection con=null; ResultSet rs,rs1,rs3; PreparedStatement ps,ps1,ps3;
HttpSession hs=request.getSession(false);
String backtype=(String)hs.getAttribute("type1");
System.out.println(backtype);
%>
<a style="position: fixed;" href="/e-canvass/jsp/<%=backtype %>.jsp" ><span>Back....</span></a>
<%
String userid=(String)hs.getAttribute("loginid");
hs.setAttribute("cmntype", "myposts");
hs.setAttribute("clickedid", userid);
String strsql="SELECT * FROM a"+userid+" where ustatus=?";
String strsql1="SELECT * FROM comments where postid=?";
con=CRUDOperation.createConection();
int s=0;
try
{
ps=con.prepareStatement(strsql);
ps.setString(1, "true");
//ps3=con.prepareStatement(strsql);
rs=ps.executeQuery();
//rs3=ps3.executeQuery();
//rs3.next();
//System.out.println("rs....value of id is"+s+"  this");
 while(rs.next())
{    s=rs.getInt("messageid");
System.out.println("id is="+s);
	 ps1=con.prepareStatement(strsql1);
	 ps1.setInt(1,s);
	 rs1=ps1.executeQuery();
	
	System.out.println("rs....in while");
%>
<div style="left:300px;right:300px;width:50%;position:relative;">
<%= rs.getString("post")%>
</div>
<div style="left:300px;right:500px;position: relative;"><p style="text-align:left;"><span>Posted Date.....</span>
<%= rs.getDate("date")%></p>
<p><a href="/e-canvass/jsp/security.jsp?<%=s %>" ><span>Security.....</span></a>
</p>
</div>
<div><p style="text-align:center;color: purple;text-decoration:underline; ">Comments..</p></div>
<%
while(rs1.next())
{
%>
<div style="left:300px;right:300px;position:relative;"><span>Name:-</span><%=rs1.getString("name") %></div>
<div style="left:300px;right:300px;position:relative;"><span>Id:-</span><%=rs1.getString("doneby") %></div>
<div style="left:300px;right:300px;position:relative;"><span>Comment:-</span><%=rs1.getString("comment") %></div>
<div style="left:300px;right:300px;position:relative;">____________________________________________</div>
<%
}
%><form action="/e-canvass/Post_text?<%=rs.getString("messageid") %>" method="Post">
<table  style="left:300px;right:300px;position:relative;">
<tr><td>
<textarea style="width:400px;" rows="1" cols="50" name="text">
</textarea>
</td></tr>
<tr><td><input type="submit" value="Comment.."/></td></tr>
</table>
</form>
<% 
}
}
catch(Exception se)
{
	System.out.println(se);
	}%>
</body>
</html>