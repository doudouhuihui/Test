package multithread;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/*****************************************************************************
 * @className: MyAQSTest.java
 * @date : 2020-04-17 16:38
 * @author : 樊玺   (fanxi@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class MyAQSTest extends AbstractQueuedSynchronizer {
    public int a(){
        return getState();
    }
}
