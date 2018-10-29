/**
 * 
 */
package com.services.container.standalone.sample.model;

import java.io.IOException;
import java.util.List;

import com.services.container.standalone.annotations.Autowired;
import com.services.container.standalone.annotations.Component;
import com.services.container.standalone.annotations.Wired;
import com.services.container.standalone.sample.io.MessageReader;

/**
 * Sample one chat message service
 * @author Fabrizio Torelli (hellgate75@gmail.com)
 *
 */
@Component(name="myChatService")
public class ChatService {
	
	@Autowired
	private Header header;
	
	@Wired(entityName="messages")
	private MessageReader reader;

	/**
	 * 
	 */
	public ChatService() {
	}
	
	public List<String> messages() throws IOException {
		if (reader==null) {
			throw new RuntimeException("MessageReader bean instance was not wired!!!");
		}
		reader.open();
		List<String> list = reader.readAll();
		reader.close();
		return list;
	}

	/**
	 * @return the header
	 */
	public Header getHeader() {
		return header;
	}

	
}
