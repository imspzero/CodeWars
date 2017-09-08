package pers.sam.practice;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.codewars.com/kata/55b195a69a6cc409ba000053/train/java
 * 
 * @author Sam Lee
 * @version 2016年11月5日下午6:21:02
 */
public class TotalIncreasingOrDecreasingNumbers3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		System.out.println("totalIncDec(0) : "+totalIncDec(0));
//		System.out.println("totalIncDec(1) : "+totalIncDec(1));
//		System.out.println("totalIncDec(2) : "+totalIncDec(2));
//		System.out.println("totalIncDec(3) : "+totalIncDec(3));
//		System.out.println("totalIncDec(4) : "+totalIncDec(4));
//		System.out.println("totalIncDec(5) : "+totalIncDec(5));
//		System.out.println("totalIncDec(6) : "+totalIncDec(6));
		System.out.println("totalIncDec(100) : "+totalIncDec(100));
			
//		System.out.println("totalIncDec(115) : "+totalIncDec(115));
		
//		bruteForceTester(100,1000);
		
//		System.out.println(isIncDecNumber(1,"100"));
//		System.out.println(isIncDecNumber(4,"2345"));
//		System.out.println(isIncDecNumber(1,"2345"));
//		System.out.println(isIncDecNumber(1,"55"));
//		System.out.println(isIncDecNumber(7,"642"));
	}
	
	/**
	 * 1) init n array
	 * 2) for each digit numbers k (ie, k=1,num<10; k=2,num<100; k=3,100) 
	 * 3)     find decrease numbers base on k-1 result in array;
	 * 5)     find increase numbers base on k-1 result In array;
	 * 6) return sum;
	 * @param n
	 * @return
	 */
	public static BigInteger totalIncDec(int n) {
		
		BigInteger bi = new BigInteger("0");
		int resultCount = 0;
		
		Queue<String> queue = new LinkedList<>();
		
		if(n==0){
			return new BigInteger("1");
		}else if(n==1){
			return new BigInteger("10");
		}
		
		// 0 digits
		List<String> zeroDigits = new ArrayList<>();
		zeroDigits.add(0+"");
		
		//1 digits
		List<String> oneDigits = new ArrayList<>();
		for(int k=0;k<10;k++){
			oneDigits.add("0"+k);
			}
		
		//2 digits
		List<String> twoDigits  = new ArrayList<>();
		for(int k=10;k<100;k++){
			twoDigits.add(k+"");
		}
		
		queue.addAll(oneDigits);
		queue.addAll(twoDigits);
		
		resultCount = resultCount +oneDigits.size()
			+twoDigits.size();
		
		//>=3 digits
		for(int i = 3;i<=n;i++){
			
			while(queue.peek().length()==i-1){
				String currentNum = queue.poll();
				
				Integer firstDigit = Integer.valueOf(currentNum.substring(0, 1));
				Integer lastDigit = Integer
						.valueOf(currentNum.substring(currentNum.length() -1, currentNum.length()));
				
				if (firstDigit > lastDigit) {
					for (int k = firstDigit; k <= 9; k++) {
						queue.add(k + currentNum);
						resultCount++;
					}

				} else if (firstDigit < lastDigit) {
					for (int k = 1; k <=firstDigit; k++) {
						queue.add(k + currentNum);
						resultCount++;
					}
				}else if(firstDigit==lastDigit){
					for (int k = 1; k <=9; k++) {
						queue.add(k + currentNum);
						resultCount++;
					}
				}
			}
			queue.add(padding0(0,i-1));
		}
		
		return new BigInteger(String.valueOf(resultCount));
	}
	
	
	public static int getBiggerIncDecNum(String currentNum,int length){
		
		if(currentNum.length()==length){
			return 0;
		}
		
		int resultCount = 0;
		
		Integer firstDigit = Integer.valueOf(currentNum.substring(0, 1));
		Integer lastDigit = Integer
				.valueOf(currentNum.substring(currentNum.length() -1, currentNum.length()));
		
		if (firstDigit > lastDigit) {
			for (int k = firstDigit; k <= 9; k++) {
				resultCount++;
			}

		} else if (firstDigit < lastDigit) {
			for (int k = 1; k <=firstDigit; k++) {
				resultCount++;
			}
		}else if(firstDigit==lastDigit){
			for (int k = 1; k <=9; k++) {
				resultCount=resultCount+getBiggerIncDecNum(k+currentNum,length);
			}
		}
		
		return resultCount;
		
	}
	
	
	/**
	 * N-1 digits to N digits Numbers
	 * @param currentDigits
	 * @param smallNum
	 */
	private static void addDigits(List<String> currentDigits, String smallNum) {
		Integer firstDigit = Integer.valueOf(smallNum.substring(0, 1));
		Integer lastDigit = Integer
				.valueOf(smallNum.substring(smallNum.length() -1, smallNum.length()));
		
		if (firstDigit > lastDigit) {
			for (int k = firstDigit; k <= 9; k++) {
				currentDigits.add(k + smallNum);
			}

		} else if (firstDigit < lastDigit) {
			for (int k = 1; k <=firstDigit; k++) {
				currentDigits.add(k + smallNum);
			}
		}else if(firstDigit==lastDigit){
			for (int k = 1; k <=9; k++) {
				currentDigits.add(k + smallNum);
			}
		}
	}
	
	/**
	 * multiply ten N times
	 * @param k
	 * @param n
	 * @return
	 */
	public static String padding0(int k,int n){
		StringBuffer sb = new StringBuffer();
		sb.append(k);
		
		for(int i = 1;i<=n;i++){
			sb.append("0");
		}
		
		return sb.toString();
	}

	/**
	 * for test
	 * @param a
	 * @param b
	 */
	public static void bruteForceTester(int a,int b){
		
		for(int i = a;i<b;i++){
			if(isIncDecNumber(i)){
				System.out.println(i);
			}
		}
		
	}
	
	public static boolean isIncDecNumber(Integer num){
		
		String str = num+"";
		
		List<Integer> intList = new ArrayList<Integer>();
		for(int i = 0;i<str.length();i++){
			intList.add(Integer.valueOf(str.substring(i, i+1)));
		}
		
		boolean flag = true;
		
		int leftNum = intList.get(0);
		for(int i = 0;i<intList.size();i++){
			if(leftNum>=intList.get(i)){
				leftNum = intList.get(i);
			}else{
				flag = false;
				break;
			}
		}
		
		if(flag){
			return flag;
		}
		flag = true;
		leftNum = intList.get(0);
		for(int i = 0;i<intList.size();i++){
			if(leftNum<=intList.get(i)){
				leftNum = intList.get(i);
			}else{
				flag = false;
				break;
			}
		}
		if(flag){
			return flag;
		}
		return false;
	}
	
	// 2017-9-8
}
