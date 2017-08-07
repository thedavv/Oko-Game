package model;

import java.util.List;

import model.cardfactory.Card;

public class Player {
	private List<Card> cards;

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	} 
}
