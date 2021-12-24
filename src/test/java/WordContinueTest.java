
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordContinueTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList();
        System.out.println("请输入第一个汉字：(q键退出)");
        String text = sc.next();



        while (!"q".equals(text)){

            if(text != null && text.length() == 1) {
                if(list.contains(text)){
                    System.out.println("该字已存在，请重新输入：(q键退出)");
                } else {
                    list.add(text);
                }

                if(list.size() >= 1){
                    System.out.println("上一个字符是："+list.get(list.size()-1)+"  请输入下个字符：(q键退出)");
                } else {
                    System.out.println("请输入下个字符：(q键退出)");
                }
            } else {
                if(list.size() >= 1){
                    System.out.println("只能输入一个汉字哦！上一个字符是："+list.get(list.size()-1)+"  请重新输入：(q键退出)");
                } else {
                    System.out.println("只能输入一个汉字哦！请重新输入：(q键退出)");

                }
            }
            text = sc.next();

        }

        for(String s : list){
            System.out.print(s);
        }



    }
}
