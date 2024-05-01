package web;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class login extends HttpServlet{
private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
{
response.setContentType("text/html");
String user=request.getParameter("user");
String pass=request.getParameter("pass");
try {
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/webpage", "root","12341234");
PreparedStatement ps = con.prepareStatement("insert into login values(?,?)");
ps.setString(1, user);
ps.setString(2, pass);
int i=ps.executeUpdate() ;
if(i==1)
{
RequestDispatcher rd =
request.getRequestDispatcher("Welcome.html");
rd.forward(request, response);
}
else
{
response.sendRedirect("login.html");
}
con.close();
} catch (Exception e)
{
e.printStackTrace();
}
}
}