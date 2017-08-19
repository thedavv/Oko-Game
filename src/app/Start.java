package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import handler.*;
import handler.printhandler.Print;
import handler.printhandler.PrintHandler;
import handler.printhandler.menu.Menu;
import handler.printhandler.menu.MenuCreation;
import handler.printhandler.menu.MenuPrintOut;
import handler.printhandler.player.GameBoard;
import handler.printhandler.player.GameBoardPrintOut;
import model.*;
import model.cardfactory.*;
import model.deck.Deck;
import util.Const;
import util.Settings;

public class Start { // TODO test settings / change setings
	// helper variables
	private static Settings		gameSettings				= Settings.getInstance();
	static int					playerHandValue				= 0;
	static int					computerHandValue			= 0;
	static int					bet							= 0;
	// TODO implement game logic

	static boolean				endProgram					= false;
	static boolean				endGame						= false;
	static String				input						= "";
	static List<Card>			playerHand					= new ArrayList<>();
	static List<Card>			computerHand				= new ArrayList<>();

	// variables from settings
	static int					finalScore					= gameSettings.getFinalScore();
	static Player				player						= gameSettings.getPlayer();
	static Player				computer					= gameSettings.getComputer();
	static int					drawingStyle				= gameSettings.getDrawStyle();
	static Deck					cardDeck					= gameSettings.getDeck();
	static Deck					cardPile					= gameSettings.getPile();
	static int					playerBank					= gameSettings
			.getPlayersBeginingMoney();
	static int					computerBank				= gameSettings
			.getPlayersBeginingMoney();;

	// handlers
	static DeckHandler			deckHandler					= new DeckHandler();
	static RuleSetHandler		ruleSetHandler				= new RuleSetHandler();
	static Print				printHandler				= new PrintHandler();
	static Menu					printMenu					= printHandler.createPrintOutMenuHandler();
	static GameBoard			printGameBoard				= printHandler.createPrintOutGameBoardHandler();

	public static void main(String[] args) { // TODO Bet
		
		
		Scanner sc = new Scanner(System.in);
		cardDeck.addCards(deckHandler.createDeck());

		while (!endProgram) {
			printMenu.createMenu(Const.MENU_MAIN);
			input = sc.next();
			switch (input) {
			case "1":
				endGame = false;
				finalScore = gameSettings.getFinalScore();
				startGame(sc);
				break;

			case "2":
				printMenu.createMenu(Const.MENU_SETTINGS);
				break;

			case "3":
				printMenu.createMenu(Const.MENU_END, finalScore);
				endProgram = true;
				break;

			default:
				break;
			}
		}
	}

	/**
	 * Methods responsible for program flow
	 */
	private static void resetRound() {

		cardPile.addCards(playerHand);// add cards to pile
		cardPile.addCards(computerHand);

		playerHand.clear(); // drop hand
		computerHand.clear();

		computer.setCards(playerHand); // clear players cards
		player.setCards(computerHand);

		computerHandValue = 0; // reset hand counts
		playerHandValue = 0;
	}

	private static void startGame(Scanner sc) {
		// TODO shuffle cards from stack dont create another deck
		while (!endGame) {
			// TODO update Bank
			if (ruleSetHandler.isHandValueMoreThanMaxValue(playerHandValue)) {
				printMenu.createMenu(Const.MENU_OVERFLOW, player, playerHandValue);
				substractLostValue(bet);
				resetRound();
			}
			// TODO winning screen
			if (isBankZero(playerBank)) {
				endGame = true;
				printMenu.createMenu(Const.MENU_LOST, finalScore);
				break;
			} else if (isBankZero(computerBank)) {
				endGame = true;
				printMenu.createMenu(Const.MENU_WIN, finalScore);
				break;
			}

			// TODO bet Screem
			// input = sc.next();
			bet = 4;

			printMenu.createMenu(Const.MENU_STATUS, playerHandValue, playerBank,
					computerBank);
			printMenu.createMenu(Const.MENU_CONTINUE);
			input = sc.next();
			switch (input) {
			case "1": // players turn
				playerTurn();
				break;

			// computers turn
			// TODO update screen
			case "2": // TODO update bank
				if (player.getCards() == null || player.getCards().size() < 1) {
					System.out.println("please draw a card before continuing");
					break;
				}
				computersTurn(playerHandValue);
				// printout board
				printGameBoard.drawGameBoard(drawingStyle, player, computer);

				// player Lost substract winnings
				if (computerHandValue < 21 && computerHandValue > playerHandValue) {
					substractLostValue(bet);
					printMenu.createMenu(Const.MENU_WIN_ROUND, player, computer, playerHandValue, computerHandValue);
				} else {
					// PlayerWon add score and winnings
					addWonValue(bet);
					printMenu.createMenu(Const.MENU_WIN_ROUND, player, computer, playerHandValue, computerHandValue);
				}
				// reset hands
				resetRound();
				break;

			case "3":
				// playe has less score when he leaves the game early
				endGame = true;
				finalScore = gameSettings.getFinalScore() - finalScore;
				printMenu.createMenu(Const.MENU_RETURN, finalScore);
				resetRound();
				break;

			default:
				break;
			}
		}
	}

	/**
	 * methods that simulate player turn. Return hand value
	 */
	// TODO dont count if player overflow
	private static int computersTurn(int playerHandValue) {
		// simple computer logic
		while (true) {
			// is overflow?
			if (ruleSetHandler.isHandValueMoreThanMaxValue(computerHandValue)) {
				printMenu.createMenu(Const.MENU_OVERFLOW, player, playerHandValue);
				break;
			} else if (playerHandValue < computerHandValue) {
				break;
			} else {
				// take card if deck is empty shuffle pile
				isDeckEmpty();
				computerHand.add(cardDeck.getCard());
				computerHandValue = ruleSetHandler.countCardsInHand(computerHand);
			}
		}
		// set computers hand
		computer.setCards(computerHand);

		return computerHandValue;
	}

	private static int playerTurn() {
		// take card if deck is empty shuffle pile
		isDeckEmpty();
		playerHand.add(cardDeck.getCard());
		player.setCards(playerHand);
		playerHandValue = ruleSetHandler.countCardsInHand(playerHand);
		printGameBoard.drawGameBoard(drawingStyle, player);

		return playerHandValue;
	}

	private static void isDeckEmpty() {
		if (cardDeck.isEmpty()) {
			cardDeck.addCards(cardPile.getAllCards());
			cardDeck.shuffle();
			cardPile.clear();
		}
	}

	private static void addWonValue(int bet) {
		playerBank += bet;
		computerBank -= bet;
	}

	private static void substractLostValue(int bet) {
		playerBank -= bet;
		computerBank += bet;
		finalScore -= bet * 25;
	}

	private static boolean isBankZero(int playerBank) {
		return (playerBank <= 0) ? true : false;
	}
}
