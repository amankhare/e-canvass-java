/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.53
 * Generated at: 2015-03-29 09:36:06 UTC
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

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("      \r\n");
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
      out.write("<title>Welcome admin....</title>\r\n");
      out.write("<script>\r\n");
      out.write("function showpendingrequest()\r\n");
      out.write("{\r\n");
      out.write("\tdocument.getElementById(\"hid\").style.display=\"none\";\r\n");
      out.write("\tdocument.getElementById(\"hdid\").style.display=\"block\";\r\n");
      out.write("\t}\r\n");
      out.write("function deleteuser()\r\n");
      out.write("{\r\n");
      out.write("\tdocument.getElementById(\"hdid\").style.display=\"none\";\r\n");
      out.write("\tdocument.getElementById(\"hid\").style.display=\"block\";\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"background-image: url('/e-canvass/images/14.jpg');background-position:right; background-repeat: no-repeat;height:100%;width:100%;background-attachment: fixed;\">\r\n");
      out.write("<div style=\"float: left;\">E-CANVASS...</div>\r\n");
      out.write("<div style=\"float: right;\"><a href=\"/e-canvass/LogOut\" style=\"color:purple;text-decoration: underline;\">Log out</a></div>\r\n");
      out.write("<h1 style=\"text-align: center;text-decoration: overline;\">Welcome Admin....</h1>\r\n");
      out.write("<div>\r\n");
      out.write("<table  style=\"width: 100%;\"><tr>\r\n");
      out.write("<th><a href=\"#\" style=\"color: blue;float:left; ;text-decoration: underline;\" onmousedown=\"showpendingrequest()\" >Pending Request</a></th>\r\n");
      out.write("<th><a  href=\"#\" style=\"color: blue;text-decoration: underline;\" onmousedown=\"deleteuser()\" >Current User</a></th></tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"hdid\" style=\"display: none;\">\r\n");
      out.write("<form action=\"/e-canvass/admin\" method=\"post\">\r\n");
      out.write("<table  style=\"width: 100%;\">\r\n");
      out.write("<tr><th>Select</th>\r\n");
      out.write("<th>Admission Num</th>\r\n");
      out.write("<th>Name</th>\r\n");
      out.write("<th>User Type</th>\r\n");
      out.write("<th>Branch</th>\r\n");
      out.write("<th>University RollNo.</th>\r\n");
      out.write("<th>Contact No.</th>\r\n");
      out.write("</tr>\r\n");
HttpSession hs=request.getSession(false);
String userid=(String)hs.getAttribute("loginid");
hs.setAttribute("type1", "admin");
Connection con=null;PreparedStatement ps=null,ps1=null;ResultSet rs=null,rs1=null;
String strsql="select * from registrationdetail where status=?";
String strsql2="select * from registrationdetail where status=?";
con=CRUDOperation.createConection();
	try
	{ 
		ps=con.prepareStatement(strsql);
		ps1=con.prepareStatement(strsql2);
		ps.setString(1, "false");
		ps1.setString(1, "true");
		rs=ps.executeQuery();
		rs1=ps1.executeQuery();
			while(rs.next())
			{
				

      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<td style=\"text-align: center;\"><input type=\"checkbox\" name=\"chk\" value=\"");
      out.print(rs.getString("admissionNum") );
      out.write('@');
      out.print( rs.getString("type") );
      out.write("\"></td>\r\n");
      out.write("<td style=\"text-align: center;\">");
      out.print( rs.getString("admissionNum") );
      out.write("</td>\r\n");
      out.write("<td style=\"text-align: center;\">");
      out.print( rs.getString("name") );
      out.write("</td>\r\n");
      out.write("<td style=\"text-align: center;\">");
      out.print( rs.getString("type") );
      out.write("</td>\r\n");
      out.write("<td style=\"text-align: center;\">");
      out.print( rs.getString("branch") );
      out.write("</td>\r\n");
      out.write("<td style=\"text-align: center;\">");
      out.print( rs.getString("universityno") );
      out.write("</td>\r\n");
      out.write("<td style=\"text-align: center;\">");
      out.print( rs.getString("phoneNum") );
      out.write("</td>\r\n");
      out.write("</tr>\r\n");

             }
			
		
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<td style=\"text-align:center;\"><input type=\"submit\" value=\"Accept\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"hid\" style=\"display: none;\">\r\n");
      out.write("<form action=\"/e-canvass/admin\" method=\"Get\">\r\n");
      out.write("<table style=\"width: 100%;\">\r\n");
      out.write("<tr><th>Select</th>\r\n");
      out.write("<th>Admission Num</th>\r\n");
      out.write("<th>Name</th>\r\n");
      out.write("<th>User Type</th>\r\n");
      out.write("<th>Branch</th>\r\n");
      out.write("<th>University RollNo.</th>\r\n");
      out.write("<th>Contact No.</th>\r\n");
      out.write("</tr>\r\n");
      out.write("\t\t");
 
		if(rs1.next())//when message is recieved
		{
			while(rs1.next())
			{
				if((rs1.getString("type")).equals("admin"))
					continue;
				else
				{
					hs.setAttribute("type", rs1.getString("type") );
		
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("<tr>\r\n");
      out.write("<td style=\"text-align: center;\"><input type=\"checkbox\" name=\"chk\" value=\"");
      out.print(rs1.getString("admissionNum") );
      out.write("\"></td>\r\n");
      out.write("<td style=\"text-align: center;\"><a href=\"/e-canvass/jsp/composeMail.jsp?");
      out.print( rs1.getString("admissionNum") );
      out.write('"');
      out.write('>');
      out.print( rs1.getString("admissionNum") );
      out.write("</a></td>\r\n");
      out.write("<td style=\"text-align: center;\">");
      out.print( rs1.getString("name") );
      out.write("</td>\r\n");
      out.write("<td style=\"text-align: center;\">");
      out.print( rs1.getString("type") );
      out.write("</td>\r\n");
      out.write("<td style=\"text-align: center;\">");
      out.print( rs1.getString("branch") );
      out.write("</td>\r\n");
      out.write("<td style=\"text-align: center;\">");
      out.print( rs1.getString("universityno") );
      out.write("</td>\r\n");
      out.write("<td style=\"text-align: center;\">");
      out.print( rs1.getString("phoneNum") );
      out.write("</td>\r\n");
      out.write("</tr>\r\n");

			}}
		}
	}
	catch(SQLException se)
	{
	System.out.println(se);}
	
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<td style=\"text-align: center;\"><input type=\"submit\" value=\"Delete\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
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
