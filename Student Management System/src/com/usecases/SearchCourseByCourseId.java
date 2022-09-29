package com.usecases;

import java.util.Scanner;

import com.bean.Course;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.exceptions.CourseException;

public class SearchCourseByCourseId {
	public static void search() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter course id to get the details");
		int cid=sc.nextInt();
		StudentDao dao=new StudentDaoImpl();
		Course c=null;
		try {
			c=dao.searchCourse(cid);
		} catch (CourseException e) {
			
			System.out.println(e.getMessage());
		}
		if(c!=null) {
			System.out.println("Course id - "+c.getCid());
			System.out.println("Course name - "+c.getCname());
			System.out.println("Course fee - "+c.getFee());
			System.out.println("Batch id - "+c.getBid());
		}else {
			System.out.println("Course does not exist");
		}
	}
}
