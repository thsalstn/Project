package team.t.t.service;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/broadcasting", configurator = HttpSessionConfigurator.class)
public class BoardSocket {

	private static Map<Object, Object> configs = Collections.synchronizedMap(new HashMap<Object, Object>());
	private String name = null;
	private HttpSession s = null;

	// 클라이언트로 부터 메시지가 도착했을 때 처리
	@OnMessage
	public void onMessage(String message, Session session) throws IOException {

		System.out.println(message);
		String str[] = message.split("/");
		String sw = str[0];
		String sender = str[1];
		String content = str[2];
		System.out.println("sw" + sw);
		System.out.println("sender" + sender);
		System.out.println("content" + content);
		synchronized (configs) {
			Iterator<Object> it = configs.keySet().iterator();
			while (it.hasNext()) {
				Session currentSession = (Session) it.next();
	
				if (!currentSession.equals(session)) {
					currentSession.getBasicRemote().sendText(message);

				}
				if (sw.equals("404")) {
					Iterator<Object> itit = configs.keySet().iterator();
					while (itit.hasNext()) {
						Session subSession = (Session) itit.next();						
						String value = (String) configs.get(subSession);
						currentSession.getBasicRemote().sendText("405/" + value + "/w");
					}
//					while (it.hasNext()) {
//						Session subSession = it.next();
//						String value = (String) configs.get(subSession);
//						System.out.println("value"+value);
//						currentSession.getBasicRemote().sendText(sw+"/"+value+"/0");
//					}
				}
			}
		}
	}

	// 클라이언트에서 서버로 접속할 때의 처리
	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {
		System.out.println("onOpen");
		s = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
		name = (String) s.getAttribute("name");
		System.out.println("board name :" +name);
		System.out.println("등록된 사용자 수 " +configs.size());
		configs.put(session, name);

//		try {
//			onMessage("섹션 수"+"/"+num, session);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	// 접속이 끊겼을 때 처리 입니다
	@OnClose
	public void onClose(Session session) {
		String str = "404/" + configs.get(session) + "/" + "님이 퇴장하셨습니다";

		System.out.println("onClose");
		configs.remove(session);
		try {
			onMessage(str, session);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
