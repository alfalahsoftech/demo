package com.alfalahsoftech.interview;

public class InterviewMphasis {
	public static void main(String[] args) {
		int input[] = {0,1,1,3,5,8};
		boolean b = isFaboni(input);
		System.out.println("isFabo: " +  b);
	}
	
	public static boolean isFaboni(int arr[]){
		
		for(int i = 0; i< arr.length-2; i++){
		   int sum = arr[i] + arr[i+1];
		   if(sum != arr[i+2] )   {
		     return false;
		   }
		}
	 
	 return true;
	}

}
