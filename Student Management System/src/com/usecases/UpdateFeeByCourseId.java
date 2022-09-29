package com.usecases;

import java.util.Scanner;

import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.exceptions.CourseException;

public class UpdateFeeByCourseId {
	public static void update() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter course id for which you want to update fees");
		int cid=sc.nextInt();
		System.out.println("Enter fees which you want to update");
		int fee=sc.nextInt();
		StudentDao dao=new StudentDaoImpl();
		String rs=null;
		try {
			rs=dao.updateFeeByCourseId(cid, fee);
			
		} catch (CourseException e) {
			
			System.out.println(e.getMessage());
		}
		
		System.out.println(rs);
	}
}
