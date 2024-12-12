package main;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import bean.Product;
import dao.InsertDAO;
import dao.SelectDAO;
import dao.UpdateDAO;
import tool.Action;

public class UpdateItemAction extends Action {
	
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
		
		InsertDAO dao1 = new InsertDAO();
		dao1.insertUnit(unit);
		
		int addGenre = dao1.insertGenre(genre);
		if (addGenre == 1) {
			session.setAttribute("message1", "新しい分類を追加しました。");
		}
		
		if (amt.isEmpty()) {
			amt = "0";
		}
		float amount = Float.parseFloat(amt);	
		
		UpdateDAO dao2 = new UpdateDAO();
		int editItem = dao2.updateItem(janCode, productName, amount, unit, genre, manufacturer);
		
		if (editItem == 1) {
			SelectDAO dao3 = new SelectDAO();
			Product updatedProduct = dao3.extractInfoProduct(janCode);
			
			session.setAttribute("product", updatedProduct);
			session.setAttribute("message2", "商品情報を更新しました。");
			return "add-item-confirm.jsp";
			
		} else {
			Product originalProduct = new Product();
			originalProduct.setProductName(productName);
			originalProduct.setGenre(genre);
			
			session.setAttribute("product", originalProduct);
			session.setAttribute("message2", "商品情報の更新に失敗しました。");
			return "add-item-confirm.jsp";
		}
	}		
}

