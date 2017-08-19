package handler.printhandler.menu;

import util.Const;
import util.Settings;

public class MenuCreation extends LineCreation {
	/**
	 * Method for printing out main menu
	 */
	public String createMainMenuPrintout() {
		StringBuilder sb = new StringBuilder();
		// System.out.println("╔═══════════════════════════════════════════════════╗");
		// System.out.println("║ Main Menu ║");
		// System.out.println("╠═══════════════════════════════════════════════════╣");
		// System.out.println("║ ║");
		// System.out.println("║ 1. NEW GAME ║");
		// System.out.println("║ 2. SETTINGS ║");
		// System.out.println("║ 3. EXIT ║");
		// System.out.println("║ ║");
		// System.out.println("╚═══════════════════════════════════════════════════╝");

		sb.append(drawLine(Settings.menuLenght, Const.TLC, Const.TRC, Const.HL, null));
		sb.append("\n");
		sb.append(
				drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP, "Main Menu"));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP,
				"1. NEW GAME"));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP,
				"2. SETTINGS"));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP, "3. EXIT"));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.BLC, Const.BRC, Const.HL, null));

		return sb.toString();
	}

	/**
	 * Method for creating status menu
	 *
	 * @param playerHandValue
	 *            is the players hand value
	 * @param playerBank
	 *            is the players bank value
	 * @param ComputerBank
	 *            is the computers bank value
	 */
	public String createStatusMenuPrintout(int playerHandValue, int playerBank,
			int ComputerBank) {
		StringBuilder sb = new StringBuilder();
		// System.out.println("╔═══════════════════════════════════════════════════╗");
		// System.out.println("║ Status ║");
		// System.out.println("╠═══════════════════════════════════════════════════╣");
		// System.out.println("║ ║");
		// System.out.println("║ Hand card value count : ║");
		// System.out.println("║ Player bank remaining : ║");
		// System.out.println("║ Computer bank remaining : ║");
		// System.out.println("║ ║");

		sb.append(drawLine(Settings.menuLenght, Const.TLC, Const.TRC, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP, "Status"));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP,
				"Hand card value count   : " + playerHandValue));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP,
				"Player bank remaining   : " + playerBank));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP,
				"Computer bank remaining : " + ComputerBank));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP, null));

		return sb.toString();
	}

	/**
	 * Method for continue menu printout
	 */
	public String createContinueMenuPrintout() {
		StringBuilder sb = new StringBuilder();
		// System.out.println("╠═══════════════════════════════════════════════════╣");
		// System.out.println("║ Draw another Card? ║");
		// System.out.println("╠═══════════════════════════════════════════════════╣");
		// System.out.println("║ ║");
		// System.out.println("║ 1. Yes ║");
		// System.out.println("║ 2. No ║");
		// System.out.println("║ 3. EXIT TO MAIN MENU ║");
		// System.out.println("║ ║");
		// System.out.println("╚═══════════════════════════════════════════════════╝");

		sb.append(drawLine(Settings.menuLenght, Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP,
				"Draw another Card?"));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP, "1. YES"));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP, "2. NO"));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP,
				"3. EXIT TO MAIN MENU"));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.BLC, Const.BRC, Const.HL, null));

		return sb.toString();
	}

	/**
	 * Method that creates game closing menu
	 *
	 * @param finalScore
	 *            is the final score of the player
	 */
	public String createEndScreenPrintout(int finalScore) {
		StringBuilder sb = new StringBuilder();
		// System.out.println("╠═══════════════════════════════════════════════════╣");
		// System.out.println("║ Game is closing. Have a nice day ║");
		// System.out.println("╠═══════════════════════════════════════════════════╣");
		// System.out.println("║ ║");
		// System.out.println("║ Final Score : unimplemented ║");
		// System.out.println("║ ║");
		// System.out.println("╚═══════════════════════════════════════════════════╝");

		sb.append(drawLine(Settings.menuLenght, Const.TLC, Const.TRC, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP,
				"Game is closing. Have a nice day"));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP,
				"Final Score : " + finalScore));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.BLC, Const.BRC, Const.HL, null));

		return sb.toString();
	}

	/**
	 * Method that prints out the overflow menu
	 *
	 * @param playerName
	 *            is the name of the palyer
	 * @param playerHandValue
	 *            is the players hand value
	 */
	public String createOverflowPrintout(String playerName, int playerHandValue) {
		// System.out.println("╔═══════════════════════════════════════════════════╗");
		// System.out.println("║ Value of hand exeeds max value in ruleset ║");
		// System.out.println("╠═══════════════════════════════════════════════════╣");
		// System.out.println("║ ║");
		// System.out.println("║ Players hand value: ║");
		// System.out.println("║ Player Lost. ║");
		// System.out.println("║ ║");
		// System.out.println("╚═══════════════════════════════════════════════════╝");
		StringBuilder sb = new StringBuilder();

		sb.append(drawLine(Settings.menuLenght, Const.TLC, Const.TRC, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP,
				"Value of hand exeeds max value in ruleset = " + Const.MAX_HAND_VALUE));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP,
				playerName + "s hand value: " + playerHandValue));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP,
				playerName + " Lost."));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.BLC, Const.BRC, Const.HL, null));

		return sb.toString();
	}

	/**
	 * Method for creating player won menu
	 *
	 * @param wonPlayerName
	 *            is the name of player that won the round
	 * @param lostPlayerName
	 *            is the name of a person who lost the round
	 * @param wonPlayerHandValue
	 *            is the value of players hand
	 * @param lostPlayerHandValue
	 *            is the value of computers hand
	 */
	public String createWinRoundScreen(String wonPlayerName, String lostPlayerName,
			int wonPlayerHandValue, int lostPlayerHandValue) {
		// System.out.println("╔═══════════════════════════════════════════════════╗");
		// System.out.println("║ Player won the round ║");
		// System.out.println("╠═══════════════════════════════════════════════════╣");
		// System.out.println("║ ║");
		// System.out.println("║ Player hand value = ║");
		// System.out.println("║ Player hand value = ║");
		// System.out.println("║ ║");
		// System.out.println("╚═══════════════════════════════════════════════════╝");
		StringBuilder sb = new StringBuilder();

		sb.append(drawLine(Settings.menuLenght, Const.TLC, Const.TRC, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP,
				wonPlayerName + " won the round"));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP,
				wonPlayerName + " hand value: " + wonPlayerHandValue));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP,
				lostPlayerName + " hand value: " + lostPlayerHandValue));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.BLC, Const.BRC, Const.HL, null));

		return sb.toString();
	}

	/**
	 * Method for printing out settings menu
	 */
	public String createSettingsMenuPrintout() {// TODO implement settings menu
		// System.out.println("╔═══════════════════════════════════════════════════╗");
		// System.out.println("║ Settings ║");
		// System.out.println("╠═══════════════════════════════════════════════════╣");
		// System.out.println("║ ║");
		// System.out.println("║ 1. Not Implemented ║");
		// System.out.println("║ ║");
		// System.out.println("╚═══════════════════════════════════════════════════╝");
		StringBuilder sb = new StringBuilder();

		sb.append(drawLine(Settings.menuLenght, Const.TLC, Const.TRC, Const.HL, null));
		sb.append("\n");
		sb.append(
				drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP, "Settings"));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP,
				"1. Not Implemented"));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.BLC, Const.BRC, Const.HL, null));

		return sb.toString();
	}

	public String createWinScreenPrintout(int finalScore) {
		StringBuilder sb = new StringBuilder();

		sb.append(drawLine(Settings.menuLenght, Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP,
				"YOU WON THE GAME!!"));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP,
				"YOUR FINAL SCORE IS: " + finalScore));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.BLC, Const.BRC, Const.HL, null));

		return sb.toString();
	}

	public String createLostScreenPrintout(int finalScore) {
		StringBuilder sb = new StringBuilder();

		sb.append(drawLine(Settings.menuLenght, Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP,
				"YOU LOST THE GAME :("));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP,
				"YOUR FINAL SCORE IS: " + finalScore));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.BLC, Const.BRC, Const.HL, null));

		return sb.toString();
	}

	public String createReturnToMenuPrintout(int finalScore) {
		StringBuilder sb = new StringBuilder();

		sb.append(drawLine(Settings.menuLenght, Const.TLC, Const.TRC, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP,
				"RETURNING TO MAIN MENU"));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP,
				"YOUR FINAL SCORE IS: " + finalScore));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(Settings.menuLenght, Const.BLC, Const.BRC, Const.HL, null));

		return sb.toString();
	}

	public void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

}
