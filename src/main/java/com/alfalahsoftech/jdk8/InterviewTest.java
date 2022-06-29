package com.alfalahsoftech.jdk8;

public class InterviewTest {

	public static void main(String[] args) {
		int ar1[] = { 1, 2, 4, 22 };
		int ar2[] = {0, 3, 9, 11, 20 };
		int arr[] = getMergedSortedArray(ar1, ar2);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	public static int[] getMergedSortedArray(int ar1[], int ar2[]) {
		int len = ar1.length + ar2.length;
		int mrgdSortArr[] = new int[len];

		for (int i = 0; i < ar1.length; i++) {
			mrgdSortArr[i] = ar1[i];
		}

		int indx = ar1.length;
		for (int i = 0; i < ar2.length; i++) {
			mrgdSortArr[indx] = ar2[i];
			indx++;
		}

		// int ar2[] = { 20, 3, 1, 9, 11 };
		for (int i = 0; i < mrgdSortArr.length; i++) {
			for (int j = 0; j < mrgdSortArr.length - 1; j++) {
				if (mrgdSortArr[j] > mrgdSortArr[j + 1]) {
					int temp = mrgdSortArr[j];
					mrgdSortArr[j] = mrgdSortArr[j + 1];
					mrgdSortArr[j + 1] = temp;
				}
			}
		}
		return mrgdSortArr;
	}

}
