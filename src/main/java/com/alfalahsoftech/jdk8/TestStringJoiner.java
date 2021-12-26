package com.alfalahsoftech.jdk8;
import java.util.ArrayList;
import java.util.StringJoiner;
public class TestStringJoiner {
	public static void main(String[] ar){
		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(2134);
		intList.add(3423);
		intList.add(4234);
		intList.add(343);

		String prefix = "(";
		String infix = ", ";
		String postfix = ")";

		StringJoiner joiner = new StringJoiner(infix, prefix, postfix);
		for (Integer i : intList)
			joiner.add(i.toString());

		System.out.println(joiner.toString());
	}
}