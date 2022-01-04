package com.yy.thread;

import lombok.Data;

/**
 * 线程不安全体现示例
 * @author yy
 */
public class ThreadSyncTest {


    public static void main(String[] args) {
        ThreadNum threadNum = new ThreadNum();

        Thread thread1 = new Thread(threadNum, "张三");
        thread1.start();
        Thread thread2 = new Thread(threadNum, "李四");
        thread2.start();
        Thread thread3 = new Thread(threadNum, "王五");
        thread3.start();

    }
}

@Data
class ThreadNum implements Runnable {

   int num = 10;

    public synchronized void onlySellOne() {
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + " = " + num);
            num--;
        }

    }

    @Override
    public void run() {
        while (num > 0) {
            onlySellOne();
        }
    }
}

