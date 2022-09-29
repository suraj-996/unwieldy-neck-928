package com.usecases;

import java.util.Scanner;

import com.bean.Student;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.exceptions.StudentException;

public class LoginUseCase {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter username: ");
		String uname=sc.next();
		System.out.println("Enter password: ");
		String password=sc.next();
		
		StudentDao dao=new StudentDaoImpl();
		try {
			Student student=dao.loginStudent(uname, password);
			System.out.println("Welcome Student : "+student.getName());
		} catch (StudentException e) {
			System.out.println(e.getMessage());
		}
	}
}
