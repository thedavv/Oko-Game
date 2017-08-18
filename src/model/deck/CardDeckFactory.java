package model.deck;

public class CardDeckFactory {
	public Deck createCardDeck() {
		return new CardDeck();
	}

	public Deck createCardStack() {
		return new CardPile();
	}
}
