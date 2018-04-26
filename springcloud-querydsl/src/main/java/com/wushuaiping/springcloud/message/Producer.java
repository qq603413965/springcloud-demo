package com.wushuaiping.springcloud.message;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @another: wushuaiping
 * @date: 2018/4/13 下午2:00
 * @description:
 */
public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException{
        // 创建连接工厂，并设置账户信息
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("root");
        factory.setPassword("admin");
        // 设置rabbitmq地址
        factory.setHost("localhost");
        Channel channel = null;

        try (
                // 建立到代理服务器的连接 java 7的try with resource写法，
                // 指try执行完后，必须要close掉的对象。这些需要close的对象会自动被关闭，前提是，这些可关闭的接口必须实现java.lang.AutoCloseeable接口
                Connection connection = factory.newConnection()
        ) {
            // 创建一个通道
            channel = connection.createChannel();

            // 声明交换器
            String exchangeName = "hello-exchange";
            channel.exchangeDeclare(exchangeName, "direct", true);

            // 发布消息
            String routingKey = "hola";
            byte[] messageBodyBytes = "quit".getBytes();
            channel.basicPublish(exchangeName, routingKey, null, messageBodyBytes);
        }finally {

            if (channel != null) channel.close();

        }
    }
}
