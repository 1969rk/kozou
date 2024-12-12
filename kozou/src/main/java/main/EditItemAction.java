package main;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import bean.Product;
import dao.SelectDAO;
import tool.Action;

public class EditItemAction extends Action {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		int productId = Integer.parseInt(request.getParameter("productId"));
		
		SelectDAO dao = new SelectDAO();
		Product product = dao.extractInfoProduct2(productId);
		
		session.setAttribute("userId", userId);
		session.setAttribute("product", product);
		
		return "edit.jsp";
	}
}
