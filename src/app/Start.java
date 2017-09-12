package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import handler.DeckHandler;
import handler.game.StartHandler;
import handler.print.Print;
import handler.print.PrintFactory;
import handler.print.menu.Menu;
import handler.print.player.GameBoard;
import model.*;
import model.cardfactory.Card;
import model.deck.CardDeckFactory;
import model.deck.Deck;
import util.Const;
import util.DimensionsException;
import util.InvalidArgumentException;
import util.Settings;

public class Start {
	// handlers
	private static DeckHandler	   deckHandler			 = new DeckHandler();
	private static StartHandler	   startHandler			 = new StartHandler();
	private static Print		   printFactory			 = new PrintFactory();
	private static CardDeckFactory deckFactory			 = new CardDeckFactory();
	private static Menu			   printMenuHandler		 = printFactory
			.createPrintOutMenuHandler();
	static GameBoard			   printGameBoardHandler = printFactory
			.createPrintOutGameBoardHandler();

	// helper variables
	private static int			   playerHandValue		 = 0;
	private static int			   computerHandValue	 = 0;
	private static boolean		   endProgram			 = false;
	private static boolean		   endGame				 = false;
	private static String		   input				 = "";
	private static List<Card>	   playerHand			 = new ArrayList<>();
	private static List<Card>	   computerHand			 = new ArrayList<>();
	private static Deck			   cardPile				 = deckFactory.createCardDeck();
	private static Deck			   cardDeck				 = deckFactory.createCardDeck();
	private static Player		   player				 = new Player("Player");
	private static Player		   computer				 = new Player("Computer");

	// variables from settings
	private static Settings		   gameSettings			 = Settings.getInstance();

