package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.GenreCount;
import bean.Stock;

public class GetDataDAO extends DAO {
	
	public List<GenreCount> genreCount(int userId) throws Exception {
		
		Connection con = getConnection();
		
		String sql = "SELECT genre_db.id AS id, genre_db.genre AS genre, SUM(stock_db.stock) AS stock_count "
				+ "FROM stock_db JOIN user_db ON user_db.id = stock_db.user_id "
				+ "JOIN genre_db ON genre_db.id = stock_db.genre_id "
				+ "JOIN product_db ON product_db.id = stock_db.product_id "
				+ "WHERE stock_db.user_id = ? AND stock_db.stock = 1 "
				+ "GROUP BY genre_db.genre, genre_db.id "
				+ "ORDER BY genre_db.id;";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, userId);
		ResultSet rs = ps.executeQuery();
		
		List<GenreCount> gcs = new ArrayList<>();
		
		while (rs.next()) {
			GenreCount gc = new GenreCount();
			gc.setGenreId(rs.getInt("id"));
			gc.setGenre(rs.getString("genre"));
			gc.setStockCount(rs.getInt("stock_count"));
			gcs.add(gc);
		}
		
		ps.close();
		con.close();
		
		return gcs;
	}
	
	
	public List<Stock> makeItemList(int userId, int genreId) throws Exception {
		
		Connection con = getConnection();
		
		String sql = "SELECT stock_db.id AS id, product_db.name AS product_name, stock, add_at "
				+ "FROM stock_db JOIN product_db ON product_db.id = stock_db.product_id "
				+ "WHERE user_id = ? AND stock_db.genre_id = ? AND stock = 1;";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, userId);
		ps.setInt(2, genreId);
		ResultSet rs = ps.executeQuery();
		
		List<Stock> items = new ArrayList<>();
		
		while (rs.next()) {
			Stock item = new Stock();
			item.setStockId(rs.getInt("id"));
			item.setProductName(rs.getString("product_name"));
			item.setStockBoolean(rs.getInt("stock"));
			item.setAddTime(rs.getString("add_at"));
			items.add(item);
		}
		
		ps.close();
		con.close();
		
		return items;
	}

}
