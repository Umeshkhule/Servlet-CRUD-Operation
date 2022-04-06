package vasyerp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editStudent")
public class EditStudent extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("<h1>Update Student</h1>");
		String sid=request.getParameter("id");
		long sid1=Long.parseLong(sid);
		Student student=StudentDao.getStudentById(sid1);
		
		out.print("<form action='editStudent2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+student.getId()+"'/></td></tr>");     
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+student.getName()+"'required></td></tr>");      
        out.print("<tr><td>Age:</td><td><input type='age' name='age' value='"+student.getAge()+"' required></td></tr>");      
        out.print("<tr><td>Course:</td><td><input type='course' name='course' value='"+student.getCourse()+"' required></td></tr>");      
        out.print("</td></tr>");      
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");     
        out.print("</table>");      
        out.print("</form>");             
        out.close();
	}
}