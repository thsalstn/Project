package team.t.t.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import team.t.t.dao.LoginDAO;
import team.t.t.dao.RecordDAO;
import team.t.t.dto.LoginDTO;

public class NaverInfo implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("NaverInfo");

		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=utf-8 ");
		String token = (String) request.getAttribute("access_token");
		int num = 0;
		System.out.println("네이버  인포 토큰"+token);
		
			try {
				String header = "Bearer " + token;
				String apiURL = "https://openapi.naver.com/v1/nid/me";
				URL url = new URL(apiURL);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("Authorization", header);
				int responseCode = con.getResponseCode();
				BufferedReader br;
				if (responseCode == 200) { 
					br = new BufferedReader(new InputStreamReader(con.getInputStream()));

				} else { 
					br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				}
				String inputLine;
				StringBuffer res = new StringBuffer();
				while ((inputLine = br.readLine()) != null) {
					res.append(inputLine);
				}
				br.close();
				System.out.println(res.toString());
				JSONParser parsing = new JSONParser();
				JSONObject jsonObj = (JSONObject) parsing.parse(res.toString());
				JSONObject resObj = (JSONObject) jsonObj.get("response");

				String id = (String) resObj.get("id");
				String email = (String) resObj.get("email");
				String name = (String) resObj.get("name");
			

				int result = 0;

				LoginDAO dao = LoginDAO.getInstance();
				LoginDTO dto = null;
				result = dao.idCheck(id);
				RecordDAO rdao = RecordDAO.getInstance();
				num = rdao.getCount(id);
				session.setAttribute("record", num);
				if (result != 1) {

			

					request.setAttribute("social_id", id);
					request.setAttribute("num", 1);
					request.setAttribute("mem_social", 2);
					request.setAttribute("name", name);					
					request.setAttribute("email", email);
					forward.setPath("/social_member.do");
					return forward;

				} else {
					
					dto = dao.selectMember(id);
					session.setAttribute("id", dto.getMem_id());
					session.setAttribute("name", dto.getMem_name());		
					session.setAttribute("email", dto.getMem_email());			
					session.setAttribute("social", dto.getMem_social());
					session.setAttribute("token", token);
					
					forward.setPath("/loginSec.do");
					return forward;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return forward;
	}
}
