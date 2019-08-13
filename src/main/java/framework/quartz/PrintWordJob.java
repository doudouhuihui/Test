package framework.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/*****************************************************************************
 * @className: PrintWordJob$
 * @date : 2019/8/12$ 14:45$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class PrintWordJob implements Job {
    static int count;
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String jobDetailStr = jobExecutionContext.getJobDetail().toString();
        System.out.println("这是第"+(++count)+"次执行任务！"+jobDetailStr);
    }
}
