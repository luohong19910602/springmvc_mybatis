package net.itaem.base.listener;

import java.util.Enumeration;

import javax.servlet.ServletContextEvent;

public class ServletContextSetupListener implements javax.servlet.ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println(event.getServletContext().getContextPath());
	}

}
