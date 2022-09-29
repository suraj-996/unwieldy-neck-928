package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Student;
import com.bean.StudentDTO;
import com.exceptions.CourseException;
import com.exceptions.StudentException;
import com.utility.DBUtil;

public class StudentDaoImpl implements StudentDao{
	
	@Override
	public String registerStudent(Student student) {
		String message="Not Inserted";
		
		
		
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("insert into student values(?,?,?,?,?)");
			ps.setInt(1, student.getRoll());
			ps.setString(2, student.getName());
			ps.setInt(3, student.getMarks());
			ps.setString(4, student.getEmail());
			ps.setString(5, student.getPassword());
			
			int x=ps.executeUpdate();
			if(x>0) {
				message ="Student Registerd successfully";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
		
		return message;
		
	}

	@Override
	public Student getStudentByRoll(int roll) throws StudentException{
		Student st=null;
		
		try(Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps= conn.prepareStatement("select * from where roll=?");
			ps.setInt(1, roll);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				int r=rs.getInt("roll");
				String n=rs.getString("name");
				int m=rs.getInt("marks");
				String e=rs.getString("email");
				String p = rs.getString("password");
				st=new Student(r,n,m,e,p);
			}else {
				throw new StudentException("student does not exist"+roll);
			}
				
				
				
		}catch(SQLException e) {
			e.printStackTrace();
			throw new StudentException(e.getMessage());
		}
		return st;
		
	}

	@Override
	public Student loginStudent(String username, String password) throws StudentException {
		Student st=null;
		try(Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps= conn.prepareStatement("select * from student where email=? AND password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				int r=rs.getInt("roll");
				String n=rs.getString("name");
				int m=rs.getInt("marks");
				String e=rs.getString("email");
				String p = rs.getString("password");
				st=new Student(r,n,m,e,p);
			}else {
				throw new StudentException("Invalid username or password");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new StudentException(e.getMessage());
		}
		return st;
	}

	@Override
	public List<Student> getAllStudentDetails() throws StudentException {
		List<Student> students = new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps= conn.prepareStatement("select * from student");
			ResultSet rs=ps.executeQuery();
			int r=rs.getInt("roll");
			String n=rs.getString("name");
			int m=rs.getInt("marks");
			String e=rs.getString("email");
			String p = rs.getString("password");
			Student st=new Student(r,n,m,e,p);
			students.add(st);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new StudentException(e.getMessage());
		}
		
		if(students.size()==0) {
			throw new StudentException("No student found...");
		}
		return null;
	}

	@Override
	public String registerStudentInsideACourse(int cid, int roll) throws StudentException, CourseException {
		String str="Not registered";
		try(Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps1= conn.prepareStatement("select * from student where roll =?");
			
			ps1.setInt(1, roll);
			ResultSet rs1= ps1.executeQuery();
			if(rs1.next()) {
				PreparedStatement ps2= conn.prepareStatement("select * from course where cid=?");
				ps2.setInt(1, cid);
				ResultSet rs2= ps2.executeQuery();
				if(rs2.next()) {
					PreparedStatement ps3= conn.prepareStatement("insert into student_course values(?,?)");
					ps3.setInt(1, cid);
					ps3.setInt(2, roll);
					
					int x= ps3.executeUpdate();
					if(x>0) {
						str="Student Registered inside a course successfully";
					}else {
						throw new StudentException("Technical error..");
					}
				}else {
					throw new CourseException("Invalid Course");
				}
			}else {
				new StudentException("Invalid Student ");
				
			}
		}catch(SQLException e) {
			throw new StudentException(e.getMessage());
		}
		
		Student student= getStudentByRoll(roll);
		return str;
	}

	@Override
	public List<StudentDTO> getAllStudentByCname(String cname) throws CourseException {
		List<StudentDTO> dtos=new ArrayList<>();
		try(Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps= conn.prepareStatement("select s.roll,s.name,s.email,c.cname,c.fee from student s INNER JOIN course c INNER JOIN student_course sc ON s.roll=sc.roll AND c.cid=sc.cid AND c.cname=?");
			ps.setString(1, cname);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				int r=rs.getInt("roll");
				String n=rs.getString("name");
				String e=rs.getString("email");
				String cn=rs.getString("cname");
				int f=rs.getInt("fee");
				
				StudentDTO dto=new StudentDTO(r,n,e,cn,f);
				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(dtos.isEmpty())
			throw new CourseException("No student found for this course");
		return null;
	}

}
