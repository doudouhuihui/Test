package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*****************************************************************************
 * @className: Collections.ArrayListTest$
 * @date : 2019/4/15$ 15:56$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        //test03();
        String s = "abcabc3321234bb";

       // System.out.println(lengthOfLongestSubstring(s));

        rotate(new int[]{1,2,3},1);

    }

    public static void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        System.arraycopy(nums, nums.length-k, temp, 0, k);
        System.arraycopy(nums, 0, temp, nums.length-1-k, nums.length-k);
        System.arraycopy(temp, 0, nums, 0, temp.length);
        System.out.println(Arrays.toString(nums));
    }
    public static int lengthOfLongestSubstring(String s) {
        int result ;
        List list = new ArrayList<Character>();
        List list1 = new ArrayList<Integer>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (list.contains(ch[i])) {
                list1.add(list.size());
                i = list1.size();
                list.clear();
            }else{
                list.add(ch[i]);
            }
        }
        Collections.sort(list1);
        result = (Integer)list1.get(-1);
        return result;
    }

    public static void test03() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        System.out.println(list);//分两次

        list.add(2, "昊");
        System.out.println(list);//分两行

        list.remove(2);
        System.out.println(list);//分两行

        list.set(2, "浩");
        System.out.println(list);//分两行
         System.out.println(list.set(2, "浩"));

        System.out.println(list.get(2));//直接一行
    }
}
