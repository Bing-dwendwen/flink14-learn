package org.example.source.kafka;

import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class KafkaSourceDemo {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        KafkaSource<String> kafkaSource = KafkaSource.<String>builder()
                .setBootstrapServers("127.0.0.1:9092")
                // 正则表达式 选择符合的topic
                // .setTopicPattern()
                .setTopics("test")
                // 设置分区
                // .setPartitions()
                // 设置消费组id
                .setGroupId("test")
                // 设置消费的结束位置
                // .setBounded()
                // 开始消费的位置
                .setStartingOffsets(OffsetsInitializer.latest())
                // 设置value序列化方式
                .setValueOnlyDeserializer(new SimpleStringSchema())
                .build();


        DataStreamSource<String> kafkaStream = env.fromSource(kafkaSource, WatermarkStrategy.noWatermarks(), "kafkaSource");
        kafkaStream.print();
        env.execute();
    }
}
