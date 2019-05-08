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
    public static void main(String[] args) {
        final List list = new Vector<>();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100;i++) {
                   list.add(i);
                    try {
                        Thread.sleep(146);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            int a ;
            @Override
            public void run() {
                while (true) {
                        System.out.print("I");
                        if (list.size() >= 100) {
                            break;
                        }

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                }
            }
        });

        t1.start();
        t2.start();
    }
}
