package com.coding2.practice.stack;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate span of stock’s price for all n days.
 * The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
 * For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 */


/**   0    1   2   3   4  5   6
 *   100, 80, 60, 70, 60, 75, 85
 *    1    1   1   2   1  4   0
 *   
 *   S = 100, 80, 75,      
 */
public class StockSpanProblem {


    public static void main(String[] args) {
        final int [] prices = {100, 80, 60, 70, 60, 75, 85};
        System.out.println(new StockSpanProblem().solve(prices));
    }


    List<Integer> solve(final int[] prices) {
        final Stack<Integer> stack = new Stack<>();
        final List<Integer> stockSpans = new ArrayList<>();

        for (int i = 0; i < prices.length ; i++) {
            while(!stack.isEmpty() && prices[stack.peek()]<= prices[i]){
                stack.pop();
            }
            int stockSpan = stack.isEmpty() ? i + 1 :  i - stack.peek();
            stockSpans.add(stockSpan);
            stack.push(i);
        }
        return stockSpans;
    }
}
