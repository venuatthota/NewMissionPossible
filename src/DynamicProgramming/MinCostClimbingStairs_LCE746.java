package DynamicProgramming;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs_LCE746 {

    public int minCostClimbingStairs_Naive(int[] cost) {
        if(cost == null || cost.length == 0){
            return 0;
        }
        if(cost.length == 1){
            return cost[0];
        }
        if(cost.length == 2){
            return Math.min(cost[0], cost[1]);
        }
        int val1 = cost[0];
        int val2 = cost[1];
        int result = Math.min(val1, val2);
        for(int i = 2;i < cost.length;i++){
            result = cost[i] + Math.min(val1, val2);
            val1 = val2;
            val2 = result;
        }
        return Math.min(val1, val2);
    }

    public int minCostClimbingStairs_DP(int[] cost) {
        if(cost == null || cost.length == 0){
            return 0;
        }
        int len = cost.length;
        if(len == 1){
            return cost[1];
        }
        int dp[] = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2;i < len;i++){
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[len - 1], dp[len - 2]);
    }

    
}
