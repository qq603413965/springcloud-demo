package com.wushuaiping.springcloud.message;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @another: wushuaiping
 * @date: 2018/4/13 下午2:38
 * @description:
 */
public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setPassword("root");
        factory.setUsername("admin");
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection()){
            final Channel channel = connection.createChannel();
            String exchangeName = "hello-exchange";
            channel.exchangeDeclare(exchangeName, "direct", true);
            // 声明队列
            String queue = channel.queueDeclare().getQueue();
            // 绑定队列
            channel.queueBind(queue, exchangeName, "hola");
            int i = 0;
            // 开始消费消息
            while (true){

                //消费消息
                boolean autoAck = false;
                String consumerTag = "";
                channel.basicConsume(queue, autoAck, consumerTag, new DefaultConsumer(channel) {
                    @Override
                    public void handleDelivery(String consumerTag,
                                               Envelope envelope,
                                               AMQP.BasicProperties properties,
                                               byte[] body) throws IOException {
                        String routingKey = envelope.getRoutingKey();
                        String contentType = properties.getContentType();
                        System.out.println("消费的路由键是： " + routingKey);
                        System.out.println("消费的内容类型： " + contentType);
                        long deliveryTag = envelope.getDeliveryTag();
                        // 确认消息
                        channel.basicAck(deliveryTag, false);
                    }
                });
                if (i == 1){
                    break;
                }
            }
        }
    }
}
