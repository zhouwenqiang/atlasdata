package com.atlas.runner;

import com.atlas.service.ScheduledService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Administrator on 2018/4/9.
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {
    private Logger logger = LoggerFactory.getLogger(MyApplicationRunner.class);

    @Autowired
    private ScheduledService scheduledService;
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        /*logger.info("系统启动时触发：{}", applicationArguments);
        logger.info("系统启动时触发开始执行TerminalCron任务时间:{}",new Date());
        //scheduledService.httpGetTerminalEquipment(false);
        logger.info("系统启动时触发结束执行TerminalCron任务时间:{}", new Date());*/
    }
}
