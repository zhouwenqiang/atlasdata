package com.atlas.service;


import com.atlas.entity.Terminal;
import java.text.ParseException;

/**
 * Created by Administrator on 2018/4/9.
 */
public interface ScheduledService {
    public void httpGetTerminalEquipment(boolean ishour);
    public Terminal terminal(String modelCode,boolean ishour) throws ParseException;
}
