package com.dgserver.server.core.context;

import java.lang.reflect.Method;

import com.dgserver.server.net.BaseMessage;
import com.dgserver.server.net.BaseServer;

abstract interface DGContext {
	public abstract Object getContextAttribute(Object paramObject);

	  public abstract Object setContextAttribute(Object paramObject1, Object paramObject2);

	  public abstract Object removeContextAttribute(Object paramObject);

	  public abstract Method getHandler(long paramLong);

	  public abstract Method getHandler(int paramInt1, int paramInt2);

	  public abstract BaseServer getService(long paramLong);

	  public abstract BaseServer getService(int paramInt1, int paramInt2);

	  public abstract BaseMessage getMessage(long paramLong)
	    throws Exception;

	  public abstract BaseMessage getMessage(int paramInt1, int paramInt2);
}
