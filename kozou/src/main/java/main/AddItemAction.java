package main;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.InsertDAO;
import tool.Action;

public class AddItemAction extends Action {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		
		String janCode = request.getParameter("janCode");
		String productName = request.getParameter("productName");
		int amount = Integer.parseInt(request.getParameter("amount"));
		String unit = request.getParameter("unit");
		String manufacturer = request.getParameter("manufacturer");
		String genre = request.getParameter("genre");
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		InsertDAO dao1 = new InsertDAO();
		int addUnit = dao1.insertUnit(unit);
		int addGenre = dao1.insertGenre(genre);
		int addProduct = dao1.insertProduct(janCode, productName, amount, unit, genre, manufacturer);
		int addItem = dao1.insertItem(userId, productName, genre);
		
		
		
		return null;
		
	}
}
