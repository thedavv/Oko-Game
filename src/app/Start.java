package app;


import java.util.ArrayList;
import java.util.List;

import handler.*;
import model.*;
import model.cardfactory.*;
import model.cardproperty.*;
import util.DimensionsException;
import util.Settings;

public class Start {//TODO implement settings to card factory
	public static void main(String[] args) {
		Settings s = Settings.getInstance();
		
		try {
			s.setCardSize(10, 8);
		} catch (DimensionsException e) {
			e.printStackTrace();
		}
		
		System.out.println("First test");
		test1();
		System.out.println("Second test");
		System.out.println();
		test2();
		System.out.println("third test");
		System.out.println();
		test3();
		System.out.println("fourth test");
		System.out.println();
		test4();
		
	}
	
	private static void test1(){
		CardFactory cf = new CardFactory();
		Card eightHearths = cf.createCard(Color.HEARTHS, Value.TEN);
		Card sevenHearths = cf.createCard(Color.HEARTHS, Value.TEN);
		Card nineClubs = cf.createCard(Color.CLUBS, Value.NINE);
		Card tenDiamonds = cf.createCard(Color.DIAMONDS, Value.TEN);
		
		List<Card> cards = new ArrayList<>();
		cards.add(tenDiamonds);
		cards.add(nineClubs);
		cards.add(sevenHearths);
		cards.add(eightHearths);
		
		Player player = new Player();
		Player computer = new Player();
		player.setCards(cards);
		computer.setCards(cards);
		
		CardFactoryHandler ch = new CardFactoryHandler();
		//ch.drawPlayer(player);
		ch.drawBothPlayers(player, computer);
	}
	
	private static void test2(){
		CardFactory cf = new CardFactory();
		Card eightHearths = cf.createCard(Color.HEARTHS, Value.ACE);
		Card sevenHearths = cf.createCard(Color.SPADES, Value.JACK);
		Card nineClubs = cf.createCard(Color.CLUBS, Value.NINE);
		Card tenDiamonds = cf.createCard(Color.DIAMONDS, Value.TEN);
		
		List<Card> cards = new ArrayList<>();
		List<Card> cards2 = new ArrayList<>();
		
		cards.add(sevenHearths);
		cards.add(eightHearths);
		cards.add(tenDiamonds);
		cards.add(nineClubs);
		cards2.add(tenDiamonds);
		cards2.add(nineClubs);
		
		Player player = new Player();
		Player computer = new Player();
		
		player.setCards(cards);
		computer.setCards(cards2);
		
		CardFactoryHandler ch = new CardFactoryHandler();
		//ch.drawPlayer(player);
		ch.drawBothPlayers(player, computer);
	}
	
	private static void test3(){
		CardFactory cf = new CardFactory();
		Card eightHearths = cf.createCard(Color.HEARTHS, Value.ACE);
		Card sevenHearths = cf.createCard(Color.SPADES, Value.JACK);
		Card nineClubs = cf.createCard(Color.CLUBS, Value.NINE);
		Card tenDiamonds = cf.createCard(Color.DIAMONDS, Value.TEN);
		
		List<Card> cards = new ArrayList<>();
		List<Card> cards2 = new ArrayList<>();
		
		cards.add(sevenHearths);
		cards.add(eightHearths);
		cards.add(tenDiamonds);
		cards.add(nineClubs);
		cards2.add(tenDiamonds);
		cards2.add(nineClubs);
		
		Player player = new Player();
		Player computer = new Player();
		
		player.setCards(cards);
		computer.setCards(cards2);
		
		CardFactoryHandler ch = new CardFactoryHandler();
		//ch.drawPlayer(player);
		ch.drawBothPlayersSecondStyle(player, computer);
	}
	
	private static void test4(){
		CardFactory cf = new CardFactory();
		Card eightHearths = cf.createCard(Color.HEARTHS, Value.ACE);
		Card sevenHearths = cf.createCard(Color.SPADES, Value.JACK);
		Card nineClubs = cf.createCard(Color.CLUBS, Value.NINE);
		Card tenDiamonds = cf.createCard(Color.DIAMONDS, Value.TEN);
		
		List<Card> cards = new ArrayList<>();
		List<Card> cards2 = new ArrayList<>();
		
		cards.add(sevenHearths);
		cards.add(eightHearths);
		cards.add(nineClubs);
		cards2.add(tenDiamonds);
		cards2.add(nineClubs);
		
		Player player = new Player();
		Player computer = new Player();
		
		player.setCards(cards);
		computer.setCards(cards2);
		
		CardFactoryHandler ch = new CardFactoryHandler();
		//ch.drawPlayer(player);
		ch.drawGameBoard(player, computer, 1);
		ch.drawGameBoard(player, computer, 2);
	}
}

