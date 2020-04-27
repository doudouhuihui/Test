package multithread.changePrint;

/*****************************************************************************
 * @className: ChangePrint3Test.java
 * @date : 2020-04-20 11:25
 * @author : 樊玺   (fanxi@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [volatile 实现]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class ChangePrint3Test {
    static volatile int i = 1;
    public static void main(String[] args) {

        new Thread(()->{
            print();
        }).start();
        new Thread(()->{
            print2();
        }).start();
    }
    private static void print(){
        while(i<100){
                if ((i&1)==1){
                    System.out.println("线程1："+i);
                    i++;
                }
        }
    }
    private static void print2(){
        while(i<100){
                if ((i&1)==0){
                    System.out.println("线程2："+i);
                    i++;
                }
        }
    }
}
