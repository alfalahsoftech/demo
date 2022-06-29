package com.alfalahsoftech.demo;

import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Endpoint(enableByDefault = true, id = "readiness")
//enable or disable can be done in application.properties file as well
public class ReadinesCustommEndpoint {
	private String ready = "NOT_READY";
	org.slf4j.Logger logger  =  LoggerFactory.getLogger(this.getClass());
	
	@ReadOperation
	public String getReady() {
		return ready;
	}
	
	@EventListener(classes = {ApplicationReadyEvent.class})
	public void setReady() {
		ready  = "Your application is ready";
		logger.info(" \n\n\t\t SAMDANI, {} \n\n", ready);
	}

}
