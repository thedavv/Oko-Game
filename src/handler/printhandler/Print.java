package handler.printhandler;

import handler.printhandler.menu.Menu;
import handler.printhandler.player.GameBoard;

public interface Print {
	Menu createPrintOutMenuHandler();
	GameBoard createPrintOutGameBoardHandler();
}
