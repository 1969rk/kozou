package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Password;
import bean.User;
import tool.Hash;

public class SecurityDAO extends DAO {
	
	public User loginSearch(String loginId, String password) throws Exception {
		
		Connection con = getConnection();
		
		User user = null;
		
		try {
			String sql1 = "SELECT * FROM user_db WHERE login_id = ?";
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps1.setString(1, loginId);
			ResultSet rs1 = ps1.executeQuery();
			
			if (rs1.next()) {
				int userId = rs1.getInt("id");
				ps1.close();
			
				Hash h = new Hash();
				String hashWord = h.loginHash(userId, password);
			
				String sql2 = "SELECT * FROM user_db WHERE login_id = ? AND password = ?;";
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setString(1, loginId);
				ps2.setString(2, hashWord);
				ResultSet rs2 = ps2.executeQuery();
			
				if (rs2.next()) {
					user = new User();
					user.setUserId(rs2.getInt("id"));
					user.setUserName(rs2.getString("name"));
				}
				ps2.close();
			}
			con.close();
			return user;
			
		} catch (Exception e) {
			return user;
		}
	}
	
	
	public String extractSalt(int userId) throws Exception {
		
		Connection con = getConnection();
		
		String sql = "SELECT salt FROM user_db WHERE id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, userId);
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		String salt = rs.getString("salt");
		
		return salt;
	}
	
	
	public int registUser(String userName, String loginId, String password) throws Exception {
		
		Connection con = getConnection();
		
		Hash h = new Hash();
		Password pw = h.registHash(password);
		String hashedPassword = pw.getHashWord();
		String salt = pw.getSalt();
		
		String sql = "INSERT INTO user_db (name, login_id, password, salt) "
				+ "VALUES (?, ?, ?, ?);";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userName);
		ps.setString(2, loginId);
		ps.setString(3, hashedPassword);
		ps.setString(4, salt);
		
		try {
			int line = ps.executeUpdate();
			
			ps.close();
			con.close();
			return line;
			
		} catch (Exception e) {
			
			ps.close();
			con.close();
			return 0;
			
		}
	}
	
}
