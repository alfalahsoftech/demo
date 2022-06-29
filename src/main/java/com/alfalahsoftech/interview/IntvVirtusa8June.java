package com.alfalahsoftech.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alfalahsoftech.core.Emp;

public class IntvVirtusa8June {

	public static void main(String[] args) {
		IntvVirtusa8June obj = new IntvVirtusa8June();
		HashMap<Emp, Double> h = new HashMap<>();
		h.put(new Emp(1, "sam", 1212.12), 1212.12);
		h.put(new Emp(2, "sam1", 1212.12), 1212.12);
		h.put(new Emp(3, "sam2", 1212.12), 1212.12);

		h.entrySet().stream().forEach(System.out::println);
		System.out.println(h.get(new Emp(3, "sam2", 1212.12)));
		String str = "count string characters";
		char ch[] = str.toCharArray();
		int count = 0;
		
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] != ' ') { // exclude space
				count++;
				// System.out.println("ch: " + ch[i]);
			}

		}
		System.out.println(" Count: " + count);

		obj.getObjectFromHash();
	}

	public void getObjectFromHash() {
		Map<Employee, List<Address>> hashMap = new HashMap<>();
		hashMap.put(new Employee("A"), Arrays.asList(new Address("St1"), new Address("St2")));

		hashMap.put(new Employee("A"), Arrays.asList(new Address("St3"), new Address("St4")));
		System.out.println(hashMap.size());// 2
		List<Address> address = hashMap.get(new Employee("A"));
		System.out.println(address);// null
	}
}

class Employee {
	private String name;

	public Employee(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return name.hashCode();
	}
}

class Address {
	private String streetName;

	public Address(String streetName) {
		this.streetName = streetName;
	}
}
