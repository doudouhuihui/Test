package leetcode;

/*****************************************************************************
 * @className: LC0665.java
 * @date : 2020-04-10 16:50
 * @author : 樊玺   (fanxi@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class LC0665 {
    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{1,5,4,6,7,10,8,9}));
    }

    public static boolean checkPossibility(int[] nums) {
        if (nums.length>2) {
            int count = 0;
            for (int i = 1; i < nums.length - 1; i++) {
                if (nums[i] > nums[i+1] && nums[i - 1] > nums[i+1]) {
                    count++;
                }


            }
            if (count >= 1) { return false;}
            return true;

        }
        return true;
    }


}
