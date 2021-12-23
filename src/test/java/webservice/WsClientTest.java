package webservice;

import cn.aa.*;

public class WsClientTest {



    public static void main(String[] args) {
        MobileCodeWS mobileCodeWs=new MobileCodeWS();
        MobileCodeWSSoap mobileCodeWSSoap=mobileCodeWs.getMobileCodeWSSoap();
        String tel=mobileCodeWSSoap.getMobileCodeInfo("15760585377",null);
        System.out.println(tel);
    }
}
