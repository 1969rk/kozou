package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Product;
import bean.Stock;

public class SelectDAO extends DAO {
	
	/* Product data will be obtained from janCode */
	public Product extractInfoProduct(String janCode) throws Exception {
		
		Connection con = getConnection();
		
		Product product = new Product();
		
		try {
			String sql = "SELECT name, amount, unit_db.unit AS unit, genre_db.genre AS genre, manufacturer "
					+ "FROM product_db JOIN unit_db ON unit_db.id = product_db.unit_id "
					+ "JOIN genre_db ON genre_db.id = product_db.genre_id WHERE jan_code = ?;";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, janCode);
			ResultSet rs = ps.executeQuery();		
			
			if (rs.next()) {
				product.setJanCode(janCode);
				product.setProductName(rs.getString("name"));
				product.setAmount(rs.getString("amount"));
				product.setUnit(rs.getString("unit"));
				product.setGenre(rs.getString("genre"));
				product.setManufacturer(rs.getString("manufacturer"));
				ps.close();
			}
			
			con.close();
			return product;
			
		} catch (Exception e) {
			con.close();
			return product;
		}
	}
	
	/* Product data will be obtained from productId */ 
	public Product extractInfoProduct2(int productId) throws Exception {
		
		Connection con = getConnection();
		
		Product product = new Product();
		
		try {
			String sql = "SELECT jan_code, name, amount, unit_db.unit AS unit, genre_db.genre AS genre, manufacturer "
					+ "FROM product_db JOIN unit_db ON unit_db.id = product_db.unit_id "
					+ "JOIN genre_db ON genre_db.id = product_db.genre_id WHERE product_db.id = ?;";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();		
			
			if (rs.next()) {
				product.setJanCode(rs.getString("jan_code"));
				product.setProductName(rs.getString("name"));
				product.setAmount(rs.getString("amount"));
				product.setUnit(rs.getString("unit"));
				product.setGenre(rs.getString("genre"));
				product.setManufacturer(rs.getString("manufacturer"));
				ps.close();
			}
			
			con.close();
			return product;
			
		} catch (Exception e) {
			con.close();
			return product;
		}
	}
	
	
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
	
// should be update
	/*     */
	public Stock extracIdsFromStock(int stockId) throws Exception {
		
		Connection con = getConnection();
		
		String sql = "SELECT stock_db.user_id AS user_id, product_db.genre_id AS genre_id FROM stock_db "
				+ "JOIN product_db ON product_db.id = stock_db.product_id WHERE stock_db.id = ?;";
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
