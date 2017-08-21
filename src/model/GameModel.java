package model;

import java.util.ArrayList;
import java.util.List;

import handler.DeckHandler;
import handler.game.StartHandler;
import handler.print.Print;
import handler.print.PrintFactory;
import handler.print.menu.Menu;
import handler.print.player.GameBoard;
import model.cardfactory.Card;
import model.deck.CardDeckFactory;
import model.deck.Deck;
import util.Settings;

public class GameModel {
	// handlers
	protected static DeckHandler	 deckHandler		   = new DeckHandler();
	protected static StartHandler	 ruleSetHandler		   = new StartHandler();
	protected static Print			 printFactory		   = new PrintFactory();
	protected static CardDeckFactory deckFactory		   = new CardDeckFactory();
	protected static Menu			 printMenuHandler	   = printFactory
			.createPrintOutMenuHandler();
	protected static GameBoard		 printGameBoardHandler = printFactory
			.createPrintOutGameBoardHandler();

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

	protected static int			 score				   = gameSettings
			.getBeginningScore();
	protected static int			 drawingStyle		   = gameSettings.getDrawStyle();
	protected static int			 playerBank			   = gameSettings
			.getPlayersBeginingMoney();
	protected static int			 computerBank		   = gameSettings
			.getPlayersBeginingMoney();
	protected static int			 bet				   = gameSettings.getMinimalBet();
}
