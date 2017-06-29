package com.dgserver.server.net;

import com.dgserver.server.net.buffer.MyBuffer;
import java.io.Serializable;

public class BaseMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6520956222682490946L;
	
	private UserInfo userInfo = null;
	private int length;
	private int version;
	
	public int GetProtocol(){
		return 0;
	}
    public void serialize(MyBuffer buf){
    	buf.skip(4);
    	buf.putInt(GetProtocol());
    }
    public void deserialize(MyBuffer buf){
    	length = buf.getInt();//长度
    	buf.getInt();//协议id
    	version = buf.get();
    }
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
    
	public void Send(){
		ServerManager.GetInstance().SendMessage(this);
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}

}
