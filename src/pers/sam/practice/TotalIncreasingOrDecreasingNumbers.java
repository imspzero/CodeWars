package pers.sam.practice;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * https://www.codewars.com/kata/55b195a69a6cc409ba000053/train/java
 * 
 * @author Sam Lee
 * @version 2016年11月5日下午6:21:02
 */
public class TotalIncreasingOrDecreasingNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		totalIncDec(3);
		
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
		
		System.out.println(Math.pow(10, n));
		
		Map<Integer,List> digitsNumberMap = new HashMap<>();
		
//		int digits = String.valueOf(n).length();
//		System.out.println(digits);
		List<String> resultListPerDigits = new ArrayList<>();
		
		// 0 digits
		digitsNumberMap.put(0, resultListPerDigits);
		
		//1 digits
		resultListPerDigits = new ArrayList<>();
		for(int k=0;k<10;k++){
				resultListPerDigits.add("0"+k);
			}
		digitsNumberMap.put(1, resultListPerDigits);
		
		//2 digits
		resultListPerDigits = new ArrayList<>();
		for(int k=10;k<100;k++){
				resultListPerDigits.add(k+"");
			}
		digitsNumberMap.put(2, resultListPerDigits);
		
		
		//>=3 digits
		for(int i = 3;i<=n;i++){
			// i digits,  for example i=1,num<10
			
			List<String> lastDigits = digitsNumberMap.get(i-1);
			List<String> currentDigits = new ArrayList<>();
			for(String smallNum:lastDigits){
				for(int j = 1;j<=9;j++){
					if(isIncDecNumber(j,smallNum)){
						currentDigits.add(j+smallNum);
					}
				}
			}
			
//			for(int k=(int) Math.pow(10, i-1);k<(int) Math.pow(10, i);k++){
//				resultListPerDigits.add(k);
//			}
			digitsNumberMap.put(i, currentDigits);
		}
		
		for(Iterator it = digitsNumberMap.keySet().iterator();it.hasNext();){
			Integer digit = (Integer) it.next();
			List<String> currentDigits = digitsNumberMap.get(digit);
			System.out.print("Digit "+digit+" :");
			for(String d:currentDigits){
				System.out.print(d+" ");
			}
			System.out.println();
		}
		
		
		for(Iterator it = digitsNumberMap.keySet().iterator();it.hasNext();){
			Integer digit = (Integer) it.next();
			List<String> currentDigits = digitsNumberMap.get(digit);
			System.out.print("Digit "+digit+" :");
			for(String d:currentDigits){
				System.out.print(d+" ");
			}
			System.out.println();
		}
		
		return null;
	}
	
	public static boolean isIncDecNumber(int leftDigit, String smallNumber) {

		if (leftDigit >= Integer.valueOf(smallNumber.substring(0, 1))
				&& Integer.valueOf(smallNumber.substring(0, 1)) >= Integer
						.valueOf(smallNumber.substring(smallNumber.length() - 2, smallNumber.length() - 1))) {
			return true;
		} else if (leftDigit <= Integer.valueOf(smallNumber.substring(0, 1))
				&& Integer.valueOf(smallNumber.substring(0, 1)) <= Integer
				.valueOf(smallNumber.substring(smallNumber.length() - 2, smallNumber.length() - 1))) {
			return true;
		}

		return false;
	}
	
}
