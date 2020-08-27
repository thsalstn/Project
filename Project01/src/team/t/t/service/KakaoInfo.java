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

public class KakaoInfo implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("KakaoInfo");

		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=utf-8 ");
		int num = 0;
		String token = (String) request.getAttribute("access_token");
		String name = null;
		String email = null;
		String id = null;
        System.out.println("카카오 인포 토큰"+token);
	
			try {
				String header = "Bearer " + token;
				String apiURL = "https://kapi.kakao.com/v2/user/me";
				URL url = new URL(apiURL);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("POST");
				con.setRequestProperty("Authorization", header);
				int responseCode = con.getResponseCode();

				BufferedReader br = null;
				if (responseCode == 200) {
					br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				}
				String inputLine;
				StringBuffer sb = new StringBuffer();
				if ((inputLine = br.readLine()) != null) {

					sb.append(inputLine);
				}
				br.close();

				JSONParser parsing = new JSONParser();
				JSONObject jsonobj = (JSONObject) parsing.parse(sb.toString());
				id = String.valueOf(jsonobj.get("id"));

				JSONObject propertiesObject = (JSONObject) jsonobj.get("properties");
				JSONObject kakao_account = (JSONObject) jsonobj.get("kakao_account");

				name = (String) propertiesObject.get("nickname");
				email = (String) kakao_account.get("email");

				int result = 0;
				LoginDAO dao = LoginDAO.getInstance();
				LoginDTO dto = null;
				System.out.println("result : " + result);
				System.out.println("id : " + id);
				result = dao.idCheck(id);
				RecordDAO rdao = RecordDAO.getInstance();
				num = rdao.getCount(id);
				session.setAttribute("record", num);
				if (result != 1) {

					request.setAttribute("social_id", id);
					request.setAttribute("num", 1);
					request.setAttribute("mem_social", 3);
					request.setAttribute("name", name);
					request.setAttribute("email", email);
					forward.setPath("/social_member.do");
					return forward;

				} else {
					dto = dao.selectMember(id);
					session.setAttribute("id",  dto.getMem_id());
					session.setAttribute("name", dto.getMem_name());				
					session.setAttribute("email", dto.getMem_email());				
					session.setAttribute("social",  dto.getMem_social());				
					session.setAttribute("access_token",  token);				
					forward.setPath("/loginSec.do");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}					
		return forward;
	}

}
