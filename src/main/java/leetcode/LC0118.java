package leetcode;

import java.util.ArrayList;
import java.util.List;

/*****************************************************************************
 * @className: LC0118.java
 * @date : 2020-03-27 14:48
 * @author : 樊玺   (fanxi@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class LC0118 {

    public static void main(String[] args) {
        System.out.println(generate(6));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>(i+1);
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
                }
            }

            list.add(temp);
        }


        return list;
    }
}
