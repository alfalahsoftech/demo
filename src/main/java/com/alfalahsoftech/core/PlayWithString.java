package com.alfalahsoftech.core;

public class PlayWithString {

	public static void print(String str) {
		System.out.println(str);
	}

	public static void main(String[] args) {
		PlayWithString strPlay = new PlayWithString();
		String str = "Wrtie a  program to count number of words in String literal";
		String s = new String(str);
		String s2 = new String(str);
		System.out.println(s.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s == s2);
		

		print("Total words: " + strPlay.countWords(str));

		String string = "     India Is   My Country   ";
		
		System.out.println(strPlay.wordcount(string) + " words.");
		print("Total words for string: " + strPlay.countWords(string));

	}

	//It will not work if we have spaces ----------XXXX
	public int countWords(String str) {
		if (str == null || str.trim().length() == 0) {
			return 0;
		}
		return str.split("\\s").length;
	}

	public int wordcount(String string) {
		int count = 0;
		//String string = "     India Is   My Country   ";
		char ch[] = new char[string.length()];
		for (int i = 0; i < string.length(); i++) {
			ch[i] = string.charAt(i);
			System.out.println(i + " :" + string.charAt(i) + " : " +  ch[i]);
			if (((i > 0) && (ch[i] != ' ') && (ch[i - 1] == ' ')) || ((ch[0] != ' ') && (i == 0)))
				count++;
		}
		System.out.println(ch);
		return count;
	}
}
