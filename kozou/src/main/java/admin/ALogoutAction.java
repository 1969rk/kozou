package admin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import tool.Action;

public class ALogoutAction extends Action {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("user") != null) {
			
			session.invalidate();
			return "../main/index.jsp";			
		}
		
		return "logout-error.jsp";
	}
}
