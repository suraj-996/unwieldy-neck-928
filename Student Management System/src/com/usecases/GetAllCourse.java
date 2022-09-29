package com.usecases;

import java.util.List;

import com.bean.Course;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.exceptions.CourseException;

public class GetAllCourse {
	public static void get() {
		StudentDao dao=new StudentDaoImpl();
		try {
			List<Course> courses = dao.getAllCourse();
			courses.forEach(c->{
				
				System.out.println("--------------------------");
				System.out.println("Course details - ");
				System.out.println("--------------------------");
				System.out.println("Course id - "+c.getCid());
				System.out.println("Course name - "+c.getCname());
				System.out.println("Course fee - "+c.getFee());
				System.out.println("Course bid - "+c.getBid());
				
			});
		} catch (CourseException e) {
			e.printStackTrace();
		}
	}
}
