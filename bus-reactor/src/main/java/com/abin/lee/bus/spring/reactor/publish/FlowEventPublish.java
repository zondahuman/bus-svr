package com.abin.lee.bus.spring.reactor.publish;

import com.abin.lee.bus.common.util.JsonUtil;
import com.abin.lee.bus.spring.reactor.event.FlowEvent;
import org.reactivestreams.Publisher;
import reactor.bus.Event;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by abin on 2017/4/14 11:49.
 * bus-svr
 * com.abin.lee.bus.spring.reactor.publish
 */
public class FlowEventPublish {


    public static void main(String[] args) {

        Flux<String> fewWords = Flux.just("Hello", "World");
        fewWords.subscribe(System.out::println);


        FlowEvent flowEvent = new FlowEvent();
        flowEvent.setValue("lee");
        Flux<FlowEvent> flowEventFlex = Flux.just(flowEvent);
        flowEventFlex.subscribe(System.out::println);

    }

}
