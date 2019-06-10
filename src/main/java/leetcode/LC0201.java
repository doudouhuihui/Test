package leetcode;

/*****************************************************************************
 * @className: LC0201$
 * @date : 2019/5/22$ 10:59$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class LC0201 {
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(2147483646, 2147483647));
    }
    public static int rangeBitwiseAnd(int m, int n) {
        if(m==0){return 0;}
        if(m==n){return m;}
        int temp = n;
        n|=n>>1;
        n|=n>>2;
        n|=n>>4;
        n|=n>>8;
        n|=n>>16;
        n = (n>>1)+1;
        if(n>=m){
            return n&m;
        }
        int result = m;
        for(int i = m; i<=temp&&i>0;i++){
            result &= i;
        }
        return result;
    }
    public int rangeBitwiseAnd2(int m, int n) {
        int cnt = 0;
        //思路：每一位不是0就是1
        //首先判断m,n是否相等，如果相等，直接返回
        //如果不相等，同时向右移一位，同时记录次数，直到相等
        //移的过程中，如果m已经为0了，就不需要移了，直接就是0
        while(m!=n) {
            if(m==0)
                return 0;
            m >>= 1;
            n >>= 1;
            cnt++;
        }
        return m<<cnt;
    }
}
