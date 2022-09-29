package com.usecases;

import java.util.Scanner;

import com.bean.Batch;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;

public class CreateBatch {
	public static void create() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter batch details to create batch ");
		System.out.println("Enter batch id");
		int bid=sc.nextInt();
		System.out.println("Enter batch name");
		String name=sc.next();
		System.out.println("Enter batch seat");
		int seat=sc.nextInt();
		Batch b=new Batch();
		b.setBid(bid);
		b.setName(name);
		b.setSeat(seat);
		StudentDao dao=new StudentDaoImpl();
		String rs=dao.createBatch(b);
		System.out.println(rs);
	}
}
