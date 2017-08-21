package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import handler.*;
import handler.game.StartHandler;
import handler.print.Print;
import handler.print.PrintFactory;
import handler.print.menu.Menu;
import handler.print.player.GameBoard;
import model.*;
import model.cardfactory.*;
import model.deck.CardDeckFactory;
import model.deck.Deck;
import util.Const;
import util.DimensionsException;
import util.Settings;

public class Start { // TODO test settings / change setings
	// handlers
	static DeckHandler	   deckHandler			 = new DeckHandler();
	static StartHandler	   ruleSetHandler		 = new StartHandler();
	static Print		   printFactory			 = new PrintFactory();
	static CardDeckFactory deckFactory			 = new CardDeckFactory();
	static Menu			   printMenuHandler		 = printFactory
			.createPrintOutMenuHandler();
	static GameBoard	   printGameBoardHandler = printFactory
			.createPrintOutGameBoardHandler();

	// helper variables
	static int			   playerHandValue		 = 0;
	static int			   computerHandValue	 = 0;
	static boolean		   endProgram			 = false;
	static boolean		   endGame				 = false;
	static String		   input				 = "";
	static List<Card>	   playerHand			 = new ArrayList<>();
	static List<Card>	   computerHand			 = new ArrayList<>();
	static Deck			   cardPile				 = deckFactory.createCardDeck();
	static Deck			   cardDeck				 = deckFactory.createCardDeck();
	static Player		   player				 = new Player("Player");
	static Player		   computer				 = new Player("Computer");

	// variables from settings
	static Settings		   gameSettings			 = Settings.getInstance();

	static int			   score				 = gameSettings.getBeginningScore();
	static int			   drawingStyle			 = gameSettings.getDrawStyle();
	static int			   playerBank			 = gameSettings.getPlayersBeginingMoney();
	static int			   computerBank			 = gameSettings.getPlayersBeginingMoney();
	static int			   bet					 = gameSettings.getMinimalBet();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		cardDeck.addCards(deckHandler.createDeck());

