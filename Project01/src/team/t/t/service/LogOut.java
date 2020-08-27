package team.t.t.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.t.t.service.Action;


public class LogOut implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		    
		System.out.println("LogOut");
		HttpSession session = request.getSession();
		session.invalidate();
		
		Cookie[] cookie = request.getCookies();
		
		if(cookie != null) {
			for(Cookie c : cookie) {
				
				if(c.getName().equals("id")) {
					c.setMaxAge(0);
					c.setPath("/");
					response.addCookie(c);
				}
			}
		}
		
		ActionForward forward = new ActionForward();
		forward.setPath("/loginForm.do");
		return forward;
	}

}
