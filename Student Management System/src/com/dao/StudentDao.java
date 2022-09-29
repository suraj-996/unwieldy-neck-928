package com.dao;

import java.util.List;

import com.bean.Batch;
import com.bean.BatchDTO;
import com.bean.Course;
import com.bean.Student;
import com.exceptions.BatchException;
import com.exceptions.CourseException;
import com.exceptions.StudentException;

public interface StudentDao {
//	Admin methods 
	public String addNewCourse(Course course);
	public String deleteCourse(String cname) throws CourseException;
	public String updateFeeByCourseId(int cid,int fee) throws CourseException;
	public Course searchCourse(int cid) throws CourseException;
	public String createBatch(Batch batch);
	public String addStudentInBatch(int cid,int roll);
	public String updateSeat(int seat,int bid) throws BatchException;
	public List<BatchDTO> getAllStudentBatch() throws StudentException;
//	Student methods
	public String registerStudent(Student student);
	public String updateStudentDetails(int roll,String name,int marks,String email,String password);
	public List<Course> getAllCourse() throws CourseException;
}
