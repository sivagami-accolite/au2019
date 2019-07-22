package com.accolite.jdbc;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import com.mysql.jdbc.PreparedStatement;

public class HashMapCrudOperations {

	public static void main(String[] args) throws SQLException {

		Student s1 = new Student("Mala", 21);
		Student s2 = new Student("Darwin", 21);
		Student s3 = new Student("Karthi", 21);
		Student s4 = new Student("Harshitha", 21);
		Student s5 = new Student("Narmatha", 21);
		HashMap<Integer, Student> hmInsert = new HashMap<>();
		hmInsert.put(1, s1);
		hmInsert.put(2, s2);
		hmInsert.put(3, s3);
		hmInsert.put(4, s4);
		hmInsert.put(5, s5);

		HashMap<Integer, Student> hmUpdate = new HashMap<>();
		Student s6 = new Student("Siva", 21);
		Student s7 = new Student("Praveen", 21);
		hmUpdate.put(4, s6);
		hmUpdate.put(5, s7);
		
		HashMap<Integer, Student> hmDelete = new HashMap<>();
		hmDelete.put(4, s6);
		hmDelete.put(5, s7);
		
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcDemo?useSSL=false", "root", "root");
			stmt = con.createStatement();

			// inserting the hmInsert values into the table Student
			PreparedStatement stmt1 = (PreparedStatement) con.prepareStatement("insert into student(studentId,studentName,age) values (?,?,?)");
			for (Map.Entry<Integer, Student> entry : hmInsert.entrySet()) {
				Integer id = entry.getKey();
				Student s = entry.getValue();
				int ids=id.intValue();
				String name = s.getName();
				int age = s.getAge();
				stmt1.setInt(1, ids);
				stmt1.setString(2, name);
				stmt1.setInt(3, age);
				stmt1.addBatch();
			}
			int count[] = stmt1.executeBatch();
            System.out.println("Inserted successfully!");
			//updating the Student table using hmUpdate
			PreparedStatement stmt2 = (PreparedStatement) con.prepareStatement("update student set studentName=? where studentId=?");
			for (Map.Entry<Integer, Student> entry1 : hmUpdate.entrySet()) {				
				Integer id = entry1.getKey();
				Student s = entry1.getValue();
				int ids=id.intValue();
				String name = s.getName();
				//System.out.println(ids+" "+name);
				stmt2.setString(1, name);
				stmt2.setInt(2, ids);
				stmt2.addBatch();
			}
			int count1[] = stmt2.executeBatch();
			System.out.println("Updated successfully!");
//			Deleting the Student table using hmDelete
			PreparedStatement stmt3 = (PreparedStatement) con.prepareStatement("delete from student where studentName=? and studentId=?");
			for (Map.Entry<Integer, Student> entry1 : hmDelete.entrySet()) {
				
				Integer id = entry1.getKey();
				Student s = entry1.getValue();
				int ids=id.intValue();
				String name = s.getName();
				stmt3.setString(1, name);
				stmt3.setInt(2, ids);
				stmt3.addBatch();
			}
			int count2[] = stmt3.executeBatch();
			System.out.println("Deleted successfully!");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// close the connection
			if (con != null)
				con.close();
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
		}

	}

}
