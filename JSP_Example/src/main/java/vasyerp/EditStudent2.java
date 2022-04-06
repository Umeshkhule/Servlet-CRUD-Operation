package vasyerp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editStudent2")
public class EditStudent2 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		long id=Long.parseLong(sid);
		String name=request.getParameter("name");
		String sage=request.getParameter("age");
		long age=Long.parseLong(sage);
		String course=request.getParameter("course");
		
		Student student=new Student();
		student.setId(id);
		student.setName(name);
		student.setAge(age);
		student.setCourse(course);
		
		int status=StudentDao.update(student);
		if (status>0) {
			response.sendRedirect("viewStudent");
		} else {
			out.println("Sorry! unable to update record");
		}
		out.close();
	}
}