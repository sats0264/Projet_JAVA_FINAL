package exception;

public class CrudOperationException extends Exception {
	private static final long serialVersionUID = 1L;

	public CrudOperationException(String message) {
		super(message);
	}
}
