package main;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import bean.GenreCount;
import dao.GetDataDAO;
import tool.Action;

public class UpdateDataAction extends Action {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		GetDataDAO dao = new GetDataDAO();
		List<GenreCount> gcs = dao.genreCount(userId);
		
		session.setAttribute("userId", userId);
		session.setAttribute("genreCount", gcs);
		
		return "menu.jsp";
		
	}

}
