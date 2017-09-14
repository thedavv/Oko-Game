package handler.print;

import handler.print.menu.MenuPrintout;
import handler.print.menu.Printout;
import handler.print.player.GameBoard;
import handler.print.player.GameBoardPrintOut;

/**
 * Factory for printing out GameBoard(Card representation of players) and
 * printing out Printout Menus
 */
public class PrintFactory {

	/**
	 * Creates handler for menu printouts
	 * 
	 * @return MenuPrintout for different menus
	 */
	public Printout createPrintOutMenuHandler() {
		return new MenuPrintout();
	}

	/**
	 * Creates handler for Game Board printouts
	 * 
	 * @return GameBoardPrintOut for different game boards
	 */
	public GameBoard createPrintOutGameBoardHandler() {
		return new GameBoardPrintOut();
	}
}
