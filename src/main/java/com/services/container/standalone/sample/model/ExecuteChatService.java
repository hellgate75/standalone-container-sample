/**
 * 
 */
package com.services.container.standalone.sample.model;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.services.container.standalone.annotations.Autowired;
import com.services.container.standalone.annotations.Service;
import com.services.container.standalone.annotations.Wired;
import com.services.container.standalone.exceptions.ServiceInvocationException;
import com.services.container.standalone.model.IContainerService;
import com.services.container.standalone.utils.EngineUtilities;
import com.services.container.standalone.utils.LogLevel;

/**
 * Sample Auto-run (Execute) kind of Service implementing {@link IContainerService}.
 * @author TORELFA
 *
 */
@Service
public class ExecuteChatService implements IContainerService {
	
	private static final Logger LOG = LoggerFactory.getLogger(ExecuteChatService.class);

	@Wired(entityName="myChatService")
	protected ChatService chat;

	
	@Autowired
	protected ApplicationInfo info;

	/**
	 * Default Constructor
	 */
	public ExecuteChatService() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.services.container.standalone.model.IContainerService#run()
	 */
	public void run() throws ServiceInvocationException {
		try {
			if (info!=null) {
				EngineUtilities.log(LOG, LogLevel.WARN, "{}", info.getName());
				EngineUtilities.log(LOG, LogLevel.WARN, "Version {}", info.getVersion());
				EngineUtilities.log(LOG, LogLevel.WARN, "Author: {}", info.getAuthor());
			} else {
				EngineUtilities.log(LOG, LogLevel.ERROR, "No info Bean loaded in the system");
			}
			if (chat!=null) {
				EngineUtilities.log(LOG, LogLevel.WARN, "Chat object: {}", chat);
				EngineUtilities.log(LOG, LogLevel.WARN, "From: {}", chat.getHeader().getFrom());
				EngineUtilities.log(LOG, LogLevel.WARN, "To: {}", chat.getHeader().getTo());
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSSZ");
				EngineUtilities.log(LOG, LogLevel.WARN, "Start: {}", format.format(chat.getHeader().getTime()));
				for (String message: chat.messages()) {
					EngineUtilities.log(LOG, LogLevel.WARN, message);
				}
			} else {
				EngineUtilities.log(LOG, LogLevel.ERROR, "No chat Bean loaded in the system");
			}
		} catch (IOException e) {
			EngineUtilities.log(LOG, LogLevel.ERROR, "Error executing ExecuteChatService in auto-run mode");
		}
	}

}
