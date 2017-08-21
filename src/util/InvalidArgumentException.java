package util;

public class InvalidArgumentException extends Exception {
	private static final long serialVersionUID = -8505817523418968678L;

	public InvalidArgumentException() {
	}

	public InvalidArgumentException(String message) {
		super(message);
	}
}
