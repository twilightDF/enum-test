package com.twilight.common.config;

/**
 * RabbitMq公共配置类，定义一些配置信息
 */
public class RabbitMQConfig {
    /**
     * Rabbitmq 队列主题名称
     */
    public static final String RABBITMQ_DEMO_TOPIC = "direct.queue";

    /**
     * Rabbitmq的Direct交换机名称
     */
    public static final String RABBITMQ_DEMO_DIRECT_EXCHANGE = "direct.exchange.demo.name";

    /**
     * Rabbitmq 的DIRECT 交换机和队列绑定的匹配键
     */
    public static final String RABBITMQ_DEMO_DIRECT_ROUTING = "direct.exchange.demo.name";

    /**
     * RabbitMQ 的 FANOUT_EXCHANGE交换机类型的队列A的名称
     */
    public static final String FANOUT_EXCHANGE_QUEUE_TOPIC_A = "fanout.A";

    /**
     * RabbitMQ 的 FANOUT_EXCHANGE交换机类型的队列A的名称
     */
    public static final String FANOUT_EXCHANGE_QUEUE_TOPIC_B = "fanout.B";

    /**
     * RabbitMQ的FANOUT_EXHCNAGE交换机类型的名称
     */
     public static final String FANOUT_EXCHANGE_DEMO_NAME = "fanout.exchange.demo.name";

    /**
     * RabbitMQ 的TOPIC_EXCHANGE交换机名称
     */
    public static final String TOPIC_EXCHANGE_DEMO_NAME = "topic.exchange.demo.name";

    /**
     * RabbitMQ的TOPIC_EXCHANGE交换机的队列A的名称
     */
    public static final String TOPIC_EXCHANGE_QUEUE_A = "topic.queue.a";

    /**
     * RabbitMQ的TOPIC_EXCHANGE交换机的队列B的名称
     */
    public static final String TOPIC_EXCHANGE_QUEUE_B = "topic.queue.b";

    /**
     * RabbitMQ的TOPIC_EXCAHNGE交换机的队列C的名称
     */
    public static final String TOPIC_EXCHANGE_QUEUE_C = "topic.queue.c";

    /**
     * HEADER_EXCHANGE交换机名称
     */
    public static final String HEADER_EXCHANGE_DEMO_NAME = "headers.exchange.demo.name";

    /**
     * RabbitMQ 的 HEADERS_EXCHANGE交换机的名称
     */
    public static final String HEADERS_EXCHANGE_QUEUE_A = "headers.queue.a";

    /**
     * RabbitMQ 的 HEADERS_EXCHANGE交换机的名称
     */
    public static final String HEADERS_EXCHANGE_QUEUE_B = "header.queue.b";

}
