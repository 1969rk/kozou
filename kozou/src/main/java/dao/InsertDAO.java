package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDAO extends DAO {
	
	public int insertUnit(String unit) throws Exception {
		
		Connection con = getConnection();
		
		String sql = "INSERT INTO unit_db (unit) VALUES (?);";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, unit);
		
		try {
			int n = ps.executeUpdate();
			
			ps.close();
			con.close();
			return n;
			
		} catch (SQLException e) {
			ps.close();
			con.close();
			return 0;
		}
	}

	
	public int insertGenre(String genre) throws Exception {
		
		Connection con = getConnection();
		
		String sql = "INSERT INTO genre_db (genre) VALUES (?);";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, genre);
		
		try {
			int n = ps.executeUpdate();
			
			ps.close();
			con.close();
			return n;
			
		} catch (SQLException e) {
			ps.close();
			con.close();
			return 0;
		}
	}
	
	
	public int insertProduct(
			String janCode, String name, int amount, String unit, String genre, String manufacturer
			) throws Exception {
		
		Connection con = getConnection();
		
		SelectDAO dao = new SelectDAO();
		int unitId = dao.toUnitId(unit);
			
		int genreId = dao.toGenreId(genre);
		
		String sql = "INSERT INTO product_db (jan_code, name, amount, unit_id, genre_id, manufacturer) "
				+ "VALUES (?, ?, ?, ?, ?, ?);";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, janCode);
		ps.setString(2, name);
		ps.setInt(3, amount);
		ps.setInt(4, unitId);
		ps.setInt(5, genreId);
		ps.setString(6, manufacturer);
		int n = ps.executeUpdate();
		
		ps.close();
		con.close();
		return n;
	}
	
	public int insertItem(int userId, String janCode, String genre) throws Exception {
		
		Connection con = getConnection();
				
		SelectDAO dao = new SelectDAO();
		int productId = dao.toProductId(janCode);
		int genreId = dao.toGenreId(genre);
		
		String sql = "INSERT INTO stock_db (user_id, product_id, genre_id) "
				+ "VALUES (?, ?, ?);";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, userId);
		ps.setInt(2, productId);
		ps.setInt(3, genreId);
		int n = ps.executeUpdate();
		
		ps.close();
		con.close();
		return n;
	}
	
	

}
