package com.services.container.standalone.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.services.container.standalone.StandAloneContainer;
import com.services.container.standalone.annotations.Execute;
import com.services.container.standalone.exceptions.StandAloneContainerAlreadyRunningException;
import com.services.container.standalone.sample.model.ExecuteChatService;
import com.services.container.standalone.utils.EngineUtilities;
import com.services.container.standalone.utils.LogLevel;

/**
 * Test Class for injection of data
 * @author Fabrizio Torelli (hellgate75@gmail.com)
 *
 */
public class Main {
	
	private static final Logger LOG = LoggerFactory.getLogger(Main.class);
	
	@Execute
	private ExecuteChatService executeChatService;
	
	/**
	 * @throws StandAloneContainerAlreadyRunningException 
	 * 
	 */
	public Main() throws StandAloneContainerAlreadyRunningException {
		super();
	}
	
	public static void main(String ...args) throws Throwable {
		EngineUtilities.log(LOG, LogLevel.WARN, "Stand Alone Container Engine starting ...");
		Main m = new Main();
		StandAloneContainer.run(m);
		StandAloneContainer.waitForReadyState();
		EngineUtilities.log(LOG, LogLevel.WARN, "Stand Alone Container Engine started ...");
		EngineUtilities.log(LOG, LogLevel.WARN, "Stand Alone Container Proxied Main ...");
		EngineUtilities.log(LOG, LogLevel.WARN, "Tranformation and proxy of Main type returned a nullable object");
		/* 
		 * Automatically the com.services.container.standalone.sample.model.ExecuteChatService
		 * service injected in the main as Execute of type : IContainerService will auto-run
		 * giving life to  same code as the chat service output, reported into that service
		 * 
		 **/
		EngineUtilities.log(LOG, LogLevel.WARN, "Stand Alone Container Engine completed ... exiting");
	}

}
