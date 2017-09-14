package app;

import java.util.ArrayList;
import java.util.List;

import handler.DeckHandler;
import handler.game.StartHandler;
import handler.print.Print;
import handler.print.PrintFactory;
import handler.print.menu.Printout;
import handler.print.player.GameBoard;
import model.Player;
import model.cardfactory.Card;
import model.deck.CardDeckFactory;
import model.deck.Deck;
import util.Settings;

public class Screen {
	private static Screen			 instance;
	// handlers
	protected static DeckHandler	 deckHandler		   = new DeckHandler();
	protected static StartHandler	 startHandler		   = new StartHandler();
	protected static Print			 printFactory		   = new PrintFactory();
	protected static CardDeckFactory deckFactory		   = new CardDeckFactory();
	protected static GameBoard		 printGameBoardHandler = printFactory.createPrintOutGameBoardHandler();
	protected static Printout		 printMenuHandler	   = printFactory.createPrintOutMenuHandler();

	// helper variables
	protected static int			 playerHandValue	   = 0;
	protected static int			 computerHandValue	   = 0;
	protected static boolean		 endProgram			   = false;
	protected static boolean		 endGame			   = false;
	protected static String			 input				   = "";
	protected static List<Card>		 playerHand			   = new ArrayList<>();
	protected static List<Card>		 computerHand		   = new ArrayList<>();
	protected static Deck			 cardPile			   = deckFactory.createCardDeck();
	protected static Deck			 cardDeck			   = deckFactory.createCardDeck();
	protected static Player			 player				   = new Player("Player");
	protected static Player			 computer			   = new Player("Computer");

	// variables from settings
	protected static Settings		 gameSettings		   = Settings.getInstance();

	protected static int			 score				   = gameSettings.getBeginningScore();
	protected static int			 drawingStyle		   = gameSettings.getDrawStyle();
	protected static int			 playerBank			   = gameSettings.getPlayersBeginingMoney();
	protected static int			 computerBank		   = gameSettings.getPlayersBeginingMoney();
	protected static int			 bet				   = gameSettings.getMinimalBet();

	protected Screen() {

	}

	public static Screen getInstance() {
		if (instance == null) {
			instance = new Screen();
		}
		return instance;
	}

	// G + S

	public static GameBoard getPrintGameBoardHandler() {
		return printGameBoardHandler;
	}

	public static int getPlayerHandValue() {
		return playerHandValue;
	}

	public static int getComputerHandValue() {
		return computerHandValue;
	}

	public static boolean isEndProgram() {
		return endProgram;
	}

	public static boolean isEndGame() {
		return endGame;
	}

	public static String getInput() {
		return input;
	}

	public static List<Card> getPlayerHand() {
		return playerHand;
	}

	public static List<Card> getComputerHand() {
		return computerHand;
	}

	public static Deck getCardPile() {
		return cardPile;
	}

	public static Deck getCardDeck() {
		return cardDeck;
	}

	public static Player getPlayer() {
		return player;
	}

	public static Player getComputer() {
		return computer;
	}

	public static int getScore() {
		return score;
	}

	public static int getDrawingStyle() {
		return drawingStyle;
	}

	public static int getPlayerBank() {
		return playerBank;
	}

	public static int getComputerBank() {
		return computerBank;
	}

	public static int getBet() {
		return bet;
	}

}
