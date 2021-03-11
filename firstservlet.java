import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class firstservlet extends HttpServlet
{
	public void doGet(HttpServeltRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		PrintWriter out =  res.getWriter();
		out.println("<html><body>");
		out.println("Welcome to servlet");
		out.println("</body></html>");
	}
}
