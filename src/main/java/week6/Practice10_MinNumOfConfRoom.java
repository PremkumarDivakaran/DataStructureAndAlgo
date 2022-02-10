package week6;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Practice10_MinNumOfConfRoom {

    @Test
    public void example1() {
        String[][] meetingTimes = {{"09 00", "09 45"}, {"09 30", "10 30"}, {"10 40", "12 00"}, {"11 00", "13 00"}, {"11 45", "14 00"}, {"16 00", "17 00"}};
        Assert.assertEquals(3, findMinimumNumOfConfRoom(meetingTimes));
    }

    @Test
    public void example2() {
        String[][] meetingTimes = {{"09 00", "09 30"},{"11 00", "11 10"},{"10 30", "11 00"},{"10 40", "11 40"}};
        Assert.assertEquals(2, findMinimumNumOfConfRoom(meetingTimes));
    }

    @Test
    public void example3() {
        String[][] meetingTimes = {{"09 00", "09 30"},{"12 00", "12 10"},{"13 30", "13 50"},{"10 40", "11 40"}};
        Assert.assertEquals(1, findMinimumNumOfConfRoom(meetingTimes));
    }

    private int findMinimumNumOfConfRoom(String[][] meetingTimes) {
        int out = meetingTimes.length;

        int[][] intMeetingTimes = new int[meetingTimes.length][2];
        for(int i=0;i<meetingTimes.length;i++){
            intMeetingTimes[i][0] = Integer.parseInt(meetingTimes[i][0].replace(" ",""));
            intMeetingTimes[i][1] = Integer.parseInt(meetingTimes[i][1].replace(" ",""));
        }

        Arrays.sort(intMeetingTimes, (a, b) -> {
            if(a[1] != b[1]) return a[1] - b[1];
            else return a[0] - b[0];
        });

        int left = 0, right = 1;

        while(right<intMeetingTimes.length){
            int endTime = intMeetingTimes[left][1];
            int nextStartTime = intMeetingTimes[right][0];
            if(endTime<=nextStartTime){
                out--;
                left++;
            }
            right++;
        }


        return out;
    }


}
