package org.example.source;

import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class ReadTextFileSource {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        // 底层调用的是 readFile，
        // readTextFile 是处理有界文件，默认文件格式 TextInputFormat，编码 UTF-8，PROCESS_ONCE
        DataStreamSource<String> stream = env.readTextFile("input");
        stream.print();
        env.execute();
    }
}
