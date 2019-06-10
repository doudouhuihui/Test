package leetcode;

/*****************************************************************************
 * @className: LC0069$
 * @date : 2019/5/21$ 15:20$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:

输入: 4
输出: 2
示例 2:

输入: 8
输出: 2
说明: 8 的平方根是 2.82842...,
由于返回类型是整数，小数部分将被舍去。]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class LC0069 {
    public static void main(String[] args) {
        System.out.println(mySqrt(9));
    }
    public static int mySqrt(int x) {
        if(x<=1){
            return x;
        }
        int temp = x >>> 1;
        for (int i = 1; i<= temp+1; i++){
            if(i*i<=x&&(i*i)/i==i){
                continue;
            }else{
                return i-1;
            }
        }
        return 1;
    }
}
