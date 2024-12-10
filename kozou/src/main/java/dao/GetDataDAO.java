package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class GetDataDAO extends DAO {
	
	public List<> forMenu(int userId) throws Exception {
		
		Connection con = getConnection();
		
		String sql = "SELECT COUNT() FROM stock_db "
				+ "JOIN user_db ON user_db.id = stock_db.user_id "
				+ "JOIN genre_db ON genre_db.id = stock_db.genre_id "
				+ "JOIN product_db ON product_db.id = stock_db.product_id "
				+ "WHERE stock_db.user_id = ? GROUP BY ";
		
		
		
		
		
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, userId);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			
		}
		
	}

}
