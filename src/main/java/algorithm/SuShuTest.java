package algorithm;

/*****************************************************************************
 * @className: SuShuTest.java
 * @date : 2020-03-19 09:54
 * @author : 樊玺   (fanxi@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class SuShuTest {
    public static void main(String[] args) {
        for(int i = 100;i<=200;i++){
            boolean flag = false;
            for(int j =2;j<=Math.sqrt(i);j++){
                if(i%j==0){
                    flag = false;
                    break;
                }else{
                    flag = true;
                }
            }
            if(flag){
                System.out.print(i+" ");
            }
        }

    }
}
