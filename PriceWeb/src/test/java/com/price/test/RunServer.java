package com.price.test;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class RunServer {
	
	private static Server server;
	
	public static void main(String[] args) throws Exception{
		
		WebAppContext root = new WebAppContext();
        root.setContextPath("/");
        root.setResourceBase("src/main/webapp/");        
        root.setDescriptor(root.getResourceBase() + "/WEB-INF/web.xml");
        root.setParentLoaderPriority(true);

        server = new Server(8088);
        server.setSendServerVersion(false);
        server.setSendDateHeader(false);
        server.setHandler(root);
        server.start();
        server.join();
	}

}
