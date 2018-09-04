package com.atlas.sched;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.atlas.entity.Terminal;
import com.atlas.entity.TerminalBoss;
import com.atlas.entity.TerminalEquipment;
import com.atlas.service.ScheduledService;
import com.atlas.service.TerminalBossService;
import com.atlas.service.TerminalEquipmentService;
import com.atlas.service.YdCarInfoService;
import com.atlas.util.DateUtils;
import com.atlas.util.HttpUtils;
import com.atlas.util.IMEI_INFO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/3/30.
 */
@Component
public class ScheduledTasks implements SchedulingConfigurer {
    private Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        logger.info("----------多线执行任务----------");
        scheduledTaskRegistrar.setScheduler(Executors.newScheduledThreadPool(10));
    }

    @Autowired
    private ScheduledService scheduledService;

    //@Scheduled(cron = "10 0/30 * * * ?")
    public void TerminalCron() {
        logger.info("开始执行TerminalCron任务时间:{}",new Date());
        scheduledService.httpGetTerminalEquipment(true);
        logger.info("结束执行TerminalCron任务时间:{}",new Date());
    }
}
