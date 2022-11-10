package org.example.source;

import org.apache.flink.api.java.io.TextInputFormat;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.FileProcessingMode;

import java.nio.file.Path;

public class ReadFileSource {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        //     PROCESS_ONCE 只读取文件种数据一次，读取完成程序退出
        //    PROCESS_CONTINUOUSLY 会一直监听文件或目录，若文件变化，会将该文件以前的内容和新添加的内容全部读取出来
        // 两秒一次刷新
        DataStreamSource<String> stream = env.readFile(new TextInputFormat(null), "input/", FileProcessingMode.PROCESS_CONTINUOUSLY, 2000);
        stream.print();
        env.execute();
    }
}
