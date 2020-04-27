package other;

/*****************************************************************************
 * @className: TryCatchFiinallyTest.java
 * @date : 2020-04-26 19:42
 * @author : 樊玺   (fanxi@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class TryCatchFiinallyTest {
    public static void main(String[] args) {
        try{
            System.out.println("try block");
//            System.exit(0);
            Thread.interrupted();
        }catch (Exception e){
            System.out.println("catch block");
        }finally {
            System.out.println("finally block");
        }
    }
}
