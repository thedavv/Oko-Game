package handler.printhandler.menu;

import model.Player;
import util.Const;

public class MenuPrintOut extends MenuCreation implements Menu {

	@Override
	public void createMenu(int menuType) {
		switch (menuType) {
		case Const.MENU_MAIN:
			System.out.println(createContinueMenuPrintout());
			break;

		case Const.MENU_STATUS:
			System.out.println(createMainMenuPrintout());
			break;

		case Const.MENU_CONTINUE:
			System.out.println(createContinueMenuPrintout());
			break;

		case Const.MENU_SETTINGS:
			System.out.println(createSettingsMenuPrintout());
			break;

		default:
			break;
		}
	}

	@Override
	public void createMenu(int menuType, int finalScore) {
		switch (menuType) {
		case Const.MENU_END:
			System.out.println(createEndScreenPrintout(finalScore));
			break;
		case Const.MENU_WIN:
			System.out.println(createWinScreenPrintout(finalScore));
			break;

		case Const.MENU_LOST:
			System.out.println(createLostScreenPrintout(finalScore));
			break;

		case Const.MENU_RETURN:
			System.out.println(createReturnToMenuPrintout(finalScore));
			break;
		default:
			break;
		}
	}

	@Override
	public void createMenu(int menuType, Player player, Player computer,
			int playerHandValue, int computerHandValue) {
		switch (menuType) {
		case Const.MENU_OVERFLOW:
			System.out.println(createOverflowPrintout(player.getName(), playerHandValue));
			break;

		case Const.MENU_WIN_ROUND:
			if (playerHandValue > computerHandValue) {
				System.out.println(createWinRoundScreen(player.getName(),
						computer.getName(), playerHandValue, computerHandValue));
			} else {
				System.out.println(createWinRoundScreen(computer.getName(),
						player.getName(), computerHandValue, playerHandValue));
			}
			break;

		default:
			break;
		}
	}
}
