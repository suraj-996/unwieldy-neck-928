package com.admin;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.usecases.AddNewCourse;
import com.usecases.AllocateStudentCourse;
import com.usecases.CreateBatch;
import com.usecases.DeleteCourseByCourseName;
import com.usecases.GetAllCourse;
import com.usecases.GetAllStudentOfEveryBatch;
import com.usecases.RegisterStudent;
import com.usecases.SearchCourseByCourseId;
import com.usecases.UpdateFeeByCourseId;
import com.usecases.UpdateSeatByBatchId;
import com.usecases.UpdateStudentDetails;

public class UserActivity {
	public static void selectUser() {

		Scanner sc = new Scanner(System.in);

		System.out.println();
		System.out
				.println("Choose an options - \n" + "1. Admin Login\n" + "2. Student Login\n");

		System.out.println();
		System.out.println("Enter any number from above: ");

		int choice = 0;
		try {
			choice = sc.nextInt();
		} catch (InputMismatchException e) {

			System.out.println("Invalid input!");

			System.out.println();
			System.out.println("Try again...");

			UserActivity.selectUser();
		}

		switch (choice) {
		case 1:
			System.out.println("Enter admin username");
			String username=sc.next();
			System.out.println("Enter admin password");
			String password=sc.next();
			if(username.equals("root") && password.equals("Suraj@123")) {
				System.out.println("Admin login successful");
				UserActivity.admin();
			}else {
				System.out.println("Username or password are wrong try again");
				UserActivity.selectUser();
			}
			
			break;
		case 2:
			UserActivity.student();
			break;
		default:
			System.out.println("Invalid choice!");
			System.out.println();

			System.out.println("Try again...");
			UserActivity.selectUser();
		}
	}

	public static void admin() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("	 1. Add a new Courses\r\n"
				+ "         2. Update Fees of course.\r\n"
				+ "         3. Delete a course from any Training session.\r\n"
				+ "         4. Search information about a course.\r\n"
				+ "         5. Create Batch under a course.\r\n"
				+ "         6. Allocate students in a Batch under a course.\r\n"
				+ "         7. Update total seats of a batch.\r\n"
				+ "         8. View the students of every batch.\r\n"
				+ "         9. Go Back");
		
		System.out.println();
		System.out.println("Enter any number from above which you want to operate");
		
		int c=0;
		
		try {
			c=sc.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Invalid input!");
			System.out.println("Try again....");
			UserActivity.admin();
		}
		
		switch(c) {
		case 1:
			AddNewCourse.add();
			break;
		case 2:
			UpdateFeeByCourseId.update();
			break;
		case 3:
			DeleteCourseByCourseName.delete();
			break;
		case 4:
			SearchCourseByCourseId.search();
			break;
		case 5:
			CreateBatch.create();
			break;
		case 6:
			AllocateStudentCourse.batch();
			break;
		case 7:
			UpdateSeatByBatchId.seat();
			break;
		case 8:
			GetAllStudentOfEveryBatch.get();
			break;
		case 9:
			UserActivity.selectUser();
		}
		
		UserActivity.admin();
			
	
		}
	public static void student() {
		Scanner sc=new Scanner(System.in);
		System.out.println("	1. Register himself in a course with a username and password (email should be the username)\r\n"
				+ "	2. can update this details.\r\n"
				+ "	3. can see all the available course list and their seat availability.\r\n"
				+ " 	4. Go back");
		
		System.out.println();
		System.out.println("Enter any number from above which you want to operate");
		int c=0;
		
		try {
			c=sc.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Invalid input!");
			System.out.println("Try again....");
			UserActivity.student();
		}
		
		switch(c) {
		case 1:
			RegisterStudent.register();
			break;
		case 2:
			UpdateStudentDetails.update();
			break;
		case 3:
			GetAllCourse.get();
			break;
		case 4:
			UserActivity.selectUser();;
			break;
		}
		
		UserActivity.student();
		
	}
}
