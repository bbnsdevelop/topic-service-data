package br.com.topicservicedata.exception;

public class TopicException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TopicException() {

	}

	public TopicException(String mensage) {
		super(mensage);

	}

}
