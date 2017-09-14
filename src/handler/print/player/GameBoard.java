package handler.print.player;

import model.Player;

/**
 * use this intervface for Clases that want to print out Game board it must
 * contain two methods one for creating both players and one for creating only
 * one player
 *
 */
public interface GameBoard {
	/**
	 * Method prints out gameBoard of selected players
	 * 
	 * @param style is the style of printing out cards
	 * @param player is the human Player
	 * @param computer is the computer Player
	 */
	public void drawGameBoard(int style, Player player, Player computer);

	/**
	 * Method prints out gameBoard of selected player
	 * 
	 * @param style is the style of printing out cards
	 * @param player is the current Player you want to be printed out
	 */
	public void drawGameBoard(int style, Player player);
}
