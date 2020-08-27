package team.t.t.service;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;

import javafx.beans.binding.StringBinding;
import team.t.t.dto.LoginDTO;

public class MailCode implements Action {
	// https://hunit.tistory.com/306
	// https://t1st0ry.tistory.com/58
	// https://joont.tistory.com/52

	
	@SuppressWarnings("unchecked")
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MailCode");
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		// Mail Server
		String hostSMTP = "smtp.naver.com";
		String hostSMTPid = "thsalstn0@naver.com";
		String hostSMTPpw = "alstn123";

		// 보내는 사람
		String fromEmail = "thsalstn0@naver.com";
		String fromName = "운영자";
		String subject = null;
		String mail = null;
		String code = null;
		boolean sw = true;
		// 받는 사람 E-Mail
		mail = (String) session.getAttribute("mail");
		List<LoginDTO> list = new ArrayList<LoginDTO>();
		list = (List<LoginDTO>) session.getAttribute("list");
		// String[] id = new String[list.size()];
		// String[] pw = new String[list.size()];
		StringBuffer str = new StringBuffer();

		if (mail != null) {
			for (int i = 0; i < list.size(); i++) {
				String id = list.get(i).getMem_id();
				str.append(id.replace(id.substring(id.length() - 3, id.length()), gg(id)) + "   " + "<br>");
				subject = "회원 아이디";
			}
		} else {
			
			mail = request.getParameter("mail");
			AuthCode auth = new AuthCode();
			code = auth.authCode();
			subject = "인증코드";
			System.out.println("인증번호" + code);
			System.out.println(mail);
			sw = false;
		}

		try {
			HtmlEmail email = new HtmlEmail();
			// email.setDebug(true);
			email.setCharset("utf-8");
			email.setHostName(hostSMTP);
			email.setSmtpPort(587);
			email.setAuthentication(hostSMTPid, hostSMTPpw);
			email.setFrom(fromEmail, fromName);
			email.addTo(mail);

			if (sw) {
				for (int i = 0; i < list.size(); i++) {
					
					email.setHtmlMsg("<html>" + "아이디" + "<br>" + "<p>" + str.toString() + "<p><br></html>");

				}
			} else {
				email.setHtmlMsg("<p>" + code + "<p>");

			}
			email.setSubject(subject);
			email.send();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.setAttribute("str", code);

		ActionForward forward = new ActionForward();

		if (sw) {
			forward.setPath("/loginForm.do");
			session.invalidate();
			return forward;
		} else {
			return null;
		}

	}

	public String gg(String id) {

		String str = id.substring(id.length() - 3, id.length());
		String s = "";
		for (int i = 0; i < str.length(); i++) {
			s += "*";
		}
		return s;
	}
}