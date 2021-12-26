package com.alfalahsoftech.jdk8;

import java.util.Arrays;
import java.util.PriorityQueue;

public class BasiJavaTest {

	public static void main(String[] args) {
		String x ="null";
		testCode(x);
		System.out.println(x);
		Base s = new Base();
		System.out.println(s.humtm);

		fillArray();
	}


	/**
	 * 
	 */
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
