package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Stock;

public class SelectDAO extends DAO {
	
	public int toUnitId(String unit) throws Exception {
		
		Connection con = getConnection();
		
		String sql = "SELECT id FROM unit_db WHERE unit = ?;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, unit);
		ResultSet rs = ps.executeQuery();
		
		int unitId = 1;
		
		if (rs.next()) {
			unitId = rs.getInt("id");
			ps.close();
		}
		
		con.close();		
		return unitId;
	}
	
	
	public int toGenreId(String genre) throws Exception {
		
		Connection con = getConnection();
		
		String sql = "SELECT id FROM genre_db WHERE genre = ?;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, genre);
		ResultSet rs = ps.executeQuery();
		
		int genreId = 1;
		
		if (rs.next()) {
			genreId = rs.getInt("id");			
			ps.close();
		}
		
		con.close();
		return genreId;
	}
	
	
	public int toProductId(String janCode) throws Exception {
		
		Connection con = getConnection();
		
		String sql = "SELECT id FROM product_db WHERE jan_code = ?;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, janCode);
		ResultSet rs = ps.executeQuery();
		
		int productId = 1;
		
		if (rs.next()) {
			productId = rs.getInt("id");
			ps.close();
		}
		
		con.close();
		return productId;
	}
	
	
	public Stock extracIdsFromStock(int stockId) throws Exception {
		
		Connection con = getConnection();
		
		String sql = "SELECT * FROM stock_db WHERE id = ?;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, stockId);
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		Stock stock = new Stock();
		stock.setUserId(rs.getInt("user_id"));
		stock.setGenreId(rs.getInt("genre_id"));
		
		ps.close();
		con.close();
		return stock;
	}
	
	
	public String convertGenre(int genreId) throws Exception {
		
		Connection con = getConnection();
		
		String sql = "SELECT genre FROM genre_db WHERE id = ?;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, genreId);
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		String genre = rs.getString("genre");
		
		ps.close();
		con.close();
		return genre;
	}

}
