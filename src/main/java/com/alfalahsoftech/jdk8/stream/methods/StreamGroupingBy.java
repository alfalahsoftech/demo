package com.alfalahsoftech.jdk8.stream.methods;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.alfalahsoftech.core.Emp;
import com.alfalahsoftech.core.Item;

public class StreamGroupingBy {
	Consumer<Object> cons = System.out::println;

	public static void main(String[] args) {
		StreamGroupingBy  mm = new StreamGroupingBy();
		mm.playGrouping();
	}


	public void playGrouping() {
		List<String> fruits =
				Arrays.asList("apple", "apple", "banana",
						"apple", "orange", "banana", "papaya","papaya","papaya","papaya");

		//#(1) Function.identity()-> It always return input of Function
		fruits.stream().map(Function.identity()).forEach(cons);
		cons.accept("\n ====>>> Using Lambda");
		//#(2)Using lambda expression Function<String,String> identity = e->e;.
		Function<String,String> identity = e->e;

		fruits.stream().map(identity).forEach(cons);
		cons.accept("\n ==>>>Sorting");
		//#(3) Sort
		fruits.stream().map(Function.identity()).sorted().forEach(cons);

		//#(4) Count frequency of elements
		Map<String, Long> count = fruits.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		cons.accept("\n Frequency of each element");
		System.out.println(count);
		//#(5) Sort on elements on frequency
		Map<String, Long> sortOnFreq = fruits.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

		List<Map.Entry<String, Long>> li = new ArrayList(sortOnFreq.entrySet());
		cons.accept("\n Sorting according to frequency");
		li.stream().sorted((e,e2)->(int)(e2.getValue().doubleValue()-e.getValue().doubleValue())).collect(Collectors.toList()).forEach(cons);
		//li.stream().sorted(Comparator::comparingLong).collect(Collectors.toList()).forEach(cons);


		//#(2) 2nd Option to Sort on elements on frequency
		cons.accept("\n 2nd Option to Sort on elements on frequency ");

		Map<String, Long> result = fruits.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		Map<String, Long> finalMap = new LinkedHashMap<>();

		//Sort a map and add to finalMap
		result.entrySet().stream()
		.sorted(Map.Entry.<String, Long>comparingByValue().reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

		System.out.println(finalMap);




		List<Item> items = Arrays.asList(
				new Item("apple", 10, new BigDecimal("9.99")),
				new Item("banana", 20, new BigDecimal("19.99")),
				new Item("orang", 10, new BigDecimal("29.99")),
				new Item("watermelon", 10, new BigDecimal("29.99")),
				new Item("papaya", 20, new BigDecimal("9.99")),
				new Item("apple", 10, new BigDecimal("9.99")),
				new Item("banana", 10, new BigDecimal("19.99")),
				new Item("apple", 20, new BigDecimal("9.99"))
				);
		Function<Item,Item> i = Function.identity();
		Function<Item,String> i2 = Item::getName;

		//Map<String, Long> itemByCount = items.stream().collect(Collectors.groupingBy(Item::getName,Collectors.counting()));
		//cons.accept("\n Count of Item by Name: \t\n" + itemByCount );

		//## OR  i2 = e-> e.getName();

		Map<String, Long> itemByCount = items.stream().collect(Collectors.groupingBy(e -> e.getName(),Collectors.counting()));
		cons.accept("\n Count of Item by Name: \t\n" + itemByCount );

		Optional<Item> maxNoOfItemByName = items.stream().collect(Collectors.maxBy((e,f)->e.getQty()-f.getQty()));
		cons.accept("\n maxNoOfItemByName: \t\n" + maxNoOfItemByName.get().getName() );

		List<Emp> l = List.of(
				new Emp(12,"Sharique",43121.48, "Gaya"),
				new Emp(11,"Arman   ",3121.48, "Gaya"),
				new Emp(13,"Shahwaz ",2321.48, "Patna"),
				new Emp(14,"Raju    ",3214.48, "Patna"),
				new Emp(14,"Adil    ",1214.48, "Patna"),
				new Emp(15,"Minal   ",4331.48,"Jehanabad"),
				new Emp(16,"Taiyyab ",51130.48,"Jehanabad")
				);

		Emp ee = new Emp();
		//		Emp e = l.stream().collect(Collectors.groupingBy(classifier));
		//		System.out.println("Emp with min salary:: " + e.getName());
		cons.accept("=======================================");
		
		l.stream().sorted(Comparator.comparingDouble(Emp::getSalary).reversed()).forEach(cons); //(e->System.out.println(e.getName() + "\t" +e.getSalary()));
		cons.accept("=======================================");
		
	
		Optional<Emp> maxSalariedEmp2= l.stream().sorted(Comparator.comparingDouble(Emp::getSalary).reversed()).findFirst();
		cons.accept("\n Max salaried emp: " + maxSalariedEmp2.get().getName());

		//2nd Highest salary

		
		Optional<Emp> secondMaxSalaied= l.stream().sorted(Comparator.comparingDouble(Emp::getSalary).reversed()).
				skip(1).findFirst();
		cons.accept("\n 2nd Max salary: " + secondMaxSalaied.get().name);

		
		
		//City wise max salary
		Map<String, Optional<Emp>> reslt = l.stream().collect(Collectors.groupingBy(Emp::getCity, Collectors.maxBy(Comparator.comparing(Emp::getSalary))));
		cons.accept("\n " + reslt);		
		//City wise max salary
		Map<String, Optional<Emp>> reslt2 = l.stream().collect(Collectors.groupingBy(Emp::getCity, Collectors.minBy(Comparator.comparing(Emp::getSalary))));
		System.out.println(reslt2);
		InstanceMethodReference inst = new InstanceMethodReference();
		Runnable r = inst::saySomething;
		Function<String, Integer> fn = inst::saySomethingWithParam;
//		Function<InstanceMethodReference, Integer> fn2 = InstanceMethodReference::saySomethingWithParam;
		String sObj = new String();
		
		//XXXX Consumer<String> s1 = sObj::toLowerCase;
		Consumer<String> s = String::toLowerCase;

	}


	class InstanceMethodReference {  
		public void saySomething(){  
			System.out.println("Hello, this is non-static method.");  
		}
		public int saySomethingWithParam(String str){  
			System.out.println("Hello, this is non-static method. " + str); 
			return str.length();
		}

	}


}
