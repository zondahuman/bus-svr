package com.abin.lee.bus.disruptor.factory;

import com.abin.lee.bus.disruptor.event.BusEvent;
import com.lmax.disruptor.EventFactory;

/**
 * Created by abin on 2017/4/13 19:28.
 * bus-svr
 * com.abin.lee.bus.disruptor.factory
 */
public class BusEventFactory implements EventFactory<BusEvent> {


    public BusEvent newInstance() {
        return new BusEvent();
    }
    
}
