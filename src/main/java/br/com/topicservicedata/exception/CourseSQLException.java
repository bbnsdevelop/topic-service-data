package br.com.topicservicedata.exception;

import java.sql.SQLException;

import org.apache.log4j.Logger;

public class CourseSQLException extends SQLException {

	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(CourseException.class);

	public CourseSQLException() {

	}
	public CourseSQLException(String mensage) {
		super(mensage);
		log.error(mensage);
	}

}
