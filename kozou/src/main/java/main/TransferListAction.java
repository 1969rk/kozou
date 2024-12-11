package main;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import bean.Stock;
import dao.GetDataDAO;
import tool.Action;

public class TransferListAction extends Action {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		int genreId = Integer.parseInt(request.getParameter("genreId"));
		String genre = request.getParameter("genre");
		
		
		GetDataDAO dao = new GetDataDAO();
		List<Stock> items = dao.makeItemList(userId, genreId); 
		
		session.setAttribute("userId", userId);
		session.setAttribute("genre", genre);
		session.setAttribute("stock", items);
		
		return "list.jsp";
		
	}

}
