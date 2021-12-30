import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class BirthdayCalcTest {

    public static void main(String[] args) {

        String[] week = {"日","一","二","三","四","五","六"};
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的生日（格式YYYY-MM-DD）：");
        String birthText = sc.next();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = null;
        try {
            birthDate = sdf.parse(birthText);
        } catch (ParseException e) {
            System.out.println("格式不正确");
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthDate);

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(new Date());
        long during = calendar1.getTimeInMillis() - calendar.getTimeInMillis();



//        Calendar calendar2 = Calendar.getInstance();
//        calendar2.setTimeInMillis(Math.abs(during));

        System.out.println("你在"+calendar.get(Calendar.YEAR)+"年"+(calendar.get(Calendar.MONTH)+1) +"月"+calendar.get(Calendar.DAY_OF_MONTH)+"出生");
        System.out.println("这一天是当年的第"+calendar.get(Calendar.DAY_OF_YEAR) +"天");
        System.out.println("这一天是周"+week[calendar.get(Calendar.DAY_OF_WEEK)-1]);
        System.out.println("今年"+(calendar1.get(Calendar.YEAR) - calendar.get(Calendar.YEAR))+"周岁");
        System.out.println("距今过了"+(Math.abs(during)/1000/60/60/24)+"天");







//        System.out.println(birthDate);
    }

}
