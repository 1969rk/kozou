package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateDAO extends DAO {
	
	public void removeItem(int stockId) throws Exception {
		
		Connection con = getConnection();
		
		String sql = "UPDATE stock_db SET stock = 0 WHERE id = ?;";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, stockId);
		ps.executeUpdate();
	}
}
