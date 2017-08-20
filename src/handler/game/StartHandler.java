package handler.game;

import java.util.List;
import java.util.Scanner;

import model.cardfactory.Card;
import model.deck.Deck;
import util.Const;

/**
 * Class contains helpful methods for checking rules and handling the counts of
 * cards in hand
 */
public class StartHandler {

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

	public Deck shufflePileIntoDeck(Deck cardDeck, Deck cardPile) {
		cardDeck.addCards(cardPile.getAllCards());
		cardDeck.shuffle();

		return cardDeck;
	}

	public int substractBetValue(int bet, int playerBank) {
		return playerBank - bet;
	}

	public int addBetValue(int bet, int playerBank) {
		return playerBank + bet;
	}

	public int updateFinalScore(int bet, int finalScore) {
		return finalScore - bet;
	}

	public boolean isBankZero(int playerBank) {
		return (playerBank <= 0) ? true : false;
	}

	public int setBet(Scanner sc) {
		String s = sc.next();
		int bet;

		switch (s) {
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":
		case "10":
			bet = Integer.parseInt(s);
			break;
		default:
			// TODO exception
			System.out.println("bad input");
			bet = 2;
			break;
		}

		return bet;
	}

	public int setBetDoubleDown(Scanner sc, int bet) {
		String s = sc.next();

		switch (s) {
		case "1":
			bet *= 2;
			break;
		case "2":
			break;

		default:
			// TODO exception
			System.out.println("bad input");
			break;
		}

		return bet;
	}

}
