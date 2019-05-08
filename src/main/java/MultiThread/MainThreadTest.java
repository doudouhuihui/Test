package MultiThread;

/*****************************************************************************
 * @className: MainThreadTest$
 * @date : 2019/4/18$ 9:31$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [主线程和子线程之间关系]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class MainThreadTest {
    public static void main(String[] args) {
        //主线程不能设置为守护线程
        //System.out.println(Thread.currentThread().isAlive());
        //Thread.currentThread().setDaemon(true);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我开始运行了");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我睡醒了");
            }
        });
        //设置守护进程后会随着主线程死亡
        //thread.setDaemon(true);
        thread.start();
        System.out.println("主线程走完了");


    }


}
