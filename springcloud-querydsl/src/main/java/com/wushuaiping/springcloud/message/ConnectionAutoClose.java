package com.wushuaiping.springcloud.message;

import com.rabbitmq.client.Connection;

/**
 * @another: wushuaiping
 * @date: 2018/4/13 下午2:59
 * @description:
 */
public interface ConnectionAutoClose extends Connection,AutoCloseable {
}
