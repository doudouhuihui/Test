package multithread;

/*****************************************************************************
 * @className: ThreadSingleTonTest$
 * @date : 2019/5/8$ 15:34$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [由单例模式引发的问题,双重检查的懒汉式单例模式，看起来好像没问题，
 * 但是第一个线程new ThreadSingleTonTest的时候因为重排序，可能分配地址后还没有初始化对象就返回，
 * 返回为null的实例，造成空指针异常。解决办法为用volatile修饰，或者使用静态内部类创建。
 * ]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class ThreadSingleTonTest {
    private volatile static ThreadSingleTonTest instance;

    private ThreadSingleTonTest() {
    }

    private static ThreadSingleTonTest getInstance() {
        if (instance == null) {
            synchronized (ThreadSingleTonTest.class) {
                if (instance == null) {
                    instance = new ThreadSingleTonTest();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                System.out.println(ThreadSingleTonTest.getInstance().hashCode());
            }).start();
        }



    }
}
