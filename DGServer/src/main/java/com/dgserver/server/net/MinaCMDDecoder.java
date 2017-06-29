/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgserver.server.net;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dgserver.server.net.buffer.MyBuffer;

/**
 *解码器，解开消息的格式，变成可以处理的数据格式。
 */
public class MinaCMDDecoder extends CumulativeProtocolDecoder {
	private static final Logger logger = LoggerFactory.getLogger(MinaCMDDecoder.class);
    /**
     * 
     * @return true 解码完成，释放缓存，false 解码未完成，等待下一次解码。
     * @throws Exception 
     */
    @Override
    protected boolean doDecode(IoSession is, IoBuffer ib, ProtocolDecoderOutput pdo) throws Exception {
//    	logger.info("HandleMessage");
    	int remain = ib.remaining();
//    	System.out.println("remain : " + remain);
    	if(remain < 4) {
    		return false;
    	}
    	int basePos = ib.position();
    	int length = ib.getInt(basePos + 0);
//    	System.out.println("length : " + length);
    	if(length > remain - 4) {
    		return false;
    	}
    	int protocol = ib.getInt(basePos + 4);
//    	logger.debug("protocol : " + protocol);
    	
    	byte[] destBytes = new byte[4+length];
    	
		MyBuffer buff = MyBuffer.wrap(destBytes);
		ib.get(destBytes, 0, destBytes.length);

		/**
		 * 绑定步骤，第一次玩家登陆时绑定用户数据
		 */
		//绑定玩家ID和seesion，第一次登陆游戏时绑定
		
		if(ServerManager.GetInstance().getServerList().containsKey(protocol)){
			BaseServer server = ServerManager.GetInstance().getServerList().get(protocol);
			BaseMessage message = server.GetRequest();
			if(message != null){
				try{
					message.deserialize(buff);
					
					UserInfo userInfo = null;
					if(protocol == 0x100) {
						//创建用户信息
						userInfo = new UserInfo();
						userInfo.deserialize(buff);
						userInfo.setSession(is);
					}else {
						userInfo = ServerManager.GetInstance().getUserInfo(is);
					}
					if(userInfo == null){
						return true;
					}
					message.setUserInfo(userInfo);
					
					BaseMessage msg = server.handle(is,message);
					if(msg != null){
						is.write(msg);
					}
				}catch(Exception e){
					e.printStackTrace();
					return true;
				}
				
			}
		}
        return true;
    }
    
    
}
