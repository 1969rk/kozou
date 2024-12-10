import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import bean.User;
import dao.SecurityDAO;
import tool.Action;

public class LoginAction extends Action {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		
		SecurityDAO dao1 = new SecurityDAO();
		User user = dao1.loginSearch(loginId, password);
		
		if (user != null) {
			
			session.setAttribute("user", user);
			
			response.sendRedirect(request.getContextPath() + "/main/menu.jsp");
			
			return null;
		
		}
		
		return "login-error.jsp";
		
	}
}
