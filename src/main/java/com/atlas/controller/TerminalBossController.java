package com.atlas.controller;

import com.atlas.entity.TerminalBoss;
import com.atlas.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by Administrator on 2018/3/22.
 */
@RestController
@RequestMapping("/tboss")
public class TerminalBossController {
    private Logger logger = LoggerFactory.getLogger(TerminalBossController.class);
    @Autowired
    private TerminalBossService terminalBossService;


    @RequestMapping(value = "/index",produces = "text/plain;charset=UTF-8")
    public String index(){
        return "Hello Spring Boot!";
    }

    @RequestMapping(value="/insert/{imei}" , method = RequestMethod.GET)
    public String insert(@PathVariable String imei ) {
        TerminalBoss terminalBoss=new TerminalBoss();
        terminalBoss.setCreateDate(new Date());
        terminalBoss.setTerminalCode("11");
        terminalBoss.setInsertstate(0);
        terminalBoss.setRemarks("测试 ");
        int a = terminalBossService.insert(terminalBoss);
        return  "成功" ;
    }
}
