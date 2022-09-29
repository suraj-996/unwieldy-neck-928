package com.usecases;

import java.util.Scanner;

import com.dao.StudentDao;
import com.dao.StudentDaoImpl;

public class UpdateStudentDetails {
	public static void update() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter student roll ");
		int roll=sc.nextInt();
		System.out.println("Enter student name ");
		String name=sc.next();
		System.out.println("Enter student email ");
		String email=sc.next();
		System.out.println("Enter student password ");
		String password=sc.next();
		System.out.println("Enter student marks ");
		int marks =sc.nextInt();
		
		StudentDao dao=new StudentDaoImpl();
		String rs= dao.updateStudentDetails(roll, name, marks, email, password);
		System.out.println(rs);
	}
}
