package com.yuyuoped;

public class SyncSolution {

    public static void main(String[] args) throws InterruptedException {
        // 获取输入的 printCount
        Integer printCount = 3;

        Object oa = new Object();
        Object ob = new Object();
        Object oc = new Object();

        // 建立三个线程
        Solution2 solutionA = new Solution2("A", oc, oa, printCount);
        Solution2 solutionB = new Solution2("B", oa, ob, printCount);
        Solution2 solutionC = new Solution2("C", ob, oc, printCount);

        new Thread(solutionA).start();
        new Thread(solutionB).start();
        Thread.sleep(10);
        new Thread(solutionC).start();
    }
}

class Solution2 implements Runnable {

    private String name;

    private Object prev;

    private Object self;

    private Integer printCount;

    public Solution2(String name, Object prev, Object self, Integer printCount) {
        this.name = name;
        this.prev = prev;
        this.self = self;
        this.printCount = printCount;
    }

    @Override
    public void run() {
        //  -- write your code here --
        while(printCount > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    printCount--;
                    self.notify();
                }

                if (printCount == 0) {
                    prev.notify();
                } else {
                    try {
                        prev.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
