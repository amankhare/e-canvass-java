<%@ page language="java" contentType="text/html; charset=ISO-8859-1" errorPage="/jsp/errorPage.jsp"
    pageEncoding="ISO-8859-1"
    %>
     <%@ page import="java.sql.*,com.dbutil.*,com.can.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
span{color:white;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body style="background-image: url('/e-canvass/images/10.jpg');background-position:center; background-repeat: no-repeat;height:100%;width:100%;background-attachment: fixed;">
<h2 style="text-align: center;text-decoration: underline;color:white;">Compose Message...
</h2>
<%HttpSession hs=request.getSession(false);
String userid=(String)hs.getAttribute("loginid");
String ty=(String)hs.getAttribute("type1");
/* String page1=(String)hs.getAttribute("page");
hs.setAttribute("page", page1);
 */
String s=request.getQueryString();
System.out.println("ye hai"+s);
String rec=(String)hs.getAttribute("rec");
System.out.println("sender id is "+userid);
hs.setAttribute("senderid", userid);
System.out.println(ty);
//logged in user id
%>
<form action="/e-canvass/Mail?<%=ty %>" method="Post">
<table style="position: absolute;left: 15%;">
<tr><td style="display:none;"><input type="text" name="senderid"></td></tr>
<tr><td >
<span>To:</span></td><td><input type="text" name="id" value=<%=s%>></td></tr>
<tr>
<td >
<span>Subject:</span></td><td><input type="text" value="" name="subject">
</td></tr>
<tr><td >
<span>Message:</span></td><td><textarea name="message" rows="20" cols="100"></textarea>
</td></tr>
<tr><td></td><td>
<input type="submit" value="send">
</td></tr>
</table>
</form>
</body>