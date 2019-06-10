package other;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*****************************************************************************
 * @className: FileTest$
 * @date : 2019/5/27$ 14:49$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class FileTest {
    public static void main(String[] args) {
        File file = new File("D:\\a\\b\\test.text");
        if(!file.exists()){
            file.mkdirs();
        }
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(123);
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.exists());
    }
}
