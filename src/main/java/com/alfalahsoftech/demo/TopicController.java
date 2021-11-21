package com.alfalahsoftech.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	public static List<Topics> topics = new ArrayList<Topics>(  Arrays.asList(
			new Topics("T001","Core Java",14500.20),
			new Topics("T002","Pythan",29001.20),
			new Topics("T003","C",8000.20),
			new Topics("T004","Angular",32000.20),
			new Topics("T005","SpringBoot",25000.20)

			));

	//************************Utility Method*******************************
	public static void printObj(Object obj) {
		System.out.println(obj);
	}
	public static void printFormated(String obj,Object... args) {
		System.out.println(String.format(obj, args));
	}
	//******************************************************

	@RequestMapping("/topics")
	public List<Topics> getAllTopics(){
		return topics;
	}
	/*(1)
	 * produce XML data
	 * URI  /topic/{tid}
	 */
	/*
	 * @GetMapping(value="/topic/{tid}",produces =
	 * {MediaType.APPLICATION_XML_VALUE}) public Topics xmlTopicByID(@PathVariable
	 * String tid,HttpServletRequest req) {
	 * printObj("Accept:  "+req.getHeader("Accept"));
	 * printObj("Gtting XML  topics by ID :" + tid ); return
	 * topics.stream().filter(id->id.getTopicID().equals(tid)).findFirst().get(); }
	 */
	/*(2)
	 * produce JSON data
	 * URI  /topic/{tid}
	 */
	/*
	 * @GetMapping("/topic/{tid}") public Topics jsonTopicByID(@PathVariable String
	 * tid,HttpServletRequest req) { printObj("Accept:  "+req.getHeader("Accept"));
	 * printObj("Gtting JSON topics by ID :" + tid ); return
	 * topics.stream().filter(id->id.getTopicID().equals(tid)).findFirst().get(); }
	 */

	/*(1)+(2)--It will return XML OR JSON data as per Accept header key in Request
	 * produce JSON data
	 * URI  /topic/{tid}
	 */
	@GetMapping(value="/topic/{tid}", produces= {"application/json","application/xml"})
	public Topics json_or_xml_TopicByID(@PathVariable String tid,HttpServletRequest req) {
		printObj("Accept:  "+req.getHeader("Accept"));
		printObj("Gtting JSON or XML topics by ID :" + tid );
		return topics.stream().filter(id->id.getTopicID().equals(tid)).findFirst().get();
	}

	@PostMapping(value = "/topic")
	public void addTopic(@RequestBody Topics topic) {
		printObj("Adding topics:");
		this.topics.add(topic);

	}
	
	@PostMapping("/createEmp")
	public void reqParam(@RequestParam("req") String reqParam) {
		printFormated("Request %s", reqParam);
	}



	@PutMapping(value="/updateTopic/{tid}")
	public void updateTopic(@RequestBody Topics topic, @PathVariable String tid) {

		printObj("===================Update topics:");
		Topics tp = topics.stream().filter(t->t.getTopicID().equals(tid)).map(t->{
			topics.set(topics.indexOf(topic), topic);
			return topic;
		}).findFirst().get();
		printFormated("Topics has been updated with ID:%s.", tid);
	}

	@DeleteMapping("/delTopic/{tid}")
	public void delTopic(@PathVariable String tid) {
		this.topics.removeIf(tp->tid.equals(tp.getTopicID()));
	}

	@GetMapping("/greaterThanCost/{cost}")
	public List<Topics> getTopicsByCost(@PathVariable Double cost){
		return this.topics.stream().filter(tp->tp.getCost().doubleValue()>cost.doubleValue()).collect(Collectors.toList());
	}
	
	@GetMapping("suc")
	public String modelView() {
		return "success";
	}
}
