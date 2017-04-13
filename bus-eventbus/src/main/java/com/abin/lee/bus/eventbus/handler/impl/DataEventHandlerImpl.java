package com.abin.lee.bus.eventbus.handler.impl;

import com.abin.lee.bus.common.util.JsonUtil;
import com.abin.lee.bus.eventbus.event.DataEvent;
import com.abin.lee.bus.eventbus.handler.DataEventHandler;
import com.google.common.eventbus.Subscribe;

/**
 * Created by abin on 2017/4/14 2017/4/14.
 * bus-svr
 * com.abin.lee.bus.eventbus.handler.impl
 */
public class DataEventHandlerImpl implements DataEventHandler {

    @Subscribe
    public void subscribeEvent(DataEvent event){
        System.out.println("event="+ JsonUtil.toJson(event));
    }


}
