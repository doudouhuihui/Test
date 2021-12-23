import org.springframework.util.StringUtils;

import java.io.*;
import java.util.*;

public class OtherTest {
    //定义
    private static String[] badArr = {"4", "444"};
    private static String[] LvStr = {"特等档","第一档","第二档","第三档","第四档","第五档"};
    private static String[][] regArr = new String[][]{
            { //特等档
                    "(\\d)(\\1){5}",//AAAAAA
                    "\\d?(\\d)(\\1){4}\\d?", //AAAAA
                    "\\d{0,2}6666\\d{0,2}",  //6666
                    "\\d{0,2}8888\\d{0,2}",  //8888
                    "\\d{0,2}9999\\d{0,2}"  //9999
            },
            { //第一档
                    "\\d{0,2}(\\d)(\\1){3}\\d{0,2}", //AAAA 除了6，8，9
                    "\\d{0,3}666\\d{0,3}",  //666
                    "\\d{0,3}888\\d{0,3}",  //888
                    "\\d{0,3}999\\d{0,3}",  //999
                    "(\\d)(\\1){2}(\\d)(\\3){2}" //AAABBB
            },
            { //第二档
                    "\\d{0,3}(\\d)(\\1){2}\\d{0,3}", //AAA
                    "(\\d)(\\1){2}(\\d)(\\3){2}",  //AAABBB
                    "(\\d)\\1(\\d)\\2(\\d)\\3",  //AABBCC
                    "(\\d)(\\d)\\1\\2\\1\\2",  //ABABAB
                    "(\\d)(\\d)(\\d)\\1\\2\\3"  //ABCABC
            },
            { //第三档
                    "\\d{0,3}444\\d{0,3}",  //444
                    "(\\d)\\1(\\d)\\2(\\d)\\3",  //AABBCC
                    "(\\d)(\\d)\\1\\2\\1\\2",  //ABABAB
                    "(\\d)(\\d)(\\d)\\1\\2\\3",  //ABCABC
                    "\\d{0,2}(\\d)\\188\\d{0,2}"  //AA88
            },
            { //第四档
                    "\\d{0,2}(\\d)\\1(\\d)\\2\\d{0,2}", //AABB
                    "\\d{0,2}(\\d)(\\d)\\1\\2\\d{0,2}",  //ABAB
                    "88" //88
            }
    };
    public static void main(String[] args) throws IOException {

        //单号码测试
        String shortNo = "023452"; //330567
        shortNo = "678901";
        System.out.println(shortNo + "-----" + getLevelByShortNo(shortNo));

        //文件批量测试
//        FileReader fis = new FileReader("E:\\Users\\hasee\\Desktop\\duan.txt"); //每行一个短号，中间不要有空行
//        BufferedReader bis = new BufferedReader(fis);
//        while (true){
//            String testNo = bis.readLine();
//            if (StringUtils.isEmpty(testNo)) break;
//            if (testNo.contains("//")) continue;  //忽略“//”注释
//            System.out.println(testNo + "-----" + getLevelByShortNo(testNo));
//        }


        //随机生成20个测试
//        StringBuilder sb;
//        for (int i = 0; i < 20; i++) {
//            sb = new StringBuilder();
//            for (int j = 0; j < 6; j++) {
//                sb.append((int)(Math.random()*10));
//            }
//            System.out.println(sb.toString() + "-----" + getLevelByShortNo(sb.toString()));
//        }


    }
    private static String getLevelByShortNo(String shortNo){
        //============level 1=============
        for (String regex : regArr[0]) {
            if (shortNo.matches(regex)) {
                return LvStr[0];
            }
        }
        //ABCDEF
        if(ifABC(shortNo) == 0 && Integer.parseInt(shortNo) > 10_0000) {
            return LvStr[0];
        }
        //============level 2=============
        for (int i = 0; i < regArr.length; i++) {
            if (shortNo.matches(regArr[1][i]) && i != regArr.length - 1) {
                return LvStr[1];
            }
            if (shortNo.matches(regArr[1][regArr.length - 1]) && !shortNo.contains(badArr[0])) {
                return LvStr[1];
            }
        }
        //============level 3=============
        for (int i = 0; i < regArr.length; i++) {
            if (i == 0 && shortNo.matches(regArr[2][i]) && !shortNo.contains(badArr[1])) {
                return LvStr[2];
            }
            if (i == 1 && shortNo.matches(regArr[2][i]) && shortNo.contains(badArr[1])) {
                return LvStr[2];
            }
            if(shortNo.matches(regArr[2][i]) && !shortNo.contains(badArr[0])) {
                return LvStr[2];
            }
        }
        //ABCDE
        String tempNo = shortNo.substring(1);
        if(ifABC(tempNo) == 0 && Integer.parseInt(tempNo) > 10000) {
            return LvStr[2];
        }
        tempNo = shortNo.substring(0, shortNo.length() - 1);
        if(ifABC(tempNo) == 0 && Integer.parseInt(tempNo) > 10000) {
            return LvStr[2];
        }
        //============level 3=============
        for (int i = 0; i < regArr.length; i++) {
            if ((i == 0 || i == regArr.length - 1) && shortNo.matches(regArr[3][i])) {
                return LvStr[3];
            }
            if (shortNo.matches(regArr[3][i]) && shortNo.contains(badArr[0])) {
                return LvStr[3];
            }
        }
        //============level 4=============
        if (shortNo.matches(regArr[4][0]) || shortNo.matches(regArr[4][1]) || shortNo.contains(regArr[4][1])) {
            return LvStr[4];
        }
        //ABCD
        tempNo = shortNo.substring(2);
        if(ifABC(tempNo) == 0 && Integer.parseInt(tempNo) > 1000) {
            return LvStr[4];
        }
        tempNo = shortNo.substring(0, shortNo.length() - 2);
        if(ifABC(tempNo) == 0 && Integer.parseInt(tempNo) > 1000) {
            return LvStr[4];
        }
        tempNo = shortNo.substring(1, shortNo.length() - 1);
        if(ifABC(tempNo) == 0 && Integer.parseInt(tempNo) > 1000) {
            return LvStr[4];
        }
        //============level 5=============
        return LvStr[5];
    }

    private static int ifABC(String tempNo) {
        int no = Integer.parseInt(tempNo);
        while (no > 0) {
//            int m = no % 10 == 0 ? 10 : no % 10;             //适用678901
            int m = no % 10 ;
            if ((no > 9) && m - 1 != (no / 10 % 10)){ break;}
            no = no /10;
        }
        return no;
    }



}
