package com.abin.lee.bus.eventbus.handler;

import com.abin.lee.bus.common.util.JsonUtil;
import com.abin.lee.bus.eventbus.event.DataEvent;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

/**
 * Created by abin on 2017/4/13 2017/4/13.
 * bus-svr
 * com.abin.lee.bus.eventbus.handler
 */
public interface DataEventHandler {

    @AllowConcurrentEvents
    void subscribeEvent(DataEvent event);


}
