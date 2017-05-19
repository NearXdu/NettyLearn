package com.zx.netty.aio_timerserver;

import java.io.IOException;

/**
 * Created by zhangxiao on 17-5-19.
 */
public class TimeServer {
    public static void main(String []args)throws IOException{
        int port =1026;
        if(args!=null&&args.length>0){
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){

            }
        }
        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);
        new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();

    }
}
