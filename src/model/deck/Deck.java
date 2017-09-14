package model.deck;

import java.util.List;

import model.cardfactory.Card;

/**
 * It contains methods for handling the deck. Ever new deck must implement these
 * methods
 */
public interface Deck {
	/**
	 * Shuffles the deck
	 */
	void shuffle();

	/**
	 * Adds cards to deck
	 * 
	 * @param cards
	 *            are the cards being added
	 */
	void addCards(List<Card> cards);

	/**
	 * Empties the deck
	 */
	void clear();

	/**
	 * Checks if the deck is empty
	 * 
	 * @return returns true if deck is empty
	 */
	boolean isEmpty();

	/**
	 * Gets the card from deck
	 * 
	 * @return Card from deck
	 */
	Card getCard();

	/**
	 * Gets all Card from a deck
	 * 
	 * @return
	 */
	List<Card> getAllCards();
}
