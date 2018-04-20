package chap3;

import java.util.Arrays;

public class LotteryArray {
	//2. 存储和遍历不对称数组LotteryArray.java
	//6*6
	public static void main(String[] args) {
		final int ROWS = 6;
		int[][] arr = new  int[ROWS][];
		for(int i = 0; i < ROWS; i++) {
			arr[i] = new int[i+1];
		}
		
		for(int j = 0; j < arr.length; j++) {
			for (int n = 0; n < arr[j].length; n++) {
				arr[j][n] = 1;
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
