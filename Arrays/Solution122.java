class Solution122 {
    // greedy approach is best. for more depth, explain it with dp (after learning).
    public static int maxProfit(int[] prices) {
        int profit = 0;

        for(int i = 1;i<prices.length;i++){
            if(prices[i-1] < prices[i]){
                profit+=prices[i] - prices[i-1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] nums = {7,6,4,3,1};
        System.out.println(maxProfit(nums));
    }

}