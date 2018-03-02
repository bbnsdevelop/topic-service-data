package br.com.topicservicedata.log;

public interface MessageLogger extends Logger {

	public void debug(String msg, Object...args);
	public void debug(String msg, Throwable exception, Object...args);
	
	public void info(String msg, Object...args);
	public void info(String msg, Throwable exception, Object...args);

	public void warn(String msg, Object...args);
	public void warn(String msg, Throwable exception, Object...args);

	public String error(String msg, Object...args);
	public String error(String msg, Throwable exception, Object...args);
	
}