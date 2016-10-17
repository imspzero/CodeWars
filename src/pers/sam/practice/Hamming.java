package pers.sam.practice;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.codewars.com/kata/hamming-numbers/train/java
 * @author SUM
 *
 */
public class Hamming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(hamming(5000));
		
	}
		
	public static long hamming(int n) {
	  	// TODO: Program me
		List<Long> resultList = new ArrayList<>();
		
		//System.out.println(Long.MAX_VALUE);
		
		for(int i =0;i<=n-1;i++){
			arrangeExponent(i,resultList);
		}
		Collections.sort(resultList);
		return resultList.get(n-1);
	 }
	
	public static void arrangeExponent(int exponent,List<Long> resultList ){
		
		for(int i = 0;i<=exponent;i++){
			for(int j = 0;j<=exponent-i;j++){
				for(int k = 0;k<=exponent-i-j;k++){
					long result = (long) (Math.pow(2, k)*Math.pow(3, j)*Math.pow(5, i));
					if(!resultList.contains(result)){
						resultList.add(result);	
					}
				}
			}
		}
	}
}
