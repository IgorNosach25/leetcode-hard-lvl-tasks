package main.java;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */

public class BestTimeBuyAndSellStockIII {

    //TODO algorithm still has n2 complexity. It has to be improved to n time.
    public int maxProfit(int[] prices) {
        int result = 0;
        if (prices == null || prices.length < 2) return result;
        int maxPreviousProfit = 0;
        int minPrevious = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            //find first the best profit
            int curr = prices[i];
            if (minPrevious > curr) {
                minPrevious = curr;
            } else {
                maxPreviousProfit = Math.max(maxPreviousProfit, curr - minPrevious);
                //it is needed if there is only one the biggest profit
                result = Math.max(maxPreviousProfit, result);
            }

            //find second profit
            int currK = i + 1;
            for (int k = i + 2; k < prices.length; k++) {
                //sum first and the second profit then save to result if is the biggest one
                result = Math.max(prices[k] - prices[currK] + maxPreviousProfit, result);
            }
        }
        return result;
    }
}
