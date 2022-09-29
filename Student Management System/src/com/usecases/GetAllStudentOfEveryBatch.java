package com.usecases;

import java.util.List;

import com.bean.BatchDTO;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.exceptions.StudentException;

public class GetAllStudentOfEveryBatch {
	public static void get() {
		StudentDao dao=new StudentDaoImpl();
		try {
			List<BatchDTO> students= dao.getAllStudentBatch();
			
			students.forEach(s->{
				int i=1;
				System.out.println("-------------------------------------");
				System.out.println("Student No - "+i++);
				System.out.println("-------------------------------------");
				System.out.println("Student name - "+s.getSname());
				System.out.println("Student roll - "+s.getRoll());
				System.out.println("Student marks - "+s.getMarks());
				System.out.println("Student email - "+s.getEmail());
				System.out.println("Student batch id - "+s.getBid());
				System.out.println("Student batch name - "+s.getBname());
			});
		} catch (StudentException e) {
			
			e.printStackTrace();
		}
		
	}
}
