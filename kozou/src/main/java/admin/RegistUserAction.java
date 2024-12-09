package admin;

import java.util.regex.Pattern;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.SecurityDAO;
import tool.Action;

public class RegistUserAction extends Action {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.getSession();
		
		String userName = request.getParameter("userName");
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		
		if (userName.equals("") || loginId.equals("") || password.equals("")) {
			return "regist-error.jsp";
		}
		
		String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$";
		Pattern p = Pattern.compile(regex);
		
		if (p.matcher(password).matches()) {
			
			SecurityDAO dao = new SecurityDAO();
			int line = dao.registUser(userName, loginId, password);
			
			if (line == 1) {
				return "admin-menu.jsp";
			
			} else {
				return "regist-error2.jsp";
			
			}
		} else {
			return "regist-error3.jsp";
		
		}
	}
}
