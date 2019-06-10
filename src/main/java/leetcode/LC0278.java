package leetcode;

/*****************************************************************************
 * @className: LC0278$
 * @date : 2019/5/22$ 15:58$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [
你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。
实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
示例:
给定 n = 5，并且 version = 4 是第一个错误的版本。
调用 isBadVersion(3) -> false
调用 isBadVersion(5) -> true
调用 isBadVersion(4) -> true

所以，4 是第一个错误的版本。 ]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class LC0278 {
    public static final int VALUE = 3;
    public static void main(String[] args) {
        System.out.println(firstBadVersion(3));
    }
    public static int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while(left<right){
            //这是关键，如果直接用left+right  / 2 会溢出
            int mid = left+(right-left)/2;
            if(!isBadVersion(mid)){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        if(isBadVersion(left)) return left;
        return left+1;
    }

    public static boolean isBadVersion(int n){
        if(n>=VALUE){
            return true;
        }
        return false;
    }
}
