package model.deck;

import java.util.List;

import model.cardfactory.Card;

public interface Deck {
	void shuffle();

	void addCards(List<Card> cards);

	void clear();

	boolean isEmpty();

	Card getCard();

	List<Card> getAllCards();
}
