package handler.printhandler;

import handler.printhandler.menu.MenuPrintOut;
import handler.printhandler.player.GameBoardPrintOut;

public interface Print {
	MenuPrintOut printOutGameBoardHandler();
	GameBoardPrintOut printOutMenuHandler();
}
