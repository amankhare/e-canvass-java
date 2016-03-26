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
<title>Upload Pic</title>
<script type="text/javascript">
function showimage(l)
{
	s=document.getElementById("imid");
	s.src="d://dextop/"+l;
	}
</script>
</head>
<body>
<form action="#" method="Post" enctype="multiport/form-data">
	<table style="top:10%;left:40%;position: absolute;">
	<tr><td><input type="file" name="file" value="/e-canvass/images/unknown_male_profile.jpg" onblur="showimage(value)" ></td></tr>
	<tr><td></td></tr>
	<tr><td></td></tr>
	<tr><td></td></tr>
	<tr><td></td></tr>
	<tr><td><img style="height:150px;width:150px;" src="/e-canvass/images/unknown_male_profile.jpg" id="imid"></td><tr>
	<tr><td></td></tr>
	<tr><td></td></tr>
	<tr><td></td></tr>
	<tr><td></td></tr>
	<tr><td><input type="submit" value="uploadpic">
</td></tr>
</table>
</form>
</body>
</html>