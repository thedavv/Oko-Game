package handler.printhandler;

import util.Const;
import util.Settings;

public class MenuPrintOut{
	/**
	 * Method for printing out main menu 
	 * */
	public void createMainMenuPrintout(){
		//		System.out.println("╔═══════════════════════════════════════════════════╗");
		//		System.out.println("║ Main Menu                                         ║");
		//		System.out.println("╠═══════════════════════════════════════════════════╣");
		//		System.out.println("║                                                   ║");
		//		System.out.println("║ 1. NEW GAME                                       ║");
		//		System.out.println("║ 2. SETTINGS                                       ║");
		//		System.out.println("║ 3. EXIT                                           ║");
		//		System.out.println("║                                                   ║");
		//		System.out.println("╚═══════════════════════════════════════════════════╝");

		System.out.println(drawLine(Settings.menuLenght, Const.TLC, Const.TRC, Const.HL, null));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP,
				"Main Menu"));
		System.out.println(drawLine(Settings.menuLenght, Const.LMJ, Const.RMJ, Const.HL, null));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP, null));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP, "1. NEW GAME"));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP, "2. SETTINGS"));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP, "3. EXIT"));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP, null));
		System.out.println(drawLine(Settings.menuLenght, Const.BLC, Const.BRC, Const.HL, null));
	}

	/**
	 * Method for creating status menu
	 * 
	 * @param playerHandValue is the players hand value
	 * @param playerBank is the players bank value
	 * @param ComputerBank is the computers bank value
	 */
	public void createStatusMenuPrintout(int playerHandValue, int playerBank, int ComputerBank){ 
		//		System.out.println("╔═══════════════════════════════════════════════════╗");
		//		System.out.println("║ Status                                            ║");
		//		System.out.println("╠═══════════════════════════════════════════════════╣");
		//		System.out.println("║                                                   ║");
		//		System.out.println("║ Hand card value count   :                         ║");
		//		System.out.println("║ Player bank remaining   :                         ║");
		//		System.out.println("║ Computer bank remaining :                         ║");
		//		System.out.println("║                                                   ║");

		System.out.println(drawLine(Settings.menuLenght, Const.TLC, Const.TRC, Const.HL, null));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP, "Status"));
		System.out.println(drawLine(Settings.menuLenght, Const.LMJ, Const.RMJ, Const.HL, null));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP, null));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP, "Hand card value count   : " + playerHandValue));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP, "Player bank remaining   : " + playerBank));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP, "Computer bank remaining : " + ComputerBank));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP, null));
	}

	/**
	 * Method for continue menu printout
	 */
	public void createContinueMenuPrintout(){
		//		System.out.println("╠═══════════════════════════════════════════════════╣");
		//		System.out.println("║ Draw another Card?                                ║");
		//		System.out.println("╠═══════════════════════════════════════════════════╣");
		//		System.out.println("║                                                   ║");
		//		System.out.println("║ 1. Yes                                            ║");
		//		System.out.println("║ 2. No                                             ║");
		//		System.out.println("║ 3. EXIT TO MAIN MENU                              ║");
		//		System.out.println("║                                                   ║");
		//		System.out.println("╚═══════════════════════════════════════════════════╝");

		System.out.println(drawLine(Settings.menuLenght, Const.LMJ, Const.RMJ, Const.HL, null));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP,
				"Draw another Card?"));
		System.out.println(drawLine(Settings.menuLenght, Const.LMJ, Const.RMJ, Const.HL, null));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP, null));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP, "1. YES"));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP, "2. NO"));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP, "3. EXIT TO MAIN MENU"));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP, null));
		System.out.println(drawLine(Settings.menuLenght, Const.BLC, Const.BRC, Const.HL, null));
	} 

	/**
	 * Method that creates game closing menu
	 * 
	 * @param finalScore is the final score of the player
	 */
	public void createEndScreenPrintout(int finalScore){
		//		System.out.println("╠═══════════════════════════════════════════════════╣");
		//		System.out.println("║ Game is closing. Have a nice day                  ║");
		//		System.out.println("╠═══════════════════════════════════════════════════╣");
		//		System.out.println("║                                                   ║");
		//		System.out.println("║ Final Score : unimplemented                       ║");
		//		System.out.println("║                                                   ║");
		//		System.out.println("╚═══════════════════════════════════════════════════╝");

		System.out.println(drawLine(Settings.menuLenght, Const.TLC, Const.TRC, Const.HL, null));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP,
				"Game is closing. Have a nice day"));
		System.out.println(drawLine(Settings.menuLenght, Const.LMJ, Const.RMJ, Const.HL, null));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP, null));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP, 
				"Final Score : " + finalScore));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP, null));
		System.out.println(drawLine(Settings.menuLenght, Const.BLC, Const.BRC, Const.HL, null));

	}

	/**
	 * Method that prints out the overflow menu
	 * 
	 * @param playerName is the name of the palyer
	 * @param playerHandValue is the players hand value
	 */
	public void createOverflowPrintout(String playerName, int playerHandValue){ 
		//		System.out.println("╔═══════════════════════════════════════════════════╗");
		//		System.out.println("║ Value of hand exeeds max value in ruleset         ║");
		//		System.out.println("╠═══════════════════════════════════════════════════╣");
		//		System.out.println("║                                                   ║");
		//		System.out.println("║ Players hand value:                               ║");
		//		System.out.println("║ Player Lost.                                      ║");
		//		System.out.println("║                                                   ║");
		//		System.out.println("╚═══════════════════════════════════════════════════╝");

		System.out.println(drawLine(Settings.menuLenght, Const.TLC, Const.TRC, Const.HL, null));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP,
				"Value of hand exeeds max value in ruleset = 21"));
		System.out.println(drawLine(Settings.menuLenght, Const.LMJ, Const.RMJ, Const.HL, null));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP, null));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP,
				playerName +"s hand value: " + playerHandValue));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP, playerName +" Lost."));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP, null));
		System.out.println(drawLine(Settings.menuLenght, Const.BLC, Const.BRC, Const.HL, null));

	}

	/**
	 * Method for creating player won menu
	 * 
	 * @param wonPlayerName is the name of player that won the round
	 * @param lostPlayerName is the name of a person who lost the round 
	 * @param wonPlayerHandValue is the value of players hand
	 * @param lostPlayerHandValue is the value of computers hand
	 */
	public void createWinRoundScreen(String wonPlayerName,String lostPlayerName, int wonPlayerHandValue, int lostPlayerHandValue){ 
		//		System.out.println("╔═══════════════════════════════════════════════════╗");
		//		System.out.println("║ Player won the round                              ║");
		//		System.out.println("╠═══════════════════════════════════════════════════╣");
		//		System.out.println("║                                                   ║");
		//		System.out.println("║ Player hand value =                               ║");
		//		System.out.println("║ Player hand value =                               ║");
		//		System.out.println("║                                                   ║");
		//		System.out.println("╚═══════════════════════════════════════════════════╝");

		System.out.println(drawLine(Settings.menuLenght, Const.TLC, Const.TRC, Const.HL, null));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP,
				wonPlayerName +" won the round"));
		System.out.println(drawLine(Settings.menuLenght, Const.LMJ, Const.RMJ, Const.HL, null));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP, null));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP,
				wonPlayerName + " hand value: " + wonPlayerHandValue));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP,
				lostPlayerName + " hand value: " + lostPlayerHandValue));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP, null));
		System.out.println(drawLine(Settings.menuLenght, Const.BLC, Const.BRC, Const.HL, null));
	}

	/**
	 * Method for printing out settings menu
	 */
	public void createSettingsMenuPrintout(){//TODO implement settings menu
		//		System.out.println("╔═══════════════════════════════════════════════════╗");
		//		System.out.println("║ Settings                                          ║");
		//		System.out.println("╠═══════════════════════════════════════════════════╣");
		//		System.out.println("║                                                   ║");
		//		System.out.println("║ 1. Not Implemented                                ║");
		//		System.out.println("║                                                   ║");
		//		System.out.println("╚═══════════════════════════════════════════════════╝");

		System.out.println(drawLine(Settings.menuLenght, Const.TLC, Const.TRC, Const.HL, null));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP, "Settings"));
		System.out.println(drawLine(Settings.menuLenght, Const.LMJ, Const.RMJ, Const.HL, null));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP, null));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP, "1. Not Implemented"));
		System.out.println(drawLine(Settings.menuLenght, Const.VL,  Const.VL,  Const.SP, null));
		System.out.println(drawLine(Settings.menuLenght, Const.BLC, Const.BRC, Const.HL, null));
	}

	public void clearScreen() {  
		System.out.print("\033[H\033[2J");  
		System.out.flush();  
	}

	/**
	 * Helper draw methods
	 * */
	//TODO check if text has more chars than lenght
	public String drawLine(int menuLenght, char leftBorder, char rightBorder, char middleSection, String middleSectionText){
		StringBuilder sb = new StringBuilder();

		sb.append(leftBorder);
		if(middleSectionText == "" || middleSectionText == null){					// no text
			for (int i = 0; i < menuLenght - 2; i++) {
				sb.append(middleSection);
			}
		} else{																	   // with text
			sb.append(middleSection);											   // space between border
			sb.append(middleSectionText);
			for (int i = 0; i < menuLenght - middleSectionText.length() - 3; i++) {
				sb.append(middleSection);
			}
		}

		sb.append(rightBorder);

		return sb.toString();
	}


}
