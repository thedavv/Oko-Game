package model.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.cardfactory.Card;

/**
 * Use this class for creating decks like card deck or card pile.
 */
public class CardDeck implements Deck {
	private List<Card> cards = new ArrayList<>();

	public CardDeck() {

	}

	@Override
	public Card getCard() {
		if (cards.size() < 1) {
			return null;
		}
		return cards.remove(0);
	}

	@Override
	public void shuffle() {
		Collections.shuffle(cards);
	}

	@Override
	public boolean isEmpty() {
		return cards.isEmpty();
	}

	@Override
	public void addCards(List<Card> cards) {
		this.cards.addAll(cards);
	}

	@Override
	public List<Card> getAllCards() {
		return cards;
	}

	@Override
	public void clear() {
		cards.clear();
	}
}
