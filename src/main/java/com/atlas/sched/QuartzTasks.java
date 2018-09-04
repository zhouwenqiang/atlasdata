package com.atlas.sched;

import com.atlas.service.ScheduledService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Administrator on 2018/4/10.
 */
@Configuration
@Component
@EnableScheduling
public class QuartzTasks {
    private static final Logger LOGGER =  LoggerFactory.getLogger(QuartzTasks.class);
    @Autowired
    private ScheduledService scheduledService;

    public void sayHello(){
        LOGGER.info("开始执行TerminalCron任务时间:{}",new Date());
        scheduledService.httpGetTerminalEquipment(false);
        LOGGER.info("结束执行TerminalCron任务时间:{}",new Date());

    }


}

