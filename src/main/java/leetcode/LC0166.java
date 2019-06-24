package leetcode;

import java.util.HashMap;
import java.util.Map;

/*****************************************************************************
 * @className: LC0166$
 * @date : 2019/6/24$ 15:01$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class LC0166 {

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1,333));
        //System.out.println(fractionToDecimal(2147483647,370000));
    }
    public static String fractionToDecimal(int numerator, int denominator) {
         /* 分母为零，直接返回零 **/
        if (numerator==0)
            return "0";

        /* 异或取符号位, 结果res使用StringBuilder保存，提高性能 **/
        boolean negetive= (numerator^ denominator)< 0;
        StringBuilder res= new StringBuilder();

        /* 计算整数部分，若取模无余数，则无小数部分，直接返回结果 **/
        long numerator_p= Math.abs((long)numerator);
        long denominator_p= Math.abs((long)denominator);
        res.append(numerator_p/ denominator_p);
        if (numerator_p% denominator_p ==0)
            return (negetive)? "-"+ res.toString() : res.toString();

        /* 小数部分处理，取模余数*10，和小数位置index一起寸入map中
        *  余数*10除以denominator_p即算出小数部分当前位置的数字
        *  若余数*10的值重复，则答案的小数值也会重复，
        *  取得第一次重复余数出现的index位置，插入括号，输出答案
        **/
        res.append(".");
        int index= res.length();
        Map<Long, Integer> circle_num= new HashMap<>();
        long remain= numerator_p% denominator;

        while (remain!=0) {
            remain*= 10;
            if (circle_num.containsKey(remain)) {
                index= circle_num.get(remain);
                res.insert(index, "(").append(")");
                break;
            }
            circle_num.put(remain, index);
            res.append(remain/ denominator_p);
            remain%= denominator_p;
            index++;
        }

        return (negetive)? "-"+ res.toString() : res.toString();
    }
}
