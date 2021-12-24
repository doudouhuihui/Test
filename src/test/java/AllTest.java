import java.util.*;

public class AllTest {
    public static void main(String[] args) {
        String billId = "005734567";
        if (billId.length()>16||billId.length()<5){
            //真实号码长度输入错误
            System.out.println("真实号码长度输入错误");
            return;
        }
        long billIdRegion = billId.startsWith("0") ? Long.parseLong(billId.substring(0, 4)) : Long.parseLong(billId.substring(0, 3));
        System.out.println(billIdRegion);
        if(billIdRegion>580||billIdRegion<570){
            //真实号码输入错误，请输入固定电话的格式数据！
            System.out.println("真实号码输入错误，请输入固定电话的格式数据");
            return;
        }
        System.out.println("正确");
    }
    public static void test(String[] args) {
//        System.out.println(Arrays.toString("123.2.2.3.2.3".split("\\.", 2)));
       // Collections.EMPTY_LIS

        List<String> redList = new ArrayList(6);
        Integer rand;
        for (int i = 0; i < 6; i++) {
                   rand = (int)(Math.random()*(33)) + 1;
            String temp = rand < 10 ? "0" + rand : rand.toString();
//            System.out.println(temp);
            while (redList.contains(temp)) {
                rand = (int)(Math.random()*(33)) + 1;
                temp = rand < 10 ? "0" + rand : rand.toString();
            }
            redList.add(temp);
        }
        rand = (int)(Math.random()*(16)) + 1;
        String blue = rand < 10 ? "0" + rand : rand.toString();
        Collections.sort(redList);
        System.out.println(redList.toString() + "|" + blue);
    }
}
