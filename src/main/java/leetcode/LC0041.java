package leetcode;

/**
 * ����?n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��
 *
 * ?
 *
 * ʾ�� 1��
 *
 *
 *
 * ���룺height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * �����6
 * ���ͣ������������� [0,1,0,2,1,0,1,3,2,1,2,1] ��ʾ�ĸ߶�ͼ������������£����Խ� 6 ����λ����ˮ����ɫ���ֱ�ʾ��ˮ����
 * ʾ�� 2��
 *
 * ���룺height = [4,2,0,3,2,5]
 * �����9
 *
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/trapping-rain-water
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LC0041 {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{4,2,0,3,2,5}));
    }

    /**
     * ˼·�������������һ��height��ǰһ��С��temp+1,�����Ƚ��¸�������������ڻ������temp>0 , s= temp* ��һ���߶�
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int tempLen = 0;
        int compVal = 0;
        int result = 0;
        if (height == null || height.length == 0) {
            return result;
        }
        for (int i = 0; i < height.length; i++) {
            if (height[i] > 0 && compVal == 0) {
                compVal = height[i];
            }
            System.out.println("height" + (i) + "��Ϊ�Ƚ�ֵ"+compVal);
            for (int j = (i+1) ; j < height.length ; ) {
                if (compVal > height[j]) {
                    tempLen++;
                    if(tempLen == height.length - (i+1)){  //ȫ���Ǳ���С�ģ�û����
                        tempLen = 0;
                        compVal = 0;
                    }
                    continue;
                } else if (j == (i+1)) {
                    compVal = 0;
                    break;
                }

                 if (tempLen > 0 && compVal > 0){
                    System.out.println("tempLen="+tempLen+",compVal="+compVal);
                    result += tempLen ;

                    System.out.println(result);
                    tempLen = 0;
                    compVal --;

                    if (compVal <= 0) {
                        j++;
                        continue;
                    }
                        break;


                }
            }
        }

        return result;
    }
}












