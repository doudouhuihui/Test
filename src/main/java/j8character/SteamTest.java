package j8character;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*****************************************************************************
 * @className: SteamTest$
 * @date : 2019/5/10$ 14:20$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class SteamTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("123");

        try (FileOutputStream fos = new FileOutputStream("D://123.txt");) {
            fos.write(65);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
