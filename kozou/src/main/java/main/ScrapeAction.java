package main;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import bean.Product;
import dao.SelectDAO;
import tool.Action;
import tool.JANcodeScraper;

public class ScrapeAction extends Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		String janCode = request.getParameter("janCode");
		String userId = request.getParameter("userId");
		
		SelectDAO dao = new SelectDAO();
		Product product = dao.extractInfoProduct(janCode);
		if (product.getProductName() == null) {
			JANcodeScraper scraper = new JANcodeScraper();
			product = scraper.scrapeProductInfo(janCode);
		}
		
		if (product != null) {
			session.setAttribute("userId", userId);
			session.setAttribute("product", product);
		} else {
			session.setAttribute("error", "商品情報を取得できませんでした。");
		}
		
		return "add-item.jsp";
	}
}
