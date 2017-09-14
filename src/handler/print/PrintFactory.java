package handler.print;

import handler.print.menu.MenuPrintout;
import handler.print.menu.Printout;
import handler.print.player.GameBoard;
import handler.print.player.GameBoardPrintOut;

public class PrintFactory implements Print {

	@Override
	public Printout createPrintOutMenuHandler() {
		return new MenuPrintout();
	}

	@Override
	public GameBoard createPrintOutGameBoardHandler() {
		return new GameBoardPrintOut();
	}
}
