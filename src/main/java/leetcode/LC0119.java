package leetcode;

import java.util.List;

/*****************************************************************************
 * @className: LC0119.java
 * @date : 2020-03-27 15:03
 * @author : 樊玺   (fanxi@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class LC0119 {
    public static void main(String[] args) {
        System.out.println(getRow(3));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = LC0118.generate(rowIndex + 1);
        return list.get(rowIndex);


//        return null;
    }
}
