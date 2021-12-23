package leetcode;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * 提示：
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4

 */
public class LC0016 {
    private LC0016(){}
    public static void main(String[] args) {
        LC0016 lc0016 = new LC0016();
        int[] nums = {1,2,5,10,11};
        int target = 12;
        System.out.println(lc0016.threeSumClosest(nums, target));
    }


    /**
     * 正常想到暴力法，3层for加起来和target比较，但是肯定会卡死，每个for最大1000，不可取
     *
     *
     */
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }



        return 0;
    }
}
