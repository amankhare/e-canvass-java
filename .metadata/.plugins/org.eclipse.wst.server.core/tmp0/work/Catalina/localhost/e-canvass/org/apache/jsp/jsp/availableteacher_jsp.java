/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.53
 * Generated at: 2015-03-31 17:49:47 UTC
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

public final class availableteacher_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("     \r\n");
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
      out.write("</head>\r\n");
      out.write("<body style=\"background-image: url('/e-canvass/images/14.jpg');background-position:right; background-repeat: no-repeat;height:100%;width:100%;background-attachment: fixed;\">\r\n");
      out.write("<div style=\"background-image:url('/e-canvass/images/9.jpg');background-repeat:no-repeat; height:130px;\">\r\n");
      out.write("</div>\r\n");
Connection con=null; ResultSet rs,rs1; PreparedStatement ps,ps1;
HttpSession hs=request.getSession(false);
String userid=(String)hs.getAttribute("loginid");
String strsql="select * from registrationdetail where admissionNum=?";
String strsql1="select * from registrationdetail where type=?";
con=CRUDOperation.createConection();
try
{
ps=con.prepareStatement(strsql);
ps.setString(1, userid);
rs=ps.executeQuery();
while(rs.next())
{

      out.write("\r\n");
      out.write("<div style=\"float:left;width:200px;height:100%;text-align: center;text-decoration: underline;position:absolute;\">Welcome ");
      out.print( rs.getString("name") );
      out.write("\r\n");
      out.write("<div><a href=\"/e-canvass/jsp/uploadpic.jsp\"><img style=\"height:150px;width:150px;\" src=\"/e-canvass/images/unknown_male_profile.jpg\"></a></div>\r\n");
      out.write("<div><a href=\"/e-canvass/jsp/Teacher.jsp\">Home</a></div>\r\n");
      out.write("<div><a href=\"/e-canvass/jsp/myposts.jsp\">My Posts</a></div>\r\n");
      out.write("<div><a href=\"/e-canvass/jsp/availableteacher.jsp?Teacher\">Teachers</a></div>\r\n");
      out.write("<div><a href=\"/e-canvass/jsp/composeMail.jsp?Teacher\">Compose</a></div>\r\n");
      out.write("<div><a href=\"/e-canvass/jsp/sentbox.jsp?Teacher\">Sentbox</a></div>\r\n");
      out.write("<div><a href=\"/e-canvass/jsp/inbox.jsp?Teacher\">Inbox</a></div>\r\n");
      out.write("<div><a href=\"/e-canvass/jsp/editinfo.jsp?Teacher\">Edit info</a></div>\r\n");
      out.write("<div><a href=\"/e-canvass/jsp/join.jsp?Teacher\">Join</a></div>\r\n");
      out.write("<div><a href=\"/e-canvass/LogOut\">Log Out</a></div>\r\n");
      out.write("</div>\r\n");
      out.write("<div style=\"left:200px;width:100%;height:100%;text-align: center;text-decoration: underline;position: absolute;\"></div>\r\n");

}

      out.write("\r\n");
      out.write("<h5 style=\"text-align: center;\">Teacher's On Portal.....</h5>\r\n");
      out.write("<table border=\"1\" style=\"left:530px;width:300px;position:relative;background-color: white;\">\r\n");
      out.write("<tr><th>Faculty</th>\r\n");
      out.write("<th>Department</th>\r\n");
      out.write("</tr>\r\n");

ps1=con.prepareStatement(strsql1);
ps1.setString(1, "teacher");
rs1=ps1.executeQuery();
System.out.println(rs1);
while(rs1.next())
{

      out.write("\r\n");
      out.write("<tr><th><a href=\"/e-canvass/jsp/composeMail.jsp?");
      out.print(rs1.getString("admissionNum") );
      out.write('"');
      out.write('>');
      out.print(rs1.getString("name") );
      out.write("</a></th>\r\n");
      out.write("<th>");
      out.print(rs1.getString("branch") );
      out.write("</th>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");

}}
catch(SQLException se)
{
	System.out.println(se);
	}

      out.write("\r\n");
      out.write("</table>\r\n");
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
