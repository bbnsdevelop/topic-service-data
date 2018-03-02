package br.com.topicservicedata.log;

public class LogFactory {

	private String fqcn;
	
	private MessageLogger messageLogger;
	
	protected LogFactory(String fqcn) {
		this.fqcn = fqcn;
	}
	
	public static LogFactory getInstance(Class<?> clazz){
		return new LogFactory(clazz.getName());
	}
	
	public MessageLogger getMessageLogger(){
		if( this.messageLogger == null ){
			this.messageLogger = new MessageLoggerImpl(fqcn);
		}
		return this.messageLogger;
	}
}
