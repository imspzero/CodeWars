package pers.sam.practice;


/**
 * 
 * @author SUM
 * https://www.codewars.com/kata/551f23362ff852e2ab000037/train/java
 * 
 */
public class LongestSlideDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
	}
	
    public static int longestSlideDown(int[][] pyramid) {
        // Code Goes Here..
    	int[][] greedyResult = new int[pyramid.length][];
    	
    	for(int i = 0;i<pyramid.length;i++){
    		greedyResult[i] = new int[pyramid[i].length];
    		
    		for(int j = 0;j<pyramid[i].length;j++){
    			greedyResult[i][j] =  pyramid[i][j];
    		}
    	}
    	
    	greedyResult[0][0] = pyramid[0][0];
    	
    	
		for (int i = 1; i < greedyResult.length; i++) {
			for (int j = 0; j < greedyResult[i].length; j++) {
				if (pyramid[i][j] == 0) {
					continue;
				}
				
				int topLeft = 0;
				int topRight = 0;
				
				if((i - 1)>=0&&(j - 1)>=0){
					topLeft= greedyResult[i - 1][j - 1];
				}
				
				if((i - 1)>=0&&(j)<=i-1){
					topRight = greedyResult[i - 1][j];
				}
				
				greedyResult[i][j] = pyramid[i][j] + Math.max(topLeft, topRight);

				// greedyResult[i][j] = pyramid[i][j];
			}
		}
    	

//    	for (int i = 0; i < greedyResult.length; i++) {
//			for (int j = 0; j < greedyResult[i].length; j++) {
//				System.out.print(greedyResult[i][j] + " ");
//			}
//			System.out.println("");
//		}
    	
    	int maxResult = 0;
    	
    	for(int i = 0;i<greedyResult[greedyResult.length-1].length;i++){
    		maxResult = Math.max(maxResult, greedyResult[greedyResult.length-1][i]);
    	}
    	
//    	System.out.println(maxResult);
    	
    	return maxResult;
    }

}
