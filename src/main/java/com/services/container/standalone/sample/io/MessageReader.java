/**
 * 
 */
package com.services.container.standalone.sample.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Fabrizio Torelli (hellgate75@gmail.com)
 *
 */
public class MessageReader {
	
	BufferedReader reader = null;

	/**
	 * Default Constructor
	 */
	public MessageReader() {
		super();
	}
	
	public void open() {
		reader = new BufferedReader(new InputStreamReader(MessageReader.class.getClassLoader().getResourceAsStream("messages.txt")));
	}

	public boolean isOpen() {
		return reader != null;
	}

	public void close() throws IOException {
		if (reader!=null) {
			reader.close();
			reader = null;
			System.gc();
		}
	}


	public boolean isReady() throws IOException {
		return (reader!=null && reader.ready());
	}
	
	public List<String> readAll() throws IOException {
		if (isReady()) {
			List<String> list = new ArrayList<String>(0);
			while (reader.ready()) {
				list.add(reader.readLine());
			}
			return list;
		}
		return new ArrayList<String>(0);
	}


}
