package MultiThread;

/*****************************************************************************
 * @className: ThreadStatusTest$
 * @date : 2019/4/17$ 17:14$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class ThreadStatusTest {
   static Thread thread;
    public static void main(String[] args) {
        Runnable runnable = new ThreadStatus();
        thread = new Thread(runnable);
        //新建状态
        System.out.println(thread.getName()+thread.getState());
        thread.start();
        System.out.println(thread.getName()+thread.getState());
    }
}
class ThreadStatus implements Runnable {

    @Override
    public void run() {
        Runnable runnable = new ThreadStatus2();
        Thread thread = new Thread(runnable);
        System.out.println(thread.getName()+thread.getState());
        thread.start();
        System.out.println(thread.getName()+thread.getState());

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getName()+thread.getState());

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getName()+thread.getState());
    }
}
class ThreadStatus2 implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ThreadStatusTest.thread.getName()+ThreadStatusTest.thread.getState());

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
