package handler;

import java.util.ArrayList;
import java.util.List;

import model.cardfactory.Card;
import model.cardfactory.CardFactory;
import model.cardproperty.Color;
import model.cardproperty.Value;
import model.deck.Deck;

public class DeckHandler {
	public List<Card> createDeck() {
		CardFactory cf = new CardFactory();
		List<Card> cards = new ArrayList<>();
		for (Color color : Color.values()) {
			for (Value value : Value.values()) {
				Card card = cf.createCard(color, value);
				cards.add(card);
			}
		}

		return cards;
	}
}
