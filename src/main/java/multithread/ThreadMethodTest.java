package multithread;

/*****************************************************************************
 * @className: ThreadMethodTest$
 * @date : 2019/4/18$ 15:30$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [控制线程的几个常用方法]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class ThreadMethodTest {
    public static void main(String[] args) throws InterruptedException {
        //join测试
        //joinTest();

        //守护线程
        //daemonTest();

        //线程睡眠
        //sleepTest();

        //线程让步
        yieldTest();

    }

    /**
     * [join方法:让一个线程等待另一个线程完成]
     * @Author: 陈伟振 (chenweizhen@vvise.com)
     * @Date: 2019/4/18 15:34
     */
    public static void joinTest() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("child thread");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        //main线程等t执行完才能继续
        t.join();

        System.out.println("main thread");
    }

    /**
     * [守护线程测试]
     * @Author: 陈伟振 (chenweizhen@vvise.com)
     * @Date: 2019/4/18 16:11
     */
    public static void daemonTest() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I am child thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("goodbye!");
            }
        });
        t.setDaemon(true);
        t.start();
        System.out.println("I am main thread!");
    }

    /**
     * [线程睡眠测试]
     * @Author: 陈伟振 (chenweizhen@vvise.com)
     * @Date: 2019/4/18 17:23
     */
    public static void sleepTest() {
        System.out.println("我要开始睡了，1秒后醒来。。。");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我睡醒啦！");
    }

    /**
     * [线程让步]
     * @Author: 陈伟振 (chenweizhen@vvise.com)
     * @Date: 2019/4/18 17:33
     */
    public static void yieldTest(){
        Thread t1  = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "," + i);
                    if (i == 3) {
                        Thread.yield();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + i);
                }
            }
        });
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}
