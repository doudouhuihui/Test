package other;

import java.util.Date;
import java.util.Stack;

/*****************************************************************************
 * @className: StirngReverse$
 * @date : 2019/6/10$ 10:28$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [字符串反转的几种方法]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class StringReverse {
    public static void main(String[] args) {
        String str = "and t.status IN (20, 25, 30, 40)\n" +
                "   AND t.shipper_id IN (SELECT t.shipper_id from v_bd_shipper_user t where t.user_id = ?)\n" +
                "   and date_format(t12.date10,'%Y-%m-%d') >= date_format(?, '%Y-%m-%d')  and date_format(t12.date10,'%Y-%m-%d') <= date_format(?, '%Y-%m-%d')  order by  t.status, t12.date10 desc) total_t]\n" +
                "10:35:06.008 [http-bio-8083-exec-2] DEBUG o.s.j.d.DataSourceTransactionManager - Initiating transaction commit\n" +
                "10:35:06.008 [http-bio-8083-exec-2] DEBUG o.s.j.d.DataSourceTransactionManager - Committing JDBC transaction on Connection [com.alibaba.druid.proxy.jdbc.ConnectionProxyImpl@11176379]\n" +
                "10:35:06.010 [http-bio-8083-exec-2] DEBUG o.s.j.d.DataSourceTransactionManager - Releasing JDBC Connection [com.alibaba.druid.proxy.jdbc.ConnectionProxyImpl@11176379] after transaction\n" +
                "10:35:06.010 [http-bio-8083-exec-2] DEBUG o.s.jdbc.datasource.DataSourceUtils - Returning JDBC Connection to DataSource\n" +
                "10:35:06.011 [http-bio-8083-exec-2] DEBUG o.s.w.s.m.m.a.RequestResponseBodyMethodProcessor - Written [{\"rows\":[{\"order_id\":\"1906100019\",\"opt_date_text\":\"2019-06-10 10:34\",\"date10_text\":\"2019-06-10 10:34\",\"date20_text\":\"2019-06-10 10:34:50\",\"status\":20,\"status_name\":\"已接单\",\"status_color\":\"#007ded\",\"order_code\":\"1906100019\",\"consignee_name\":\"刘宇飞\",\"consignee_phone\":\"18948789369\",\"shipper_id\":32,\"shipper_name\":\"中粮可口可乐（陕西）饮料有限公司\",\"shipper_name_full\":\"中粮可口可乐（陕西）饮料有限公司\",\"start_area\":\"610116\",\"start_full_name\":\"陕西省西安市长安区\",\"start_area_name\":\"陕西省西安市长安区长安大道165号\",\"end_area\":\"610402\",\"end_full_name\":\"陕西省咸阳市秦都区\",\"end_area_name\":\"陕西省咸阳市秦都区秦都大道103号\",\"car_code\":\"冀A539T2\",\"driver_id\":90,\"driver_name\":\"刘胜利\",\"link_mobile\":\"18996325812\",\"gis_lng\":108.877396,\"gis_lat\":34.231853,\"gis_address\":\"中国陕西省西安市雁塔区高新六路10号\",\"e_id\":\"0\"},{\"order_id\":\"1906100017\",\"opt_date_text\":\"2019-06-10 10:26\",\"date10_text\":\"2019-06-10 10:31\",\"date20_text\":\"2019-06-10 10:32:34\",\"status\":20,\"status_name\":\"已接单\",\"status_color\":\"#007ded\",\"order_code\":\"1906100017\",\"consignee_name\":\"刘宇飞\",\"consignee_phone\":\"18948789369\",\"shipper_id\":32,\"shipper_name\":\"中粮可口可乐（陕西）饮料有限公司\",\"shipper_name_full\":\"中粮可口可乐（陕西）饮料有限公司\",\"start_area\":\"610116\",\"start_full_name\":\"陕西省西安市长安区\",\"start_area_name\":\"陕西省西安市长安区长安大道165号\",\"end_area\":\"610402\",\"end_full_name\":\"陕西省咸阳市秦都区\",\"end_area_name\":\"陕西省咸阳市秦都区秦都大道103号\",\"car_code\":\"陕K95366\",\"driver_id\":13,\"driver_name\":\"王柏青\",\"link_mobile\":\"15769458899\",\"gis_lng\":108.877490,\"gis_lat\":34.231820,\"gis_address\":\"中国陕西省西安市雁塔区高新六路10号\",\"e_id\":\"0\"},{\"order_id\":\"1906060014\",\"opt_date_text\":\"2019-06-06 11:53\",\"date10_text\":\"2019-06-10 09:56\",\"date20_text\":\"2019-06-10 10:04:20\",\"status\":20,\"status_name\":\"已接单\",\"status_color\":\"#007ded\",\"order_code\":\"1906060014\",\"consignee_name\":\"烽火工业\",\"consignee_phone\":\"15315645121\",\"shipper_id\":38,\"shipper_name\":\"农夫山泉陕西\",\"shipper_name_full\":\"农夫山泉陕西太白山有限公司\",\"start_area\":\"610103\",\"start_full_name\":\"陕西省西安市碑林区\",\"start_area_name\":\"陕西省西安市碑林区长安北街12号\",\"end_area\":\"450502\",\"end_full_name\":\"广西北海市海城区\",\"end_area_name\":\"广西北海市海城区烽火工业园区\",\"car_code\":\"陕KE8010\",\"driver_id\":6,\"driver_name\":\"李永军\",\"link_mobile\":\"15740562310\",\"gis_lng\":108.884044,\"gis_lat\":34.237841,\"gis_address\":\"中国陕西省西安市雁塔区唐兴路108号\",\"e_id\":\"0\"},{\"order_id\":\"1906100010\",\"opt_date_text\":\"2019-06-10 09:48\",\"date10_text\":\"2019-06-10 09:48\",\"date20_text\":\"2019-06-10 10:22:39\",\"status\":20,\"status_name\":\"已接单\",\"status_color\":\"#007ded\",\"order_code\":\"1906100010\",\"consignee_name\":\"刘宇飞\",\"consignee_phone\":\"18948789369\",\"shipper_id\":32,\"shipper_name\":\"中粮可口可乐（陕西）饮料有限公司\",\"shipper_name_full\":\"中粮可口可乐（陕西）饮料有限公司\",\"start_area\":\"610116\",\"start_full_name\":\"陕西省西安市长安区\",\"start_area_name\":\"陕西省西安市长安区长安大道165号\",\"end_area\":\"610402\",\"end_full_name\":\"陕西省咸阳市秦都区\",\"end_area_name\":\"陕西省咸阳市秦都区秦都大道103号\",\"car_code\":\"陕L01213\",\"driver_id\":42,\"driver_name\":\"陶功银\",\"link_mobile\":\"15445235665\",\"gis_lng\":108.884125,\"gis_lat\":34.237800,\"gis_address\":\"中国陕西省西安市雁塔区高新六路10号\",\"e_id\":\"0\"},{\"order_id\":\"1906060031\",\"opt_date_text\":\"2019-06-06 15:33\",\"date10_text\":\"2019-06-06 15:33\",\"date20_text\":\"2019-06-06 15:34:41\",\"status\":20,\"status_name\":\"已接单\",\"status_color\":\"#007ded\",\"order_code\":\"1906060031\",\"consignee_name\":\"刘子亚\",\"consignee_phone\":\"18948789369\",\"shipper_id\":30,\"shipper_name\":\"蒙牛乳业液体奶塞北\",\"shipper_name_full\":\"蒙牛乳业液体奶塞北事业部\",\"start_area\":\"150102\",\"start_full_name\":\"内蒙古呼和浩特市新城区\",\"start_area_name\":\"内蒙古呼和浩特市新城区柳沟村132号\",\"end_area\":\"150522\",\"end_full_name\":\"内蒙古通辽市科尔沁左翼后旗\",\"end_area_name\":\"内蒙古通辽市科尔沁左翼后旗科技大道100号\",\"car_code\":\"陕KC5878\",\"driver_id\":9,\"driver_name\":\"曹鸿喜\",\"link_mobile\":\"13353268566\",\"gis_lng\":108.883906,\"gis_lat\":34.237737,\"gis_address\":\"中国陕西省西安市雁塔区高新六路\",\"e_id\":\"0\"},{\"order_id\":\"1906050014\",\"opt_date_text\":\"2019-06-05 15:48\",\"date10_text\":\"2019-06-05 15:48\",\"date20_text\":\"2019-06-05 17:16:08\",\"status\":20,\"status_name\":\"已接单\",\"status_color\":\"#007ded\",\"order_code\":\"1906050014\",\"consignee_name\":\"李三思\",\"consignee_phone\":\"18091512046\",\"shipper_id\":30,\"shipper_name\":\"蒙牛乳业液体奶塞北\",\"shipper_name_full\":\"蒙牛乳业液体奶塞北事业部\",\"start_area\":\"610101\",\"end_area\":\"610102\",\"end_full_name\":\"陕西省西安市新城区\",\"end_area_name\":\"陕西省西安市新城区人民路\",\"car_code\":\"\",\"e_id\":\"0\"},{\"order_id\":\"1906060033\",\"opt_date_text\":\"2019-06-06 15:50\",\"date10_text\":\"2019-06-06 15:50\",\"date20_text\":\"2019-06-06 16:02:20\",\"status\":25,\"status_name\":\"已到厂\",\"status_color\":\"#007ded\",\"order_code\":\"1906060033\",\"consignee_name\":\"刘宇\",\"consignee_phone\":\"18948789369\",\"shipper_id\":30,\"shipper_name\":\"蒙牛乳业液体奶塞北\",\"shipper_name_full\":\"蒙牛乳业液体奶塞北事业部\",\"start_area\":\"150102\",\"start_full_name\":\"内蒙古呼和浩特市新城区\",\"start_area_name\":\"内蒙古呼和浩特市新城区柳沟村132号\",\"end_area\":\"610402\",\"end_full_name\":\"陕西省咸阳市秦都区\",\"end_area_name\":\"陕西省咸阳市秦都区秦都大道103号\",\"car_code\":\"陕KA7996\",\"driver_id\":25,\"driver_name\":\"郭峰\",\"link_mobile\":\"13066915121\",\"gis_lng\":108.884090,\"gis_lat\":34.237553,\"gis_address\":\"中国陕西省西安市雁塔区高新六路\",\"e_id\":\"0\"},{\"order_id\":\"1906060013\",\"opt_date_text\":\"2019-06-06 11:29\",\"date10_text\":\"2019-06-06 11:29\",\"date20_text\":\"2019-06-06 11:30:52\",\"status\":25,\"status_name\":\"已到厂\",\"status_color\":\"#007ded\",\"order_code\":\"1906060013\",\"consignee_name\":\"刘宇飞\",\"consignee_phone\":\"18948789369\",\"shipper_id\":30,\"shipper_name\":\"蒙牛乳业液体奶塞北\",\"shipper_name_full\":\"蒙牛乳业液体奶塞北事业部\",\"start_area\":\"150102\",\"start_full_name\":\"内蒙古呼和浩特市新城区\",\"start_area_name\":\"内蒙古呼和浩特市新城区柳沟村132号\",\"end_area\":\"610404\",\"end_full_name\":\"陕西省咸阳市渭城区\",\"end_area_name\":\"陕西省咸阳市渭城区秦都大道103号\",\"car_code\":\"冀A8970W\",\"driver_id\":94,\"driver_name\":\"李昌平\",\"link_mobile\":\"18995263321\",\"gis_lng\":108.884165,\"gis_lat\":34.237813,\"gis_address\":\"中国陕西省西安市雁塔区唐兴路108号\",\"e_id\":\"0\"},{\"order_id\":\"1906060043\",\"opt_date_text\":\"2019-06-06 16:19\",\"date10_text\":\"2019-06-06 16:19\",\"date20_text\":\"2019-06-06 16:21:05\",\"status\":30,\"status_name\":\"在途\",\"status_color\":\"#e95200\",\"order_code\":\"1906060043\",\"consignee_name\":\"王宇\",\"consignee_phone\":\"18563265441\",\"shipper_id\":32,\"shipper_name\":\"中粮可口可乐（陕西）饮料有限公司\",\"shipper_name_full\":\"中粮可口可乐（陕西）饮料有限公司\",\"start_area\":\"610116\",\"start_full_name\":\"陕西省西安市长安区\",\"start_area_name\":\"陕西省西安市长安区长安大道165号\",\"end_area\":\"150204\",\"end_full_name\":\"内蒙古包头市青山区\",\"end_area_name\":\"内蒙古包头市青山区柳巷街道132号\",\"car_code\":\"陕K11111\",\"driver_id\":112,\"driver_name\":\"淮磊\",\"link_mobile\":\"19000000000\",\"e_id\":\"0\"},{\"order_id\":\"1906060009\",\"opt_date_text\":\"2019-06-06 11:07\",\"date10_text\":\"2019-06-06 11:07\",\"date20_text\":\"2019-06-06 11:32:25\",\"status\":30,\"status_name\":\"在途\",\"status_color\":\"#e95200\",\"order_code\":\"1906060009\",\"consignee_name\":\"李磊\",\"consignee_phone\":\"18717166480\",\"shipper_id\":29,\"shipper_name\":\" 中粮可口可乐\",\"shipper_name_full\":\"  中粮可口可乐（内蒙古）饮料有限公司\",\"start_area\":\"150402\",\"start_full_name\":\"内蒙古赤峰市红山区\",\"start_area_name\":\"内蒙古赤峰市红山区南关163号\",\"end_area\":\"610525\",\"end_full_name\":\"陕西省渭南市澄城县\",\"end_area_name\":\"陕西省渭南市澄城县大汝公路\",\"car_code\":\"陕A87678\",\"driver_id\":70,\"driver_name\":\"李浩\",\"link_mobile\":\"13322222222\",\"gis_lng\":108.884128,\"gis_lat\":34.237782,\"gis_address\":\"中国陕西省西安市雁塔区唐兴路108号\",\"e_id\":\"1906060009\"},{\"order_id\":\"1906060002\",\"opt_date_text\":\"2019-06-06 09:12\",\"date10_text\":\"2019-06-06 09:12\",\"date20_text\":\"2019-06-06 10:22:01\",\"status\":30,\"status_name\":\"在途\",\"status_color\":\"#e95200\",\"order_code\":\"1906060002\",\"consignee_name\":\"李三思\",\"consignee_phone\":\"18091512046\",\"shipper_id\":30,\"shipper_name\":\"蒙牛乳业液体奶塞北\",\"shipper_name_full\":\"蒙牛乳业液体奶塞北事业部\",\"start_area\":\"150102\",\"start_full_name\":\"内蒙古呼和浩特市新城区\",\"start_area_name\":\"内蒙古呼和浩特市新城区柳沟村132号\",\"end_area\":\"610102\",\"end_full_name\":\"陕西省西安市新城区\",\"end_area_name\":\"陕西省西安市新城区人民路\",\"car_code\":\"陕KC5878\",\"driver_id\":9,\"driver_name\":\"曹鸿喜\",\"link_mobile\":\"13353268566\",\"gis_lng\":108.883906,\"gis_lat\":34.237737,\"gis_address\":\"中国陕西省西安市雁塔区高新六路\",\"e_id\":\"0\"}],\"total\":11}] as \"text/plain\" using [org.springframework.http.converter.StringHttpMessageConverter@7fc50fd0]\n" +
                "10:35:06.013 [http-bio-8083-exec-2] DEBUG o.s.web.servlet.DispatcherServlet - Null ModelAndView returned to DispatcherServlet with name 'springServlet': assuming HandlerAdapter completed request handling\n" +
                "10:35:06.013 [http-bio-8083-exec-2] DEBUG c.v.c.u.interceptor.LogInterceptor - 计时结束：10:35:06.013  耗时：0:0:0.57  URI: /xy-tms/wayMonitor/getDataList  最大内存: 1787m  已分配内存: 684m  已分配内存中的剩余空间: 256m  最大可用内存: 1359m\n" +
                "10:35:06.013 [http-bio-8083-exec-2] DEBUG o.s.web.servlet.DispatcherServlet - Successfully completed request";
        long start = System.currentTimeMillis();
        System.out.println(reverse1(str));
        System.out.println("递归：" + (new Date().getTime() - start));

        start = System.currentTimeMillis();
        System.out.println(reverse2(str));
        System.out.println("charAt逆序遍历：" + (new Date().getTime() - start));

        start = System.currentTimeMillis();
        System.out.println(reverse3(str));
        System.out.println("char数组逆序遍历：" + (new Date().getTime() - start));

        start = System.currentTimeMillis();
        System.out.println(reverse4(str));
        System.out.println("StringBuffer/Builder自带方法：" + (new Date().getTime() - start));

        start = System.currentTimeMillis();
        System.out.println(reverse5(str));
        System.out.println("char数组首尾对调：" + (new Date().getTime() - start));

        start = System.currentTimeMillis();
        System.out.println(reverse6(str));
        System.out.println("char数组首尾对调异或：" + (new Date().getTime() - start));

        start = System.currentTimeMillis();
        System.out.println(reverse7(str));
        System.out.println("char数组进出栈：" + (new Date().getTime() - start));
    }

    /**
     * 递归
     *
     * @param str
     * @return
     */
    private static String reverse1(String str) {
        if (str.length() <= 1) {
            return str;
        }
        String left = str.substring(0, str.length() / 2);
        String right = str.substring(str.length() / 2, str.length());
        return reverse1(right) + reverse1(left);
    }


    /**
     * charAt遍历拼接
     * @param str
     * @return
     */
    private static String reverse2(String str) {
        String reverse = "";
        for (int i = str.length()-1; i >= 0; i--){
            reverse += str.charAt(i);
        }
        return reverse;
    }

    /**
     * 和第二个方法类似，要快一点，因为不用调用方法
     * @param str
     * @return
     */
    private static String reverse3(String str){
        char[] chs = str.toCharArray();
        String reverse = "";
        for (int i = chs.length - 1; i >=0; i--){
            reverse += chs[i];
        }
        return reverse;
    }

    /**
     * 强烈推荐，速度最快，写法最简单
     * @param str
     * @return
     */
    private static String reverse4(String str){
        return new StringBuffer(str).reverse().toString();
    }

    /**
     * 3的改进，数组首尾对调，也不错
     * @param str
     * @return
     */
    private static String reverse5(String str){
        char[] chs = str.toCharArray();
        int n = chs.length -1;
        int middle = chs.length / 2;
        for (int i = 0; i < middle; i++ ){
            char temp = chs[i];
            chs[i] = chs[n - i];
            chs[n-i] = temp;
        }
        return new String(chs);
    }

    /**
     * 和上面5类似，原先的首尾交换转为数字异或交换
     * @param str
     * @return
     */
    private static String reverse6(String str){
        char[] chs = str.toCharArray();
        int begin = 0;
        int end = chs.length - 1;
        while (begin < end){
            chs[begin] = (char) (chs[begin]^chs[end]);
            chs[end] = (char) (chs[begin]^chs[end]);
            chs[begin] = (char) (chs[begin]^chs[end]);
            begin++;
            end--;
        }
        return new String(chs);
    }

    /**
     * 比较慢，涉及拆装箱，数据结构
     * @param str
     * @return
     */
    private static String reverse7(String str){
        char[] chs = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c:chs){
            stack.push(c);
        }
        String reverse = "";
        for(char c:chs){
            reverse += stack.pop();
        }
        return reverse;
    }
}
