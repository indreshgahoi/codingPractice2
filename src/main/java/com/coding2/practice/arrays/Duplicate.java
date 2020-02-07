package com.coding2.practice.arrays;

public class Duplicate {


    public static void main(String[] args) {
        int input[] = {3,2,2,1,4,4};
        System.out.println(new Duplicate().solve(input));

        int input1[] = {2,4,3,4,1,1};
        System.out.println(new Duplicate().solve(input1));

        int input3[] = {1,2,3,4,5,5};
        System.out.println(new Duplicate().solve(input3));

        int input4[] = {1,1,3,4,4};
        System.out.println(new Duplicate().solve(input4));

    }


    int solve(int []arr){
        int l = 1, r = arr.length -1;
        while(r>0){
            int mid = (l+r)/2;
            if(checkForDuplicate(mid, arr)){
                return mid;
            }
            int postion =  totalNumberlessThan(mid, arr); // 3
            if(postion > (mid-1)){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }

    int totalNumberlessThan(int eleToSearch, int [] arr){
        int count = 0;
        for(int i = 0 ; i < arr.length; ++i){
            if(arr[i]< eleToSearch)
                count++;
        }
        return count;

    }

    boolean checkForDuplicate(int eleToSearch, int [] arr){
        int foundTime = 0;
        for(int i = 0 ; i < arr.length; ++i){
            if(arr[i] == eleToSearch)
                foundTime++;
            if(foundTime>1) break;
        }
        return foundTime>1;
    }

}
