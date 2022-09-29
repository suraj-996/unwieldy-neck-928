package com.usecases;

import java.util.Scanner;

import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.exceptions.CourseException;

public class DeleteCourseByCourseName {
	public static void delete() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter course name which you want to delete");
		String cname=sc.next();
		StudentDao dao=new StudentDaoImpl();
		String rs=null;
		try {
			rs = dao.deleteCourse(cname);
		} catch (CourseException e) {
			
			System.out.println(e.getMessage());
		}
		System.out.println(rs);
		
	}
}
