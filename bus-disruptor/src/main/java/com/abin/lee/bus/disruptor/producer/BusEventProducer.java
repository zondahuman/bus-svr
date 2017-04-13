package com.abin.lee.bus.disruptor.producer;

import com.abin.lee.bus.disruptor.event.BusEvent;
import com.abin.lee.bus.disruptor.factory.BusEventFactory;
import com.abin.lee.bus.disruptor.handler.BusEventHandler;
import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by abin on 2017/4/13 2017/4/13.
 * bus-svr
 * com.abin.lee.bus.disruptor.producer
 */
public class BusEventProducer {

    public static void main(String[] args) {
        EventFactory<BusEvent> eventFactory = new BusEventFactory();
        // Executor that will be used to construct new threads for consumers
        Executor executor = Executors.newCachedThreadPool();
        // Specify the size of the ring buffer, must be power of 2.
        int ringBufferSize = 1024 * 1024; // RingBuffer 大小，必须是 2 的 N 次方；
        Disruptor<BusEvent> disruptor = new Disruptor<BusEvent>(eventFactory, ringBufferSize,  new LimitedThreadFactory(), ProducerType.SINGLE,
                new BusySpinWaitStrategy());

        EventHandler<BusEvent> eventHandler = new BusEventHandler();

        // 可以使用lambda来注册一个EventHandler
        disruptor.handleEventsWith(eventHandler);
        // Start the Disruptor, starts all threads running
        disruptor.start();

        RingBuffer<BusEvent> ringBuffer = disruptor.getRingBuffer();
        long sequence = ringBuffer.next();//请求下一个事件序号；
        BusEvent event = ringBuffer.get(sequence);//获取该序号对应的事件对象；
        event.setBusName("abin");
        // Get the ring buffer from the Disruptor to be used for publishing.
        ringBuffer.publish(sequence);
    }




    static class LimitedThreadFactory implements ThreadFactory {
        private final AtomicInteger count =new AtomicInteger(0);

        public Thread newThread(Runnable r) {
            if (count.compareAndSet(0, 1)) {
                return new Thread(r);
            } else {
                throw new IllegalStateException("Created more that one thread");
            }
        }
    }

}
