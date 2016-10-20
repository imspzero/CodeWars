package pers.sam.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Sam Lee
 * @version 2016年10月18日上午11:09:35
 * 
You have a positive number n consisting of digits. You can do at most one operation: Choosing the index of a digit in the number, remove this digit at that index and insert it back to another place in the number.

Doing so, find the smallest number you can get.

 * 
 */

public class ToSmallest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		smallest(12113456789l);
	}

	public static long[] smallest(long n) {
		// your code
		long [] result = new long[3];
		
		String numStr = String.valueOf(n);
		
		List<Integer> digitList = new ArrayList<>();
		
		getDistinctNumber(numStr, digitList);
		
		
		System.out.println(digitList);
		
		
		return result;
	}
	
	public static long [] getSmallestNumber(String numStr,List<Integer> digitList){
		
		long [] resultBefore = {0,0,0};

		long [] resultAfter = {0,0,0};
		
		String resultNum = "";
		
		long tempResult = Long.valueOf(numStr);
		
		for(int i = 0;i<digitList.size();i++){
			int lastIndex = numStr.lastIndexOf(digitList.get(i));
			
			Integer currentDigit = digitList.get(i);
			
			for(int j = lastIndex-1;j>=0;j--){
				Integer formerDigit = Integer.valueOf(numStr.substring(j, j+1));
				if(formerDigit>=currentDigit){
					resultNum = numStr.substring(0,j)+
								currentDigit + 
								numStr.substring(j+1,lastIndex)+
								numStr.substring(lastIndex+1,numStr.length());
					
					if(Long.valueOf(resultNum)<=tempResult){
						resultBefore[0] = Long.valueOf(resultNum);
						resultBefore[1] = Long.valueOf(digitList.get(i));
						resultBefore[2] = j;
					}
				}
			}
			
			for(int j = numStr.length()-1;j>=lastIndex+1;j--){
				Integer followedDigit = Integer.valueOf(numStr.substring(j, j+1));
//				if(){
//					
//				}
			}		
		}
			
		return resultBefore;
	}
	

	private static void getDistinctNumber(String numStr, List<Integer> digitList) {
		for(int i=0;i<numStr.length();i++){
			Integer num = Integer.valueOf(numStr.substring(i, i+1));
			if(!digitList.contains(num)){
				digitList.add(num);
			}
		}
		
		Collections.sort(digitList);
	}
}
