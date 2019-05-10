package multithread;

/*****************************************************************************
 * @className: DeadLockTest$
 * @date : 2019/5/10$ 14:12$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class DeadLockTest {
    public static void main(String[] args) throws InterruptedException {
        String s1 = "123";
        String s2 = "456";

        Thread t1 = new Thread(()->{
            synchronized (s1){
                try {
                    //获取s1时等s2被锁住， sleep不释放s1锁
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (s2){
                    System.out.println(111);
                }
            }
        });
        Thread t2 = new Thread(()->{
            synchronized (s2){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (s1){
                    System.out.println(222);
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
