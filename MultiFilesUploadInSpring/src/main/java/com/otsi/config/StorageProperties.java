package com.otsi.config;

import org.springframework.context.annotation.Configuration;

@Configuration(value = "upload")
public class StorageProperties {
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
