package main.greedy;

/*

    Your are given an array of integers prices, for which the i-th element is the price of a
    given stock on day i; and a non-negative integer fee representing a transaction fee.

    You may complete as many transactions as you like, but you need to pay the transaction
    fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you
    must sell the stock share before you buy again.)

    Return the maximum profit you can make.

    Input: prices = [1, 3, 2, 8, 4, 9], fee = 2

    Output: 8

    Explanation: The maximum profit can be achieved by:
        Buying at prices[0] = 1
        Selling at prices[3] = 8
        Buying at prices[4] = 4
        Selling at prices[5] = 9
        The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

    Time Complexity: O(N), where NN is the number of prices.
    Space Complexity: O(1), the space used by cash and hold.

 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    public static void main(String[] args){

        int[] input = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println("Maximum profit which can be achieved is :: " + maxProfit(input, fee));
    }

    private static int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}
