package com.usecases;

import java.util.Scanner;

import com.dao.StudentDao;
import com.dao.StudentDaoImpl;

public class AllocateStudentCourse {
	public static void batch() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter roll to allocate course");
		int roll=sc.nextInt();
		System.out.println("Enter cid to allocate course");
		int cid =sc.nextInt();
		StudentDao dao=new StudentDaoImpl();
		String rs= dao.addStudentInBatch(cid, roll);
		System.out.println(rs);
	}
}
