package br.com.topicservicedata.log;

public class MessageLoggerImpl extends AbstractLogger implements MessageLogger {

	private static final long serialVersionUID = -1669382164671206061L;

	public void debug(String msg, Object... args) {
		if( getLoggerHandler().isDebugEnabled() ){
			if( args == null ){ //#34018
				getLoggerHandler().debug(msg);
			} else {
				getLoggerHandler().debug(String.format(msg, args));
			}
		}
	}
	
	public void debug(String msg, Throwable exception, Object... args) {
		if( getLoggerHandler().isDebugEnabled() ){
			if( args == null ){ 
				getLoggerHandler().debug(msg, exception);
			} else {
				getLoggerHandler().debug(String.format(msg, args), exception);
			}
		}
	}
	
	public String error(String msg, Object... args) {
		String errorMessage = ( args == null ? msg : String.format(msg, args) );
		getLoggerHandler().error(errorMessage);
		return errorMessage;
	}
		
	public String error(String msg, Throwable exception, Object... args) {
		String errorMessage = ( args == null ? msg : String.format(msg, args) );
		getLoggerHandler().error(errorMessage, exception);
		return errorMessage;
	}
	
	public void info(String msg, Object... args) {
		if( getLoggerHandler().isInfoEnabled() ){
			if( args == null ){
				getLoggerHandler().info(msg);
			} else {
				getLoggerHandler().info(String.format(msg, args));
			}
		}
	}
	
	public void info(String msg, Throwable exception, Object... args) {
		if( getLoggerHandler().isInfoEnabled() ){
			if( args == null ){
				getLoggerHandler().info(msg, exception);
			} else {
				getLoggerHandler().info(String.format(msg, args), exception);
			}
		}
	}
	
	public void warn(String msg, Object... args) {
		getLoggerHandler().warn(( args == null ? msg : String.format(msg, args) ));
	}
	
	public void warn(String msg, Throwable exception, Object... args) {
		getLoggerHandler().warn( ( args == null ? msg : String.format(msg, args) ), exception);
	}
	
	MessageLoggerImpl(String fqcn) {
		super(fqcn);
	}
	
}