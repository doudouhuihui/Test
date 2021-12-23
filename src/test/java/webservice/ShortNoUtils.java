package webservice;

import com.ai.appframe2.complex.center.CenterFactory;
import com.ai.common.csf.CsfCaller;
import com.alibaba.fastjson.JSON;
//import com.asiainfo.crm.so.util.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 档次	   号码类型
 * 特等	   AAAAAA，AAAAA，6666，8888，9999，ABCDEF
 * 第一档	   AAAA(A≠6、8、9），666，888，999，AAABBB（不带4）
 * 第二档	   AAA(A≠6、8、9、4），AAABBB（带4），AABBCC（不带4），ABABAB（不带4），ABCABC（不带4），ABCDE
 * 第三档	   AAA（A=4），AABBCC（带4），ABABAB（带4），ABCABC（带4），AA88
 * 第四档	   AABB，ABAB，88，ABCD
 * 第五档	   其他号码
 */
public final class ShortNoUtils {
    public static void main(String[] args) {
        //
        String shortNo = "254666"; //330567

//        System.out.println(checkContinue(shortNo, "AAABBB"));
        // shortNo = "101234";
        System.out.println(shortNo + "-----" + getLevelByShortNo(shortNo).getValue());
//        System.out.println(checkLv0_2(shortNo));
//        System.out.println(checkLv0_4(shortNo));
//        System.out.println("-----------------");
//        System.out.println(ifABC("0234"));
//        System.out.println(ifCBA("3210"));
        System.out.println(Long.MAX_VALUE);
        System.out.println("33001656349058012001");
        System.out.println("33001656349058012001".matches("\\d{6,20}"));

    }
    public enum LevelEnum{
        LV0("0"),
        LV1("1"),
        LV2("2"),
        LV3("3"),
        LV4("4"),
        LV5("5");
        private String value;
        LevelEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    private ShortNoUtils(){}

    private static transient final Log log = LogFactory.getLog(ShortNoUtils.class);

    private static String[] badArr = {"4", "444"};  //带4的不好数字
    private static String[][] regArr = new String[][]{
            { //特等档
                    "(\\d)(\\1){5}",//AAAAAA
                    "\\d?(\\d)(\\1){4}", //AAAAA
                    "\\d{0,2}6666",  //6666
                    "\\d{0,2}8888",  //8888
                    "\\d{0,2}9999"  //9999
            },
            { //第一档
                    "\\d{0,2}(\\d)(\\1){3}", //AAAA
                    "\\d{0,3}666",  //666
                    "\\d{0,3}888",  //888
                    "\\d{0,3}999",  //999
                    "(\\d)(\\1){2}(\\d)(\\3){2}" //AAABBB
            },
            { //第二档
                    "\\d{0,3}(\\d)(\\1){2}", //AAA
                    "(\\d)(\\1){2}(\\d)(\\3){2}",  //AAABBB
                    "(\\d)\\1(\\d)\\2(\\d)\\3",  //AABBCC
                    "(\\d)(\\d)\\1\\2\\1\\2",  //ABABAB
                    "(\\d)(\\d)(\\d)\\1\\2\\3"  //ABCABC
            },
            { //第三档
                    "\\d{0,3}444",  //444
                    "(\\d)\\1(\\d)\\2(\\d)\\3",  //AABBCC
                    "(\\d)(\\d)\\1\\2\\1\\2",  //ABABAB
                    "(\\d)(\\d)(\\d)\\1\\2\\3",  //ABCABC
                    "\\d{0,2}(\\d)\\188"  //AA88
            },
            { //第四档
                    "\\d{0,2}(\\d)\\1(\\d)\\2", //AABB
                    "\\d{0,2}(\\d)(\\d)\\1\\2",  //ABAB
                    "\\d{0,4}(\\d)(\\1){1}" //AA
            }
    };

    private static String AAABBB = "AAABBB";
    private static String AABBCC = "AABBCC";
    private static String ABCABC = "ABCABC";
    private static String ABABAB = "ABABAB";
    private static String AABB = "AABB";
    private static String ABAB = "ABAB";

    /**
     * 判断是否是特等档到第二档
     * @param shortNo 短号
     * @return boolean 是 否
     */
    public static boolean checkLv0_2(String shortNo) {
        LevelEnum lv = getLevelByShortNo(shortNo);
        return LevelEnum.LV0 == lv || LevelEnum.LV1 == lv || LevelEnum.LV2 == lv;
    }

    /**
     * 判断是否是特等档到第四档
     * @param shortNo 短号
     * @return boolean 是 否
     */
    public static boolean checkLv0_4(String shortNo) {
        LevelEnum lv = getLevelByShortNo(shortNo);
        return LevelEnum.LV0 == lv || LevelEnum.LV1 == lv || LevelEnum.LV2 == lv
                || LevelEnum.LV3 == lv || LevelEnum.LV4 == lv;
    }

    /**
     * 判断递增/递减
     * @param shortNo 短号
     * @param type 类型
     * @return
     */
    private static boolean checkContinue(String shortNo, String type){
        String a = shortNo.substring(0, 1) , b , c ;
        int length = shortNo.length();
        String checkStr = "0";
        if (type.equals(AAABBB) || type.equals(ABABAB) || type.equals(ABAB) || type.equals(AABB)){
            b = shortNo.substring(length - 1, length);
            checkStr = a + b;

        } else if (type.equals(AABBCC)) {
            b = shortNo.substring(2, 3);
            c = shortNo.substring(length - 1, length);
            checkStr = a + b + c;
        } else if (type.equals(ABCABC)) {
            b = shortNo.substring(1,2);
            c = shortNo.substring(length - 1, length);
            checkStr = a + b + c;
        }
        return ifABC(checkStr) || ifCBA(checkStr);
    }


    /**
     * 根据短号判断第几档
     * @param shortNo 短号
     * @return str(0特等，1一等 2二等，3三等，4四等，5五等)
     */
    public static LevelEnum getLevelByShortNo(String shortNo) {
        if (log.isDebugEnabled()) {
            log.debug("传入的短号为：" + shortNo);
        }
        //============level 1=============
        for (String regex : regArr[0]) {
            if (shortNo.matches(regex)) {
                return LevelEnum.LV0;
            }
        }
        //ABCDEF
        if(checkLH(shortNo)) {
            return LevelEnum.LV0;
        }
        //============level 2=============
        for (int i = 0; i < regArr[1].length; i++) {
            if (shortNo.matches(regArr[1][i]) && i != regArr[1].length - 1) {
                return LevelEnum.LV1;
            }
            if (shortNo.matches(regArr[1][regArr[1].length - 1]) && !shortNo.contains(badArr[0]) && checkContinue(shortNo, AAABBB)) {
                return LevelEnum.LV1;
            }
        }
        //============level 3=============
        for (int i = 0; i < regArr[2].length; i++) {
            if (i == 0 && shortNo.matches(regArr[2][i]) && !shortNo.contains(badArr[1])) {
                return LevelEnum.LV2;
            }
            if (i == 1 && shortNo.matches(regArr[2][i]) && shortNo.contains(badArr[1]) && checkContinue(shortNo, AAABBB)) {
                return LevelEnum.LV2;
            }
            if (i == 2 && shortNo.matches(regArr[2][i]) && !shortNo.contains(badArr[0]) && checkContinue(shortNo, AABBCC)) {
                return LevelEnum.LV2;
            }
            if (i == 3 && shortNo.matches(regArr[2][i]) && !shortNo.contains(badArr[0]) && checkContinue(shortNo, ABABAB)) {
                return LevelEnum.LV2;
            }
            if (i == 4 && shortNo.matches(regArr[2][i]) && !shortNo.contains(badArr[0]) && checkContinue(shortNo, ABCABC)) {
                return LevelEnum.LV2;
            }
        }
        //ABCDE
        String tempNo = shortNo.substring(1);
        if(checkLH(tempNo)) {
            return LevelEnum.LV2;
        }
//        tempNo = shortNo.substring(0, shortNo.length() - 1);
//        if(checkLH(tempNo)) {
//            return LevelEnum.LV2;
//        }
        //============level 3=============
        for (int i = 0; i < regArr[3].length; i++) {
            if ((i == 0 || i == regArr[3].length - 1) && shortNo.matches(regArr[3][i])) {
                return LevelEnum.LV3;
            }
            if (shortNo.matches(regArr[3][i]) && shortNo.contains(badArr[0])) {
                if (i == 1 && checkContinue(shortNo, AABBCC))
                    return LevelEnum.LV3;
                if (i == 2 && checkContinue(shortNo, ABABAB))
                    return LevelEnum.LV3;
                if (i == 3 && checkContinue(shortNo, ABCABC))
                    return LevelEnum.LV3;

            }
        }
        //============level 4=============
        for (int i = 0; i < regArr[4].length; i++) {
            if (shortNo.matches(regArr[4][i])) {
                if (i == 0 && checkContinue(shortNo, AABB)) {
                    return LevelEnum.LV4;
                }
                if (i == 1 && checkContinue(shortNo, ABAB)) {
                    return LevelEnum.LV4;
                }
                if (i == 2){
                    return LevelEnum.LV4;
                }
            }
        }
        //ABCD
        tempNo = shortNo.substring(2);
        if(checkLH(tempNo)) {
            return LevelEnum.LV4;
        }
//        tempNo = shortNo.substring(0, shortNo.length() - 2);
//        if(checkLH(tempNo)) {
//            return LevelEnum.LV4;
//        }
//        tempNo = shortNo.substring(1, shortNo.length() - 1);
//        if(checkLH(tempNo)) {
//            return LevelEnum.LV4;
//        }
        //============level 5=============
        return LevelEnum.LV5;
    }

    /**
     * 检查是否连号
     * @param shortNo  短号
     * @return boolean
     */
    private static boolean checkLH(String shortNo) {
        return ifABC(shortNo) || ifCBA(shortNo);
    }

    /**
     * 判断数字递增连号
     * @param shortNo 短号
     * @return Boolean
     */
    private static boolean ifABC(String shortNo) {
        if (shortNo.startsWith("0") && !shortNo.startsWith("01")) {  //防止0234误判
            return false;
        }
        int no = Integer.parseInt(shortNo);
        while (no > 0) {
//            int m = no % 10 == 0 ? 10 : no % 10;             //678901
            int m = no % 10 ;                                  //345678
            if ((no > 9) && m - 1 != (no / 10 % 10)){ break;}
            no = no /10;
        }
        return no == 0 ;
    }
    /**
     * 判断数字递减连号
     * @param shortNo 短号
     * @return Boolean
     */
    private static boolean ifCBA(String shortNo) {
        if (shortNo.startsWith("0")) {  //防止0654误判
            return false;
        }
        int no = Integer.parseInt(shortNo);
        while (no > 0) {
            int m = no % 10 ;
            if ((no > 9) && m + 1 != (no / 10 % 10)){ break;}
            no = no /10;
        }
        return no == 0 ;
    }

    /**
     * 调用接口查询是否有调拨记录
     * @return boolean
     */
    public static boolean isAllocate(String vpmnGroupId, String shortNum, String orgId) throws Exception {

        HashMap reqMap = new HashMap(8);
        reqMap.put("VPMN_GROUP_ID",vpmnGroupId);
        reqMap.put("REGION_ID", CenterFactory.getCenterInfo().getRegion());
        reqMap.put("ORG_ID", orgId);
        reqMap.put("START_NUM",shortNum);
        reqMap.put("END_NUM", shortNum);
        reqMap.put("ALLOCATE_STATE","1");
        reqMap.put("ORDER_STATE","1");
        reqMap.put("START_PAGE","1");
        reqMap.put("END_PAGE","1");
        if(log.isDebugEnabled()) {
            log.debug("开始调用CSF接口---------res_ISQryResShortNumInfoCSV_getAllocaationNotes 入参：" + JSON.toJSONString(reqMap));
        }
        String res = CsfCaller.call(String.class, "res_ISQryResShortNumInfoCSV_getAllocaationNotes" , JSON.toJSONString(reqMap));
        if(log.isDebugEnabled()){
            log.debug("调用CSF接口---------res_ISQryResShortNumInfoCSV_getAllocaationNotes---------成功! 出参：" + res);
        }

        if (StringUtils.isNotBlank(res)) {
            Map resMap = (Map) JSON.parse(res);
            if (resMap != null) {
                Map busiMap = (Map) resMap.get("busiInfo");
                List list = busiMap != null ? (List) busiMap.get("vpmnShortNumInfo") : new ArrayList();
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        Map<String, String> shortMap = (Map)list.get(i);
                        SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String expireDate = shortMap.get("expireDate");
                        String effectiveDate = shortMap.get("effectiveDate");
//                        boolean effective = DateUtil.isBetween(sdfs.parse(effectiveDate), sdfs.parse(expireDate));
//                        return effective;
                    }
                }
            }

        }
        return false;
    }

    /**
     * 获取当前组织虚拟网集团下的所有调拨成功的短号
     * @return
     */
    public static Set getAllocateShortNum(String vpmnGroupId, String orgId) throws Exception {
        HashMap reqMap = new HashMap(8);
        reqMap.put("VPMN_GROUP_ID",vpmnGroupId);
        reqMap.put("REGION_ID", CenterFactory.getCenterInfo().getRegion());
        reqMap.put("ORG_ID", orgId);
        reqMap.put("ALLOCATE_STATE","1");
        reqMap.put("ORDER_STATE","1");
        reqMap.put("START_PAGE","1");
        reqMap.put("END_PAGE","99");
        if(log.isDebugEnabled()) {
            log.debug("开始调用CSF接口---------res_ISQryResShortNumInfoCSV_getAllocaationNotes 入参：" + JSON.toJSONString(reqMap));
        }
        String res = CsfCaller.call(String.class, "res_ISQryResShortNumInfoCSV_getAllocaationNotes" , JSON.toJSONString(reqMap));
        if(log.isDebugEnabled()){
            log.debug("调用CSF接口---------res_ISQryResShortNumInfoCSV_getAllocaationNotes---------成功! 出参：" + res);
        }
        Set<String> shortSet = new HashSet();

        if (StringUtils.isNotBlank(res)) {
            Map resMap = (Map) JSON.parse(res);
            if (resMap != null) {
                Map busiMap = (Map) resMap.get("busiInfo");
                List list = busiMap != null ? (List) busiMap.get("vpmnShortNumInfo") : new ArrayList();
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        Map<String, String> shortMap = (Map)list.get(i);
                        SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String expireDate = shortMap.get("expireDate");
                        String effectiveDate = shortMap.get("effectiveDate");
//                        if(DateUtil.isBetween(sdfs.parse(effectiveDate), sdfs.parse(expireDate))) {
//                            shortSet.add(shortMap.get("shortNum"));
//                        }
                    }
                }
            }

        }
        return shortSet;
    }
}

