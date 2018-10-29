/**
 * 
 */
package com.services.container.standalone.sample.model;

import java.util.Date;

import com.services.container.standalone.annotations.Component;

/**
 * Chat header class
 * @author Fabrizio Torelli (hellgate75@gmail.com)
 *
 */
@Component
public class Header {

	private String from = "fabrizio.torelli@ie.verizon.com";
	private String to = "karthick.kujuluvasurendran@ie.verizon.com";
	private Date time=new Date(System.currentTimeMillis());
	
	/**
	 * Default constructor
	 */
	public Header() {
		super();
	}

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}
	
	

}
