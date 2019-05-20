package multithread;

/*****************************************************************************
 * @className: PrintChangeTest$
 * @date : 2019/5/10$ 14:03$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [两个线程，一个输出奇数，一个输出偶数，要求交替执行]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class PrintChangeTest {
    public static void main(String[] args) throws InterruptedException {
        final Print print = new Print();
        Thread t1 = new Thread(()->{
            synchronized (print){
                while(print.count < 100){
                    if (!print.flag) {
                        print.count++;
                        print.flag = true;
                        System.out.println(Thread.currentThread().getName() + "---" + print.count);
                        print.notifyAll();
                        try {
                            print.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else{
                        try {
                            print.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                print.notifyAll();
            }
        });
        Thread t2 = new Thread(()->{
            synchronized (print){
                while(print.count<100){
                    if(print.flag){
                        print.count++;
                        print.flag = false;
                        System.out.println(Thread.currentThread().getName() + "---" + print.count);
                        print.notifyAll();
                        try {
                            print.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else{
                        try {
                            print.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                print.notifyAll();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
}
class Print{
    public volatile static int count;
    public volatile static boolean flag;
}
