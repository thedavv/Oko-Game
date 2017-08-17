package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.cardfactory.Card;
import model.cardfactory.CardFactory;
import model.cardproperty.Color;
import model.cardproperty.Value;

public class Deck {
	private static Deck instance;
	private List<Card> deck = new ArrayList<>();
	private List<Card> stack = new ArrayList<>();// pile of used cards
	
	private Deck(){
		createDeck();
		shuffleDeck(deck);
	}
	
	//card manipulation
	public Card getCard(){//TODO this will not work as intended(creates new deck with all cards) shuffle stack instead
		if(deck.size()< 1){
			createDeck();
			shuffleDeck(deck);
		}
		return deck.remove(0);
	}
	
	public void addCardsToStack(List<Card> hand){
		for (Card card : hand) {
			stack.add(card);
		}
	}
	
	//G
	public static Deck getInstance() {
		if(instance == null){
			instance = new Deck();
		}
		
		return instance;
	}

	// deck handling
	private void createDeck(){
		CardFactory cf = new CardFactory();
		Card card;
		
		for (Color color : Color.values()) {
			for (Value	value: Value.values()) {
				card  = cf.createCard(color, value);
				deck.add(card);
			}
		}
	}
	
	private void shuffleDeck(List<Card> list){
		Collections.shuffle(list);
	}
	
	
}
