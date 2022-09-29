package com.usecases;

import java.util.List;

import com.bean.Student;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.exceptions.StudentException;

public class GetAllStudentUseCase {
	public static void main(String[] args) {
		StudentDao dao=new StudentDaoImpl();
		
		try {
			List<Student> students=dao.getAllStudentDetails();
			students.forEach(s->{
				System.out.println("Student Name : "+s.getName());
				System.out.println("Student Email : "+s.getEmail());
				System.out.println("Student Marks : "+s.getMarks());
			});
		} catch (StudentException e) {
			System.out.println(e.getMessage());
		}
	}
}
