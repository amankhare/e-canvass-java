/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.53
 * Generated at: 2015-03-29 13:52:00 UTC
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

public final class viewmessage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write(" \r\n");
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
      out.write("<body style=\"background-image: url('/e-canvass/images/6.jpg');background-position:center; background-repeat: no-repeat;height:100%;width:100%;background-attachment: fixed;\">\r\n");
HttpSession hs=request.getSession(false);
String s1=(String)hs.getAttribute("whoItIs");
System.out.println(s1);
Connection con=null;PreparedStatement ps=null;ResultSet rs=null;
String strsql="select * from messages where messageid=?";
String s=request.getQueryString();
con=CRUDOperation.createConection();
try
{   hs=request.getSession();
	ps=con.prepareStatement(strsql);
	ps.setString(1, s);
	rs=ps.executeQuery();
    rs.next();
		
      out.write("\r\n");
      out.write("\t\t<a href=\"/e-canvass/jsp/");
      out.print((String)hs.getAttribute("whichbox") );
      out.write(".jsp?");
      out.print(s1 );
      out.write("\" style=\"float:left;\">Back....</a>\r\n");
      out.write("\t<h3 style=\"text-align: center;text-decoration: underline;color: white;\">");
      out.print(rs.getString("subject") );
      out.write("</h3>\r\n");
      out.write("<title>");
      out.print(rs.getString("subject") );
      out.write("</title>\r\n");
      out.write("<div style=\"left:350px;right:300px;width:50%;position:relative;background-color: white;\">");
      out.print(rs.getString("messageText"));
      out.write("</div>\r\n");

}
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