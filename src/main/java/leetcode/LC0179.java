package leetcode;

/*****************************************************************************
 * @className: LC0179$
 * @date : 2019/6/20$ 17:54$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
示例 1:
输入: [10,2]
输出: 210
示例 2:
输入: [3,30,34,5,9]
输出: 9534330
说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class LC0179 {

    public static void main(String[] args) {

        int[] arr = {3,30,34,5,9};
        System.out.println(largestNumber(arr));
    }

    /**
     * 思路:
     * 1.把数组内容当作字符串拼起来
     * 2.由大到小排序输出
     * @param nums
     * @return
     */
    public static String largestNumber(int[] nums) {
        if(nums.length==0){
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }

        char[] chs = sb.toString().toCharArray();
        for (int i = 0; i< chs.length; i++) {
            for (int j = 0; j< chs.length-1-i; j++){
                if(chs[j]<chs[j+1]){
                    char temp = chs[j] ;
                    chs[j] = chs[j+1];
                    chs[j+1] = temp;
                }
            }
        }
        if(chs[0]=='0'){
            return "0";
        }
        return new String(chs);
    }
}
