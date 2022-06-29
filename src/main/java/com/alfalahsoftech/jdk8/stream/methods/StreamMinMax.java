package com.alfalahsoftech.jdk8.stream.methods;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import com.alfalahsoftech.core.Emp;

public class StreamMinMax {

	public static void main(String[] args) {
		StreamMinMax  mm = new StreamMinMax();
		mm.playWithMin();
	}

	public void playWithMin() {
		List<Emp> l = List.of(
				new Emp(12,"Sharique",43121.48),
				new Emp(11,"Arman",3121.48),
				new Emp(13,"Shahwaz",2321.48),
				new Emp(14,"Raju",3214.48),
				new Emp(15,"Minal",4331.48),
				new Emp(16,"Taiyyab",51130.48)
				);

		Emp ee = new Emp();
		Emp e = l.stream().min(Comparator.comparing(Emp::getSalary)).get();
		System.out.println("Emp with min salary:: " + e.getName());


		InstanceMethodReference inst = new InstanceMethodReference();
		Runnable r = inst::saySomething;
		Function<String, Integer> fn = inst::saySomethingWithParam;

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
