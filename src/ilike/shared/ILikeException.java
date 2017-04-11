package ilike.shared;

/**
 * 
 * @author Ana Germano up201105083
 *
 */ 

public class ILikeException extends java.lang.Exception{

	private static final long serialVersionUID = 1L;

	public ILikeException() {
		super();
	}

	public ILikeException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public ILikeException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ILikeException(String arg0) {
		super(arg0);
	}

	public ILikeException(Throwable arg0) {
		super(arg0);
	}
}