package com.thoughtWorks.objs;

public class Reporter extends Person {
	public Reporter(String name, String channelName) {
		super(name);
		this.channelName = channelName;
	}

	private String channelName;

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
}
