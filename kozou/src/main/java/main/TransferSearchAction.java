package main;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import tool.Action;

public class TransferSearchAction extends Action {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		session.setAttribute("userId", userId);
		
		return "search.jsp";
		
	}
}
