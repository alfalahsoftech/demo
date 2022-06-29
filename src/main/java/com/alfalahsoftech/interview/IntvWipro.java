package com.alfalahsoftech.interview;

import java.util.HashMap;

import com.alfalahsoftech.core.Emp;

public class IntvWipro {
	public static void main(String[] args) {
		HashMap<Emp, Double> h = new HashMap<>();
		h.put(new Emp(1, "sam", 1212.12), 1212.12);
		h.put(new Emp(2, "sam1", 1212.12), 1212.12);
		h.put(new Emp(3, "sam2", 1212.12), 1212.12);

		h.entrySet().stream().forEach(System.out::print);
	}
}
