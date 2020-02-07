package com.coding2.practice.arrays;

import java.util.Arrays;

public class JumpGame {

    public static void main(String[] args) {
        final JumpGame jumpGame = new JumpGame();
        int [] testCase1 = {1,1,1,2,1,1,1,1,0,2};
        System.out.println(jumpGame.canJump(testCase1));

        int [] testCase2 = {5,1,0,0,0,3,0,4,1,0,0};
        System.out.println(jumpGame.canJump(testCase2));

    }
    public boolean canJump(int[] nums) {
        final int targetReachableIndex = nums.length - 1;
        int currentMaxReachableIndex = 0;
        int currentIndex = 0;
         while(currentIndex < nums.length && currentIndex <= currentMaxReachableIndex && currentMaxReachableIndex < targetReachableIndex){
             currentMaxReachableIndex = Math.max(currentMaxReachableIndex, currentIndex + nums[currentIndex]);
             currentIndex++;
             if(currentMaxReachableIndex>=targetReachableIndex) return true;
         }
         return currentMaxReachableIndex>=targetReachableIndex;
    }


}



