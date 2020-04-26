package multithread;

/*****************************************************************************
 * @className: ThreadLocalTest.java
 * @date : 2020-04-17 14:59
 * @author : 樊玺   (fanxi@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public final class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal<String> stringLocal = new ThreadLocal<>();
        stringLocal.set("123");
        System.out.println(stringLocal.get());
        new Thread(()->{
            System.out.println(stringLocal.get());
        }).start();
    }
}
