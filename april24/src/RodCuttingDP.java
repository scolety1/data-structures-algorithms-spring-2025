import java.util.Arrays;

public class RodCuttingDP {

	public static void main(String[] args) {
		
		int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
		
		int rod_length = 8;
		
		int[][] dp = new int[rod_length][rod_length+1];
		
		for(int i = 0 ; i < rod_length; i++) {
			Arrays.fill(dp[i], -1);
		}

		int solution = cutRod(prices, rod_length - 1, rod_length, dp );
		System.out.println("Maximum Profit: " + solution);
		
	}

	public static int cutRod(int[] prices, int index, int rod_length, int[][] dp) {
		
		//base case
		if(index == 0) {
			return rod_length * prices[0];
		}
		
		if(dp[index][rod_length] != -1) {
			return dp[index][rod_length];
		}
		
		int notCut = cutRod(prices, index-1, rod_length, dp);
		int cut = Integer.MIN_VALUE;
		int length_of_cut = index + 1;
		
		if(length_of_cut <= rod_length) {
			cut = prices[index] + cutRod(prices, index, rod_length - length_of_cut, dp);
		}
		int answer = Math.max(cut, notCut);
		dp[index][rod_length] = answer;
		return answer;
		
	}
	
	
}
