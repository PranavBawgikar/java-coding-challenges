/*
Challenge: Buy and Sell Stock - 1
Given an array of stock prices. At most one transaction is allows i.e., buy one and sell share of the stock.
Design an algorithm to find the maximum profit.
Note: You cannot sell a stock before you buy one.

Exampl 1:
Input: {7, 1, 5, 3, 6, 4}
Output: 5

Explanation: Buy on Day 2 (Price = 1) and sell on Day 5 (Price  = 6), profit = 6 - 1 = 5.
Not 7 - 1 = 6, as selling price needs to be larger than buying price.
*/
public class BuyAndSellStock {
	public static void main(String[] args) {
		int[] arr = {7, 1, 5, 3, 6, 4, 8};
		int result = getMaxProfit(arr);
		System.out.println("The maximum profit is " + result);
	}

	public static int getMaxProfit(int[] arr) {
		int min = Integer.MAX_VALUE;
		int max = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] < min) {
				min = arr[i];
			}
			if(arr[i] - min > max) {
				max = arr[i] - min;
			}
		}
		return max;
	}
}