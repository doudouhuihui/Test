package other;

import com.sun.deploy.util.StringUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

/*****************************************************************************
 * @className: ScannerTest$
 * @date : 2019/6/10$ 10:00$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class ScannerTest {
    public static void main(String[] args) throws Exception {
        System.out.println(1.11>1.3);
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        FileOutputStream fos = new FileOutputStream("D:\\123.txt");
        fos.write(str.getBytes());
        fos.close();

        FileInputStream fis = new FileInputStream("D:\\123.txt");
        str = "";
        int i;
        while ((i=fis.read())!=-1){
            str +=(char)i;
        }
        System.out.println(new StringBuilder(str).reverse());
    }
}
