package com.lenderborrower.generalledgerservices.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@ConfigurationProperties(prefix = "useraccount")
public class ConfigProperties {
	
	private String urlaccount;
	private String urlmember;
	public String getUrlaccount() {
		return urlaccount;
	}
	public void setUrlaccount(String urlaccount) {
		this.urlaccount = urlaccount;
	}
	public String getUrlmember() {
		return urlmember;
	}
	public void setUrlmember(String urlmember) {
		this.urlmember = urlmember;
	}
	
	
}
