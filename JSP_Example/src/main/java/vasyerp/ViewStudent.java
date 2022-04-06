package vasyerp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewStudent")
public class ViewStudent extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("<a href='student.html'>Add New Student</a>");
		out.print("<h1>Student List</h1>");

		List<Student> list=StudentDao.getAllStudent();
		out.print("<table border='1' width='100%'>");
		out.print("<tr><th>ID</th><th>NAME</th><th>AGE</th><th>COURSE</th><th>EDIT</th><th>DELETE</th></tr>");
		for(Student student:list) {
			out.print("<tr><td>"+student.getId()+"</td><td>"+student.getName()+"</td><td>"+student.getAge()+"</td><td>"+student.getCourse()+""
					+ "</td><td><a href='editStudent?id="+student.getId()+"'>Edit</a></td><td><a href='deleteStudent?id="+student.getId()+"'>Delete</a></td></tr>");
		}
		out.close();
	}

}
