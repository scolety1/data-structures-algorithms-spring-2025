package april24_2;

import java.util.Arrays;

public class TaxiProfitDP {

	public static void main(String[] args) {
		int[][] input_rides = { {2,5,4}, {1,5,1} };
		
		Ride[] rides = new Ride[input_rides.length];
		
		for(int i = 0; i < input_rides.length; i++ ) {
			rides[i] = new Ride(input_rides[i][0], input_rides[i][1], input_rides[i][2]); 
		}
		
		Arrays.sort(rides, (a,b) -> a.end - b.end);
		
		int[] dp = new int[rides.length];
		Arrays.fill(dp, -1);
		
		int final_answer = findMaxProfit(rides, 0, dp);
		System.out.println(final_answer);
	}

	public static int findMaxProfit(Ride[] rides, int index, int[] dp) {
		
		//base case
		if(rides.length == index) {
			return 0;
		}
		
		if(dp[index] != -1) {
			return dp[index];
		}
		
		int next = index + 1;
		
		while(next < rides.length && rides[next].start < rides[index].end ) {
			next++;
		}
		
		
		int takeCustomer = (rides[index].end - rides[index].start + rides[index].tip) + findMaxProfit(rides, next, dp); 
		int skipCustomer = findMaxProfit(rides, index+1, dp);
		
		int answer = Math.max(takeCustomer, skipCustomer);
		dp[index] = answer;
		return answer;
		
	}
	
}






