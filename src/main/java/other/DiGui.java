package other;

/*****************************************************************************
 * @className: DiGui$
 * @date : 2019/5/14$ 10:10$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class DiGui {
    public static void main(String[] args) {
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));


        System.out.println(fib2(1));
        System.out.println(fib2(2));
        System.out.println(fib2(3));
        System.out.println(fib2(4));
        System.out.println(fib2(5));

        System.out.println("-----------------------");
        System.out.println(arrSum(new int[]{1,2,3,4,5}));
        System.out.println(hanoi(25));
    }

    public static long hanoi(int n){
        if(n==1)return 1;
        if(n==2)return 3;

        return 1 + hanoi(n-1)*2;
    }

    public static int fib(int n){
        if(n<=2){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    public static int fib2(int n){
        if(n<=2){
            return 1;
        }
        int x = 1;
        int y = 1;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = x + y;
            x = y;
            y = result;
        }
        return result;
    }

    public static int arrSum(int[] arr){
        if(arr.length==1){
            return arr[0];
        }
        int[] newArr = new int[arr.length-1];
        for(int i = 1; i<arr.length;i++){
            newArr[i-1] = arr[i];
        }
        return arr[0]+arrSum(newArr);
    }
}
