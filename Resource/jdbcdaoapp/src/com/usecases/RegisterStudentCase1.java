package com.usecases;

import java.util.Scanner;

import com.bean.Student;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;

public class RegisterStudentCase1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter student name: ");
		String sname=sc.next();
		System.out.println("Enter student marks: ");
		int marks=sc.nextInt();
		System.out.println("Enter student email: ");
		String email=sc.next();
		System.out.println("Enter student password: ");
		String password=sc.next();
		
		StudentDao dao=new StudentDaoImpl();
		
		Student student =new Student();
		student.setName(sname);
		student.setMarks(marks);
		student.setEmail(email);
		student.setPassword(password);
		String result =dao.registerStudent(student);
		System.out.println(result);
	}
}	
