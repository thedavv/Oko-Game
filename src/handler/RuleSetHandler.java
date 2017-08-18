package handler;

import java.util.List;

import model.cardfactory.Card;
import util.Const;

/**
 * Class contains helpful methods for checking rules and handling the counts of
 * cards in hand
 */
public class RuleSetHandler {

	/**
	 * Method for counting cards in hand
	 *
	 * @param hand
	 *            is players hand
	 * @return total int card value in hand
	 */
	public int countCardsInHand(List<Card> hand) {
		int handValue = 0;
		for (Card card : hand) {
			handValue += card.getValue().getIntValue();
		}
		return handValue;
	}

	/**
	 * Method for calculating if hand exceeded max hand value
	 *
	 * @param handValue
	 *            players cards value
	 * @return true if hand exceeded the max hand value defined in
	 *         <code>Const</Settings> class
	 */
	public boolean isHandValueMoreThanMaxValue(int handValue) {
		return (handValue > Const.MAX_HAND_VALUE) ? true : false;
	}
}
