package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/*****************************************************************************
 * @className: LC0977$
 * @date : 2019/8/5$ 14:19$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
示例 1：
输入：[-4,-1,0,3,10]
输出：[0,1,9,16,100]
示例 2：
输入：[-7,-3,2,3,11]
输出：[4,9,9,49,121]
]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class LC0977 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(sortedSquares2(new int[]{-4, -1, 0, 3, 10})));
    }


    /**
     * [普通做法-先平方再排序]
     *
     * @param A
     * @return
     * @Author: 陈伟振 (chenweizhen@vvise.com)
     * @Date: 2019/8/5 15:04
     */
    public static int[] sortedSquares(int[] A) {
        int length = A.length;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = A[i] * A[i];
        }
        Arrays.sort(res);
        return res;
    }

    /**
     * [双指针]
     * 因为原数组是有序的，找到0为分界点，双指针向两边移动，判断大小
     *
     * @param arr arr
     * @return int
     * @Author: 陈伟振 (chenweizhen@vvise.com)
     * @Date: 2019/8/5 15:05
     */
    public static int[] sortedSquares2(int arr[]) {
        int N = arr.length;
        int j = 0;
        while (j < N && arr[j] < 0) {
            j++;
        }
        int i = j - 1;
        System.out.println(i);
        System.out.println(j);
        int[] res = new int[N];
        int t = 0;
        while (i >= 0 && j < N) {
            if (arr[i] * arr[i] > arr[j] * arr[j]) {
                res[t++] = arr[j] * arr[j];
                j++;
            } else {
                res[t++] = arr[i] * arr[i];
                i--;
            }
        }
        //j走完了i还没
        while (i >= 0) {
            res[t++] = arr[i] * arr[i];
            i--;
        }
        //i走完了j还没
        while (j < N) {
            res[t++] = arr[j] * arr[j];
            j++;
        }
        return res;
    }
}
