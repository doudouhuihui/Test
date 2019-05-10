package multithread;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*****************************************************************************
 * @className: ThreadProblem1$
 * @date : 2019/5/8$ 14:55$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [可见性问题：两个线程同时增加一万，结果会是两万吗？]
 * @desc :[结果是10000到20000之间，因为缓存和线程切换的原因，可能两个线程同时读取，同时自加，同时覆盖，只加了1次，实际加了两次，所以结果会小于两万
 * ，如果把count用volatile修饰，可以解决缓存导致的可见性问题，但是count++不是原子性操作，volatile不能解决原子性问题，所以要使用synchronized块]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class ThreadProblem1 {
    private int count = 0;

    public int getCount() {
        return count;
    }
    public synchronized void add10K() {
       for (int i = 0; i < 10000; i++) {
           count++;
       }
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadProblem1 test = new ThreadProblem1();
        Thread t1 = new Thread(() -> {
            test.add10K();

        });
        Thread t2 = new Thread(() -> {
            test.add10K();
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
}
