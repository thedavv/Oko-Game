package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import handler.*;
import handler.printhandler.MenuPrintOut;
import handler.printhandler.card.GameBoardPrintout;
import model.*;
import model.cardfactory.*;
import model.deck.Deck;
import util.Settings;

public class Start { // TODO test settings / change setings / Bug with drawing
						// cards from deck
	// helper variables
	private static Settings		gameSettings				= Settings.getInstance();
	static int					playerHandValue				= 0;
	static int					computerHandValue			= 0;
	// TODO implement game logic
	static int					playerBank					= 0;
	static int					computerBank				= 0;
	static int					finalScore					= 0;
	static boolean				endProgram					= false;
	static boolean				endGame						= false;
	static String				input						= "";
	static List<Card>			playerHand					= new ArrayList<>();
	static List<Card>			computerHand				= new ArrayList<>();

	// variables from settings
	static Player				player						= gameSettings.getPlayer();
	static Player				computer					= gameSettings.getComputer();
	static int					drawingStyle				= gameSettings.getDrawStyle();
	static Deck					cardDeck					= gameSettings.getDeck();
	static Deck					cardPile					= gameSettings.getPile();

	// handlers
	static DeckHandler			deckHandler					= new DeckHandler();
	static GameBoardPrintout	gameboardPrintoutHandler	= new GameBoardPrintout();
	static MenuPrintOut			menuPrintoutHandler			= new MenuPrintOut();
	static RuleSetHandler		ruleSetHandler				= new RuleSetHandler();

	public static void main(String[] args) { // TODO score/start bank/Bet
		Scanner sc = new Scanner(System.in);
		cardDeck.addCards(deckHandler.createDeck());

		while (!endProgram) {
			menuPrintoutHandler.createMainMenuPrintout();
			input = sc.next();
			switch (input) {
			case "1":
				endGame = false;
				startGame(sc);
				break;

			case "2":
				menuPrintoutHandler.createSettingsMenuPrintout();
				break;

			case "3":
				menuPrintoutHandler.createEndScreenPrintout(finalScore);
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
				menuPrintoutHandler.createOverflowPrintout(player.getName(),
						playerHandValue);
				resetRound();
			}
			menuPrintoutHandler.createStatusMenuPrintout(playerHandValue, playerBank,
					computerBank);
			menuPrintoutHandler.createContinueMenuPrintout();

			input = sc.next();
			switch (input) {
			case "1": // players turn
				playerTurn();
				break;

			// computers turn
			case "2": // TODO update bank
				if (player.getCards() == null || player.getCards().size() < 1) {
					System.out.println("please draw a card before continuing");
					break;
				}
				computersTurn(playerHandValue);
				// printout board
				gameboardPrintoutHandler.drawGameBoard(drawingStyle, player, computer);

				// TODO implement score
				if (computerHandValue < 21 && computerHandValue > playerHandValue) {
					// win screen
					menuPrintoutHandler.createWinRoundScreen(computer.getName(),
							player.getName(), computerHandValue, playerHandValue);
				} else {
					menuPrintoutHandler.createWinRoundScreen(player.getName(),
							computer.getName(), playerHandValue, computerHandValue);
				}
				// reset hands
				resetRound();
				break;

			case "3": // TODO score
				endGame = true;
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
				menuPrintoutHandler.createOverflowPrintout(computer.getName(),
						computerHandValue);
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
		gameboardPrintoutHandler.drawGameBoard(drawingStyle, player);

		return playerHandValue;
	}

	private static void isDeckEmpty() {
		if (cardDeck.isEmpty()) {
			cardDeck.addCards(cardPile.getAllCards());
			cardDeck.shuffle();
			cardPile.clear();
		}
	}
}
