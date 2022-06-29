package com.alfalahsoftech.jdk8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author samalam
 *
 */
public class JDK_8_Test {

	public static void main(String[] args) {
		JDK_8_Test t = new JDK_8_Test();
		t.getListEmp();
	}

	public void getListEmp() {
		List<Employee>  list = Arrays.asList(
				new Employee(11),
				new Employee(15),
				new Employee(31),
				new Employee(21),
				new Employee(19),
				new Employee(39)
				);

		Predicate<Employee> p = (e)->{
			return e.getAge()> 15;
		};

		List<Employee> filteredList = list.stream().filter(p).collect(Collectors.toList());
		System.out.println(filteredList);
		//Sort the list
		Optional<Employee> opt = filteredList.stream().findAny();
		System.out.println(String.format("Is Present: %B %n  Age: %d", opt.isPresent(), opt.get().getAge()));
		//We can use printf for format
		System.out.printf("Is Present: %B %n  Age: %d", opt.isPresent(), opt.get().getAge());
		Comparator<Employee> comparator = (obj1,obj2) -> obj1.getAge() - obj2.getAge();
		filteredList.stream().sorted(comparator).forEach(System.out::println);;
		
	}

	@ToString
	@Getter
	@Setter
	class Employee{
		int age;
		Employee(int age){
			this.age = age;
		}
	}

}
