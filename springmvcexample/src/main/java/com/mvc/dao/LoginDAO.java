package com.mvc.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mvc.model.LoginDetails;
import com.mvc.model.User;

@Repository
public class LoginDAO{

	@Autowired
	JdbcTemplate jTemplate;
	
	public long save(User user) {
		String sql;
		sql = "INSERT INTO REGISTER(FIRSTNAME,PASSWORD)"+" VALUES('"+user.getFirstName()+"','"+user.getPassword()+"')";
		System.out.println(sql);
		this.jTemplate.execute(sql);
		return 1;
	}
	
	public List<LoginDetails> viewUser() {
		String sql = "select * from login ";
		return this.jTemplate.query(sql, new RowMapper<LoginDetails>(){
			public LoginDetails mapRow(ResultSet rs, int arg1) throws SQLException {
				LoginDetails m = new LoginDetails();
				m.setUsername(rs.getString("firstname"));
				m.setStatus(rs.getString("status"));
				return m;
			}
		});
	}
	
	
	
	public List<User> getUsers(String name)
	{
		String sql="select * from register where firstname='"+name+"';";
		List<User> users = this.jTemplate.query(sql, new RowMapper<User>(){
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User m = new User();
				m.setFirstName(rs.getString("firstname"));
				m.setPassword(rs.getString("password"));
				return m;
			}
		});
		return users;
	}

	public void removeRegistered(String name) {
		String sql;
		sql="DELETE from register where firstname='"+name+"';";
		System.out.println(sql);
		this.jTemplate.execute(sql);
		
	}

	public void createAdminView(String name, String status) {
		String sql;
		sql = "INSERT INTO LOGIN(FIRSTNAME,STATUS)"+" VALUES('"+name+"','"+status+"')";
		System.out.println(sql);
		this.jTemplate.execute(sql);
	}

	public void deleteLoggedIn(String name) {
		String sql="delete from login where firstname='"+name+"';";
		System.out.println(sql);
		this.jTemplate.execute(sql);
	}
}
