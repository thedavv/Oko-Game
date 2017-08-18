package app;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import handler.*;
import handler.printhandler.CardPrintOut;
import handler.printhandler.MenuPrintOut;
import model.*;
import model.cardfactory.*;
import model.cardproperty.Value;
import util.Const;
import util.DimensionsException;
import util.Settings;

public class Start { //TODO test settings / change setings / Bug with drawing cards from deck
	//  helper variables
	private static Settings   	gameSettings 		 = Settings.getInstance();
	static int 				  	playerHandValue  	 = 0; 	
	static int 				  	computerHandValue 	 = 0; 	
	static int 				  	playerBank		     = 0; //TODO implement in game logic
	static int 				  	computerBank     	 = 0; //TODO implement in game logic
	static int 					finalScore			 = 0; //TODO implement in game logic
	static boolean    		  	endProgram			 = false;
	static boolean    		  	endGame 		     = false;
	static String     		  	input 				 = "";
	static List<Card> 		    playerHand 			 = new ArrayList<>();
	static List<Card> 		    computerHand      	 = new ArrayList<>();

	//  variables from settings
	static Deck 			    cardDeck 		     = gameSettings.getDeck();
	static Player 			    player 		         = gameSettings.getPlayer();
	static Player 			    computer 		     = gameSettings.getComputer();

	//  handlers
	static CardPrintOut 	    cardPrintoutHandler  = new CardPrintOut();
	static MenuPrintOut 	    menuPrintoutHandler  = new MenuPrintOut();
	static RuleSetHandler       ruleSetHandler       = new RuleSetHandler();

	public static void main(String[] args) { //TODO score/start bank/Bet
//				try {
//					gameSettings.setCardSize(10, 12);
//				} catch (DimensionsException e) {
//					e.printStackTrace();
//				}
		Card c = cardDeck.getCard();
		//CardPrintOut.drawCard(c.getColor(), Value.NINE, 3);//Const.CARD_SIZE_X
		
		playerHand.add(cardDeck.getCard());
		playerHand.add(cardDeck.getCard());
		playerHand.add(cardDeck.getCard());
		playerHand.add(cardDeck.getCard());
		playerHand.add(cardDeck.getCard());
		System.out.print(CardPrintOut.createLeftSideOfLine(Const.CARD_SIZE_X / 2,  String.valueOf(Const.VL),  String.valueOf(Const.HL),  "10"));
		System.out.print(CardPrintOut.createRightSideOfLine(Const.CARD_SIZE_X / 2,  String.valueOf(Const.VL),  String.valueOf(Const.VL),  "10"));
		System.out.println();
		System.out.println(CardPrintOut.createCompleteLineRL(playerHand.size(), Const.CARD_SIZE_X, Const.CARD_PARTIAL_SIZE_X, String.valueOf(Const.TLC), String.valueOf(Const.TRC),String.valueOf(Const.TJ), String.valueOf(Const.HL), null));
		List<String> valueStrings = new ArrayList<>();
		for (Card ca : playerHand) {
			valueStrings.add(String.valueOf(c.getValue().getLabel()));
		}
		System.out.println(CardPrintOut.createCompleteLineLR(playerHand.size(), Const.CARD_SIZE_X, Const.CARD_PARTIAL_SIZE_X, String.valueOf(Const.TLC), String.valueOf(Const.TRC),String.valueOf(Const.TJ), String.valueOf(Const.HL), valueStrings));
		System.out.println(CardPrintOut.createStringRepresentationOfPlayersHand(playerHand));
		System.out.println(CardPrintOut.createStringRepresentationOfOfPlayersHandSecondStyle(playerHand));		
		//*******************************************
		Scanner sc = new Scanner(System.in);

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
	 * */
	private static void resetRound(){
		cardDeck.addCardsToStack(playerHand);               	 		 // add cards to pile
		cardDeck.addCardsToStack(computerHand);  

		playerHand.clear(); 								 		 // drop hand
		computerHand.clear();							

		computer.setCards(playerHand);			        			 // clear players cards
		player.setCards(computerHand);			

		computerHandValue = 0;										 // reset hand counts 
		playerHandValue   = 0;
	}

	private static void startGame(Scanner sc){
		while (!endGame) { // TODO shuffle cards from stack dont create another deck
			
			if(ruleSetHandler.isHandValueMoreThanMaxValue(playerHandValue)){ // TODO update Bank
				menuPrintoutHandler.createOverflowPrintout(player.getName(), playerHandValue);
				resetRound();	
			}
			menuPrintoutHandler.createStatusMenuPrintout(playerHandValue, playerBank, computerBank);
			menuPrintoutHandler.createContinueMenuPrintout();

			input = sc.next();
			switch (input) {
			case "1": 												// players turn
				playerTurn();
				break;

			// computers turn
			case "2": //TODO update bank		
				if(player.getCards() == null || player.getCards().size() < 1){ //TODO rework this condition
					System.out.println("please draw a card before continuing");
					break;
				}
				computersTurn(playerHandValue);						
				cardPrintoutHandler.drawGameBoard(player, computer,			    	// printout board
						Const.DRAW_PLAYERS_CARDS_MIRROR_WAY);  		

				if(computerHandValue < 21 && computerHandValue > playerHandValue){  //TODO implement score
					menuPrintoutHandler.createWinRoundScreen(computer.getName(),
							player.getName(),computerHandValue,playerHandValue);	// win screen
				} else{
					menuPrintoutHandler.createWinRoundScreen(player.getName(),
							computer.getName(),playerHandValue,computerHandValue);
				}
				resetRound();														// reset hands
				break;

			case "3": //TODO score
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
	 * */
	private static int computersTurn(int playerHandValue){	//TODO dont count if player has overflow	
		//System.out.println(playerHandValue);

		while (true) {																//simple computer logic
			if(ruleSetHandler.isHandValueMoreThanMaxValue(computerHandValue)){		//is overflow?
				menuPrintoutHandler.createOverflowPrintout(computer.getName(), computerHandValue);
				break;
			} else if(playerHandValue < computerHandValue){
				break;
			} else{
				computerHand.add(cardDeck.getCard());		
				computerHandValue = ruleSetHandler.countCardsInHand(computerHand);
			}
		}
		computer.setCards(computerHand);					 						// set computers hand

		return computerHandValue;
	}

	private static int playerTurn(){ 
		playerHand.add(cardDeck.getCard()); 					 // player draws a card
		player.setCards(playerHand);
		playerHandValue = ruleSetHandler.countCardsInHand(playerHand);
		cardPrintoutHandler.drawPlayer(player);

		return playerHandValue;
	}
}

