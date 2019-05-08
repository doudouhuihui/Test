package Other;

import java.math.BigDecimal;

/*****************************************************************************
 * @className: PITest$
 * @date : 2019/4/22$ 15:13$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class PITest {
    public static void main(String[] args) {
       // System.out.println(cal(100));
        //System.out.println(cal1(50000000));
        //System.out.println(Math.PI);
        print1();
    }

    public static double cal(int count) {
        double result = 1.00d;
        int temp = 0;
        while (temp < count) {
            temp++;
            result = result + Math.pow(-1, temp) * (1.0d / (2d * temp + 1d));
        }
        return result * 4;
    }

    public static double cal1(int count) {
        BigDecimal result = new BigDecimal(1.00);
        int temp = 0;
        BigDecimal flag;
        BigDecimal serial;
        BigDecimal fenshu;
        BigDecimal sum;
        while (temp < count) {
            temp++;
            flag = new BigDecimal(-1).pow(temp);
            fenshu = new BigDecimal(new BigDecimal(2).multiply(new BigDecimal(temp)).add(new BigDecimal(1)).intValue());
            serial = new BigDecimal(1.00).divide(fenshu, 16, BigDecimal.ROUND_HALF_EVEN);
            sum = flag.multiply(serial);
            result = result.add(sum);
        }
        return result.doubleValue() * 4;
    }

    public static void print1(){
        for (int i = 0; i < 5; i++) {  //行数

            for (int k = 0; k < i; k++) { //空格
                System.out.print(" ");
            }
            for (int j = 5; j > i; j--) { //星号
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
