package admin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import bean.User;
import dao.InitialDAO;
import dao.SecurityDAO;
import tool.Action;

public class ALoginAction extends Action {
	
public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		InitialDAO init = new InitialDAO();
		init.initialize();
		
		HttpSession session = request.getSession();
		
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		
		if (!loginId.equals("root")) {
			return "admin-login-error.jsp";
		}
				
		SecurityDAO dao1 = new SecurityDAO();
		User user = dao1.loginSearch(loginId, password);
		
		if (user != null) {
			
			session.setAttribute("user", user);
			return "admin-menu.jsp";
		
		}
		
		return "admin-login-error.jsp";
		
	}

}
