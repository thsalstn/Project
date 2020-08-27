package team.t.t.service;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class LoginManager implements HttpSessionBindingListener  {

	private static LoginManager loginManager = null;
	private static Hashtable<HttpSession, String> loginUsers = new Hashtable<HttpSession, String>();

	public static synchronized LoginManager getInstance() {

		if (loginManager == null) {
			loginManager = new LoginManager();
		}
		return loginManager;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("세선 연결");	
		loginUsers.put(event.getSession(), event.getName());

	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("세션 끊어짐 ");
		loginUsers.remove(event.getSession());
		
	}

	public int checkSession(String id) {
		int sw = 0;
		Enumeration<HttpSession> e = loginUsers.keys();
		HttpSession session = null;
		while (e.hasMoreElements()) {
			session = e.nextElement();
			if (loginUsers.get(session).equals(id)) {
				sw = 1;
			}		
		}
		return sw;
	}

	// 로그인을 완료한 사용자의 아이디를 세션에 저장
	public void setSession(HttpSession session, String id) {
       
		session.setAttribute(id, this);
	}

}
