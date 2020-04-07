package leetcode;

/*****************************************************************************
 * @className: LC0083.java
 * @date : 2020-03-27 11:09
 * @author : 樊玺   (fanxi@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:

输入: 1->1->2
输出: 1->2]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class LC0083 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        ListNode resNode = deleteDuplicates(head);
        System.out.println(resNode.val);

    }
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode temp = head;
        while(head.next != null) {
            boolean flag = false;
            ListNode node = head.next;
            if (node.val == head.val) {
                //head.next.next可能为Null
                head.next = head.next.next;
                flag = true;

            }
            if (!flag) {
                head = head.next;
            }

            if (head == null) {
                break;
            }
        }
        return temp;
    }
}
