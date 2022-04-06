package vasyerp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/saveStudent")
public class SaveStudent extends HttpServlet {
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	      String id=request.getParameter("id");      
	        String name=request.getParameter("name");      
	        String age=request.getParameter("age");    
	        String course=request.getParameter("course");
	        
	        Student student=new Student();
	        student.setId(Long.parseLong(id));
	        student.setName(name);
	        student.setAge(Long.parseLong(age));
	        student.setCourse(course);
	        
	        int status=StudentDao.save(student);
	        if (status>0) {
	        	out.print("<p>Record inserted successfully!</p>");
	        	request.getRequestDispatcher("student.html").include(request, response);
				
			} else {
				out.print("Sorry record not save!");
	        	request.getRequestDispatcher("student.html").include(request, response);
			}
	        out.close();
	}
}
