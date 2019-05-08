package multithread;

import java.util.List;
import java.util.Vector;

/*****************************************************************************
 * @className: ThreadCommunicateTest$
 * @date : 2019/4/19$ 9:40$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [线程通信的方式]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class ThreadCommunicateTest {
    public static void main(String[] args) {
        //同步
        //syncTest();

        //轮询
        whileLoopTest();
    }


    public static void whileLoopTest() {
        final List list = new Vector();
        String str = "";
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (str) {
                    for (int i = 0; i < 10; i++) {
                        list.add(i);
                        System.out.println(Thread.currentThread().getName() + "插入一个元素" + i);

                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            int size;
            @Override
            public void run() {
                synchronized (str) {
                    while (true) {
                        System.out.println("size" + list.size());
                        System.out.println(list.size() >= 1);
                        if ((size = list.size()) >= 1) {
                            System.out.println("1" + Thread.currentThread().getName() + "获取集合大小" + size);
                        }
                        if (size == 10) {
                            System.out.println("2" + Thread.currentThread().getName() + "获取集合大小" + size);
                            break;
                        }
                    }
                }
            }
        });

        t1.start();
        t2.start();


    }


    public static void syncTest() {
        CommPOJO obj = new CommPOJO();
        //两个线程用同一个对象
        ThreadA threadA = new ThreadA(obj);
        ThreadB threadB = new ThreadB(obj, threadA);
        threadA.start();
        threadB.start();
    }


}

class ThreadA extends Thread {
    private CommPOJO obj;

    public ThreadA() {
    }

    public ThreadA(CommPOJO obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        obj.method();
    }
}

class ThreadB extends Thread {
    private CommPOJO obj;
    private ThreadA threadA;

    public ThreadB() {
    }

    public ThreadB(CommPOJO obj, ThreadA threadA) {
        this.obj = obj;
        this.threadA = threadA;
    }

    @Override
    public void run() {
        try {
            threadA.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        obj.method();
    }
}

class CommPOJO {
    public synchronized void method() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
    }
}

