package com.services.container.standalone.sample.model;

import java.util.HashMap;
import java.util.Map;

import com.services.container.standalone.annotations.Component;
import com.services.container.standalone.annotations.Configuration;
import com.services.container.standalone.annotations.Inject;
import com.services.container.standalone.sample.io.MessageReader;

@Configuration(packages={"com.services.container.standalone.sample.model"})
public class BaseConfiguration {

	@Component
	public Map<String, String> information() {
		HashMap<String, String> data = new HashMap<String, String>(0);
		data.put("author", "TORELFA (Fabrizio Torelli) - fabrizio.torelli@ie.verizon.com");
		data.put("title", "Fake Chat (only Annotation test scope)");
		data.put("version", "1.0.0");
		return data;
	}

	@Component(name="info")
	public ApplicationInfo getInfoBean(@Inject(entityName="information") Map<String, String> information) {
		return new ApplicationInfo(information);
	}

	@Component(name="messages")
	public MessageReader getMessageService() {
		return new MessageReader();
	}

}
