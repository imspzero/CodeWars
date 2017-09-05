package pers.sam.practice;

/*
 * https://www.codewars.com/kata/codewars-style-ranking-system/train/java
 */
public class User {
	
	public int rank;
	
	public int progress;
	
	
	User(){
		this.rank = -8;
		this.progress = 0;
	}
	
	public void incProgress(int activityRank){
		
		
		System.out.println("before"+" "+this.rank);
		System.out.println("before"+" "+this.progress);
		System.out.println(activityRank);
		
		if(activityRank<-8||activityRank>8||activityRank==0){
			throw new IllegalArgumentException("illegal activity rank");
		}
		
		if(this.rank==8){
			System.out.println("after"+" "+this.rank);
			System.out.println("after"+" "+this.progress);
			return;
		}
		
		int incProgress = getIncrementProgress(activityRank);
		if(incProgress == 0){
			System.out.println("after"+" "+this.rank);
			System.out.println("after"+" "+this.progress);
			return;
		}else{
			progress = progress +incProgress;
		}
		
		int incRank = 0;
		
		if(progress>=100){
			incRank = progress/100;
			updateRank(incRank);
			progress = this.rank==8?0:progress%100;
		}
		

		System.out.println("after"+" "+this.rank);
		System.out.println("after"+" "+this.progress);
		
	}
	
	private int getIncrementProgress(int activityRank){
		
		int rankDifference = getRankDifference(activityRank);
		
		if(rankDifference==0){
			return 3;
		}else if(rankDifference==-1){
			return 1;
		}else if(rankDifference<=-2){
			return 0;
		}else{
			return 10*rankDifference*rankDifference;
		}
	}
	
	private int getRankDifference(int activityRank){
		
		if(this.rank==activityRank){
			return 0;
		}else if(this.rank>activityRank){
			
			return (rank*activityRank>0)?activityRank-rank:activityRank-rank+1;
			
		}else if(this.rank<activityRank){
			
			return (rank*activityRank>0)?activityRank-rank:activityRank-rank-1;
		}
		
		return 0;
	}
	
	private void updateRank(int incRank){
		
		if(this.rank==8){
			return;
		}
		
		if(rank<0&&Math.abs(rank)>incRank){
			this.rank = this.rank + incRank;
		}else if(rank<0&&Math.abs(rank)<=incRank){
			this.rank = this.rank + incRank +1;
		}else if(this.rank>0){
			this.rank= this.rank + incRank;
		}
		
		if(this.rank >=8){
			this.rank = 8;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(102%100);
	}
}
