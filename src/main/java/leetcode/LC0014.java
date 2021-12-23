package leetcode;

/**
 *
 */
public class LC0014 {

    public static void main(String[] args) {
        LC0014 lc0014 = new LC0014();
//        String[] strs = {"flower","flow","flight","fler"};
        String[] strs = {"ab","a"};

        System.out.println(lc0014.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        //取最短的一个，记录一下
        String shortStr = strs[0];
        for(int i = 0; i < strs.length; i++) {
            if (shortStr.length() > strs[i].length()) {
                shortStr = strs[i];
            }
        }
        char[] chars = shortStr.toCharArray();
        String resStr = "";
        //遍历最短的这个每个字符
        for (int i = 0; i < chars.length; i++) {
            resStr += chars[i];
            for (int j = 0; j < strs.length; j++) {
                if (!strs[j].startsWith(resStr)) {
                    return resStr.substring(0,resStr.length()-1);
                }
            }
        }


        return resStr;
    }
}
