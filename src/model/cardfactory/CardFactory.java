package model.cardfactory;

import model.cardproperty.Color;
import model.cardproperty.Value;

/**
 * Class for creating player cards. It includes methods that create cards.
 * 
 * @author David Racek
 *
 */
public class CardFactory {
	/**
	 * Method creates new card, by its value and color.
	 * 
	 * @param color
	 *            is color of card
	 * @param value
	 *            is value of card
	 * @return new Player card
	 */
	public Card createCard(Color color, Value value) {
		return new PlayerCard(color, value);
	};
}
