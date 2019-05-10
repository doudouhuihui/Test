package multithread;

/*****************************************************************************
 * @className: VolatileTest$
 * @date : 2019/5/9$ 10:55$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [参考ThreadProblem1测试类]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class VolatileTest {
    private int x;
    private int y;
    private int z;
    public void set(){
        z = 3;
        x = 1;
        y = 2;
    }
    public static void main(String[] args) throws InterruptedException {
        VolatileTest test = new VolatileTest();
        Thread t1 = new Thread(()->{
            test.set();
        });
        Thread t2 = new Thread(()->{
            while(true) {
                if (test.z == 3) {
                    System.out.println("x:" + test.x);
                    System.out.println("y:" + test.y);
                    break;
                }
            }
        });
        Thread t3 = new Thread(()->{
            while(true) {
                if (test.z == 3) {
                    System.out.println("x=" + test.x);
                    System.out.println("y=" + test.y);
                    break;
                }
            }
        });

        t2.start();
        t3.start();
        t1.start();
        t1.join();
        t2.join();
        t3.join();
    }
}
