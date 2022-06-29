package com.alfalahsoftech.core;

import org.apache.catalina.util.ToStringUtil;

public class Emp {
	private int id;
	public String name;
	public double salary;
	private String city;

	public Emp() {
	}

	public Emp(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public Emp(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public Emp(int id, String name, double salary, String city) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", salary=" + salary + ", city=" + city + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	/*
	 * @Override public int hashCode() { return this.id; }
	 */

}