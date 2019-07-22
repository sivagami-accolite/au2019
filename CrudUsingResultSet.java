package com.accolite.jdbc;

import java.sql.*;

public class CrudUsingResultSet {

	public static void main(String[] args) throws SQLException {
		
		ResultSet rs=null;
		Statement stmt=null;
		Connection con=null;
		// load driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
					
		// open db connection
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcDemo?useSSL=false", "root", "root");
		stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,
							ResultSet.CONCUR_UPDATABLE,
						    ResultSet.HOLD_CURSORS_OVER_COMMIT);
		//inserting using resultSet
		
		rs = stmt.executeQuery("select * from student");
		rs.moveToInsertRow();
		rs.updateInt(1, 3039);
		rs.updateString(2, "Siva");
		rs.updateInt(3, 21);
		rs.insertRow();
		
		//updating using ResultSet
		
		rs = stmt.executeQuery("select * from student");
		while(rs.next()){
	         int newAge = rs.getInt("age") + 10;
	         rs.updateInt( "age", newAge );
	         rs.updateRow();
	      }	
		
		rs = stmt.executeQuery("select * from student");
		while (rs.next())
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getInt("age"));
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		finally 
		{
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
