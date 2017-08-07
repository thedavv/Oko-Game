package app;


import java.util.ArrayList;
import java.util.List;

import handler.*;
import model.*;
import model.cardfactory.*;
import model.cardproperty.*;
import util.DimensionsException;
import util.Settings;

public class Start {
	public static void main(String[] args) {
		Settings s = Settings.getInstance();
		
		try {
			s.setCardSize(10, 8);
		} catch (DimensionsException e) {
			e.printStackTrace();
		}
		
		//test
		//System.out.println(s.getCardSizeX() + " " + s.getCardSizeY());
		
		/*CardFactory cf = new CardFactory();
		Card eightHearths = cf.getCard(Color.HEARTHS, Value.EIGHT);
		Card sevenHearths = cf.getCard(Color.HEARTHS, Value.SEVEN);
		Card nineClubs = cf.getCard(Color.CLUBS, Value.NINE);
		Card tenDiamonds = cf.getCard(Color.DIAMONDS, Value.TEN);
		
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
		ch.drawPlayer(player);
		ch.drawBothPlayers(player, computer);*/
		
		test1();
		test2();
		
	}
	
	private static void test1(){
		CardFactory cf = new CardFactory();
		Card eightHearths = cf.getCard(Color.HEARTHS, Value.EIGHT);
		Card sevenHearths = cf.getCard(Color.HEARTHS, Value.SEVEN);
		Card nineClubs = cf.getCard(Color.CLUBS, Value.NINE);
		Card tenDiamonds = cf.getCard(Color.DIAMONDS, Value.TEN);
		
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
		Card eightHearths = cf.getCard(Color.HEARTHS, Value.EIGHT);
		Card sevenHearths = cf.getCard(Color.HEARTHS, Value.SEVEN);
		//Card nineClubs = cf.getCard(Color.CLUBS, Value.NINE);
		//Card tenDiamonds = cf.getCard(Color.DIAMONDS, Value.TEN);
		
		List<Card> cards = new ArrayList<>();
		//cards.add(tenDiamonds);
		//cards.add(nineClubs);
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
	
}

