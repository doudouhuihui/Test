import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*****************************************************************************
 * @className: AllTest.java
 * @date : 2019-12-13 17:06
 * @author : 樊玺   (fanxi@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class LinkTest<E> {

    private Node<E> first, last;
    private int size;

    public void linkFirst(E e){
        Node<E> f = first;
        Node<E> newNode = new Node<E>(null, e, first);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    public void linkLast(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<E>(last, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public void linkBefore(E e, Node<E> succ){
        Node<E> pred = succ.prev;
        Node<E> newNode = new Node<E>(pred,  e,  succ);
        succ.prev = newNode;
        if (pred == null) {
            first = newNode;
        } else {
            pred.next = newNode;
        }
        size++;
    }

    public E unlinkFirst(Node<E> node){
        E e = node.item;
        Node<E> next = node.next;
        node.item = null;
        node.next = null;
        first = next;

        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;






        return e;
    }







    public static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;
        public Node(Node<E> prev, E e, Node<E> next){
            this.item = e;
            this.prev = prev;
            this.next = next;
        }
    }
}
