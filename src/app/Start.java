package app;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import handler.*;
import model.*;
import model.cardfactory.*;
import model.cardproperty.*;
import util.Const;
import util.DimensionsException;
import util.Settings;

public class Start { //TODO test settings / change setings
	//helper variables
	private static Settings   s 				= Settings.getInstance();
	static int 				  playerHandValue   = 0; 	
	static int 				  computerHandValue = 0; 	
	static boolean    		  endProgram		= false;
	static boolean    		  endGame 		    = false;
	static String     		  input 			= "";
	static List<Card> 		  playerHand 		= new ArrayList<>();
	static List<Card> 		  computerHand      = new ArrayList<>();

	// variables from settings
	static Deck 			  deck 		        = s.getDeck();
	static Player 			  player 		    = s.getPlayer();
	static Player 			  computer 		    = s.getComputer();

	//handlers
	static CardFactoryHandler printCardHandler  = new CardFactoryHandler(); 
	static RuleSetHandler     ruleSetHandler    = new RuleSetHandler();

	public static void main(String[] args) { //TODO score/start bank/Bet
		Scanner sc = new Scanner(System.in);

		while (!endProgram) {
			mainMenuPrintout();
			input = sc.next();
			switch (input) {
			case "1":
				endGame = false;
				startRound(sc);
				break;

			case "2":
				settingsMenuPrintout();
				break;

			case "3":
				endScreenPrintout();
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
		deck.addCardsToStack(playerHand);               	 		 // add cards to pile
		deck.addCardsToStack(computerHand);  
		
		playerHand.clear(); 								 		 // drop hand
		computerHand.clear();							
		
		computer.setCards(playerHand);			        			 // clear players cards
		player.setCards(computerHand);			
		
		computerHandValue = 0;										 // reset hand counts 
		playerHandValue   = 0;

	}

	private static void startRound(Scanner sc){
		while (!endGame) {
			if(ruleSetHandler.isHandMorethanMaxValue(playerHand)){ // TODO update Bank
				overFlowPrintout();
				resetRound();	
			}

			statusMenuPrintout();
			continueMenuPrintout();

			input = sc.next();
			switch (input) {
			case "1": 												// players turn
				playerTurn();
				break;
			
			// computers turn
		    //TODO draw bug if starting with 2(same reference????) and begining with 2 null pointer		
			case "2":		
				if(player.getCards() == null){ //TODO rework this condition
					System.out.println("please draw a card before continuing");
					break;
				}
				
				System.out.println("Computers turn");
				computersTurn(playerHandValue);						
				printCardHandler.drawGameBoard(player, computer,	// printout board
						Const.DRAW_PLAYERS_CARDS_MIRROR_WAY);  		
				
				System.out.println(playerHandValue +" "+ computerHandValue);
				winRoundScreen();									// win screen
				resetRound();										// reset hands
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

	private static int computersTurn(int playerHandValue){	//TODO dont count if player has overflow	
		
		System.out.println(playerHandValue);
		boolean overflow = false;

		while (true) {																//simple computer logic
			overflow = ruleSetHandler.isHandMorethanMaxValue(computerHand);
			if(overflow){															//is overflow?
				overFlowPrintout();
				break;
			} else if(playerHandValue < computerHandValue){
				break;
			} else{
				computerHand.add(deck.getCard());		
				computerHandValue = ruleSetHandler.countCardsInHand(computerHand);
			}
		}
		computer.setCards(computerHand);					 						// set computers hand
		
		
		return computerHandValue;
	}

	// returns hand value count
	private static int playerTurn(){
		playerHand.add(deck.getCard()); 					 // player draws a card
		player.setCards(playerHand);
		playerHandValue = ruleSetHandler.countCardsInHand(playerHand);
		printCardHandler.drawPlayer(player);

		return playerHandValue;
	}

	/**
	 * Methods for printing out menus 
	 * */
	public static void mainMenuPrintout(){//TODO finish handler for main menu
		System.out.println("╔═══════════════════════════════════════════════════╗");
		System.out.println("║ Main Menu                                         ║");
		System.out.println("╠═══════════════════════════════════════════════════╣");
		System.out.println("║                                                   ║");
		System.out.println("║  1. NEW GAME                                      ║");
		System.out.println("║  2. SETTINGS                                      ║");
		System.out.println("║  3. EXIT                                          ║");
		System.out.println("║                                                   ║");
		System.out.println("╚═══════════════════════════════════════════════════╝");
	}

	public static void statusMenuPrintout(){ // TODO create dynamic drawn status menu and values
		System.out.println("╔═══════════════════════════════════════════════════╗");
		System.out.println("║ Status                                            ║");
		System.out.println("╠═══════════════════════════════════════════════════╣");
		System.out.println("║                                                   ║");
		System.out.println("║  Hand card value count   : unimplemented          ║");
		System.out.println("║  Player bank remaining   : unimplemented          ║");
		System.out.println("║  Computer bank remaining : unimplemented          ║");
		System.out.println("║                                                   ║");
	}

	public static void continueMenuPrintout(){
		System.out.println("╠═══════════════════════════════════════════════════╣");
		System.out.println("║ Draw another Card?                                ║");
		System.out.println("╠═══════════════════════════════════════════════════╣");
		System.out.println("║                                                   ║");
		System.out.println("║  1. Yes                                           ║");
		System.out.println("║  2. No                                            ║");
		System.out.println("║  3. EXIT TO MAIN MENU                             ║");
		System.out.println("║                                                   ║");
		System.out.println("╚═══════════════════════════════════════════════════╝");
	} 

	public static void endScreenPrintout(){//TODO final score
		System.out.println("╠═══════════════════════════════════════════════════╣");
		System.out.println("║ Game is Closing. Have a nice day                  ║");
		System.out.println("╠═══════════════════════════════════════════════════╣");
		System.out.println("║                                                   ║");
		System.out.println("║ Final Score : unimplemented                       ║");
		System.out.println("║                                                   ║");
		System.out.println("╚═══════════════════════════════════════════════════╝");
	}

	public static void overFlowPrintout(){ //TODO implement Player variable depending on actual player
		System.out.println("╔═══════════════════════════════════════════════════╗");
		System.out.println("║ Value of hand exeeds max value in ruleset         ║");
		System.out.println("╠═══════════════════════════════════════════════════╣");
		System.out.println("║                                                   ║");
		System.out.println("║ Player Lost.                                      ║");
		System.out.println("║                                                   ║");
		System.out.println("╚═══════════════════════════════════════════════════╝");
	}

	public static void winRoundScreen(){ //TODO implement Player variable depending on actual player
		System.out.println("╔═══════════════════════════════════════════════════╗");
		System.out.println("║ Player won the round                              ║");
		System.out.println("╠═══════════════════════════════════════════════════╣");
		System.out.println("║                                                   ║");
		System.out.println("║ Player with Value beat Player with Value          ║");
		System.out.println("║                                                   ║");
		System.out.println("╚═══════════════════════════════════════════════════╝");
	}
	public static void settingsMenuPrintout(){//TODO implement settings menu
		System.out.println("╔═══════════════════════════════════════════════════╗");
		System.out.println("║ Settings                                          ║");
		System.out.println("╠═══════════════════════════════════════════════════╣");
		System.out.println("║                                                   ║");
		System.out.println("║  1. Unimplemented                                 ║");
		System.out.println("║                                                   ║");
		System.out.println("╚═══════════════════════════════════════════════════╝");
	}
}

