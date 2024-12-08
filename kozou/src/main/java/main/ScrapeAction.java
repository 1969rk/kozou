package main;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean.Product;
import tool.Action;

public class ScrapeAction extends Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String janCode = request.getParameter("janCode");
		
		if (janCode == null || janCode.isEmpty()) {
			request.setAttribute("error", "JANコードを入力してください。");
			return "input.jsp";
		}
		
		JANcodeScraper scraper = new JANcodeScraper();
		Product product = scraper.scrapeProductInfo(janCode);
		
		if (product != null) {
			request.setAttribute("product", product);
		} else {
			request.setAttribute("error", "商品情報を取得できませんでした。");
		}
		
		return "result.jsp";
	}
}
