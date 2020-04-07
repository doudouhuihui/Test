package multithread;

import java.util.HashMap;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

/*****************************************************************************
 * @className: AddThread.java
 * @date : 2020-01-15 10:02
 * @author : 樊玺   (fanxi@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class AddThread {
    static long sum = 0;
    static long sum1;
    static long sum2;
    static long sum3;
    static long sum4;

    public static void main(String[] args) throws InterruptedException {

        singleThread();
        mulitThread();
    }

    private static void singleThread() {
        long sum = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i <= 10_0000_0000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(sum + "," + (end - start));
    }



    private static void mulitThread() throws InterruptedException {
        long start = System.currentTimeMillis();
        int count = 4;
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        ExecutorService resThread = Executors.newSingleThreadExecutor();
        //CountDownLatch countDownLatch = new CountDownLatch(count);
        CyclicBarrier barrier = new CyclicBarrier(count, ()->{

        });

        executorService.execute(() -> {
            add1();
//            countDownLatch.countDown();
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            add2();
            //            countDownLatch.countDown();
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            add3();
            //            countDownLatch.countDown();
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            add4();
            //            countDownLatch.countDown();
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
//        countDownLatch.await();
//        sum = sum1 + sum2 + sum3 + sum4;
//        long end = System.currentTimeMillis();
//        System.out.println(sum + "," + (end - start));


    }


    public static void add1() {
        for (int i = 0; i < 2_5000_0000; i++) {
            sum1 += i;
        }
    }

    public static void add2() {
        for (int i = 2_5000_0000; i < 5_0000_0000; i++) {
            sum2 += i;
        }
    }

    public static void add3() {
        for (int i = 5_0000_0000; i < 7_5000_0000; i++) {
            sum3 += i;
        }
    }

    public static void add4() {
        for (int i = 7_5000_0000; i <= 10_0000_0000; i++) {
            sum4 += i;
        }
    }
}
