package main.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

/*
    Your company built an in-house calendar tool called HiCal. You want to add a feature
    to see the times in a day when everyone is available.

    To do this, you’ll need to know when any team is having a meeting. In HiCal, a meeting
    is stored as tuples ↴ of integers (start_time, end_time). These integers represent
    the number of 30-minute blocks past 9:00am.

    Write a method mergeRanges() that takes a list of meeting time ranges and returns a
    list of condensed ranges.

    For example, given:
        [Meeting(0, 1), Meeting(3, 5), Meeting(4, 8), Meeting(10, 12), Meeting(9, 10)]

    your method would return:
        [Meeting(0, 1), Meeting(3, 8), Meeting(9, 12)]

    https://www.interviewcake.com/question/python/merging-ranges

    Time Complexity : O(N*logN)
 */
public class MergingRanges {

    static class Meeting{

        int startTime;
        int endTime;

        public Meeting(int startTime, int endTime) {
            // number of 30 min blocks past 9:00 am
            this.startTime = startTime;
            this.endTime   = endTime;
        }
    }

    public static void main(String[] args){

        ArrayList<Meeting> meetingList = new ArrayList<>();
        meetingList.add(new Meeting(0, 1));
        meetingList.add(new Meeting(3, 5));
        meetingList.add(new Meeting(4, 8));
        meetingList.add(new Meeting(10, 12));
        meetingList.add(new Meeting(9, 10));

        mergeRanges(meetingList);
    }

    static class CustomComparator implements Comparator<Meeting>{

        @Override
        public int compare(Meeting o1, Meeting o2) {
            return new Integer(o1.startTime).compareTo(new Integer(o2.startTime));
//            return o1.startTime - o2.startTime;
        }
    }

    private static void mergeRanges(ArrayList<Meeting> meetingList) {

        Collections.sort(meetingList, new CustomComparator());

        // or use below to sort
//        Collections.sort(meetingList, new Comparator<Meeting>() {
//            @Override
//            public int compare(Meeting o1, Meeting o2) {
//                return o1.startTime - o2.startTime;
//            }
//        });

        Stack<Meeting> stack = new Stack<>();
        for(int i=0; i<meetingList.size(); i++){
            if(stack.empty()){
                stack.push(meetingList.get(i));
            }
            else {
                Meeting temp = stack.peek();
                if(meetingList.get(i).startTime <= temp.endTime){
                    temp.endTime = meetingList.get(i).endTime;
                    stack.pop();
                    stack.push(temp);
                }
                else {
                    stack.push(meetingList.get(i));
                }
            }
        }

        while (!stack.empty()){
            Meeting temp = stack.pop();
            System.out.println("["+ temp.startTime + "," + temp.endTime +"]");
        }
    }
}
