/*****************************************************************************
 * @className: BitTest$
 * @date : 2019/4/16$ 17:57$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
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
        //最大正数+1就成了最小负数
        System.out.println("正数5的二进制：" + Integer.toBinaryString(5));
        System.out.println("最大正整数：" + Integer.MAX_VALUE + ",二进制为：" + Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println();

        System.out.println("负数5的二进制：" + Integer.toBinaryString(-5));
        System.out.println("最小负整数：" + Integer.MIN_VALUE + ",二进制为：" + Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println();

        //>>, >>>, <<运算
        //bitMove();

        // | & ^ ~ 运算


    }

    public static void bitLogic() {

    }


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
