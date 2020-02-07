package com.coding2.practice;

import java.util.Arrays;
import java.util.List;

public class WaysToSum {


    public static void main(String[] args) {
        System.out.println(ways(5, 3));
    }

    public static int ways(int total, int k) {
        // Write your code here
          int[] count = new int[total+1];
          for(int i = 0 ; i < total + 1 ; ++i){
              count[i] = 0;
            }
        count[0] = 1;
        for(int i = 1 ; i < total + 1 ; ++i){
         for(int n = 1 ; n < k + 1 ; ++n){
                  if(i >= n){
                      count[i] = count[i] + count[i-n]  ;
                  }
              }
            System.out.println(Arrays.toString(count));

          }
          return count[total];
    }


    public static int minCost(List<List<Integer>> cost) {
        // Write your code here
        int len = cost.size();
        int[] c1 = new int[len];
        int[] c2 = new int[len];
        int[] c3 = new int[len];
        c1[0] = cost.get(0).get(0);
        c2[0] = cost.get(0).get(1);
        c3[0] =  cost.get(0).get(2);


        for(int i = 1 ; i < len ; ++i){
            c1[i] = Math.min(c2[i-1], c3[i-1]) + cost.get(i).get(0);
            c2[i] = Math.min(c1[i-1], c3[i-1]) + cost.get(i).get(1);
            c3[i] = Math.min(c2[i-1], c1[i-1]) + cost.get(i).get(2);
        }
        return Math.min(Math.min(c1[len - 1], c2[len - 1]), c3[len - 1]);

    }


}
