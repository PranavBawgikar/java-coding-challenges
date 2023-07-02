/*M
Challenge: Stock Market Profit (Source: Facebook)
Suppose you have been keeping an eye on the stock market for a while, and you have been tracking the daily prices of a particular stock. 
You want to make a profit by buying and selling the stock at the right time. 
Given the array of prices of the stock on each day, you need to figure out the best strategy to maximize your profit.
However, if the stock prices are constantly decreasing, there is no way for you to make a profit.

Example 1:
Input:
7
arr[] = {100, 180, 260, 310, 40, 535, 695}

Output:
865

Explanation:
Buy the stock on day 0 and sell it on day 3 => 310-100 = 210
Buy the stock on day 4 and sell it on day 6 => 695-40 = 655
Maximum Profit = 210+ 655 = 865

Example 2:
Input:
5
arr[]=[4,2,2,2,4}

Output:
2

Explanation:
Buy the stock on day 1 and sell it on day 4 => 4-2=2
Maximum Profit = 2

Input format:
The first line of the input is an integer value specifying the size of the array. The next line of the input is the array of integer values separated by space.

Output format:
The output is the integer value specifying the maximum profit.
*/

import java.util.Scanner;

public class StockMarketProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] prices = new int[n]; //array of stock prices
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        int maxProfit = findMaxProfit(prices);
        System.out.println(maxProfit);
    }

    private static int findMaxProfit(int[] prices) {
        int maxProfit = 0;
        int buyPrice = prices[0]; //price at which we will buy the stock

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buyPrice) { //comparing current price with the buyPrice
                maxProfit += prices[i] - buyPrice; //it means we can sell the stock and make a profit
                //updating the maxProfit by adding the difference between the current price and buyPrice
            }
            //Regardless of whether we sell the stock or not, we update the buyPrice to the current price
            //This is because we want to find the next buying opportunity for maximizing the profit
            buyPrice = prices[i];
        }

        return maxProfit;
    }
}
//The approach used in the code is called "greedy approach." 
//It takes advantage of the fact that we can make multiple transactions to maximize the profit. 
//Whenever we find a price that is higher than the previous buying price, we sell the stock and update the maximum profit. 
//By doing this for all increasing prices, we maximize the overall profit.