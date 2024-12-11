import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import bean.GenreCount;
import bean.User;
import dao.GetDataDAO;
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
			
			int userId = user.getUserId();
			GetDataDAO dao2 = new GetDataDAO();
			List<GenreCount> gcs = dao2.genreCount(userId);
			
			session.setAttribute("user", user);
			session.setAttribute("genreCount", gcs);
			
			response.sendRedirect(request.getContextPath() + "/main/menu.jsp");
			
			return null;
		
		}
		
		return "login-error.jsp";
		
	}
}
