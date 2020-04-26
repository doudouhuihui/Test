package multithread.changePrint;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*****************************************************************************
 * @className: ChangePrint2Test.java
 * @date : 2020-04-20 11:18
 * @author : 樊玺   (fanxi@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [LOCK condition实现]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class ChangePrint2Test {
    static int i = 1;
    static final ReentrantLock lock = new ReentrantLock();
    static final Condition con = lock.newCondition();
    public static void main(String[] args) {
        new Thread(()->{
            print();
        }).start();

        new Thread(()->{
            print2();
        }).start();
    }
    private  static void print(){
        while (i < 100){
            lock.lock();
            if ((i&1)== 1) {
                System.out.println(i);
                i++;
                con.signalAll();
            } else {
                try {
                    con.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();
        }

    }

    private  static void print2(){
        while (i < 100){
            lock.lock();
            if ((i&1)== 0) {
                System.out.println(i);
                i++;
                con.signalAll();
            } else {
                try {
                    con.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();
        }
    }
}
