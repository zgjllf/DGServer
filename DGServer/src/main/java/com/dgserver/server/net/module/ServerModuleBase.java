package com.dgserver.server.net.module;

import com.dgserver.server.net.buffer.MyBuffer;

public class ServerModuleBase implements ServerModule {

	public int getModuleType() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void serialize(MyBuffer out) {
		// TODO Auto-generated method stub
		out.putInt(getModuleType());
	}

	public void deserialize(MyBuffer in) {
		// TODO Auto-generated method stub
		
	}

}
