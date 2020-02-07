package com.coding2.practice;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
Given a collection of intervals, merge all overlapping intervals
        Input: [[1,3],[8,20],[3,4],[15,18]]
        Output: [[1,4],[8,20]]


        [[1,3],[8,20],[3,4],[15,18]] O(nLog(n))
        1-3, 3-4, 8-20, 15-18 , O(n)
        1-4, 8-20
        nLog(n)

*/



public class MergerInterval {


    public static void main(String[] args) {

        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1,3));
        list.add(new Interval(8,20));
        list.add(new Interval(3,4));
        list.add(new Interval(15,18));


        System.out.println(new MergerInterval().merge(list));
        ;
    }


    private static class Interval implements Comparable{
        Integer start;
        Integer end ;
        Interval(int start, int end){
            this.start = start;
            this.end = end ;
        }
        @Override
        public int compareTo(Object o) {
            return Integer.compare(this.start, ((Interval)o).start);
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public List<Interval> merge(final List<Interval> intervals){
        System.out.println("before start: " + intervals);
        Collections.sort(intervals);
        System.out.println("after start: " + intervals);

        final Stack<Interval> stack = new Stack<>();

        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if(stack.isEmpty()){
                stack.push(interval);
            }else{
                Interval top = stack.peek();
                if(interval.start > top.end){
                    stack.push(interval);
                }else if(interval.start <= top.end){
                    top.end = Math.max(interval.end, top.end);
                }
            }
        }
        final List<Interval> list = new ArrayList<>();
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return  list;
    }


}
