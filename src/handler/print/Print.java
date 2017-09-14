package handler.print;

import handler.print.menu.Printout;
import handler.print.player.GameBoard;

public interface Print {
	Printout createPrintOutMenuHandler();

	GameBoard createPrintOutGameBoardHandler();
}
