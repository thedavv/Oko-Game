package handler.print.menu;

import util.Const;
import util.Settings;

public class MenuCreation extends LineCreation {
	private static Settings settings = Settings.getInstance();

	/**
	 * Method for printing out main menu
	 */
	public String createMainMenuPrintout() {
		StringBuilder sb = new StringBuilder();
		sb.append(
				drawLine(settings.getMenuLenght(), Const.TLC, Const.TRC, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"Main Menu"));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"1. NEW GAME"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"2. SETINGS"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"3. EXIT"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"4. HIGH SCORE TABLE"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.BLC, Const.BRC, Const.HL, null));

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

		sb.append(
				drawLine(settings.getMenuLenght(), Const.TLC, Const.TRC, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"Status"));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"Hand card value count : " + playerHandValue));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"Player bank remaining : " + playerBank));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"Computer bank remaining : " + ComputerBank));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));

		return sb.toString();
	}

	/**
	 * Method for creating continue menu printout
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

		sb.append(
				drawLine(settings.getMenuLenght(), Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"Draw another Card?"));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"1. YES"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"2. NO"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"3. EXIT TO MAIN MENU"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.BLC, Const.BRC, Const.HL, null));

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

		sb.append(
				drawLine(settings.getMenuLenght(), Const.TLC, Const.TRC, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"Game is closing. Have a nice day"));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"Final Score : " + finalScore));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.BLC, Const.BRC, Const.HL, null));

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

		sb.append(
				drawLine(settings.getMenuLenght(), Const.TLC, Const.TRC, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"Value of hand exeeds max value in ruleset = " + Const.MAX_HAND_VALUE));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				playerName + "s hand value: " + playerHandValue));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				playerName + " Lost."));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.BLC, Const.BRC, Const.HL, null));

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

		sb.append(
				drawLine(settings.getMenuLenght(), Const.TLC, Const.TRC, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				wonPlayerName + " won the round"));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				wonPlayerName + " hand value: " + wonPlayerHandValue));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				lostPlayerName + " hand value: " + lostPlayerHandValue));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.BLC, Const.BRC, Const.HL, null));

		return sb.toString();
	}

	/**
	 * Method that creates settings menu
	 */
	public String createSettingsMenuPrintout() {
		// System.out.println("╔═══════════════════════════════════════════════════╗");
		// System.out.println("║ settings ║");
		// System.out.println("╠═══════════════════════════════════════════════════╣");
		// System.out.println("║ ║");
		// System.out.println("║ 1. Not Implemented ║");
		// System.out.println("║ ║");
		// System.out.println("╚═══════════════════════════════════════════════════╝");
		StringBuilder sb = new StringBuilder();

		sb.append(
				drawLine(settings.getMenuLenght(), Const.TLC, Const.TRC, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"SETTINGS"));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"1. PRINTOUT SETUP"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"2. PLAYER SETUP"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"3. MONEY RULES SETUP"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"4. BACK TO MAIN MENU"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.BLC, Const.BRC, Const.HL, null));

		return sb.toString();
	}

	/**
	 * Method that creates settings submenu for Player
	 */
	public String createSettingsSubmenuPlayerPrintout() {
		// System.out.println("╔═══════════════════════════════════════════════════╗");
		// System.out.println("║ settings ║");
		// System.out.println("╠═══════════════════════════════════════════════════╣");
		// System.out.println("║ ║");
		// System.out.println("║ 1. Not Implemented ║");
		// System.out.println("║ ║");
		// System.out.println("╚═══════════════════════════════════════════════════╝");
		StringBuilder sb = new StringBuilder();

		sb.append(
				drawLine(settings.getMenuLenght(), Const.TLC, Const.TRC, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"PLAYER SETUP"));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"1. SET playerName"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"2. SET computerName"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"3. BACK"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.BLC, Const.BRC, Const.HL, null));

		return sb.toString();
	}

	/**
	 * Method that creates settings submenu for Printout game Board
	 */
	public String createSettingsSubmenuPrintout() {
		StringBuilder sb = new StringBuilder();

		sb.append(
				drawLine(settings.getMenuLenght(), Const.TLC, Const.TRC, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"PRINTOUT SETUP"));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"1. SET menuLenght"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"2. SET cardSizeX AND cardSizeY"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"3. SET spaceBetweenPlayers"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"4. SET cardPartialSizeX"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"5. SET drawStyle"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"6. BACK"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.BLC, Const.BRC, Const.HL, null));

		return sb.toString();
	}

	/**
	 * Method that creates settings submenu for Money
	 */
	public String createSettingsSubmenuMoneyPrintout() {
		StringBuilder sb = new StringBuilder();

		sb.append(
				drawLine(settings.getMenuLenght(), Const.TLC, Const.TRC, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"MONEY RULES SETUP"));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"1. SET playersBeginingMoney"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"2. SET computersBeginingMoney"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"3. SET beginningScore"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"4. SET minimalBet"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"5. SET maximalBet"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"6. BACK"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.BLC, Const.BRC, Const.HL, null));

		return sb.toString();
	}

	/**
	 * Method that creates Win screen
	 */
	public String createWinScreenPrintout(int finalScore) {
		StringBuilder sb = new StringBuilder();

		sb.append(
				drawLine(settings.getMenuLenght(), Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"YOU WON THE GAME!!"));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"YOUR FINAL SCORE IS: " + finalScore));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.BLC, Const.BRC, Const.HL, null));

		return sb.toString();
	}

	/**
	 * MMethod that creates Lost screen
	 */
	public String createLostScreenPrintout(int finalScore) {
		StringBuilder sb = new StringBuilder();

		sb.append(
				drawLine(settings.getMenuLenght(), Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"YOU LOST THE GAME :("));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"YOUR FINAL SCORE IS: " + finalScore));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.BLC, Const.BRC, Const.HL, null));

		return sb.toString();
	}

	/**
	 * Method that creates Return screen
	 */
	public String createReturnToMenuPrintout(int finalScore) {
		StringBuilder sb = new StringBuilder();

		sb.append(
				drawLine(settings.getMenuLenght(), Const.TLC, Const.TRC, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"RETURNING TO MAIN MENU"));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"YOUR FINAL SCORE IS: " + finalScore));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.BLC, Const.BRC, Const.HL, null));

		return sb.toString();
	}

	/**
	 * Method that creates Bet screen
	 */
	public String createBetInputScreen(int bet) {
		StringBuilder sb = new StringBuilder();

		sb.append(
				drawLine(settings.getMenuLenght(), Const.TLC, Const.TRC, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"SET YOUR BET"));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"Bet last Round : " + bet));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"Maximum bet is : " + Const.MAX_BET));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.BLC, Const.BRC, Const.HL, null));

		return sb.toString();
	}

	/**
	 * Method for cls
	 */
	public void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	/**
	 * Method that creates Double down screen
	 */
	public String createdoubleDownMenuPrintout() {
		StringBuilder sb = new StringBuilder();

		sb.append(
				drawLine(settings.getMenuLenght(), Const.TLC, Const.TRC, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"DOUBLE DOWN ON BET??"));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"1. YES"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"2. NO"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.BLC, Const.BRC, Const.HL, null));

		return sb.toString();
	}

	/**
	 * Method that creates ScoreBoard screen
	 */
	public String createScoreBoardPrintout(String data) {
		StringBuilder sb = new StringBuilder();

		sb.append(
				drawLine(settings.getMenuLenght(), Const.TLC, Const.TRC, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"SCOREBOARD"));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		for (String str : data.split("\n")) {
			sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
					str));
			sb.append("\n");
		}

		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.BLC, Const.BRC, Const.HL, null));

		return sb.toString();
	}
}
