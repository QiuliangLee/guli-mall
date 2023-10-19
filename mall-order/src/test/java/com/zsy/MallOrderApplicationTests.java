package com.zsy;

import com.zsy.order.entity.OrderReturnApplyEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class MallOrderApplicationTests {

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 创建交换机
     */
    @Test
    void contextLoads() {
        DirectExchange directExchange = new DirectExchange("hello.java.exchange", true, false);
        amqpAdmin.declareExchange(directExchange);
        log.info("exchange[{}] success", directExchange.getName());
    }

    /**
     * 创建队列
     */
    @Test
    void contextLoads2() {
        Queue queue = new Queue("hello.java.queue", true, false, false);
        amqpAdmin.declareQueue(queue);
        log.info("queue[{}] success", queue.getName());
    }

    /**
     * 绑定交换机和队列
     */
    @Test
    void contextLoads3() {
        Binding binding = new Binding("hello.java.queue", Binding.DestinationType.QUEUE
                , "hello.java.exchange", "hello.java", null);
        amqpAdmin.declareBinding(binding);
        log.info("binding[{}] success", "hello.java.binding");
    }

    @Test
    public void testSendMessage() {
        OrderReturnApplyEntity orderReturnApplyEntity = new OrderReturnApplyEntity();
        orderReturnApplyEntity.setCompanyAddress("123");
        orderReturnApplyEntity.setDescPics("344");
        rabbitTemplate.convertAndSend("hello.java.exchange", "hello.java", orderReturnApplyEntity);
        log.info("消息发送完成,{}", "hello world");
    }

    @Test
    public void testReceiveMessage() {

    }
}
