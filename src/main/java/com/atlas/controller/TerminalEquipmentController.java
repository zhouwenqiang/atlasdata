package com.atlas.controller;

import com.atlas.entity.*;
import com.atlas.service.TerminalEquipmentService;
import com.atlas.service.YdCarInfoService;
import com.atlas.service.YdCarService;
import com.atlas.service.YdCarTerminalService;
import com.atlas.util.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;
import java.util.Date;

/**
 * Created by Administrator on 2018/3/22.
 */
@RestController
@RequestMapping("/terminalequipment")
public class TerminalEquipmentController {

    @Autowired
    private TerminalEquipmentService terminalEquipmentService;


    @Autowired
    private Environment env;

    @RequestMapping(value = "/index",produces = "text/plain;charset=UTF-8")
    public String index(){
        return "Hello Spring Boot!";
    }

    @RequestMapping(value="/insert" , method = RequestMethod.GET)
    public String insert(TerminalEquipment terminalEquipment){
       String mestr="";
        return mestr;
    }
}
