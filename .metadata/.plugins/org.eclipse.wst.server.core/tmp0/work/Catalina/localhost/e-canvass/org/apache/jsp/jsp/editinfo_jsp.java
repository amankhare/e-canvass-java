/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.53
 * Generated at: 2015-03-29 14:01:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import com.dbutil.*;
import com.can.*;

public final class editinfo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"/e-canvass/jsp/errorPage.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("       \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/e-canvass/bootstrap/bootstrap.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/e-canvass/bootstrap/bootstrap.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/e-canvass/bootstrap/bootstrap-responsive.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/e-canvass/bootstrap/bootstrap-responsive.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/e-canvass/bootstrap/bootstrap.js\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/e-canvass/bootstrap/bootstrap.min.js\">\r\n");
      out.write("<title>Edit Info...</title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var upass;\r\n");
      out.write("function checkpass(upass)\r\n");
      out.write("{\tif(XMLHttpRequest)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\tx=new XMLHttpRequest();\r\n");
      out.write("\t\t}\r\n");
      out.write("\tx.onreadystatechange=function()\r\n");
      out.write("\t{\r\n");
      out.write("\t\tif(x.readyState==4 && x.status==200)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\tk=(x.responseText).split(\"&\");\r\n");
      out.write("\t\t   document.getElementById(\"msgtxt\").innerHTML=k[0];\r\n");
      out.write("\t\t\tdocument.getElementById(\"msgtxt\").style.color=\"green\";\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tdocument.getElementById(\"mepass\").style.display=k[1];\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tx.open(\"GET\",\"/e-canvass/Edit?p=\"+upass,true);\r\n");
      out.write("\tx.send(null);\r\n");
      out.write("\t\r\n");
      out.write("\t}\r\n");
      out.write("function shownpass()\r\n");
      out.write("{\r\n");
      out.write("\tdocument.getElementById(\"pass\").style.display=\"block\";\r\n");
      out.write("\tdocument.getElementById(\"passtxt\").style.display=\"block\";\r\n");
      out.write("\t//document.write(\"i am here\");\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"background-image :url('/e-canvass/images/7.jpg');background-attachment: fixed;height: 100%;width: 100%;background-position:center; background-repeat: repeat;\">\r\n");
      out.write("<h1 style=\"text-align: center;text-decoration: overline;\">Edit Info</h1>\r\n");
HttpSession hs=request.getSession(false);
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
			
      out.write("\r\n");
      out.write("<form action=\"/e-canvass/Edit\" method=\"POST\">\r\n");
      out.write("<table  style=\"top:10%;left:34%;height:500px;width:500px;position:absolute;\">\r\n");
      out.write("<tr><td>Admission Number </td><td colspan=\"2\">");
      out.print(rs.getString("admissionNum") );
      out.write("</td></tr>\r\n");
      out.write("<tr><td>Name </td><td colspan=\"2\"><input type=\"text\" value=\"");
      out.print(rs.getString("name") );
      out.write("\" name=\"name\"/></td></tr>\r\n");
      out.write("<tr><td>Password </td><td colspan=\"2\">*******<br/><p style=\"text-decoration: underline;\" onclick=\"shownpass()\">Change Password</p></td></tr>\r\n");
      out.write("<tr><td></td><td><input type=\"text\" id=\"mepass\" style=\"display: none;\" value=\"");
      out.print(rs.getString("password") );
      out.write("\"  name=\"pass\"/></td></tr>\r\n");
      out.write("<tr><td></td>\r\n");
      out.write("<td id=\"passtxt\" style=\"display:none;\">Verify password</td>\r\n");
      out.write("<td colspan=\"2\" id=\"pass\" style=\"display:none;\"><input type=\"password\" value=\"\" onblur=\"checkpass(this.value)\"/>\r\n");
      out.write("<p id=\"msgtxt\" style=\"color:red;\"></p>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr><td >UniversityNumber</td><td colspan=\"2\">");
      out.print(rs.getString("universityno"));
      out.write("</td></tr>\r\n");
      out.write("<tr><td >Branch</td><td colspan=\"2\">");
      out.print(rs.getString("branch"));
      out.write("</td></tr>\r\n");
      out.write("<tr><td>User Type</td><td colspan=\"2\">");
      out.print(rs.getString("type"));
      out.write("</td></tr>\r\n");
      out.write("<tr><td><input type=\"submit\"></td></tr>\r\n");
      out.write("</table></form>\r\n");
     }}
		catch(SQLException se)
		{
			System.out.println(se);}
			

      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
