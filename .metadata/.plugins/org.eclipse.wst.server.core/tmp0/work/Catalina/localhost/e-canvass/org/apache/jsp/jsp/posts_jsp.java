/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.53
 * Generated at: 2015-04-18 13:42:01 UTC
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

public final class posts_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      			null, true, 8192, true);
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
      out.write("<style type=\"text/css\">\r\n");
      out.write("span{color:purple;\r\n");
      out.write("     }\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body  style=\"background-image: url('/e-canvass/images/3.jpg');background-position:center; background-repeat: no-repeat;height:100%;width:100%;background-attachment: fixed;\">\r\n");
      out.write("<h3 style=\"text-align: center;\">Posts....</h3>\r\n");
Connection con=null; ResultSet rs,rs1,rs3; PreparedStatement ps,ps1,ps3;
HttpSession hs=request.getSession(false);
String backtype=(String)hs.getAttribute("type1");
System.out.println(backtype);

      out.write("\r\n");
      out.write("<a style=\"position: fixed;\" href=\"/e-canvass/jsp/");
      out.print(backtype );
      out.write(".jsp\" ><span>Back....</span></a>\r\n");

String userid=(String)hs.getAttribute("loginid");
String s11="posts";
String clickedid=request.getQueryString();
System.out.println(clickedid);
hs.setAttribute("clickedid", clickedid);
hs.setAttribute("cmntype", s11);
String strsql="SELECT * FROM a"+clickedid+" where ustatus=?";
String strsql3="select * from security where hidefrom=? and messageid=?";
String strsql1="SELECT * FROM comments where postid=?";
con=CRUDOperation.createConection();
int s=0;
try
{
ps=con.prepareStatement(strsql);
ps3=con.prepareStatement(strsql3);
ps.setString(1, "true");
rs=ps.executeQuery();
 while(rs.next())
{    s=rs.getInt("messageid");
     System.out.println("id is="+s);
     ps3.setString(1, userid);
     ps3.setInt(2, s);
     rs3=ps3.executeQuery();
     if(!rs3.next())
     {
	 ps1=con.prepareStatement(strsql1);
	 ps1.setInt(1,s);
	 rs1=ps1.executeQuery();

	System.out.println("rs....in while");

      out.write("\r\n");
      out.write("<div style=\"left:300px;right:300px;width:50%;position:relative;\">\r\n");
      out.print( rs.getString("post"));
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<div style=\"left:300px;right:300px;position:relative;\"><span>Posted Date.....</span>\r\n");
      out.print( rs.getDate("date"));
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<div><p style=\"text-align:center;color: purple;text-decoration:underline; \">Comments..</p></div>\r\n");

while(rs1.next())
{

      out.write("\r\n");
      out.write("<div style=\"left:300px;right:300px;position:relative;\"><span>Name:-</span>");
      out.print(rs1.getString("name") );
      out.write("</div>\r\n");
      out.write("<div style=\"left:300px;right:300px;position:relative;\"><span>Id:-</span>");
      out.print(rs1.getString("doneby") );
      out.write("</div>\r\n");
      out.write("<div style=\"left:300px;right:300px;position:relative;\"><span>Comment:-</span>");
      out.print(rs1.getString("comment") );
      out.write("</div>\r\n");
      out.write("<div style=\"left:300px;right:300px;position:relative;\">____________________________________________</div>\r\n");

if(rs1.getString("doneby").equals(userid))
{
String q1=rs1.getString("postid");	
hs.setAttribute("id", q1);
hs.setAttribute("id1", rs1.getString("comment"));

      out.write("\r\n");
      out.write("<form action=\"/e-canvass/DelComment\" method=\"get\">\r\n");
      out.write("<input type=\"submit\" value=\"Delete\" >\r\n");
      out.write("</form>\r\n");

}}

      out.write("\r\n");
      out.write("<form action=\"/e-canvass/Post_text?");
      out.print(rs.getString("messageid") );
      out.write("\" method=\"Post\">\r\n");
      out.write("<table  style=\"left:300px;right:300px;position:relative;\">\r\n");
      out.write("<tr><td>\r\n");
      out.write("<textarea style=\"width:400px;\" rows=\"1\" cols=\"50\" name=\"text\">\r\n");
      out.write("</textarea>\r\n");
      out.write("</td></tr>\r\n");
      out.write("<tr><td><input type=\"submit\" value=\"Comment..\"/></td></tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
 
}
}
}
catch(Exception se)
{
	System.out.println(se);
	}
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
