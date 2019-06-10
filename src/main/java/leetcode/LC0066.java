package leetcode;

import java.util.Arrays;

/*****************************************************************************
 * @className: LC0066$
 * @date : 2019/5/21$ 14:46$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class LC0066 {

    public static void main(String[] args) {
        int[] arr = plusOne(new int[]{0,9,0});
        System.out.println(Arrays.toString(arr));
    }
    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        if(length>1&&digits[0]==0){
            return new int[]{0};
        }
        int temp = 0;
        if(digits[0]==9){
            for(int i =1; i<length;i++){
                if(digits[i]==9){
                    temp+=1;
                }
            }
            if(temp+1==length){
                int[] arr = new int[length+1];
                arr[0] = 1;
                return arr;
            }
        }

        digits[length-1] += 1;
        for(int i = length-1;i>=0;i--){
            if(digits[i]>9){
                digits[i]=0;
                digits[i-1]+=1;
            }
        }
        return digits;

    }
}
