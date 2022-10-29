package com.yuyuoped;

public class VolatileDemo {
    public static void main(String[] args) {
        Object o = new Object();

        try {
            new Thread(new Solution(1, o)).start();
            new Thread(new Solution(2, o)).start();
            new Thread(new Solution(3, o)).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Solution implements Runnable {

    private int threadId;

    private Object o;

    // You can add other member variables needed.
    // -- write your code here --
    private volatile static int number = 1;

    public Solution(int threadId, Object o) {
        this.threadId = threadId;
        this.o = o;
    }

    @Override
    public void run(){
        // -- write your code here --
        synchronized(o) {
            while(true) {
                if (number == 29) {
                    o.notifyAll();
                    break;
                }
                if (number / 5 % 3 == (threadId - 1)) {
                    for(int i = 0; i < 5; i++) {
                        if (number == 29) break;
                        System.out.println("Thread " + threadId + ": " + (number++));
                    }
                    o.notifyAll();
                } else {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}