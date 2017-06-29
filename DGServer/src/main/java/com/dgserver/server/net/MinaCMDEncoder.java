/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgserver.server.net;


import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dgserver.server.net.buffer.MyBuffer;

/**
 *编码器
 */
public class MinaCMDEncoder implements ProtocolEncoder {
	private static final Logger logger = LoggerFactory.getLogger(MinaCMDEncoder.class);
	public void encode(IoSession session, Object message, ProtocolEncoderOutput out)
            throws Exception {
//        System.out.println("编码");
		try{
			MyBuffer joyBuffer = MyBuffer.allocate(256);

	        BaseMessage msg = (BaseMessage)message;
	        //用户信息
	        //msg.getUserInfo().serialize(joyBuffer);
	        msg.serialize(joyBuffer);
	        joyBuffer.putInt(0,joyBuffer.position() - 4);
	        byte[] buffer = joyBuffer.arrayToPosition();
	        out.write(IoBuffer.wrap(buffer));
		}catch(Exception e){
			e.printStackTrace();
		}
    }

    public void dispose(IoSession is) throws Exception {
    }

}
