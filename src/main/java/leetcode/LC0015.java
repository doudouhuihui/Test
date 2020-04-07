package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*****************************************************************************
 * @className: LC0015.java
 * @date : 2020-03-19 14:27
 * @author : 樊玺   (fanxi@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
[-1, 0, 1],
[-1, -1, 2]
]
 * 2
 ******************************************************************************/
public class LC0015 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList();
        for (int i = 0; i < nums.length - 2; i++ ) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> tempList = new ArrayList();
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(nums[k]);
                        Collections.sort(tempList);
                        resList.add(tempList);
                    }
                }
            }
        }
        String temp ;
        String temp2;
        List<List<Integer>> tempList = new ArrayList<>();
        tempList.addAll(resList);
        for(int i = 0; i < tempList.size(); i++){
            for (int j = i + 1; j < tempList.size(); j++) {
                temp = "" + tempList.get(i).get(0) + tempList.get(i).get(1) + tempList.get(i).get(2);
                temp2 = "" + tempList.get(j).get(0) + tempList.get(j).get(1) + tempList.get(j).get(2);
                if (temp.equals(temp2)) {
                    resList.set(i, null);
                }
            }
        }
        int length = resList.size();
        for (int i = 0; i < length; i++) {
            resList.remove(null);
        }





        return resList;
    }

    public static void main(String[] args) {
//        int[] arr = {-1, 0, 1, 2, -1, -4};
      //  int[] arr = {0,0,0,0};
       // List list = threeSum(arr);
      //  System.out.println(list);
        int[] arr = {1,2,3,4,5,6,7};

        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n - 1 ; i++ ) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == 7){
                    System.out.println(arr[i] + "," + arr[j]);
                }
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n ; i++) {
            map.put(arr[i], 7 - arr[i]);
        }

        for (int i = 0; i < n ; i++ ) {

        }
        System.out.println(count);
    }

}
