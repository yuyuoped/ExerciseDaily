package com.datastruct;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyLinkedList {
    public static void main(String[] args) {
        Calendar calendar = new Calendar.Builder().set(Calendar.YEAR, 2018).set(Calendar.DAY_OF_YEAR, 200).build();
        Date time = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(time));
    }
}