	private static int			   score				 = gameSettings
			.getBeginningScore();
	private static int			   drawingStyle			 = gameSettings.getDrawStyle();
	private static int			   playerBank			 = gameSettings
			.getPlayersBeginingMoney();
	private static int			   computerBank			 = gameSettings
			.getPlayersBeginingMoney();
	private static int			   bet					 = gameSettings.getMinimalBet();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (!endProgram) {
			printMenuHandler.createMenu(Const.MENU_MAIN);
			input = sc.next();

			switch (input) {
				// new game
				case "1":
					setUpNewGame();
					startGame(sc);
					break;
				// settings
				case "2":
					printMenuHandler.createMenu(Const.MENU_SETTINGS);
					settingsMain(sc);
					updateStartFromGameSettings();
					break;

				case "3":
					printMenuHandler.createMenu(Const.MENU_END, score);
					startHandler.storeFinalScore(player.getName(), score,
							gameSettings.getScoreFile());
					endProgram = true;
					break;
				// scoreboard
				case "4":
					String s = startHandler
							.getFinalScoreLeaderboard(gameSettings.getScoreFile());
					printMenuHandler.createMenu(Const.MENU_SCOREBOARD, s);
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
			if (startHandler.isHandValueMoreThanMaxValue(playerHandValue)) {
				printMenuHandler.createMenu(Const.MENU_OVERFLOW, player, playerHandValue);
				// update values
				computerBank = startHandler.addBetValue(bet, computerBank);
				playerBank = startHandler.substractBetValue(bet, playerBank);
				score = startHandler.updateScorePlayerLost(bet, score);
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
					// player has less score when he leaves the game early
					endGame = true;
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

		cardPile.clear();
		cardDeck.clear();
		cardDeck.addCards(deckHandler.createDeck());
		cardDeck.shuffle();
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

	/**
	 * Player and computer turns
	 */
	private static int playerTurn(Scanner sc) {
		// take card if deck is empty shuffle pile
		// bet
		if (playerHand == null || playerHand.size() < 1) {
			printMenuHandler.createMenu(Const.MENU_BET, bet);
			bet = startHandler.setBet(sc);
			// double down?
		} else if (playerHand.size() == 1) {
			printMenuHandler.createMenu(Const.MENU_DOUBLE_DOWN);
			bet = startHandler.setBetDoubleDown(sc, bet);
		}

		// take card if deck is empty, shuffle pile
		if (cardDeck.isEmpty()) {
			cardDeck = startHandler.shufflePileIntoDeck(cardDeck, cardPile);
			cardDeck.shuffle();
			cardPile.clear();
		}

		playerHand.add(cardDeck.getCard());
		player.setCards(playerHand);
		playerHandValue = startHandler.countCardsInHand(playerHand);
		printGameBoardHandler.drawGameBoard(drawingStyle, player);

		return playerHandValue;
	}

	private static int computersTurn(int playerHandValue) {
		// simple computer logic
		while (true) {
			// is overflow?
			if (startHandler.isHandValueMoreThanMaxValue(computerHandValue)) {
				printMenuHandler.createMenu(Const.MENU_OVERFLOW, computer,
						computerHandValue);
				break;
			} else if (playerHandValue < computerHandValue) {
				break;
			} else {
				// take card if deck is empty, shuffle pile
				if (cardDeck.isEmpty()) {
					cardDeck = startHandler.shufflePileIntoDeck(cardDeck, cardPile);
					cardDeck.shuffle();
					cardPile.clear();
				}
				computerHand.add(cardDeck.getCard());
				computerHandValue = startHandler.countCardsInHand(computerHand);
			}
		}
		// set computers hand
		computer.setCards(computerHand);

		return computerHandValue;
	}

	/**
	 * Methods for updating score
	 */
	private static void endRoundUpdate() {
		// player lost
		if (computerHandValue < 21 && computerHandValue > playerHandValue) {
			// update score for players
			computerBank = startHandler.addBetValue(bet, computerBank);
			playerBank = startHandler.substractBetValue(bet, playerBank);
			score = startHandler.updateScorePlayerLost(bet, score);
			printMenuHandler.createMenu(Const.MENU_WIN_ROUND, player, computer,
					playerHandValue, computerHandValue, false);
			// PlayerWon update score and winnings
		} else {
			playerBank = startHandler.addBetValue(bet, playerBank);
			computerBank = startHandler.substractBetValue(bet, computerBank);
			score = startHandler.updateScorePlayerWon(bet, score);
			printMenuHandler.createMenu(Const.MENU_WIN_ROUND, player, computer,
					playerHandValue, computerHandValue, true);
		}
	}

	private static boolean isGameEnd() {
		if (startHandler.isBankZero(playerBank)) {
			endGame = true;
			printMenuHandler.createMenu(Const.MENU_LOST, score);
		} else if (startHandler.isBankZero(computerBank)) {
			endGame = true;
			printMenuHandler.createMenu(Const.MENU_WIN, score);
		} else {
			endGame = false;
		}

		return endGame;
	}

	/**
	 * Methods responsible for settings update
	 */
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
				try {
					System.out.println("Set Lenght of menus. X - size");
					value = sc.nextInt();
					gameSettings.setMenuLenght(value);
				} catch (DimensionsException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					System.err.println("bad input");
					e1.printStackTrace();
				}
				break;
			case "2":
				try {
					System.out.println("Set printout size of cards");
					System.out.println("Set Lenght of X - size");
					value = sc.nextInt();
					System.out.println("Set Lenght of Y - size");
					value2 = sc.nextInt();
					gameSettings.setCardSize(value, value2);
				} catch (DimensionsException e) {
					e.printStackTrace();
				} catch (Exception e1) {
					System.err.println("bad input");
					e1.printStackTrace();
				}
				break;
			case "3":
				try {
					System.out.println("Set space between player cards");
					value = sc.nextInt();
					gameSettings.setSpaceBetweenPlayers(value);
				} catch (DimensionsException e) {
					e.printStackTrace();
				} catch (Exception e1) {
					System.err.println("bad input");
					e1.printStackTrace();
				}
				break;
			case "4":
				try {
					System.out.println("Set the size of bottom card");
					value = sc.nextInt();
					gameSettings.setCardPartialSizeX(value);
				} catch (DimensionsException e) {
					e.printStackTrace();
				} catch (Exception e1) {
					System.err.println("bad input");
					e1.printStackTrace();
				}
				break;
			case "5":
				try {
					System.out.println("Set drawing style");
					System.out.println("1. Same Way From Left to right. Most reft card top");
					System.out.println("2. Same Way From right to left. Most right card top");
					System.out.println("3. Mirror way");
					System.out.println("4. Reverse mirror way");
					value = sc.nextInt();
					gameSettings.setDrawStyle(value);
				} catch (InvalidArgumentException e) {
					e.printStackTrace();
				} catch (Exception e1) {
					System.err.println("bad input");
					e1.printStackTrace();
				}
				break;
			case "6":
				break;
			default:
				System.err.println("bad input");
				break;
		}
	}

	private static void settingsSubmenuPlayer(Scanner sc) {
		input = sc.next();
		switch (input) {
			case "1":
				System.out.println("Current player name is: " + player.getName());
				System.out.println("Set Player name: ");
				try {
					input = sc.next();
					gameSettings.setPlayerName(input);
				} catch (InvalidArgumentException e) {
					e.printStackTrace();
				}
				break;
			case "2":
				System.out.println("Current Computer name is: " + computer.getName());
				System.out.println("Set Computer name: ");
				try {
					input = sc.next();
					gameSettings.setComputerName(input);
				} catch (InvalidArgumentException e) {
					e.printStackTrace();
				}
				break;
			case "3":
				break;
			default:
				System.err.println("bad input");
				break;
		}
	}

	private static void settingsSubmenuMoney(Scanner sc) {
		int value = 0;
		input = sc.next();
		switch (input) {
			case "1":
				try {
					System.out.println("Set player beginning bank");
					value = sc.nextInt();
					gameSettings.setPlayersBeginingMoney(value);
				} catch (InvalidArgumentException e) {
					e.printStackTrace();
				} catch(Exception e){
					System.err.println("bad input");
					e.printStackTrace();
				}
				break;
			case "2":
				try {
					System.out.println("Set computers beginning money");
					value = sc.nextInt();
					gameSettings.setComputersBeginingMoney(value);
				} catch (InvalidArgumentException e) {
					e.printStackTrace();
				}catch(Exception e){
					System.err.println("bad input");
					e.printStackTrace();
				}
				break;
			case "3":
				try {
					System.out.println("Set beginning score");
					value = sc.nextInt();
					gameSettings.setBeginningScore(value);
				} catch (Exception e1) {
					System.err.println("bad input");
					e1.printStackTrace();
				}
				break;
			case "4":
				try {
					System.out.println("Set minimal value player can bet");
					value = sc.nextInt();
					gameSettings.setMinimalBet(value);
				} catch (InvalidArgumentException e) {
					e.printStackTrace();
				} catch (Exception e) {
					System.err.println("bad input");
					e.printStackTrace();
				}
				break;
			case "5":
				try {
					System.out.println("Set maximum value player can bet");
					value = sc.nextInt();
					gameSettings.setMaximalBet(value);
				} catch (InvalidArgumentException e) {
					e.printStackTrace();
				} catch (Exception e) {
					System.err.println("bad input");
					e.printStackTrace();
				}
				break;
			case "6":
				break;

			default:
				break;
		}
	}

	private static void updateStartFromGameSettings() {
		Start.player.setName(gameSettings.getPlayer().getName());
		Start.computer.setName(gameSettings.getComputer().getName());

		Start.score = gameSettings.getBeginningScore();
		Start.drawingStyle = gameSettings.getDrawStyle();
		Start.playerBank = gameSettings.getPlayersBeginingMoney();
		Start.computerBank = gameSettings.getComputersBeginingMoney();
		Start.bet = gameSettings.getMinimalBet();
	}
}
