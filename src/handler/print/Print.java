package handler.print;

import handler.print.menu.Menu;
import handler.print.player.GameBoard;

public interface Print {
	Menu createPrintOutMenuHandler();

	GameBoard createPrintOutGameBoardHandler();
}
