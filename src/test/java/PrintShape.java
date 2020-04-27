import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

/*****************************************************************************
 * @className: PrintShape$
 * @date : 2019/8/7$ 11:04$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class PrintShape {
    static int i = 0;
    public static void main(String[] args) {
        ThreadLocal<Long> threadLocal = new ThreadLocal<>();
        threadLocal.set(100l);
        System.out.println(threadLocal.get());
        for (int i = 1; i <= 9; i++) {
            if (i <= 5) {
                for (int k = 5; k > i; k--) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= (2 * i - 1); j++) {
                    System.out.print("*");
                }
                //continue;
            } else {
                for (int k = 5; k < i; k++) {
                    System.out.print(" ");
                }
                for (int j = 9; j >= 2 * (i - 5) + 1; j--) {
                    System.out.print("*");
                }
            }

            System.out.println();
        }
    }
}
