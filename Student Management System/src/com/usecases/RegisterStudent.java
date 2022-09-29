package com.usecases;

import java.util.Scanner;

import com.bean.Student;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;

public class RegisterStudent {
	public static void register() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter details of student to register");
		
		System.out.println("Enter student name");
		String name=sc.next();
		System.out.println("Enter student marks");
		int marks=sc.nextInt();
		System.out.println("Enter student email");
		String email=sc.next();
		System.out.println("Enter student password");
		String password=sc.next();
		
		Student s=new Student();
		s.setEmail(email);
		s.setMarks(marks);
		s.setName(name);
		s.setPassword(password);
		StudentDao dao=new StudentDaoImpl();
		String rs= dao.registerStudent(s);
		System.out.println(rs);
	}
}
