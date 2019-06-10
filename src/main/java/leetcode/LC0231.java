package leetcode;

/*****************************************************************************
 * @className: LC0231$
 * @date : 2019/5/21$ 16:59$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [给定一个整数，编写一个函数来判断它是否是 2 的幂次方。]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class LC0231 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(4));
        System.out.println(isPowerOfTwo2(4));
    }
    public static boolean isPowerOfTwo(int n) {
        if(n==1)return true;
        if(n<=0)return false;
        int k = n - 1;
        k |= k>>1;
        k |= k>>2;
        k |= k>>4;
        k |= k>>8;
        k |= k>>16;
        return (k+1)==n;
    }
    public static boolean isPowerOfTwo2(int n){
        return n>0&&(n&(n-1))==0;
    }
}

