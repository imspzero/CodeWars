package pers.sam.practice;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * https://www.codewars.com/kata/recover-a-secret-string-from-random-triplets/train/java
 * 
 * @author SUM
 *
 */
public class SecretDetective {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SecretDetective detective = new SecretDetective();
		char[][] triplets = {
			      {'t','u','p'},
			      {'w','h','i'},
			      {'t','s','u'},
			      {'a','t','s'},
			      {'h','a','p'},
			      {'t','i','s'},
			      {'w','h','s'}
			    };
		 detective.recoverSecret(triplets);
	}
	
	public String recoverSecret(char[][] triplets) {
		Map<String,String> charMap = new HashMap<>();
		
		for(int i = 0;i<triplets.length;i++){
			for(int j = 0;j<triplets[i].length;j++){
				charMap.put(String.valueOf(triplets[i][j]), String.valueOf(triplets[i][j]));
			}
		}
		
		StringBuffer testStr = new StringBuffer("");
		
		Set<String> keySet = charMap.keySet();
		for(Iterator<String> i = keySet.iterator();i.hasNext();){
			testStr.append(i.next());
		}
		
		System.out.println(testStr);
		
		permutation(testStr,0,triplets);
		
		System.out.println(testStr);
		
		return testStr.toString();
	}
	
	public static boolean permutation(StringBuffer testStr, int k, char[][] triplets) {

		if (k >= testStr.length()) {
			//System.out.println(testStr);
			if(isValidString(testStr,triplets)){
				return true;
			}else{
				return false;
			}
			
		} else {
			for (int i = k; i < testStr.length(); i++) {

				char x = testStr.charAt(k);
				char y = testStr.charAt(i);
				testStr.setCharAt(k, y);
				testStr.setCharAt(i, x);

				boolean flag = permutation(testStr, k + 1, triplets);
				if(flag){
					return true;
				}
				testStr.setCharAt(k, x);
				testStr.setCharAt(i, y);

			}
		}

		return false;
	}
	
	public static boolean isValidString(StringBuffer testStr,char[][] triplets){
		
		for(int i = 0;i<triplets.length;i++){
			char a = triplets[i][0]; 
			char b = triplets[i][1];
			char c = triplets[i][2];
			
			int ia = testStr.indexOf(String.valueOf(a));
			int ib = testStr.indexOf(String.valueOf(b));
			int ic = testStr.indexOf(String.valueOf(c));
			
			if(!(ia<ib&&ib<ic)){
				return false;
			}		
		}
		return true;
	}
	
}
