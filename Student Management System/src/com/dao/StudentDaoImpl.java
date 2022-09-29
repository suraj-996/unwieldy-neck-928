package com.dao;

import com.bean.Batch;
import com.bean.BatchDTO;
import com.bean.Course;
import com.bean.Student;
import com.exceptions.BatchException;
import com.exceptions.CourseException;
import com.exceptions.StudentException;
import com.utility.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class StudentDaoImpl implements StudentDao{

	@Override
	public String addNewCourse(Course course) {
		String msg="Not inserted";
		
		try(Connection conn= DBUtil.provideConnection()) {
			PreparedStatement ps= conn.prepareStatement("insert into course values(?,?,?,?)");
			ps.setInt(1, course.getCid());
			ps.setString(2, course.getCname());
			ps.setInt(3, course.getFee());
			ps.setInt(4, course.getBid());
			
			int x=ps.executeUpdate();
			if(x>0) {
				msg="A new course added successfully";
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return msg;
	}

	@Override
	public String deleteCourse(String c) throws CourseException{
		String msg="Not deleted";
		
		try(Connection conn=DBUtil.provideConnection();) {
			PreparedStatement ps= conn.prepareStatement("delete from course where cname=?");
			ps.setString(1, c);
			int x=ps.executeUpdate();
			if(x>0) {
				msg="Course deleted successfully "+c;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new CourseException("Course does not exist "+c);
		}
		return msg;
	}

	@Override
	public String updateFeeByCourseId(int cid,int fee) throws CourseException {
		String msg="Not Updated";
		
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps= conn.prepareStatement("update course set fee=? where cid=?");
			ps.setInt(1, fee);
			ps.setInt(2, cid);
			int x=ps.executeUpdate();
			if(x>0) {
				msg="Fee Updated Successfully for cid "+cid;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CourseException("Course id does not exist");
			
		}
		return msg;
	}

	@Override
	public Course searchCourse(int cid) throws CourseException {
		Course c=null;
		
		
		try (Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps= conn.prepareStatement("select * from course where cid=?");
			ps.setInt(1, cid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				int ci=rs.getInt("cid");
				String cn=rs.getString("cname");
				int f=rs.getInt("fee");
				int b=rs.getInt("bid");
				c=new Course(ci,cn,f,b);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new CourseException("Course does not exist");
		}
		return c;
	}

	@Override
	public String createBatch(Batch batch) {
		String msg="Not inserted";
		Connection conn=DBUtil.provideConnection();
		try {
			PreparedStatement ps= conn.prepareStatement("insert into batch values(?,?,?)");
			ps.setInt(1, batch.getBid());
			ps.setString(2, batch.getName());
			ps.setInt(3, batch.getSeat());
			int x=ps.executeUpdate();
			if(x>0) {
				msg="Batch Inserted Successfully";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return msg;
	}

	@Override
	public String addStudentInBatch(int cid, int roll) {
		String msg="Not inserted";
		
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("insert into student_batch values(?,?)");
			ps.setInt(1, cid);
			ps.setInt(2, roll);
			int x=ps.executeUpdate();
			if(x>0) {
				msg="Course alloted successfully for student roll "+roll;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return msg;
	}

	@Override
	public String updateSeat(int seat,int bid) throws BatchException {
		String msg="Not updated";
		
		try (Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("update batch set seat=? where bid=?");
			ps.setInt(1, seat);
			ps.setInt(2,bid);
			int x=ps.executeUpdate();
			if(x>0) {
				msg="Seat updated successfully";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			new BatchException("Not able to update seat for batch id "+bid);
		}
		return msg;
	}

	@Override
	public List<BatchDTO> getAllStudentBatch() throws StudentException {
		List<BatchDTO> students=new ArrayList<>();
		
		
		try (Connection conn=DBUtil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("select s.name,s.roll,s.marks,s.email,b.bid,b.name from student s INNER JOIN student_batch sb ON s.roll=sb.roll INNER JOIN course c ON c.cid=sb.cid INNER JOIN batch b ON b.bid=c.bid;");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				String n=rs.getString("name");
				int r=rs.getInt("roll");
				int m=rs.getInt("marks");
				String e=rs.getString("email");
				int b=rs.getInt("bid");
				String n2=rs.getString("name");
				BatchDTO bd=new BatchDTO(n,r,m,e,b,n2);
				students.add(bd);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			new BatchException("No student found");
		}
		return students;
	}

	@Override
	public String registerStudent(Student student) {
		String msg="Not registered";
		
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("insert into student (name,marks,email,password) values(?,?,?,?)");
			
			ps.setString(1, student.getName());
			ps.setInt(2, student.getMarks());
			ps.setString(3, student.getEmail());
			ps.setString(4, student.getPassword());
			
			int x=ps.executeUpdate();
			if(x>0) {
				msg="Student registered successfully";
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return msg;
	}

	@Override
	public String updateStudentDetails(int roll, String name, int marks, String email, String password) {
		String msg="Not updated";
		Connection conn=DBUtil.provideConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("update student set name=?,marks=?,email=?,password=? where roll=?");
			ps.setString(1, name);
			ps.setInt(2, marks);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setInt(5, roll);
			int x=ps.executeUpdate();
			if(x>0) {
				msg="Updated student details successfully";
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Course> getAllCourse() throws CourseException {
		List<Course> courses = new ArrayList<>();
		
		Connection conn=DBUtil.provideConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from course");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int ci=rs.getInt("cid");
				String cn=rs.getString("cname");
				int f=rs.getInt("fee");
				int b=rs.getInt("bid");
				Course c=new Course(ci,cn,f,b);
				courses.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			new BatchException("No course found");
		}
		return courses;
	}
	
	

	

	
	
	
	
}
