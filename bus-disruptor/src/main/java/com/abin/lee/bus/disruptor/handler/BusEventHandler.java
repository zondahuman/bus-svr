package com.abin.lee.bus.disruptor.handler;

import com.abin.lee.bus.common.util.JsonUtil;
import com.abin.lee.bus.disruptor.event.BusEvent;
import com.lmax.disruptor.EventHandler;

/**
 * Created by abin on 2017/4/13 2017/4/13.
 * bus-svr
 * com.abin.lee.bus.disruptor.handler
 */
public class BusEventHandler implements EventHandler<BusEvent> {

    public void onEvent(BusEvent busEvent, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("busEvent="+ JsonUtil.toJson(busEvent)+",sequence="+sequence+",endOfBatch="+endOfBatch);
    }

}
