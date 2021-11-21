package com.alfalahsoftech.demo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 

//Without above annotation  i were getting below exception
// Resolved [org.springframework.http.converter.HttpMessageNotWritableException: No converter for [class com.alfalahsoftech.demo.Topics] with preset Content-Type 'null']

public class Topics {

	Double cost;
	
	String topicID, topicName, topicDescription;
	public Topics() {
		
	}
	public Topics(String topicID, String topicName, String topicDescription) {

	}
	public Topics(String topicID, String topicName, Double cost) {
		this.topicID = topicID;
		this.topicName = topicName;
		this.cost = cost;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public String getTopicID() {
		return topicID;
	}
	public void setTopicID(String topicID) {
		this.topicID = topicID;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public String getTopicDescription() {
		return topicDescription;
	}
	public void setTopicDescription(String topicDescription) {
		this.topicDescription = topicDescription;
	}
	
	@Override
	public int hashCode() {
		int prime =31;
		int result = 1;
		result = prime * (this.getTopicID() != null ? this.getTopicID().hashCode() : 0);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		 if(obj == this)
			 return true;
		 if(obj == null)
			 return false;
		 if(obj.getClass()!=this.getClass())
			 return false;
		 Topics tp = (Topics) obj;
		 if(tp.getTopicID().equals(this.getTopicID()))
			 return true;
		return false;
	}
	
	

}
