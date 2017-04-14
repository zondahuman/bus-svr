package com.abin.lee.bus.eventbus.producer;

import com.abin.lee.bus.eventbus.event.DataEvent;
import com.abin.lee.bus.eventbus.handler.DataEventHandler;
import com.abin.lee.bus.eventbus.handler.impl.DataEventHandlerImpl;
import com.google.common.eventbus.EventBus;

/**
 * Created by abin on 2017/4/13 2017/4/13.
 * bus-svr
 * com.abin.lee.bus.eventbus.producer
 */
public class DataEventProducer {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();

        eventBus.register(new DataEventHandlerImpl());

        DataEvent dataEvent = new DataEvent();
        dataEvent.setValue("lee");
        eventBus.post(dataEvent);
    }

}
