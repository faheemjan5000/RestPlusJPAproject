package exceptions;

public class ItemNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	  public ItemNotFoundException(String exceptionMessage) {
	    super(exceptionMessage);
	  }

}
