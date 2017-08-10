

package com.cunjin.gate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.web.session.HttpSessionCreatedEvent;
import org.springframework.session.events.SessionCreatedEvent;
import org.springframework.session.events.SessionDestroyedEvent;

/**
 * 处理应用的各种事件,如Session time
 * 〈功能详细描述〉
 */

public class ApplicationEventListener implements ApplicationListener<ApplicationEvent> {
	private static final Logger logger = LoggerFactory.getLogger(ApplicationEventListener.class);

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if(event instanceof SessionCreatedEvent){
			SessionCreatedEvent sde = (SessionCreatedEvent)event;
			logger.info("session created {}", sde.getSessionId());
		}else if(event instanceof HttpSessionCreatedEvent){
			HttpSessionCreatedEvent sce = (HttpSessionCreatedEvent)event;
			logger.info("http session created, source={}", sce.getSource());
		}else if(event instanceof SessionDestroyedEvent){
			SessionDestroyedEvent sde = (SessionDestroyedEvent)event;
			logger.info("session destroyed,session id={},session source={}", sde.getSessionId(), sde.getSource());
		}else {
			logger.debug("application event:{}", event);
		}
	}

}
