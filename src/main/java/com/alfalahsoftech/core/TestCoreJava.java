package com.alfalahsoftech.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCoreJava {

	public static void main(String[] args) {
//		System.out.println(palindrome("madam"));
//		System.out.println(palindrome_V2("madam"));
		printListOfList();

	}
	
	
	public static void printListOfList() {
		//input
		List< Integer> list = Arrays.asList(1,2,5,8,6,7);
		
		//o/p: List<List<Integer>> -[[1,2], [5,8], [6,7]]

		int count=0;
		ArrayList<Integer>  li = new ArrayList<>();
		ArrayList<ArrayList<Integer>>  lili = new ArrayList<ArrayList<Integer>>();

		for(int i=0; i < list.size(); i++){
		   
		   if(count%2==0){
		     li = new ArrayList<>();
			 lili.add(li);
		   }
		   li.add(list.get(i));
		   count++;
		}
		System.out.println(lili);
	}
	
	public static String palindrome(String word) {
		if(word == null || word.isEmpty()) {
			return word;
		}
		return word.charAt(word.length() - 1) +
				palindrome(word.substring(0, word.length() - 1));

	}
	
	public static boolean palindrome_V2(String word) {
		if(word == null || word.isEmpty()) {
			return false;
		}
		String revWord = "";
		System.out.println("word: "+ word);
		for (int i = word.length() - 1 ; i >= 0; i -- ) {
			revWord += word.charAt(i); 
			System.out.println(revWord);
			
		}
		System.out.println("revWord=" + revWord);
		return false;
	}

}
