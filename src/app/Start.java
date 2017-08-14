package app;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import handler.*;
import handler.printout.CardPrintOut;
import handler.printout.MenuPrintoutHandler;
import model.*;
import model.cardfactory.*;
import model.cardproperty.*;
import util.Const;
import util.DimensionsException;
import util.Settings;

public class Start { //TODO test settings / change setings / Bug with drawing cards from deck
	//helper variables
	private static Settings   	gameSettings 		 = Settings.getInstance();
	static int 				  	playerHandValue  	 = 0; 	
	static int 				  	computerHandValue 	 = 0; 	
	static int 				  	playerBank		     = 0; //TODO implement in game logix
	static int 				  	computerBank     	 = 0; //TODO implement in game logix
	static int 					finalScore			 = 0; //TODO implement in game logix
	static boolean    		  	endProgram			 = false;
	static boolean    		  	endGame 		     = false;
	static String     		  	input 				 = "";
	static List<Card> 		    playerHand 			 = new ArrayList<>();
	static List<Card> 		    computerHand      	 = new ArrayList<>();

	// variables from settings
	static Deck 			    cardDeck 		     = gameSettings.getDeck();
	static Player 			    player 		         = gameSettings.getPlayer();
	static Player 			    computer 		     = gameSettings.getComputer();

	//handlers
	static CardPrintOut 	    cardPrintoutHandler  = new CardPrintOut(); 
	static RuleSetHandler       ruleSetHandler       = new RuleSetHandler();
	static MenuPrintoutHandler  menuPrintoutHandler  = new MenuPrintoutHandler();

	public static void main(String[] args) { //TODO score/start bank/Bet
		//		try {
		//			gameSettings.setCardSize(10, 12);
		//		} catch (DimensionsException e) {
		//			e.printStackTrace();
		//		}

		Scanner sc = new Scanner(System.in);

		while (!endProgram) {
			menuPrintoutHandler.mainMenuPrintout();
			input = sc.next();
			switch (input) {
			case "1":
				endGame = false;
				startGame(sc);
				break;

			case "2":
				menuPrintoutHandler.settingsMenuPrintout();
				break;

			case "3":
				menuPrintoutHandler.endScreenPrintout(finalScore);
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
			if(ruleSetHandler.isHandMorethanMaxValue(playerHand)){ // TODO update Bank
				menuPrintoutHandler.overFlowPrintout(player.getName(), playerHandValue);
				resetRound();	
			}

			menuPrintoutHandler.statusMenuPrintout(playerHandValue, playerBank, computerBank);
			menuPrintoutHandler.continueMenuPrintout();

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

				System.out.println("Computers turn");
				computersTurn(playerHandValue);						
				cardPrintoutHandler.drawGameBoard(player, computer,			    	// printout board
						Const.DRAW_PLAYERS_CARDS_MIRROR_WAY);  		

				if(computerHandValue < 21 && computerHandValue > playerHandValue){  //TODO implement score
					menuPrintoutHandler.winRoundScreen(computer.getName(),
							player.getName(),playerHandValue,computerHandValue);	// win screen
				} else{
					menuPrintoutHandler.winRoundScreen(player.getName(),
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
	 * methods that simulate player turn. Retun hand value
	 * */
	private static int computersTurn(int playerHandValue){	//TODO dont count if player has overflow	
		//System.out.println(playerHandValue);
		boolean overflow = false;

		while (true) {																//simple computer logic
			overflow = ruleSetHandler.isHandMorethanMaxValue(computerHand);
			if(overflow){															//is overflow?
				menuPrintoutHandler.overFlowPrintout(player.getName(), playerHandValue);
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

