package org.example.source.mySource;

import org.apache.flink.streaming.api.functions.source.RichParallelSourceFunction;

public class MySource extends RichParallelSourceFunction<Integer> {

    private Boolean flag = true;
    private int i = 1;
    @Override
    public void run(SourceContext<Integer> sourceContext) throws Exception {
        while (i< 10 && flag){
            Thread.sleep(1000);
            i++;
            sourceContext.collect(i);
        }
    }

    @Override
    public void cancel() {
        flag = false;
    }
}
