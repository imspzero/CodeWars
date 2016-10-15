package pers.sam.practice;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://www.codewars.com/kata/54eb33e5bc1a25440d000891/
 * @author SUM
 *
 */
public class Decompose {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		long a = 10;
//		
//		System.out.println((long)Math.floor(Math.sqrt(new Double(Long.toString(a)))));
//		
		Decompose d = new Decompose();
	    long n = 12;
		d.decompose(n);
		
	}

	public String decompose(long n) {
		
		System.out.println(n);
		List<Long> resultList = new LinkedList<>();
		
		long remainSquares = n * n;
		
//		resultList.add(n - 1);
//		remainSquares = remainSquares - (n - 1) * (n - 1);
		
		if(queryIncreasingList(n,remainSquares,resultList)){
			Collections.reverse(resultList);
			
			String resultString = "";
			long lastNum = 0;
			for(int i = 0;i<resultList.size();i++){
				resultString = resultString+resultList.get(i)+" ";
			}
			System.out.println(resultString);
			return resultString.trim();
		}else{
			return "";
		}
	}

	public static boolean queryIncreasingList(long n,long remainSquares,List<Long> resultList) {

		for (long i = Math.min(n-1,(long)Math.floor(Math.sqrt(new Double(Long.toString(remainSquares))))); i > 0; i--) {
			
			if(resultList.size()>0&&i>=resultList.get(resultList.size()-1)){
				continue;
			}
			
			remainSquares = remainSquares-i*i;
			resultList.add(i);
			
			if(remainSquares ==0){
				return true;
			}
			
			if(queryIncreasingList(n,remainSquares,resultList)){
				return true;
			}else{
				remainSquares = remainSquares+i*i;
				resultList.remove(resultList.size()-1);
				continue;
			}
		}
		
		return false;
		
	}

}
