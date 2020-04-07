package leetcode;

/*****************************************************************************
 * @className: LC0019.java
 * @date : 2020-03-19 13:51
 * @author : 樊玺   (fanxi@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [删除链表的倒数第N个节点]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。
 * 2
 ******************************************************************************/
public class LC0019 {


    //预留指针，快慢指针，快指针先走n步，然后快慢一起走，快指针走到结束，删除慢指针即可
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre, end = pre;
        while (n != 0) {
            start = start.next;
            n--;
        }
        while (start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;

        return pre.next;

    }

    //最笨的方法，先统计多少个数，然后找到那个数，进行删除，最符合正常人思路，不过
    //因为没有前驱，所以index - 1的时候进行删除
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0; //统计链表总数
        int count2 = 0;  //第二次统计
        for (ListNode node = head; node != null; node = node.next) {
            count++;
        }
        int index = count - n + 1; //正序第几个
        for (ListNode node = head; node != null; node = node.next) {
            count2++;
            if (count2 == index) {  //删除这个节点
                if(node == head) {
                    head = node.next;
                    break;
                }
            }
            if (count2 == index - 1) {
                node.next = node.next.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