		while (!endProgram) {
			printMenuHandler.createMenu(Const.MENU_MAIN);
			input = sc.next();
			switch (input) {
				case "1":
					setUpNewGame();
					startGame(sc);
					break;

				case "2":
					printMenuHandler.createMenu(Const.MENU_SETTINGS);
					settingsMain(sc);
					updateStartFromGameSettings();
					break;

				case "3":
					score = gameSettings.getBeginningScore() - score;
					printMenuHandler.createMenu(Const.MENU_END, score);
					endProgram = true;
					break;

				default:
					break;
			}
		}
	}

	/**
	 * Methods responsible for game flow
	 */
	private static void startGame(Scanner sc) {
		while (!endGame) {
			if (ruleSetHandler.isHandValueMoreThanMaxValue(playerHandValue)) {
				printMenuHandler.createMenu(Const.MENU_OVERFLOW, player, playerHandValue);
				// update values
				computerBank = ruleSetHandler.addBetValue(bet, computerBank);
				playerBank = ruleSetHandler.substractBetValue(bet, playerBank);
				score = ruleSetHandler.updateFinalScore(bet, score);
				resetRound();
			}

			endGame = isGameEnd();
			if (endGame) {
				break;
			}

			printMenuHandler.createMenu(Const.MENU_STATUS, playerHandValue, playerBank,
					computerBank);
			printMenuHandler.createMenu(Const.MENU_CONTINUE);

			input = sc.next();

			switch (input) {
				// players turn
				case "1":
					playerTurn(sc);
					break;

				// computers turn
				case "2":
					if (player.getCards() == null || player.getCards().size() < 1) {
						System.out.println("please draw a card before continuing");
						break;
					}
					computersTurn(playerHandValue);
					// printout board
					printGameBoardHandler.drawGameBoard(drawingStyle, player, computer);

					// update standings
					endRoundUpdate();

					// reset hands
					resetRound();
					break;

				case "3":
					// playe has less score when he leaves the game early
					endGame = true;
					score = gameSettings.getBeginningScore() - score;
					printMenuHandler.createMenu(Const.MENU_RETURN, score);
					resetRound();
					break;

				default:
					break;
			}
		}
	}

	private static void setUpNewGame() {
		endGame = false;
		score = gameSettings.getBeginningScore();
		playerBank = gameSettings.getPlayersBeginingMoney();
		computerBank = gameSettings.getPlayersBeginingMoney();
		bet = gameSettings.getMinimalBet();
	}

	private static void resetRound() {

		// add cards to pile
		cardPile.addCards(playerHand);
		cardPile.addCards(computerHand);

		// drop hand
		playerHand.clear();
		computerHand.clear();

		// clear players cards
		computer.setCards(playerHand);
		player.setCards(computerHand);

		// reset hand counts
		computerHandValue = 0;
		playerHandValue = 0;
	}

	private static int playerTurn(Scanner sc) {
		// take card if deck is empty shuffle pile
		// bet
		if (playerHand == null || playerHand.size() < 1) {
			printMenuHandler.createMenu(Const.MENU_Bet, bet);
			bet = ruleSetHandler.setBet(sc);
			// double down?
		} else if (playerHand.size() == 1) {
			printMenuHandler.createMenu(Const.MENU_DOUBLE_DOWN);
			bet = ruleSetHandler.setBetDoubleDown(sc, bet);
		}

		// take card if deck is empty, shuffle pile
		if (cardDeck.isEmpty()) {
			cardDeck = ruleSetHandler.shufflePileIntoDeck(cardDeck, cardPile);
			cardPile.clear();
		}

		playerHand.add(cardDeck.getCard());
		player.setCards(playerHand);
		playerHandValue = ruleSetHandler.countCardsInHand(playerHand);
		printGameBoardHandler.drawGameBoard(drawingStyle, player);

		return playerHandValue;
	}

	private static int computersTurn(int playerHandValue) {
		// simple computer logic
		while (true) {
			// is overflow?
			if (ruleSetHandler.isHandValueMoreThanMaxValue(computerHandValue)) {
				printMenuHandler.createMenu(Const.MENU_OVERFLOW, player, playerHandValue);
				break;
			} else if (playerHandValue < computerHandValue) {
				break;
			} else {
				// take card if deck is empty, shuffle pile
				if (cardDeck.isEmpty()) {
					cardDeck = ruleSetHandler.shufflePileIntoDeck(cardDeck, cardPile);
					cardPile.clear();
				}
				computerHand.add(cardDeck.getCard());
				computerHandValue = ruleSetHandler.countCardsInHand(computerHand);
			}
		}
		// set computers hand
		computer.setCards(computerHand);

		return computerHandValue;
	}

	private static void endRoundUpdate() {
		// player lost
		if (computerHandValue < 21 && computerHandValue > playerHandValue) {
			// update score for players
			computerBank = ruleSetHandler.addBetValue(bet, computerBank);
			playerBank = ruleSetHandler.substractBetValue(bet, playerBank);
			score = ruleSetHandler.updateFinalScore(bet, score);
			printMenuHandler.createMenu(Const.MENU_WIN_ROUND, player, computer,
					playerHandValue, computerHandValue);
			// PlayerWon update score and winnings
		} else {
			playerBank = ruleSetHandler.addBetValue(bet, playerBank);
			computerBank = ruleSetHandler.substractBetValue(bet, computerBank);
			printMenuHandler.createMenu(Const.MENU_WIN_ROUND, player, computer,
					playerHandValue, computerHandValue);
		}
	}

	private static boolean isGameEnd() {
		if (ruleSetHandler.isBankZero(playerBank)) {
			endGame = true;
			printMenuHandler.createMenu(Const.MENU_LOST, score);
		} else if (ruleSetHandler.isBankZero(computerBank)) {
			endGame = true;
			printMenuHandler.createMenu(Const.MENU_WIN, score);
		} else {
			endGame = false;
		}

		return endGame;
	}

	private static void settingsMain(Scanner sc) {
		input = sc.next();
		switch (input) {
			case "1":
				printMenuHandler.createMenu(Const.MENU_SETTINGS_SUBMENU_PRINTOOUT);
				settingsSubmenuPrintout(sc);
				break;
			case "2":
				printMenuHandler.createMenu(Const.MENU_SETTINGS_SUBMENU_PLAYER);
				settingsSubmenuPlayer(sc);
				break;
			case "3":
				printMenuHandler.createMenu(Const.MENU_SETTINGS_SUBMENU_MONEY);
				settingsSubmenuMoney(sc);
				break;
			case "4":
				break;

			default:
				break;
		}
	}

	private static void settingsSubmenuPrintout(Scanner sc) {
		int value = 0;
		int value2 = 0;
		input = sc.next();

		switch (input) {
			case "1":
				System.out.println("Set Lenght of menus. X - size");
				value = sc.nextInt();
				gameSettings.setMenuLenght(value);
				break;
			case "2":
				System.out.println("Set printout size of cards");
				System.out.println("Set Lenght of X - size");
				value = sc.nextInt();
				System.out.println("Set Lenght of Y - size");
				value2 = sc.nextInt();
				try {
					gameSettings.setCardSize(value, value2);
				} catch (DimensionsException e) {
					e.printStackTrace();
				}
				break;
			case "3":
				System.out.println("Set space between player cards");
				value = sc.nextInt();
				gameSettings.setSpaceBetweenPlayers(value);
				break;
			case "4":
				value = sc.nextInt();
				System.out.println("Set the size of bottom card");
				gameSettings.setCardPartialSizeX(value);
				break;
			case "5":
				value = sc.nextInt();
				System.out.println("Set drawing style");
				System.out.println("1. Same Way From Left to right. Most reft card top");
				System.out.println("2. Same Way From right to left. Most right card top");
				System.out.println("3. Mirror way");
				System.out.println("4. Reverse mirror way");
				gameSettings.setDrawStyle(value);
				break;
			case "6":
				break;
			default:
				break;
		}
	}

	private static void settingsSubmenuPlayer(Scanner sc) {
		input = sc.next();
		switch (input) {
			case "1":
				System.out.println("Set Player name: ");
				gameSettings.setPlayerName(input);
				break;
			case "2":
				System.out.println("Set Computer name: ");
				gameSettings.setComputerName(input);
				break;
			default:
				break;
		}
	}

	private static void settingsSubmenuMoney(Scanner sc) {
		int value = 0;
		input = sc.next();
		switch (input) {
			case "1":
				value = sc.nextInt();
				System.out.println("Set player beginning bank");
				gameSettings.setPlayersBeginingMoney(value);
				break;
			case "2":
				value = sc.nextInt();
				System.out.println("Set computers beginning money");
				gameSettings.setComputersBeginingMoney(value);
				break;
			case "3":
				value = sc.nextInt();
				System.out.println("Set beginning score");
				gameSettings.setBeginningScore(value);
				break;
			case "4":
				System.out.println("Set minimal value player can bet");
				value = sc.nextInt();
				gameSettings.setMinimalBet(value);
				break;
			case "5":
				System.out.println("Set maximum value player can bet");
				value = sc.nextInt();
				gameSettings.setMaximalBet(value);
				break;
			case "6":
				break;

			default:
				break;
		}
	}

	private static void updateStartFromGameSettings() {
		Start.player.setName(gameSettings.getPlayer().getName());
		Start.computer.setName(gameSettings.getPlayer().getName());
		
		Start.score 	   = gameSettings.getBeginningScore();
		Start.drawingStyle = gameSettings.getDrawStyle();
		Start.playerBank   = gameSettings.getPlayersBeginingMoney();
		Start.computerBank = gameSettings.getPlayersBeginingMoney();
		Start.bet 		   = gameSettings.getMinimalBet();
	}
}
