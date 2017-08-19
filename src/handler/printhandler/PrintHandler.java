package handler.printhandler;

import handler.printhandler.menu.MenuPrintOut;
import handler.printhandler.player.GameBoardPrintOut;

public class PrintHandler implements Print{

	@Override
	public MenuPrintOut printOutGameBoardHandler() {
		return new MenuPrintOut();
		
	}

	@Override
	public GameBoardPrintOut printOutMenuHandler() {
		return new GameBoardPrintOut();
	}

}
