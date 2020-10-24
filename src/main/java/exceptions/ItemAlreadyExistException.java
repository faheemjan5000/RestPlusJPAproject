package exceptions;

public class ItemAlreadyExistException extends Exception {
	
	private static final long serialVersionUID = 1L;

	  public ItemAlreadyExistException(String exceptionMessage) {
	    super(exceptionMessage);
	  }

	
}
