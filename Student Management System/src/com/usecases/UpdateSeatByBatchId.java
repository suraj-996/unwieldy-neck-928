package com.usecases;

import java.util.Scanner;

import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.exceptions.BatchException;

public class UpdateSeatByBatchId {
	public static void seat() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter seat which you want to update");
		int seat=sc.nextInt();
		System.out.println("Enter bid for which you want to update");
		int bid=sc.nextInt();
		
		StudentDao dao=new StudentDaoImpl();
		String rs=null;
		try {
			rs=dao.updateSeat(seat, bid);
		} catch (BatchException e) {
			
			e.printStackTrace();
		}
		System.out.println(rs);
	}
}
