package com.alfalahsoftech.core;

public class RemoveDuplicateInArrayExample {
	
	/*
	 * Note:
	 * JavaTPoint both approach is wrong
	 */
	public static int removeDuplicateElements(int arr[], int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int[] temp = new int[n];
		int j = 0;
		// int arr[] = { 10, 20, 20, 30, 30, 40, 50, 50 };
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				temp[j++] = arr[i];
			}
		}

		temp[j++] = arr[n - 1];
		// Changing original array
		for (int i = 0; i < j; i++) {
			arr[i] = temp[i];
		}
		return j;
	}

	public static int removeDuplicateElements_using_Separate_Index(int arr[], int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int j = 0;// for next element
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				arr[j++] = arr[i];
			}
		}
		arr[j++] = arr[n - 1];
		return j;
	}

	public static void main(String[] args) {
		int arr[] = { 10, 20, 20, 30, 10, 30, 40, 50, 50 };
		int length = arr.length;
		length = removeDuplicateElements_using_Separate_Index(arr, length);// removeDuplicateElements(arr, length);
		// printing array elements
		for (int i = 0; i < length; i++)
			System.out.print(arr[i] + " ");
	}
}
