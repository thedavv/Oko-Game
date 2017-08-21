package util;

public class DimensionsException extends Exception {
	private static final long serialVersionUID = -8121524851474561971L;
	private int[]			  dimensions;

	public DimensionsException() {
	}

	public DimensionsException(String message) {
		super(message);
	}

	public DimensionsException(String message, int[] dimensions) {
		super(message);
		this.dimensions = dimensions;
	}

	public int[] getDimensions() {
		return this.dimensions;
	}
}
