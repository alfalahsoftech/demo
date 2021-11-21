package com.alfalahsoftech.jdk8;

import java.time.ZoneId;
import java.util.List;

import com.alfalahsoftech.demo.Topics;


public interface IUserService {
	//void checkConnection();
	public default void crateTopics() {
		System.out.println("User SErvice");
	}
	
	public default void crateTopics(Object obj) {
		System.out.println("User SErvice");
	}
	public static ZoneId getTimeZone(String zone) {
		
	 return ZoneId.of(zone);
	}
}
