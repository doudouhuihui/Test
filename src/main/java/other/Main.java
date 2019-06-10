package other;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;

/*****************************************************************************
 * @className: Main$
 * @date : 2019/6/10$ 11:31$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class Main {

    public static final String HTTp_URL="http://192.168.1.225:18088/vvise-js/";
    public static void main(String[] args) {
        Dol();
    }
    public static void Dol(){
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;
        try {
            URL url = new URL(HTTp_URL);
            HttpURLConnection connection =  (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();

            bis = new BufferedInputStream(is);

            File file = new File("D:/test/"+HTTp_URL.substring((HTTp_URL.lastIndexOf("/"))));//名字截取 可以省略
            FileOutputStream fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            int b = 0;
            byte[] byArr = new byte[1024*4];
            while((b=bis.read(byArr))!=-1){
                bos.write(byArr, 0, b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(bis!=null){
                    bis.close();
                }
                if(bos!=null){
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


