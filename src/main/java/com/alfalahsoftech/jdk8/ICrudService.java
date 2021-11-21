package com.alfalahsoftech.jdk8;

import java.util.List;

import com.alfalahsoftech.demo.Topics;

public interface ICrudService {

	List<Topics> findAll();
	
	public default void crateTopics() {
		System.out.println("CRUD SErvice");
	}
}
