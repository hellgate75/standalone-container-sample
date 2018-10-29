package com.services.container.standalone.sample.model;

import java.util.Map;

public class ApplicationInfo {
	
	private String name = "Fake Chat (only Annotation test scope)";

	private String version = "1.0.0";

	private String author = "TORELFA (Fabrizio Torelli) - fabrizio.torelli@ie.verizon.com";
	
	private Map<String, String> information;

	public ApplicationInfo(Map<String, String> information) {
		super();
		this.information=information;
	}

	public String getName() {
		return information.get("title");
	}

	public String getVersion() {
		return information.get("version");
	}

	public String getAuthor() {
		return information.get("author");
	}
	
	

}
