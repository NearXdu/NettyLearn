package com.zx.nio.aio_timerserver;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Created by zhangxiao on 17-5-19.
 */
public class AcceptCompletionHandler implements
        CompletionHandler<AsynchronousSocketChannel, AsyncTimeServerHandler> {
    @Override
    public void completed(AsynchronousSocketChannel asynchronousSocketChannel, AsyncTimeServerHandler asyncTimeServerHandler) {
        asyncTimeServerHandler.asynchronousServerSocketChannel.accept();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        asynchronousSocketChannel.read(buffer,buffer,new ReadCompletionHandler(asynchronousSocketChannel));

    }

    @Override
    public void failed(Throwable throwable, AsyncTimeServerHandler asyncTimeServerHandler) {
        throwable.printStackTrace();
        asyncTimeServerHandler.latch.countDown();
    }
}
