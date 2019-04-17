package MultiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*****************************************************************************
 * @className: CreateThreadTest$
 * @date : 2019/4/17$ 14:54$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [创建线程的三种方式]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class CreateThreadTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //继承Thread类
        new DemoThread1().start();
        System.out.println(Thread.currentThread().getName());
        //实现Runnable接口
        new Thread(new DemoThread2()).start();

        FutureTask ft = new FutureTask(new DemoThread3());
        new Thread(ft).start();
        System.out.println(ft.get());
    }
}

class DemoThread1 extends Thread {

    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println(this.currentThread().getName());
            System.out.println("Extends Thread class to create!");
        }
    }

}
class DemoThread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
            System.out.println("implements Runable interface to create!");
        }
    }
}

class DemoThread3 implements Callable {

    @Override
    public String call() throws Exception {
        return "Implements Callable interface to create!";
    }
}
