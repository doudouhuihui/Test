package collections.myLinkedList;

import java.util.NoSuchElementException;

public class MyLinkList<E> {
    private Node<E> first, last;
    private int size;

    public MyLinkList(){}

    public void linkFirst(E e){
        Node f = first;
        Node newNode = new Node(null, e, first);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            first.prev = newNode;
        }
        size++;
    }
    public void linkLast(E e){
        Node l = last;
        Node newNode = new Node(last, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            first.next = newNode;
        }
        size++;
    }
    private void linkBefore(E e, Node<E> succ){
        Node prev = succ.prev;
        Node newNode = new Node(prev, e, succ);
        succ.prev = newNode;
        if (prev == null) {
            first = newNode;
        } else {
            prev.next = newNode;
        }
        size++;

    }
    private E unlinkFirst(Node<E> node){
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
    private E unlinkLast(Node<E> node){
        E e = node.item;
        Node<E> prev = node.prev;
        node.prev = null;
        last = prev;
        if (prev == null) {
            first = null;
        } else {
            prev.next = null;
        }
        size--;

        return e;
    }

    private E unlink(Node<E> node) {
        E e = node.item;
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        node.prev = null;
        node.next = null;

        if (prev==null){
            first = next;
        } else {
            prev.next = next;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
        }


        size--;
        return e;
    }

    private E getFirst(){
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.item;
    }

    private E getLast(){
        if (last == null){
            throw new NoSuchElementException();
        }
        return last.item;
    }

    private E removeFirst(){
        if (first == null){
            throw new NoSuchElementException();
        }
        E e = first.item;
        unlinkFirst(first);
        return e;
    }

    private E removeLast(){
        if (last == null){
            throw new NoSuchElementException();
        }
        E e = last.item;
        unlink(last);
        return e;
    }

}

class Node<E> {
    Node<E> prev, next;
    E item;
    public Node(Node prev, E item, Node next){
        this.prev = prev;
        this.item = item;
        this.next = next;
    }

}
