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
   volatile int result;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();
        for (int i = 0; i < 8; i++) {
            new Thread(()->{
                int x = 0;
                while(volatileTest.getResult() < 100){
                    x++;
                }
                System.out.println(x);
            }).start();
        }
        Thread.sleep(100);
        volatileTest.setResult(200);
    }
}
