package model.cardproperty;

import util.Const;

/**
 *
 * Enum that contains values of the cards
 *
 */
public enum Value {
	SEVEN(Const.SEVEN, 7), EIGHT(Const.EIGHT, 8), NINE(Const.NINE, 9), TEN(Const.TEN, 10), JACK(Const.JACK,
			1), QUEEN(Const.QUEEN, 1), KING(Const.KING, 1), ACE(Const.ACE, 1);

	private final int	 intValue;
	private final String label;

	Value(String label, int intValue) {
		this.label = label;
		this.intValue = intValue;
	}

	public String getLabel() {
		return this.label;
	}

	public int getIntValue() {
		return this.intValue;
	}

}
