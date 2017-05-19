package com.zx.netty.nio_timeserver;

import java.io.IOException;

/**
 * Created by zhangxiao on 17-5-19.
 */
public class TimeServer {
    public static void main(String[]args) throws IOException {
        int port =1024;
        if(args!=null && args.length>0){
            try{
                port = Integer.valueOf(args[0]);
            }catch(NumberFormatException e){

            }
        }//end if
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer,"NIO-MultiplexerTimeServer-001").start();
    }
}
