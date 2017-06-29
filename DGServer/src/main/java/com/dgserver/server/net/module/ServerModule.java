package com.dgserver.server.net.module;

import com.dgserver.server.net.buffer.MyBuffer;

public interface ServerModule {
	/**
	 * 模块类型
	 * 
	 * @return
	 */
	public int getModuleType();

	/**
	 * 串行化
	 * 
	 * @param out
	 */
	public void serialize(MyBuffer out);
	public void deserialize(MyBuffer in);
}
