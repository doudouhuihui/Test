package leetcode;

import java.util.Arrays;

/*****************************************************************************
 * @className: LC0088.java
 * @date : 2020-03-27 11:36
 * @author : 樊玺   (fanxi@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。

 

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 

示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class LC0088 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

            int temp = nums1.length;
            System.arraycopy(nums2, 0, nums1, m, n);
            nums1 = Arrays.copyOf(nums1, m+n);
            Arrays.sort(nums1);
            nums1 = Arrays.copyOf(nums1, temp);

        System.out.println(Arrays.toString(nums1));


    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};
        merge(arr1, 3, arr2, 3);
        System.out.println();
    }
}
