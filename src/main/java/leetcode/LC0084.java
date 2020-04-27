package leetcode;

/*****************************************************************************
 * @className: LC0084.java
 * @date : 2020-03-27 15:50
 * @author : 樊玺   (fanxi@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class LC0084 {

    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(arr));
    }

    /**
     * 思路：两个指针，计算每个元素的前后是否大于等于它，如果是，继续往前/后，
     * 直到两端都小于它，此时的面积，和上一次最大面积比较，保存最大的
     * @param heights
     * @return int
     */
    public static int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int count = 1;
            int a = i - 1, b = i + 1;
            while(a >= 0 && heights[a] >= heights[i]){
                a--;
                count++;
            }
            while (b <= heights.length - 1 && heights[b] >= heights[i]){
                b++;
                count++;
            }
            max = Math.max(max, count * heights[i]);

        }

        return max;
    }


}
