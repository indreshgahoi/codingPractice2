package com.coding2.practice.arrays;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;

public class JumpGame3 {

    public static void main(String[] args) {
        int [] input1 = {1,1,2,4,6,3,7} ;
        System.out.println("results : " + new JumpGame3().canReach(input1, 5));

        int [] input2 = {4,2,3,0,3,1,2} ;
        System.out.println("results : " + new JumpGame3().canReach(input2, 5));
    }



    public boolean canReach(final int[] arr, int start) {
        final Queue<Integer> q = new LinkedList<>();
        final BitSet visitedIndexes = new BitSet(arr.length);
        final int target = 0;
        q.add(start);
        visitedIndexes.set(start);
        while(!q.isEmpty()){
            int current = q.remove();
            if(arr[current] == target) return true;
            int x = current - arr[current], y = current + arr[current];
            //System.out.println("x: " + x + " y: " + y);
            safeAdd(arr, q, visitedIndexes, x);
            safeAdd(arr, q, visitedIndexes, y);
            //System.out.println(q);
        }

       return false;
    }

    private void safeAdd(int[] arr, Queue<Integer> q, BitSet visitedIndexes, int x) {
        if (x >= 0 && x < arr.length && !visitedIndexes.get(x)) {
            q.add(x);
            visitedIndexes.set(x);
        }
    }
}
