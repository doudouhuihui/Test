package leetcode;

/**
 * 给定?n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * ?
 *
 * 示例 1：
 *
 *
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0041 {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{4,2,0,3,2,5}));
    }

    /**
     * 思路：遍历，如果下一个height比前一个小，temp+1,继续比较下个。。。如果大于或等于且temp>0 , s= temp* 第一个高度
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int tempLen = 0;
        int compVal = 0;
        int result = 0;
        if (height == null || height.length == 0) {
            return result;
        }
        for (int i = 0; i < height.length; i++) {
            if (height[i] > 0 && compVal == 0) {
                compVal = height[i];
            }
            System.out.println("height" + (i) + "作为比较值"+compVal);
            for (int j = (i+1) ; j < height.length ; ) {
                if (compVal > height[j]) {
                    tempLen++;
                    if(tempLen == height.length - (i+1)){  //全部是比它小的，没意义
                        tempLen = 0;
                        compVal = 0;
                    }
                    continue;
                } else if (j == (i+1)) {
                    compVal = 0;
                    break;
                }

                 if (tempLen > 0 && compVal > 0){
                    System.out.println("tempLen="+tempLen+",compVal="+compVal);
                    result += tempLen ;

                    System.out.println(result);
                    tempLen = 0;
                    compVal --;

                    if (compVal <= 0) {
                        j++;
                        continue;
                    }
                        break;


                }
            }
        }

        return result;
    }
}












