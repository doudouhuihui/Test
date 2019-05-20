package multithread;

import java.util.ArrayList;
import java.util.List;

/*****************************************************************************
 * @className: SynchronizedTest$
 * @date : 2019/5/9$ 11:50$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : []
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class SynchronizedTransferTest {
    //单例
    private final Allocator admin = Allocator.getInstance();
    private static final Object obj = new Object();
    private int balance;

    public SynchronizedTransferTest(int balance) {
        this.balance = balance;
    }


    /**
     * 串行化锁，可以实现，效率太慢
     *
     * @param b
     * @param amt
     */
    public void transfer(SynchronizedTransferTest b, int amt) {
        synchronized (SynchronizedTransferTest.class) {
            //或者synchronized (obj){
            if (this.balance >= amt) {
                this.balance -= amt;
                b.balance += amt;
            }
        }
    }

    /**
     * 细粒度锁
     *
     * @param b
     * @param amt
     */
    public void transfer2(SynchronizedTransferTest b, int amt) {
        while (!admin.apply(this, b)){
        }
        try {
            synchronized (this) {
                synchronized (b) {
                    if (this.balance >= amt) {
                        this.balance -= amt;
                        b.balance += amt;
                    }
                }
            }
        }finally {
            admin.free(this, b);
        }

    }

    public int getBalance() {
        return this.balance;
    }


    public static void main(String[] args) throws InterruptedException {

        //并发转帐问题
       // synTest();

        //死锁问题
        deadLockTest();

    }


    public static void synTest() throws InterruptedException {
        /*
         三个帐户，分别是ABC,1000，2000，3000元
         A向B转1000，B向C转1000，结果应该是0，2000，4000，可并不
         于是尝试在transfer方法上加锁，还是不行,因为在方法上加锁,锁的是对象this
         于是a.transfer锁的是a, b.transfer锁的是b，还是可以共同进入transfer，没有互斥作用
         其实只要找到一个共同的对象当作锁就可以了
         可以用synchronized(SynchronizedTest.class)来锁住，或者传入一个共同的对象，但是效率太慢，串行化了

         transfer2用的细粒度锁，先锁住当前，再锁住目标对象，好多了，A转B，C转D，两者可以同步进行
         */
        SynchronizedTransferTest a = new SynchronizedTransferTest(1000);
        SynchronizedTransferTest b = new SynchronizedTransferTest(2000);
        SynchronizedTransferTest c = new SynchronizedTransferTest(3000);
        Thread t1 = new Thread(() -> {
            //由于执行速度太快，转1000次1块的，让线程有切换的机会
            for (int i = 0; i < 1000; i++) {
                a.transfer(b, 1);
                //a.transfer2(b, 1);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                b.transfer(c, 1);
                //b.transfer2(c, 1);
            }
        });


        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(a.getBalance());
        System.out.println(b.getBalance());
        System.out.println(c.getBalance());
    }

    public static void deadLockTest() throws InterruptedException {
        SynchronizedTransferTest a = new SynchronizedTransferTest(1000);
        SynchronizedTransferTest b = new SynchronizedTransferTest(2000);
        /**
         * 有A,B两个帐户，一个1000，一个2000，A向B转1000，同时B向A转1500
         * 正常结果应该是A 1500， B 1500
         * 我们用细粒度锁方法试一下，结果死循环了，发生了死锁
         * 因为A等B，B也在等A
         */
        Thread t1 = new Thread(() -> {
            //由于执行速度太快，转1000次1块的，让线程有切换的机会
            for (int i = 0; i < 1000; i++) {
                a.transfer2(b, 1);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1500; i++) {
                b.transfer2(a, 1);
            }
        });


        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(a.getBalance());
        System.out.println(b.getBalance());
    }


}
class Allocator{
    private volatile static Allocator als;
    private Allocator(){}
    public static Allocator getInstance(){
        if(als == null){
            synchronized (Allocator.class){
                if(als == null){
                    als = new Allocator();
                }
            }
        }
        return als;
    }
    private List<Object> list = new ArrayList<>();

    synchronized boolean apply(Object a, Object b){
        if (list.contains(a) || list.contains(b)) {
            return false;
        }else{
            list.add(a);
            list.add(b);
        }
        return true;
    }

    synchronized void free(Object a, Object b){
        list.remove(a);
        list.remove(b);
    }
}
