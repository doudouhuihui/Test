package algorithm;

import java.util.Arrays;

/*****************************************************************************
 * @className: QuickSortTest.java
 * @date : 2020-03-18 11:35
 * @author : 樊玺   (fanxi@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class QuickSortTest {

    //https://blog.csdn.net/nrsc272420199/article/details/82587933

    public static void main(String[] args) {
        int[] arr = {5,8,7,4,6,6,4,4,5,9,8,7,1,3};
        sort(arr, 0, arr.length -1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int middle = getMiddle(arr, low, high);
        sort(arr, low, middle-1);
        sort(arr, middle + 1, high);
    }

    private static int getMiddle(int[] arr, int low, int high) {
        int temp = arr[low];
        while(low < high){
            while (low < high && arr[high] >= temp) {
                high--;
            }
            arr[low] = arr[high];
            while(low < high && arr[low] <= temp) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }
}
