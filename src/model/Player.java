package model;

import java.util.List;

import model.cardfactory.Card;

/**
 * @author David Racek
 * 
 *         Class for creating a player. It contains methods for creating player
 *         hand.
 *
 */
public class Player {
	private String		name;
	private List<Card>	cards;

	public Player(String name) {
		this.name = name;
	}

	// G + S
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
