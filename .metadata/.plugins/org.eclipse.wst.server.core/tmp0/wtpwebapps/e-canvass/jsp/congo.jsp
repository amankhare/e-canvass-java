<%@page import="java.lang.ProcessBuilder.Redirect"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" errorPage="/e-canvass/jsp/errorPage.jsp"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Congrats</title>
</head>
<body>
<h3 style="text-align: center;">Information Changed....</h3>
<h5 style="text-align: center;">You will be redirected to homepage.....in 5 seconds</h5>
<%HttpSession hs=request.getSession(false);
response.sendRedirect("/e-canvass/jsp/"+(request.getQueryString()));
%>
</body>
</html>