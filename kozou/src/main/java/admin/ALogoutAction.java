package admin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import tool.Action;

public class ALogoutAction extends Action {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession(false);
		
		if (session != null && session.getAttribute("user") != null) {
			
			session.invalidate();
			
			response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
			response.setHeader("Pragma", "no-cache");
			response.setDateHeader("Expires", 0);
			
			response.sendRedirect(request.getContextPath());
			
			return null;			
		}
		
		return "admin-logout-error.jsp";
	}
}
