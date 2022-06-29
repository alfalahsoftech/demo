package com.alfalahsoftech.core;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class TestInterviewQ{

	public static void main(String[] args) {
		//IntStream.range(1,101).forEach(System.out::println);
		TestInterviewQ q = new TestInterviewQ();
		q.test();
		q.groupingBy();


	}

	public void test() {
		
		List<Emp> empList = Arrays.asList(
				new Emp("Amber", 20000),
				new Emp("Ramesh", 18000),
				new Emp("Ali", 450000),
				new Emp("Joy", 191000)

				);
		
//		Collections.sort(empList, (o1,o2)->{ o1.salary -o2.salary()});
		//empList.stream().sorted((o1,o2)->{ return (int)(o1.salary - o2.salary); });
		ToDoubleFunction<Emp> tf = e->e.getSalary();
		Optional<Emp> emp = empList.stream()
		        .sorted(Comparator.comparingDouble(Emp::getSalary).reversed()).skip(1).findFirst();

		System.out.println(emp.get().getSalary());	
//		empList.stream().sorted((o1,o2)->{ return (int)(o1.salary - o2.salary); });
		System.out.println(empList);

	}
	
	public void groupingBy() {
		List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");
		 Map<String, Long> result  = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		 System.out.println(result);
	}

}
