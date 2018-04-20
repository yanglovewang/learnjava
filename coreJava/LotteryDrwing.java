package chap3;

import java.util.Scanner;

/*
 * 1. 在一个字符串中抽取随机数，不能重复 LotteryDrawing.java
 * 
 */
public class LotteryDrwing {
	
	public static void main(String[] args) {
		System.out.println("input str");
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		System.out.println("随机取的个数：");
		int n = input.nextInt();
		char[] cs = getChars(n, s);
		for(char cc : cs) {
			System.out.println(cc);
		}
	}

	private static char[] getChars(int n, String s) {
		int num = s.length();
		int[] xiabiao = new int[n]; //下标数组
		char[] targets = new char[n]; //随机数
		//生成下标数组,可能同时生成多个一样的所以要剔除
		for(int j = 0; j < xiabiao.length; j++) {
			xiabiao[j] = (int) (Math.random()*num);
			targets[j] = s.charAt(xiabiao[j]);
			s = s.substring(0, xiabiao[j]) + s.charAt(s.length()-1) + s.substring(xiabiao[j]+1, s.length());
			num--;
		}
		
		
		return targets;
	}

}
