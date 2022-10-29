package com.yuyuoped;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class MultiThreadDateSolution {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        Thread[] thread = Solution3.getWeekDay();
        for (Thread t : thread) {
            t.start();
        }
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        TreeMap<String, String> rmap = new TreeMap<>(Solution3.map);
        System.out.println("Time limit 200ms: " + ((end - start) < 240));
        System.out.println("Solution.map.size() = " + Solution3.map.size());
        System.out.println("Solution.map = " + rmap);

    }
}

class Solution3 {
    static String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(1024);

    static Thread[] getWeekDay() throws Exception {
        Thread[] weekDay = new Thread[7];
        // write your code here

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = sdf.parse("2021-10-8");
        long oneDayMillisecond = 24 * 60 * 60 * 1000;
        long thousandDayMillisecond = 1000 * oneDayMillisecond;

        for (int j = 0; j < 7; j++) {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-M-d");
            Date currentThreadBeginDate = new Date(beginDate.getTime() + thousandDayMillisecond * j);
            weekDay[j] = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    Date currentDate = new Date(currentThreadBeginDate.getTime() + oneDayMillisecond * i);
                    map.put(sdf1.format(currentDate), day[(i + 5) % 7]);
                }
            });
        }

        return weekDay;
    }

}
