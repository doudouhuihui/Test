package multithread;

import java.util.List;
import java.util.Vector;

/*****************************************************************************
 * @className: Main$
 * @date : 2019/4/17$ 17:55$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class Main {
    public static void main(String[] args) throws InterruptedException {
        final Thread t1, t2;
        final Object obj = new Object();
        final boolean[] flag = new boolean[1];
        t1 = new Thread(() -> {
            synchronized (obj) {
                int i = 1;
                while(i < 100) {
                    if (!flag[0]) {
                            System.out.println(i);
                            i = i + 2;
                            flag[0] = true;
                            obj.notifyAll();
                            try {
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }


                    }
                }
                obj.notifyAll();


            }

        });
        t2 = new Thread(() -> {
            synchronized (obj) {
                int i = 2;
                while (i < 100) {
                    if (flag[0]) {
                            System.out.println(i);
                            i = i + 2;
                            flag[0] = false;
                            obj.notifyAll();
                            try {
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                    }else{
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                obj.notifyAll();
            }
    });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

}


}
