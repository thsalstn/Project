package team.t.t.service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

public class HttpSessionConfigurator extends Configurator{
 

	
	@Override
	public void modifyHandshake(ServerEndpointConfig config, HandshakeRequest request, HandshakeResponse response) {
	 
		HttpSession session = (HttpSession) request.getHttpSession();
		ServletContext context = session.getServletContext();
		config.getUserProperties().put(HttpSession.class.getName(), session);
		config.getUserProperties().put(ServletContext.class.getName(), context);
	}
	
}
