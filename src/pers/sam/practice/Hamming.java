package pers.sam.practice;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * https://www.codewars.com/kata/hamming-numbers/train/java
 * @author SUM
 *
 */
public class Hamming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long start = System.currentTimeMillis();
		System.out.println(hamming(100));
		long end = System.currentTimeMillis();
		
		System.out.println(" "+(end-start)/1000);
		
		System.out.println(Math.log(100));
	}

	public static long hamming(int n) {
	  	// TODO: Program me
//		List<Long> resultList = new ArrayList<>();
//		
//		arrangeExponent(n,resultList);
//		
//		Collections.sort(resultList);
//		return resultList.get(n-1);
		
		
		
		TreeSet<Long> set = new TreeSet<>(Arrays.asList(2L,3L,5L));
		long smallest = 1;
		for(int i=1;i<n;i++){
			smallest = set.pollFirst();
			set.add(smallest*2L);
			set.add(smallest*3L);
			set.add(smallest*5L);
		}
		return smallest;
	 }
	
	public static void arrangeExponent(int exponent,List<Long> resultList ){
		
		for(int i = 0;i<=exponent;i++){
			for(int j = 0;j<=exponent-i&&j<=exponent/2;j++){
				for(int k = 0;k<=exponent-i-j&&k<=exponent/2;k++){
					long result = (long) (Math.pow(2, k)*Math.pow(3, j)*Math.pow(5, i));
					if(!resultList.contains(result)){
						resultList.add(result);	
					}
				}
			}
		}
	}
}
