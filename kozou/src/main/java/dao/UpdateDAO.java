package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateDAO extends DAO {
	
	public int updateItem(String janCode, String productName, float amount, String unit, String genre, String manufacturer) throws Exception {
		
		Connection con = getConnection();
		
		SelectDAO dao = new SelectDAO();
		int unitId = dao.toUnitId(unit);
		int genreId = dao.toGenreId(genre);
		
		String sql = "UPDATE product_db SET name = ?, amount = ?, unit_id = ?, "
				+ "genre_id = ?, manufacturer = ? WHERE jan_code = ?;";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, productName);
		ps.setFloat(2, amount);
		ps.setInt(3, unitId);
		ps.setInt(4, genreId);
		ps.setString(5, manufacturer);
		ps.setString(6, janCode);
		int n = ps.executeUpdate();
		
		ps.close();
		con.close();
		
		return n;
	}
	
	
	public void removeItem(int stockId) throws Exception {
		
		Connection con = getConnection();
		
		String sql = "UPDATE stock_db SET stock = 0 WHERE id = ?;";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, stockId);
		ps.executeUpdate();
		
		ps.close();
		con.close();
	}
}
