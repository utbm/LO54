package com.mycompany.sp4.webapp.infrastructure.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionDetector implements HttpSessionListener {

	private static final Logger LOG = LoggerFactory.getLogger(SessionDetector.class);

	public SessionDetector() {
		LOG.info("SessionDetector initialized");
	}

	@Override
	public void sessionCreated(final HttpSessionEvent se) {
		LOG.error("Session created " + se.getSource());
		Thread.dumpStack();
	}

	@Override
	public void sessionDestroyed(final HttpSessionEvent se) {

	}
}
