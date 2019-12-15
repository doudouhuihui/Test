package collections.myArrayList;

import java.util.Arrays;

public class MyArrList<E> {

    private static final int CAPACITY = 10;
    private Object[] data;
    private int size;
    private Object[] emptyData = {};
    public MyArrList() {
        this.data = emptyData;
    }
    public MyArrList(int capacity){
        if (capacity<0) throw new IllegalArgumentException();
        if (capacity==0) this.data = emptyData;
        if (capacity>Integer.MAX_VALUE) this.data = new Object[Integer.MAX_VALUE];
        data = new Object[capacity];
    }
    public int size() {return size;}
    public boolean isEmpty() {
        return size == 0;
    }

    public E add(E e) {
        ensureCapacity(size + 1);
        data[size++] = e;
        return e;
    }

    public E set(int index, E e) {
        rangeChk(index);
        data[index] = e;
        return e;
    }


    public E get(int index) {
        rangeChk(index);
        return (E) data[index];
    }

    public E get(Object obj) {
        if (null == obj) {
            for (int i = 0; i < data.length; i++) {
                if (null == data[i]) {
                    return null;
                }
            }
        }  else {
            for (int i = 0; i < data.length; i++) {
                if (obj.equals(data[i])) {
                    return (E) obj;
                }
            }
        }
        return null;
    }

    public E remove(Object obj) {
        if (null == obj) {
            for (int i = 0; i < data.length; i++) {
                if (null == data[i]) {
                    size--;
                   System.arraycopy(data, i+1, data, i, data.length - i);
                    return null;
                }
            }
        }  else {
            for (int i = 0; i < data.length; i++) {
                if (obj.equals(data[i])) {
                    size--;
                    System.arraycopy(data, i+1, data, i, data.length - i -1);
                    return (E) obj;
                }
            }
        }
        return null;
    }
    private void rangeChk(int index) {
        if (index<0) {
            throw new IllegalArgumentException();
        }
        if (index>=size) {
            throw new ArrayIndexOutOfBoundsException();
        }

    }

    private void ensureCapacity(int needCapacity) {
        if(data == emptyData){
            needCapacity = CAPACITY;
        }
        if (needCapacity>data.length) {
            flat(needCapacity);
        }
    }
    public void print(){
        for (int i = 0; i< size; i++) {
            System.out.print(data[i]+",");
        }
    }
    private void flat(int needCapacity){
        int old = data.length;
        int newCapacity = old + (old >> 2);
        if (newCapacity < 0) {
            throw new OutOfMemoryError();
        }
        if (newCapacity < needCapacity) {
            newCapacity = needCapacity;
        }
        if (newCapacity > Integer.MAX_VALUE) {
            newCapacity = Integer.MAX_VALUE;
        }
        data = Arrays.copyOf(data, newCapacity);

    }

    public static void main(String[] args) {
        MyArrList list = new MyArrList();
        list.add("123");
        list.add("456");
        list.set(0,"111");
        System.out.println(list.get(1));
        System.out.println(list.get(0));
        System.out.println(list.get("456"));
        list.remove("111");
        System.out.println(list.get(0));
        System.out.println(list.isEmpty());
        list.print();
    }
}
