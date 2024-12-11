package main;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import bean.Product;
import dao.InsertDAO;
import tool.Action;

public class AddItemAction extends Action {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		
		String janCode = request.getParameter("janCode");
		String productName = request.getParameter("productName");
		String amt = request.getParameter("amount");
		String unit = request.getParameter("unit");
		String manufacturer = request.getParameter("manufacturer");
		String genre = request.getParameter("genre");
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		session.setAttribute("userId", userId);
		
		InsertDAO dao = new InsertDAO();
		dao.insertUnit(unit);
		
		int addGenre = dao.insertGenre(genre);
		if (addGenre == 1) {
			session.setAttribute("message2", "新しい分類を追加しました。");
		}
		
		if (amt.isEmpty()) {
			amt = "0";
		}
		float amount = Float.parseFloat(amt);	
		int addProduct = dao.insertProduct(janCode, productName, amount, unit, genre, manufacturer);
		if (addProduct == 1) {
			session.setAttribute("message3", "新しい商品を追加しました。");
		}
		
		int addItem = dao.insertItem(userId, janCode, genre);
		if (addItem == 1) {
			Product product = new Product();
			product.setProductName(productName);
			product.setGenre(genre);
			session.setAttribute("product", product);
			return "add-item-confirm.jsp";
		} else {
			session.setAttribute("message4", "商品の追加に失敗しました。");
			return "add-item-confirm.jsp";
		}
		
	}
}
