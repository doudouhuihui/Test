package leetcode;

/*****************************************************************************
 * @className: LC0680$
 * @date : 2019/6/25$ 15:00$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
示例 1:
输入: "aba"
输出: True
示例 2:
输入: "abca"
输出: True
解释: 你可以删除c字符。
注意:
字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。

 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class LC0680 {
    public static void main(String[] args) {
        System.out.println(test("125231"));
    }
    private static boolean test(String s){
        int low = 0;
        int high = s.length()-1;
        while(low<high){
            if(s.charAt(low)!=s.charAt(high)){
                //如果不相等，跳一个再走一遍试试
                return isTest(s, low, high-1)||isTest(s, low+1, high);
            }
            low++;
            high--;
        }
        return true;
    }

    /**
     * 判断回文数
     * @param s
     * @param i
     * @param j
     * @return
     */
    private static boolean isTest(String s, int i , int j){
        while (i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
