package com.coding2.practice;

import java.util.*;

public class MaxSprints {


    public static void main(String[] args) {
        System.out.println(getMostVisited(5, new ArrayList<>(Arrays.asList(2,4,1,3))));
    }

    private static class Pair {
        int mark ;
        boolean isEnd ;
        Pair(int x, boolean e){
            this.mark = x ;
            this.isEnd = e;
        }
    }

    public static int getMostVisited(int n, List<Integer> sprints) {
        // Write your code here

        List<Pair> list = new ArrayList();
        for(int i = 1 ; i < sprints.size() ; ++i){
            Pair mark1 = new Pair(Math.min(sprints.get(i),sprints.get(i-1)), false);
            Pair mark2 = new Pair(Math.max(sprints.get(i),sprints.get(i-1)), true);
            list.add(mark1);
            list.add(mark2);
        }
        list.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare(o1.mark, o2.mark);
            }
        });

        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int maxMark = -1;
        int maxVisit = -1;
        for(int i = 0 ; i < list.size() ; ++i){
            Pair current = list.get(i);
            if(!current.isEnd){
                start++;
            }
            map.put(current.mark, start);
            if(start > maxMark){
                maxMark = start;
                maxVisit = current.mark;
            }
            if(current.isEnd){
                start--;
            }
        }
        return maxVisit;
    }
}
