package org.example.source;

import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.Arrays;
import java.util.List;

public class FromCollections {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        List<String> strings = Arrays.asList("111", "222", "444");
        DataStreamSource<String> stream = env.fromCollection(strings);
        stream.print();
        env.execute();
    }
}
