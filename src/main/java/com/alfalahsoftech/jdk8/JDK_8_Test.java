package com.alfalahsoftech.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
				new Employee(21)
				);

		Predicate<Employee> p = (e)->{
			return e.getAge()> 15;
		};

		List<Employee> filteredList = list.stream().filter(p).collect(Collectors.toList());
		System.out.println(filteredList);
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
