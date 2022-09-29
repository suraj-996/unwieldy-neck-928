package com.dao;

import java.util.List;

import com.bean.Student;
import com.bean.StudentDTO;
import com.exceptions.CourseException;
import com.exceptions.StudentException;

public interface StudentDao {
//	public String registerStudent(String name,int marks,String email,String password); 
	
	public String registerStudent(Student student);
	public Student getStudentByRoll(int roll) throws StudentException;
	public Student loginStudent(String username,String password) throws StudentException;
	public List<Student> getAllStudentDetails() throws StudentException;
	public String registerStudentInsideACourse(int cid,int roll) throws StudentException,CourseException;
	public List<StudentDTO> getAllStudentByCname(String cname) throws CourseException;
	
	
	
}
