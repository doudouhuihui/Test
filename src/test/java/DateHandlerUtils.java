import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public  class DateHandlerUtils {
//    private DateHandlerUtils(){}

    public static String calcCostTimeByTimestamp(Timestamp timestamp1, Timestamp timestamp2){
        return calcCostTimeByMills(calcDuringMills(timestamp1, timestamp2));
    }


    public static long calcDuringMills(Timestamp timestamp1, Timestamp timestamp2){
        if (timestamp1 != null && timestamp2 != null) {
            Calendar instance1 = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance1.setTime(timestamp1);
            instance2.setTime(timestamp2);
            return Math.abs(instance2.getTimeInMillis() - instance1.getTimeInMillis());
        }
        return 0;


    }







    public static String calcCostTimeByMills(long costMills){
        String costTimeText = "";
        long day =  (costMills/1000/60/60/24);
        long hour = costMills/1000/60/60%24;
        long minu = costMills/1000/60%60;
        long seco = costMills/1000%60;
        //30.5分钟= 0.5小时
        BigDecimal hour1 = new BigDecimal(minu*60+seco).divide(new BigDecimal(3600)).setScale(2, BigDecimal.ROUND_HALF_UP);

        //1天2小时30分36秒  ===》 26.51小时
        if (day != 0) {
            costTimeText += day+"天"+hour+"小时"+minu+"分钟"+seco+"秒";
        } else  if(hour != 0){
            costTimeText += hour+"小时"+minu+"分钟"+seco+"秒";
        } else if (minu != 0) {
            costTimeText += minu+"分钟"+seco+"秒";
        } else  {
            costTimeText += seco + "秒";
        }
        System.out.println(costTimeText);
        costTimeText = (((day*24)+hour) + (hour1.doubleValue())) +"小时";
        System.out.println(costTimeText);
        return costTimeText;
    }

    public static void main(String[] args) {
//        String s = DateHandlerUtils.calcCostTime("2021-11-04 11:35:10", "2021-11-05 15:38:10");
//        System.out.println(s);

        BigDecimal hour1 = new BigDecimal(600).divide(new BigDecimal(3600),2,BigDecimal.ROUND_HALF_UP);
        System.out.println(hour1.toString());
    }

    public static String calcCostTime(String createDate, String finishDate) {
        return calcCostTimeByMills(calcCostTimeByMills(createDate, finishDate));
    }

    public static long calcCostTimeByMills(String createDate, String finishDate) {
        if (StringUtils.isEmpty(createDate) || StringUtils.isEmpty(finishDate)) {
            return 0;
        }
        Date startDate = string2Date(createDate, "yyyy-MM-dd HH:mm:ss");
        Date endDate = string2Date(finishDate, "yyyy-MM-dd HH:mm:ss");
        if (startDate == null || endDate == null){
            return 0;
        }

        Calendar instance1 = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance1.setTime(startDate);
        instance2.setTime(endDate);

        long mills1 = instance1.getTimeInMillis();
        long mills2 = instance2.getTimeInMillis();
        long costMills = mills2 - mills1;
        return Math.abs(costMills);
    }

    public static Date string2Date(String strtime,String datepattern){
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat(datepattern);
            return dateFormat.parse(strtime, new ParsePosition(0));
        }catch(Exception e){
            //throw new Exception(e);
        }
        return null;
    }
}
