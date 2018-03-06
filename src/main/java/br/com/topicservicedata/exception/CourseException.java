package br.com.topicservicedata.exception;

import org.apache.log4j.Logger;

public class CourseException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(CourseException.class);

	public CourseException() {

	}
	public CourseException(String mensage) {
		super(mensage);
		log.error(mensage);
	}

}
