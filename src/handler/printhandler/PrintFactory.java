package handler.printhandler;

import handler.printhandler.menu.Menu;
import handler.printhandler.menu.MenuPrintOut;
import handler.printhandler.player.GameBoard;
import handler.printhandler.player.GameBoardPrintOut;

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
