package com.accolite.jdbc;

import java.sql.*;

public class MysqlConn {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			
			// load driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// open db connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcDemo?useSSL=false", "root", "root");
			
			stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_UPDATABLE,
				    ResultSet.HOLD_CURSORS_OVER_COMMIT);
			
			//normal insertion
//			String sql = "insert into employee(empId,empName,age) values (3272,'Ps',21)";
//			int rowAffected= stmt.executeUpdate(sql);
//			System.out.println("Rows effected by insert:"+rowAffected);
			//normal updation
//			String sql="update employee set empName='Praveen' where empId='3272'";
//			int rowAffected= stmt.executeUpdate(sql);
//			System.out.println("Rows effected by Update:"+rowAffected);
//			//inserting using result set
//			rs = stmt.executeQuery("select * from employee");
//			rs.moveToInsertRow();
//			rs.updateString(2, "Siva");
//			rs.updateInt(1, 3039);
//			rs.updateInt(3, 21);
//			rs.insertRow();
//			
			//Insert using prepareStatement
//			PreparedStatement stmt1=con.prepareStatement("insert into employee(empId,empName,age) values (?,?,?)");  
//			stmt1.setInt(1,3811);//1 specifies the first parameter in the query  
//			stmt1.setString(2,"Thamil");  
//			stmt1.setInt(3,20);  
//			int i=stmt1.executeUpdate();  
//			System.out.println(i+" records inserted");
//			update using prepared statement
			String query = "update employee set empName = ? where empId = ?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, "Sivagami Sankaralingam");
			ps.setInt(2, 5353);
			int rowA=ps.executeUpdate();
			System.out.println("Rows affected by update:"+rowA);
			//delete using prepared statement
			String dQuery="delete from employee where empName=?";
			PreparedStatement ps2=con.prepareStatement(dQuery);
			ps2.setString(1, "Thamil");
			int rowB=ps2.executeUpdate();
			System.out.println("Rows affected by delete:"+rowB);
			
			//batch opearations---insertion
//			String q1="insert into employee values(2222,'Shruthi',21)";
//			String q2="insert into employee values(1111,'Sri',21)";
//			String q3="insert into employee values(3333,'Dhanya',21)";
//			
//			Statement bstmt=con.createStatement();
//			bstmt.addBatch(q1);
//			bstmt.addBatch(q2);
//			bstmt.addBatch(q3);
//			int[] rowsAff=bstmt.executeBatch();
//			System.out.println("Rows inserted using batch statement:"+rowsAff[0]);
			
			//batch operation----update
//			String sql = "update employee set empName=? where empId=?";
//			PreparedStatement preparedStatement = null;
//			
//			    preparedStatement = con.prepareStatement(sql);
//			    preparedStatement.setString(1, "Gary");
//			    preparedStatement.setLong  (2, 1612);
//			    preparedStatement.addBatch();
//			
//			    preparedStatement.setString(1, "Tony Stark");
//			    preparedStatement.setLong  (2, 3511);
//			    preparedStatement.addBatch();
//			    int[] rowsAff=preparedStatement.executeBatch();
//				System.out.println("Rows updated using batch statement:"+rowsAff[0]);
//				rs = stmt.executeQuery("select * from employee");
//				
				//calling procedure using callable statement
				String cpquery="{call getEmp()}";
				CallableStatement cs = null;
				cs = con.prepareCall(cpquery);
				rs=cs.executeQuery();
				while (rs.next())
					System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getInt("age"));
//				DatabaseMetaData dmd=con.getMetaData();
//				System.out.println(dmd.getSQLKeywords());
		
		} 
		catch (Exception e) 
		{
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
