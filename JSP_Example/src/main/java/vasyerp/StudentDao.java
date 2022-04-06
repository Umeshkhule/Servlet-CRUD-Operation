package vasyerp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	public static Connection getConnection(){   
		Connection con=null;   
		try{    
			Class.forName("org.postgresql.Driver");   
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/studentdb","postgres","postgres");
		}   
		catch(Exception e) 
		{   
			System.out.println(e);
		}   
		return con;    
	}   
	public static int save(Student student){     
		int status=0;   
		try{    
			Connection con=StudentDao.getConnection();     
			PreparedStatement pst=con.prepareStatement(    
					"insert into student(id,name,age,course) values(?,?,?,?)");    
			pst.setLong(1,student.getId());   
			pst.setString(2,student.getName());     
			pst.setLong(3,student.getAge());      
			pst.setString(4,student.getCourse());   

			status=pst.executeUpdate();     

			con.close();   
		}   
		catch(Exception e)    
		{   
			e.printStackTrace();  
		}   
		return status;      
	}   
	public static int update(Student student){      
		int status=0;   
		try{    
			Connection con=StudentDao.getConnection();     
			PreparedStatement pst=con.prepareStatement(    
					"update student set name=?,age=?,course=? where id=?");   
			pst.setLong(4,student.getId());   
			pst.setString(1,student.getName());     
			pst.setLong(2,student.getAge());      
			pst.setString(3,student.getCourse());   

			status=pst.executeUpdate();     

			con.close();   
		}   
		catch(Exception e)    
		{
			e.printStackTrace();
		}    
		return status;      
	}   
	public static int delete(long id){     
		int status=0;   
		try{    
			Connection con=StudentDao.getConnection();     
			PreparedStatement pst=con.prepareStatement("delete from student where id=?");      
			pst.setLong(1,id);      
			status=pst.executeUpdate();     

			con.close();   
		}catch(Exception e){
			e.printStackTrace();
			}     
		return status;      
	}   
	public static Student getStudentById(long id){      
		Student student=new Student();   

		try{    
			Connection con=StudentDao.getConnection();     
			PreparedStatement pst=con.prepareStatement("select * from student where id=?");    
			pst.setLong(1,id);      
			ResultSet rs=pst.executeQuery();   
			if(rs.next()){     
				student.setId(rs.getLong(1));    
				student.setName(rs.getString(2));      
				student.setAge(rs.getLong(3));   
				student.setCourse(rs.getString(4));    
			}   
			con.close();   
		}catch(Exception e){
			e.printStackTrace();
			}   
		return student;      
	}   
	public static List<Student> getAllStudent(){    
		List<Student> list=new ArrayList<Student>();    

		try{    
			Connection con=StudentDao.getConnection();     
			PreparedStatement pst=con.prepareStatement("select * from student");   
			ResultSet rs=pst.executeQuery();   
			while(rs.next()){      
				Student student=new Student();   
				student.setId(rs.getLong(1));    
				student.setName(rs.getString(2));      
				student.setAge(rs.getLong(3));   
				student.setCourse(rs.getString(4));    
				list.add(student);   
			}   
			con.close();   
		}catch(Exception e){
			e.printStackTrace();
			}     
		return list;    
	}   
} 