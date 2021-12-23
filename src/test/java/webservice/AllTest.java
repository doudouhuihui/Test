package webservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AllTest {
    private Set<String> mySet = new HashSet();
    private long a ;
    public void setA(long a){
        this.a = a;
    }
    public long getA(){
        return this.a;
    }



    private List func() {
        List<String> list = new ArrayList<>();
        mySet.clear();
        mySet = new HashSet(){{add("4");}};
        for (Iterator<String> i = mySet.iterator(); i.hasNext(); ) {
            list.add(i.next());
        }

        for (int i = 1; i <= 5; i++){
            if (!filter(i+"")) {
                list.add(i+"");
            }
        }

//        mySet.clear();
//        mySet.add("123");
//        mySet.add("456");
        return list;
    }
    private boolean filter(String e){
        if(mySet.contains(e)) {
            return true;
        }
        if (e.equals("2") || e.equals("4")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws ParseException {
        //AllTest allTest = new AllTest();
//        String reg = "\\d{0,4}(\\d)(\\1){1}\\d{0,4}";
//        String reg2 = "";
//        System.out.println("311231".matches(reg));
//        String regx = "-?([0-9])*";
//        String data = "1";
//        System.out.println(data.matches(regx));
//        String dateFormat = "yyyy/MM/dd";
//        SimpleDateFormat sf2 = new SimpleDateFormat(dateFormat);
//        sf2.parse("20210102");

        String startDate = "2016-01-01";
        String endDate = "2020/01/01";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd");
        Date start, end;
        try{
            start = sf.parse(startDate);
        } catch (Exception e) {
            start = sf2.parse(startDate);
        }
        try{
            end = sf.parse(endDate);
        } catch (Exception e) {
            end = sf2.parse(endDate);
        }

        Calendar c = Calendar.getInstance();
        c.setTime(start);
        c.add(Calendar.YEAR, 3);

        Calendar c1 = Calendar.getInstance();
        c1.setTime(end);
        System.out.println(c.compareTo(c1) >= 0);


    }

}
