package com.example.sundy_android_test.chapter_my;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author xiads
 * @date 14-8-12
 */
public class TimerTest {

    static int mCount = 0;
    static int mCount2 = 0;
    static int mCount3 = 0;
    static int mCount4 = 0;

    static ScheduledExecutorService mService = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) throws ParseException {
        /*mService.scheduleAtFixedRate(new Work(), 2, 1, TimeUnit.SECONDS);
        mService.scheduleAtFixedRate(new Work2(), 2, 2, TimeUnit.SECONDS);
        mService.scheduleAtFixedRate(new Work3(), 2, 3, TimeUnit.SECONDS);
        mService.scheduleAtFixedRate(new Work4(), 2, 4, TimeUnit.SECONDS);*/
        Timer myTimer = new Timer();
        myTimer.schedule(new Worker(), 1000);//1秒后执行
//      2012-02-28 09:58:00执行
        myTimer.schedule(new Worker(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2014-08-12 23:11:00"));
        myTimer.schedule(new Worker(), 5000,1000);//5秒后执行 每一秒执行一次
//      2012-02-28 09:58:00执行一次 以后每秒执行一次，如果设定的时间点在当前时间之前，任务会被马上执行，然后开始按照设定的周期定时执行任务
        myTimer.schedule(new Worker(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2014-08-12 23:11:00"),1000);
        myTimer.scheduleAtFixedRate(new Worker(), 5000, 1000);//5秒后执行 每一秒执行一次 如果该任务因为某些原因（例如垃圾收集）而延迟执行，那么接下来的任务会尽可能的快速执行，以赶上特定的时间点
        myTimer.scheduleAtFixedRate(new Worker(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2014-08-12 23:11:00"), 1000);//和上个类似
    }

    static class Worker extends TimerTask {

        @Override
        public void run() {
            System.out.println("我被执行了！"+"时间是："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }
    }

    /*private static class Work implements Runnable {
        @Override
        public void run() {
            System.out.println("count:" + mCount);
            mCount++;
            //if(mCount == 5) mService.shutdown();
        }
    }

    private static class Work2 implements Runnable {
        @Override
        public void run() {
            System.out.println("count2:" + mCount2);
            mCount2++;
        }
    }

    private static class Work3 implements Runnable {
        @Override
        public void run() {
            System.out.println("count3:" + mCount3);
            mCount3++;
        }
    }

    private static class Work4 implements Runnable {
        @Override
        public void run() {
            System.out.println("count4:" + mCount4);
            mCount4++;
        }
    }*/
}
