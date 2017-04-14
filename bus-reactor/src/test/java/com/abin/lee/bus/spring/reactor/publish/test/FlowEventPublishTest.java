package com.abin.lee.bus.spring.reactor.publish.test;

import com.abin.lee.bus.common.util.JsonUtil;
import com.abin.lee.bus.spring.reactor.event.FlowEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.UnicastProcessor;
import reactor.util.function.Tuple2;

import java.time.Duration;

/**
 * Created by abin on 2017/4/14 14:14.
 * bus-svr
 * com.abin.lee.bus.spring.reactor.publish.test
 */
public class FlowEventPublishTest {
    public static void main(String[] args) {

        UnicastProcessor<FlowEvent> hotSource = UnicastProcessor.create();

        Flux<FlowEvent> hotFlux = hotSource.publish()
                .autoConnect()
                .retry();

        FlowEvent flowEvent = new FlowEvent();
        flowEvent.setValue("lee");

        hotSource.onNext(flowEvent);

        hotFlux.subscribe(d -> System.out.println("Subscriber 1 to Hot Source: "+d));


        hotSource.onComplete();
    }
}
