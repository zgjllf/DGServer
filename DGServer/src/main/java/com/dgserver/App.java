package com.dgserver;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dgserver.server.app.Plugin;
import com.dgserver.server.app.ServerApp;
import com.dgserver.server.net.ServerManager;
/**
 * Hello world!
 *
 */
public class App 
{
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
    public static void main( String[] args ) throws Exception
    {
    	final ServerApp app = ServerApp.getInstance();
    	
    	app.registPlugin(new Plugin()
        {
			public void onAppStart() throws Exception {
				// TODO Auto-generated method stub

		        logger.info("-----------service start------------");
			}

			public void onAppStop() throws Exception {
				// TODO Auto-generated method stub
				
		        logger.info("-----------service stop-----------");
			}
        });

    	ServerManager server = new ServerManager(9998);
		server.Start();
		
    	app.start();

    }
    
}
