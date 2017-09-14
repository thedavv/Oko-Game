package model.cardproperty;

import util.Const;

/**
 *
 * Enum that contains color of the cards
 *
 */
public enum Color {
	SPADES(Const.SPADES), CLUBS(Const.CLUBS), HEARTHS(Const.HEARTHS), DIAMONDS(Const.DIAMONDS);

	private final char color;

	Color(char color) {
		this.color = color;
	}

	public char getColor() {
		return this.color;
	}
}
