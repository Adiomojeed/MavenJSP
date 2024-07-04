package com.codeleaf.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codeleaf.web.model.UserModel;

public class UserDao {
	Connection conn;
	public UserDao() {
		try {
			String URL = "jdbc:mysql://localhost:3306/school";
			String USERNAME = "root";
			String PASSWORD = "";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connected to database");
		} catch (ClassNotFoundException e) {
			System.out.println("Class: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL: " + e.getMessage());
		}
	}
	
	public UserModel getUser(int id) {
		String sql = "select * from students where id=?"; 
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int uid = rs.getInt("id");
				String name = rs.getString("name");
				return new UserModel(uid, name);
			} else {
				System.out.println("User not found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SQL2: " + e.getMessage());
		}
		return null;
		
	}
}
