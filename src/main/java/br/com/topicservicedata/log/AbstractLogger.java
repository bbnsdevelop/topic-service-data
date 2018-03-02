package br.com.topicservicedata.log;

import java.io.Serializable;

public abstract class AbstractLogger implements Logger , Serializable{

	private static final long serialVersionUID = -731967654745275861L;
	private transient org.apache.log4j.Logger log4jHandler;
	private String loggerName = null;
	
	protected AbstractLogger(String fqcn) {
		this.log4jHandler = org.apache.log4j.Logger.getLogger(fqcn);
		this.loggerName = fqcn;
	}
	
	protected org.apache.log4j.Logger getLoggerHandler(){
		if(this.log4jHandler == null){
			this.log4jHandler = org.apache.log4j.Logger.getLogger(this.loggerName);
		}
		
		return this.log4jHandler;
	}
}
