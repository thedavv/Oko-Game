package handler.print;

import handler.print.menu.Menu;
import handler.print.menu.MenuPrintOut;
import handler.print.player.GameBoard;
import handler.print.player.GameBoardPrintOut;

public class PrintFactory implements Print{

	@Override
	public Menu createPrintOutMenuHandler() {
		return new MenuPrintOut();
	}

	@Override
	public GameBoard createPrintOutGameBoardHandler() {
		return new GameBoardPrintOut();
	}
}
