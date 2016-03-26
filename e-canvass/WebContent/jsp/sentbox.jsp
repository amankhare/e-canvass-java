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
<title>Sentbox</title>
</head>
<body style="background-image: url('/e-canvass/images/6.jpg');background-position:center; background-repeat: no-repeat;height:100%;width:100%;background-attachment: fixed;">
<%
HttpSession hs=request.getSession(false);
String s=request.getQueryString();
hs.setAttribute("whoItIs",s);
%>
<a href="/e-canvass/jsp/<%=s %>.jsp" style="float:left;color:white;">Back....</a>
<h3 style="text-align: center;text-decoration: underline;color:white;">Sentbox....</h3>
<form action="/e-canvass/SentDel?<%=s	 %>" method="Post">
<table border="1" style="left:100px;width: 80%;background-color: white;position: relative;border-color: brown;">
<tr>
<th>Select</th>
<th>Sent To</th>
<th>Subject</th>
<th>Message</th>
</tr>
<%String userid=(String)hs.getAttribute("loginid");
System.out.println(userid);
int k=50;
hs.setAttribute("whichbox","sentbox");
Connection con=null;PreparedStatement ps=null;ResultSet rs=null;
String strsql="select * from messages where senderid=?";
con=CRUDOperation.createConection();
	try
	{
		ps=con.prepareStatement(strsql);
		ps.setString(1, userid);
		rs=ps.executeQuery();
			while(rs.next())
			{   if(rs.getString("sstatus").equals("true"))
			{
				System.out.println("1");
				if((rs.getString("messagetext")).length()<=50)
					k=(rs.getString("messagetext")).length();
		%>
<tr><td style="text-align: center;"><input type="checkbox" value="<%=rs.getString("messageid") %>" name="chkbx" ></td>
<td style="text-align: center;"><%=rs.getString("receiverid") %></td>
<td style="text-align: center;"><%=rs.getString("subject") %></td>
<td style="text-align: center;"><a href="/e-canvass/jsp/viewmessage.jsp?<%=rs.getString("messageid") %>"><%=(rs.getString("messagetext")).substring(0, k) %></a></td>
<%
}	
			}
		}
	catch(SQLException se)
	{
	System.out.println(se);}
	
%>
<tr><td colspan="4"><input type="submit" value="Delete"></td></tr>
</table>
</form>
</body>
</html>