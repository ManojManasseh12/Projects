package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class register extends HttpServlet
{
private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
response.setContentType("text/html");
PrintWriter pw = response.getWriter();
String name=request.getParameter("name");
String fname=request.getParameter("fname");
String mname=request.getParameter("mname");
String mail=request.getParameter("mail");
String dob=request.getParameter("dob");
String gender=request.getParameter("gender");
String state=request.getParameter("state");
String num=request.getParameter("num");
try {
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webpage","root","12341234");
PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?,?,?,?)");
ps.setString(1,name);
ps.setString(2,fname);
ps.setString(3,mname);
ps.setString(4,mail);
ps.setString(5,dob);
ps.setString(6,gender);
ps.setString(7, state );
ps.setString(8,num);
int i=ps.executeUpdate();
if(i==1)
{
RequestDispatcher rd = request.getRequestDispatcher("login.html");
rd.forward(request, response);
}
else
{
response.sendRedirect("register.html");
}
con.close();
} catch (Exception e)
{
e.printStackTrace();
}
}
}
