package com.dgserver.server.app;

public abstract interface Plugin {
	  public abstract void onAppStart()
			    throws Exception;
	
	  public abstract void onAppStop()
			    throws Exception;
}
