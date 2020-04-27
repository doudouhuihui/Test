package datastruct;

/*****************************************************************************
 * @className: BinTreePrintTest.java
 * @date : 2020-03-18 09:38
 * @author : 樊玺   (fanxi@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class BinTreePrintTest {

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(8);
        root.right = new Node(6);
        root.left.right = new Node(3);
        beforePrint(root);
        System.out.println();
        middlePrint(root);//
        System.out.println();
        afterPrint(root);

    }

    private static void beforePrint(Node node) {
        if (node == null) {
            return ;
        }
        System.out.print(node.value + " ");
        beforePrint(node.left);
        beforePrint(node.right);
    }
    private static void middlePrint(Node node) {
        if (node == null) {
            return;
        }
        beforePrint(node.left);
        System.out.print(node.value + " ");
        beforePrint(node.right);
    }
    private static void afterPrint(Node node) {
        if (node == null) {
            return;
        }
        beforePrint(node.left);
        beforePrint(node.right);
        System.out.print(node.value + " ");
    }

}

