package com.xiao.mq.kafka;

import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaInitialConfiguration {
//    // 创建一个名为testtopic的Topic并设置分区数为8，分区副本数为2
//    @Bean
//    public NewTopic initialTopic() {
//        return new NewTopic("testtopic1", 1, (short) 1);
//    }
//
//    // 如果要修改分区数，只需修改配置值重启项目即可
//    // 修改分区数并不会导致数据的丢失，但是分区数只能增大不能减小
//    @Bean
//    public NewTopic updateTopic() {
//        return new NewTopic("testtopic3", 3, (short) 3);
//    }
}
