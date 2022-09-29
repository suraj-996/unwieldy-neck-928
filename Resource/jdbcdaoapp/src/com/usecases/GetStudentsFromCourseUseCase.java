package com.usecases;

import java.util.List;
import java.util.Scanner;

import com.bean.StudentDTO;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.exceptions.CourseException;

public class GetStudentsFromCourseUseCase {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter course name");
		String cname=sc.next();
		StudentDao dao=new StudentDaoImpl();
		try {
			List<StudentDTO> dtos=dao.getAllStudentByCname(cname);
			dtos.forEach(d->System.out.println(d));
			
		} catch (CourseException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
