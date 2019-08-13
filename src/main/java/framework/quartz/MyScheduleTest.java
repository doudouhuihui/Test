package framework.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.HolidayCalendar;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/*****************************************************************************
 * @className: MyScheduleTest$
 * @date : 2019/8/12$ 14:47$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class MyScheduleTest {
    public static void main(String[] args) throws InterruptedException, SchedulerException {
            //demo();
            //schedule();
        //cronTest();


    }

    /**
     * [简单使用定时任务]
     * @Author: 陈伟振 (chenweizhen@vvise.com)
     * @Date: 2019/8/13 14:05
     * @throws SchedulerException
     * @throws InterruptedException
     */
    public static void demo() throws SchedulerException, InterruptedException{
        //通过调度工厂获取调度器，stdSchedulerFactory()
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();
        //创建job实例，通过JobBuilder绑定，并声明任务名称和组
        JobDetail jobDetail = JobBuilder.newJob(PrintWordJob.class).withIdentity("printWord", "group1").build();
        //创建触发器，通过TriggerBuilder，并声明触发器名称和组，立即执行，通过简单调度器每秒一次,永远执行下去
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("printTrigger", "triggerGroup1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever())
                .build();
        //把job和触发器绑定
        scheduler.scheduleJob(jobDetail, trigger);
        System.out.println("定时任务开始执行");
        //正式执行
        scheduler.start();

        //主线程睡眠1分钟
        TimeUnit.MINUTES.sleep(1);
        scheduler.shutdown();
        System.out.println("定时任务执行完毕");
    }


    /**
     * [3秒后开始执行，执行3秒后结束]
     * @Author: 陈伟振 (chenweizhen@vvise.com)
     * @Date: 2019/8/13 14:03
     * @throws SchedulerException
     * @throws InterruptedException
     */
    public static void schedule() throws SchedulerException, InterruptedException {

        Date startDate = new Date();
        startDate.setTime(startDate.getTime()+3000);

        Date endDate = new Date();
        endDate.setTime(startDate.getTime()+3000);

        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();

        JobDetail jobDetail = JobBuilder.newJob(JobA.class)
                .withIdentity("job1","group1")
                .usingJobData("id",1)
                .usingJobData("name","chenwz")
                .build();


        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1","group1")
                .usingJobData("sex","man")
                .startNow()
                .startAt(startDate)
                .endAt(endDate)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever())
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();

    }

    /**
     * [cron表达式]
     * @Author: 陈伟振 (chenweizhen@vvise.com)
     * @Date: 2019/8/13 14:04
     * @throws SchedulerException
     */
    public static void cronTest() throws SchedulerException {
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();

        //
        //HolidayCalendar holidayCalendar = new HolidayCalendar();
        //holidayCalendar.addExcludedDate(new Date());
        //scheduler.addCalendar("holiday", holidayCalendar, false,false);

        JobDetail jobDetail = JobBuilder.newJob(JobA.class).withIdentity("job1","group1").build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 30 19 ? * * 2019"))
                //.modifiedByCalendar("holiday")  排除掉某个日期
                .build();


        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();

    }
}
