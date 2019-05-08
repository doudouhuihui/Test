package other;

/*****************************************************************************
 * @className: Other.BitTest$
 * @date : 2019/4/16$ 17:57$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [常见的位运算，正负二进制表示，最大最小值，无符号左移右移，逻辑运算]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class BitTest {
    public static void main(String[] args) {
        //计算机以二进制存储，int一共4字节，32位，第一位为0表示正数，所以最大正数为为011...(31个1)
        //第一位为1表示负数，负数以补码存储，则正数取反加1，所以最小负数为1000...(31个0)
        //小技巧，正负数转换：最低位1之后的位不变，前面全部取反
        //最大正数+1就成了最小负数
        System.out.println("5的二进制：" + Integer.toBinaryString(5));
        System.out.println("最大正整数：" + Integer.MAX_VALUE + ",二进制为：" + Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println();

        System.out.println("-5的二进制：" + Integer.toBinaryString(-5));
        System.out.println("最小负整数：" + Integer.MIN_VALUE + ",二进制为：" + Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println();

        //>>, >>>, <<运算
        bitMove();

        // | & ^ ~ 运算
        bitLogic();


    }

    /**
     * [与/或/异或/非运算]
     * @Author: 陈伟振 (chenweizhen@vvise.com)
     * @Date: 2019/4/17 9:36
     */
    public static void bitLogic() {

        System.out.println("7的二进制：" + Integer.toBinaryString(7));
        System.out.println("-7的二进制：" + Integer.toBinaryString(-7));
        System.out.println("10的二进制：" + Integer.toBinaryString(10));
        System.out.println("-10的二进制：" + Integer.toBinaryString(-10));
        System.out.println();

        //与运算，有0则0，全1则1， 任何数和0与运算为0， 任何数和它本身运算还是本身
        //7二进制：0000 0000 0000 0000 0000 0111，10的二进制：0000 0000 0000 0000 0000 1010
        //与运算之后：0000 0000 0000 0000 0000 0010 = 2
        System.out.println("7和10与运算：" + Integer.toBinaryString(7 & 10) + "->" + (7 & 10));
        //7二进制：0000 0000 0000 0000 0000 0111，-10的二进制：1111 1111 1111 1111 1111 0110
        //与运算之后：0000 0000 0000 0000 0000 0110 = 6
        System.out.println("7和-10与运算：" + Integer.toBinaryString(7 & -10) + "->" + (7 & -10));
        //-7二进制：1111 1111 1111 1111 1111 1001，-10的二进制：1111 1111 1111 1111 1111 0110
        //与运算之后：1111 1111 1111 1111 1111 0000 = -16
        System.out.println("-7和-10与运算：" + Integer.toBinaryString(-7 & -10) + "->" + (-7 & -10));
        System.out.println();

        //或运算，有1则1，全0则0，任何数和0运算后，是它本身，任何数和它本身还是本身
        //7二进制：0000 0000 0000 0000 0000 0111，10的二进制：0000 0000 0000 0000 0000 1010
        //或运算之后：0000 0000 0000 0000 0000 1111 = 15
        System.out.println("7和10或运算：" + Integer.toBinaryString(7 | 10) + "->" + (7 | 10));
        //7二进制：0000 0000 0000 0000 0000 0111，-10的二进制：1111 1111 1111 1111 1111 0110
        //或运算之后：1111 1111 1111 1111 1111 0111 = 9
        System.out.println("7和-10或运算：" + Integer.toBinaryString(7 | -10) + "->" + (7 | -10));
        //-7二进制：1111 1111 1111 1111 1111 1001，-10的二进制：1111 1111 1111 1111 1111 0110
        //与运算之后：1111 1111 1111 1111 1111 1111 = -1
        System.out.println("-7和-10或运算：" + Integer.toBinaryString(-7 | -10) + "->" + (-7 | -10));
        System.out.println();

        //异或运算，相异为1，相同为0，任何数和它本身运算为0，和0运算相当于非运算
        //7二进制：0000 0000 0000 0000 0000 0111，10的二进制：0000 0000 0000 0000 0000 1010
        //异或运算之后：0000 0000 0000 0000 0000 1101 = 13
        System.out.println("7和10异或运算：" + Integer.toBinaryString(7 ^ 10) + "->" + (7 ^ 10));
        //7二进制：0000 0000 0000 0000 0000 0111，-10的二进制：1111 1111 1111 1111 1111 0110
        //异或运算之后：1111 1111 1111 1111 1111 0001 = -15
        System.out.println("7和-10异或运算：" + Integer.toBinaryString(7 ^ -10) + "->" + (7 ^ -10));
        //-7二进制：1111 1111 1111 1111 1111 1001，-10的二进制：1111 1111 1111 1111 1111 0110
        //异或运算之后：0000 0000 0000 0000 0000 1111 = 15
        System.out.println("-7和-10异或运算：" + Integer.toBinaryString(-7 ^ -10) + "->" + (-7 ^ -10));
        System.out.println();

        //非运算，0变1，1变0 ，相当于正数变负数，再减去1
        //7二进制：0000 0000 0000 0000 0000 0111
        //取反后：1111 1111 1111 1111 1111 1000 = -8
        System.out.println("7非运算：" + Integer.toBinaryString(~7) + "->" + (~7));
        //-7二进制：1111 1111 1111 1111 1111 1001
        //取反后：0000 0000 0000 0000 0000 0110 = 6
        System.out.println("-7非运算：" + Integer.toBinaryString(~-7) + "->" + (~-7));
        System.out.println();


        //测试，从左到右依次执行
        System.out.println(~ 7 & 6 | 5 ^ 4);




    }


    /**
     * [无符号带符号左移右移]
     * @Author: 陈伟振 (chenweizhen@vvise.com)
     * @Date: 2019/4/17 9:33
     */
    public static void bitMove() {
        //>>为带符号右移，最高位随着符号位，相当于除以2
        //如果右移超过了32位，相当于没移动，实际移动位数 = 移动位数 % 32
        //5二进制为0000 0000 0000 0000 0000 0101，带符号右移一位：0000 0000 0000 0000 0000 0010
        System.out.println("移位前5二进制：" + Integer.toBinaryString(5) + ",带符号右移一位：" + Integer.toBinaryString(5>>1) + "->" + (5>>1));
        //-5二进制为1111 1111 1111 1111 1111 1011， 带符号右移一位：1111 1111 1111 1111 1111 1101
        System.out.println("移位前-5二进制：" + Integer.toBinaryString(-5)+ ",带符号右移一位：" + Integer.toBinaryString(-5>>1) + "->" + (-5>>1));
        System.out.println();

        //<<左移,低位补0，相当于乘以2，左移不存在带不带符号
        //如果左移超过了32位，相当于没移动，实际移动位数 = 移动位数 % 32
        ////5二进制为0000 0000 0000 0000 0000 0101，左移一位：0000 0000 0000 0000 0000 1010
        System.out.println("移位前5二进制：" + Integer.toBinaryString(5) + ",左移一位：" + Integer.toBinaryString(5<<1) + "->" + (5<<1));
        //-5二进制为1111 1111 1111 1111 1111 1011， 左移一位：1111 1111 1111 1111 1111 0110
        System.out.println("移位前-5二进制：" + Integer.toBinaryString(-5) + ",左移一位：" + Integer.toBinaryString(-5<<1) + "->" + (-5<<1));
        System.out.println();

        //无符号右移>>>,和带符号右移区别就是无论正负，最高位补0
        //如果右移超过了32位，相当于没移动，实际移动位数 = 移动位数 % 32
        //5二进制为0000 0000 0000 0000 0000 0101，带符号右移一位：0000 0000 0000 0000 0000 0010
        System.out.println("移位前5二进制：" + Integer.toBinaryString(5) + ",无符号右移一位：" + Integer.toBinaryString(5>>>1) + "->" + (5>>>1));
        //-5二进制为1111 1111 1111 1111 1111 1011， 带符号右移一位：0111 1111 1111 1111 1111 1101,变成正数了
        System.out.println("移位前-5二进制：" + Integer.toBinaryString(-5)+ ",无符号右移一位：" + Integer.toBinaryString(-5>>>1) + "->" + (-5>>>1));
        System.out.println();
    }


}
