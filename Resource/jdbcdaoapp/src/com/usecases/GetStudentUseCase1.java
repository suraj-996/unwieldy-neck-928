package com.usecases;

import java.util.Scanner;

import com.bean.Student;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.exceptions.StudentException;

public class GetStudentUseCase1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter student roll: ");
		int roll=sc.nextInt();
		
		StudentDao dao=new StudentDaoImpl();
		Student st=null;
		try {
			st = dao.getStudentByRoll(roll);
		} catch (StudentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		
		if(st!=null) {
			System.out.println(st);
		}else {
			System.out.println("student does not exist");
		}
	}

}
