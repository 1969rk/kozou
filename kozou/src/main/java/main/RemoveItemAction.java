package main;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import bean.Stock;
import dao.GetDataDAO;
import dao.SelectDAO;
import dao.UpdateDAO;
import tool.Action;

public class RemoveItemAction extends Action {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		int stockId = Integer.parseInt(request.getParameter("stockId"));
		
		SelectDAO dao1 = new SelectDAO();
		Stock itemIds = dao1.extracIdsFromStock(stockId);
		int userId = itemIds.getUserId();
		int genreId = itemIds.getGenreId();
		
		UpdateDAO dao2 = new UpdateDAO();
		dao2.removeItem(stockId);
		
		GetDataDAO dao3 = new GetDataDAO();
		List<Stock> items = dao3.makeItemList(userId, genreId); 
		
		session.setAttribute("userId", userId);
		session.setAttribute("stock", items);
		
		return "list.jsp";

	}

}
