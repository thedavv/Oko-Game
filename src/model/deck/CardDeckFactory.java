package model.deck;

/**
 * Factory for creating card decks
 */
public class CardDeckFactory {
	/**
	 * Creates a new Deck
	 * 
	 * @return new CardDeck
	 */
	public Deck createCardDeck() {
		return new CardDeck();
	}
}
