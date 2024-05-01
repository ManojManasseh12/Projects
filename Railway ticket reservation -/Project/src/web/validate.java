package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class validate extends HttpServlet
{
private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException
{
String name=request.getParameter("name");
String pass=request.getParameter("pass");
int flag = 0;
try {
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webpage","root", "12341234");
Statement ps = con.createStatement();
ResultSet rs = ps.executeQuery("select * from login");
while(rs.next())
{
if(rs.getString(1).compareTo(name)==0 && rs.getString(2).compareTo(pass)==0)
{
flag = 1;
break;
} }
if(flag==1)
{
RequestDispatcher rd = request.getRequestDispatcher("Welcome.html");
rd.forward(request, response);
}
else
{
response.sendRedirect("login1.html");
}
con.close();
}
catch (Exception e)
{
e.printStackTrace();
}
}
}