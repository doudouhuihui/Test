import java.util.HashMap;

/*****************************************************************************
 * @className: LRUTest$
 * @date : 2019/4/15$ 16:41$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class LRUTest {
    private Node head;
    private Node end;
    private int limit;
    private HashMap<String, Node> hashMap;
    public LRUTest(int limit){
        this.limit = limit;
        hashMap = new HashMap<String, Node>();
    }

    public void put(String key, String val){
        Node node = hashMap.get(key);
        if(node==null){
            if(hashMap.size()>=limit){
                String oldKey = removeNode(head);
                hashMap.remove(oldKey);

            }
            Node newNode = new Node(key,val);
            addNode(newNode);
            hashMap.put(key,newNode);
        }else{
            node.val = val;
            refreshNode(node);
        }

    }
    //

    public String removeNode(Node node){
        if(node==head){
            head = node.next;
        }else if (node == end){
            end = node.prev;
        }else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        return (String) node.key;
    }

    public void addNode(Node node){
        if (end !=null) {
            end.next = node;
            node.prev = end;
            node.next = null;
        }
        end = node;
        if (head == null) {
            head = node;
        }
    }
    public void refreshNode(Node node){
        if (node == end) {
            return;
        }
        removeNode(node);
        addNode(node);
    }
    public String get(String key) {
        Node node = hashMap.get(key);
        if (node ==null ) {
            return null;
        }else{
            refreshNode(node);
            return (String) node.val;
        }
    }
    public static void main(String[] args) {
        LRUTest lruTest = new LRUTest(4);
        lruTest.put("1","111");
        lruTest.put("2","222");
        lruTest.put("3","333");
        lruTest.put("4","444");
        lruTest.put("5","555");
        lruTest.get("4");

    }


}
class Node<K, V>{
    public Node(K k, V v){
        this.key = k;
        this.val = v;
    }
    public Node prev;
    public Node next;
    public K key;
    public V val;
}
