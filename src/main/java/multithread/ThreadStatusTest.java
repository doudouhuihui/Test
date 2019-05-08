package multithread;

/*****************************************************************************
 * @className: ThreadStatusTest$
 * @date : 2019/4/17$ 17:14$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [线程的五种状态]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class ThreadStatusTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //3.当执行该方法时，为运行状态
                System.out.println(Thread.currentThread().getState());

                //4.此时为阻塞状态
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        //1.此时只是创建普通线程对象，和一般对象没什么区别，状态为新建
        System.out.println(t.getState());



        //2.当调用start方法，状态由新建转换为就绪，不一定执行run方法
        t.start();

        System.out.println("main thread");
        //让main线程等t线程执行完
        t.join();

        //5.线程已经死亡
        System.out.println(t.getState());

        //线程死亡不能复活，会抛异常
        //t.start();
    }

}

