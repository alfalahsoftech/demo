package com.alfalahsoftech.jdk8;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BasiJavaTest {

	public static void main(String[] args) {
		duplicate();
		System.out.println("Dplicates are: " + findDuplicates(Arrays.asList(1,2,1,3,4,5,2)));
		revStr("samdani");
		String x ="null";
		testCode(x);
		System.out.println(x);
		Base s = new Base();
		System.out.println(s.humtm);

		fillArray();
	}
	public static String revStr(String valueStr){
		  int len = valueStr.length();
		  if(valueStr == null || len == 0) {
			return valueStr;
		  }
		  String reversedValue = "";
		  for(int i = len-1; i >= 0; i--){
		     reversedValue += valueStr.charAt(i);
		  }
		  System.out.println(String.format("reversedValue =>%s", reversedValue));
		  return reversedValue;
		}
	
	private static <T> Set<T> findDuplicates(Collection<T> collection) {
	    Set<T> uniques = new HashSet<>();
	    return collection.stream()
	        .filter(e -> !uniques.add(e))
	        .collect(Collectors.toSet());
	}

	public static void duplicate() {
		int[] nums =  new int[] {3, 6, 2, 1, 8, 2, 8, 2};
		//Arrays.sort(nums);
		
		for(int i = 0; i<nums.length;i++) {
			
			for (int j = 0; j < nums.length - 1; j++) {
				if( nums[j] < nums[j+1]) {
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
		
		System.out.println("list: " );
		IntStream.of(nums).forEach((e)->System.out.println(e));
		
		for (int i = 0; i < nums.length-1; i++) {

		    if (nums[i] == nums[i+1]) {
		        System.out.println("duplicate item "+nums[i+1]+" at Location "+(i+1) );
		    }

		}
	}
	
	public static void fillArray() {
		System.out.println("1 << 4; ==> "+ (1 << 4)); //16 HashMap initial capacity
		int ar[] = new int[5];
		for(int i=5; i>0; i--){
			ar[5-i]=i;
		}
		//int[] a, int fromIndex, int toIndex, int val
		Arrays.fill(ar, 1,4,8);
		
		System.out.println("----==========Arrays value============---------");
		System.out.println(Arrays.toString(ar));
		Arrays.stream(ar).forEach(System.out::print);
		

	}
	public static void testCode(String y) {
		y ="sss";
		System.out.println(y);



		class Base{

			Base(){
				System.out.println("Base");
			}
		}

		class Derived extends Base{
			Derived(){
				System.out.println("Derived");
			}

			void throwTest(){

			}
		}

		class SubDerived extends Derived{
			SubDerived(){
				System.out.println("SubDerived");
			}
			//Exception Exception is not compatible with throws clause in Derived.throwTest()
			//	Wrong to add exception
			//void throwTest() throws Exception {
			void throwTest(){

			}
		}

		SubDerived d = new SubDerived();


		///

		PriorityQueue<Number> p = new PriorityQueue<Number>();

		p.add(12);
		p.add(21);
		p.add(11);
		p.add(1);
		//1,11,12,21
		System.out.println(p.poll() +"  "+ p.peek());

		//The method zolo(String) is ambiguous for the type BasiJavaTest
		//zolo(null);



	}
	static void zolo(String x) {

	}
	static void zolo(Integer x) {

	}
	static void zolo(Object x) {

	}



	static class Base{
		static String humtm="base";
		Base(){
			humtm="base1";	
		}
	}
	static class SubClass extends Base{
		SubClass(){
			humtm="SubClass";
		}
	}

	static class SubSubClass extends SubClass{
		SubSubClass(){
			humtm="SubSubClass";
		}
	}

}
