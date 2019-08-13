package framework.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/*****************************************************************************
 * @className: JobA$
 * @date : 2019/8/12$ 18:49$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class JobA implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //可以用来传值
        System.out.println(jobExecutionContext.getJobDetail().getKey());
        System.out.println(jobExecutionContext.getJobDetail().getJobDataMap().get("id"));
        System.out.println(jobExecutionContext.getJobDetail().getJobDataMap().get("name"));
        System.out.println(jobExecutionContext.getTrigger().getJobDataMap().get("sex"));
        System.out.println("-------------------------------------------------------------");
    }
}
