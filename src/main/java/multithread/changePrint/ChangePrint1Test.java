package multithread.changePrint;

/*****************************************************************************
 * @className: ChangePrint1Test.java
 * @date : 2020-04-20 10:50
 * @author : 樊玺   (fanxi@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [synchroized wait notifyall实现]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class ChangePrint1Test {
    static volatile int i = 1;
    static final Object lock = new Object();
    public static void main(String[] args) {

        new Thread(()->{
            print();
        }).start();

        new Thread(()->{
           print2();
        }).start();
    }

    private  static void print(){
        while (i < 100) {
            synchronized (lock) {
                if ((i&1)==1) {
                    System.out.println(i);
                    i++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    private  static void print2(){
        while (i < 100) {
            synchronized (lock) {
                if ((i&1)==0) {
                    System.out.println(i);
                    i++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }


}
