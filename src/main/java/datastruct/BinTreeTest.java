package datastruct;

import java.util.Arrays;

/*****************************************************************************
 * @className: BinTreeTest.java
 * @date : 2020-01-17 16:51
 * @author : 樊玺   (fanxi@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class BinTreeTest {







    public static void main(String[] args) throws Exception {

        System.out.println(path(7,3));
    }

    private static int fab(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }
        return fab(num-1) + fab(num-2);
    }

    private static int fab2(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }
        int a = 1, b = 1,c = 0;
        for (int i = 2; i < num ; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static int path(int m, int n) {
        //dp[m][n] = dp[m-1][n] + dp[m][n-1];
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        for (int i = 1; i< m; i++) {
            for (int j = 1; j < n; j++) {
                arr[j] = arr[j] + arr[j-1];
            }
        }

        return arr[n-1];
    }
}
class Node{
    public int value;
    public Node left;
    public Node right;
//    public Node parent;
    public Node(int e){
        this.value = e;
    }
    public Node(int e, Node l, Node r){
        this.value = e;
        this.left = l;
        this.right = r;
//        this.parent = p;
    }


}
