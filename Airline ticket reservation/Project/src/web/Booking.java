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
public class Booking extends HttpServlet
{
private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
response.setContentType("text/html");
try {
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webpage","root","12341234");
PreparedStatement ps = con.prepareStatement("insert into booking values(?,?,?,?,?)");
String From=request.getParameter("From");
String Depart=request.getParameter("Depart");
String To=request.getParameter("To");
String Return=request.getParameter("Return");
String num=request.getParameter("num");
ps.setString(1,From);
ps.setString(2,Depart);
ps.setString(3,To);
ps.setString(4,Return);
ps.setString(5,num);

int i=ps.executeUpdate();
if(i==1)
{
RequestDispatcher rd = request.getRequestDispatcher("Sucess.html");
rd.forward(request, response);
}
else
{
response.sendRedirect("Booking.html");
}
con.close();
} 
catch (Exception e)
{
e.printStackTrace();
}
}
}
