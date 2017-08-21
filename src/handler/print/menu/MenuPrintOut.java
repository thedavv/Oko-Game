package handler.print.menu;

import model.Player;
import util.Const;

public class MenuPrintOut extends MenuCreation implements Menu {

	@Override
	public void createMenu(int menuType) {
		switch (menuType) {
		case Const.MENU_MAIN:
			System.out.println(createMainMenuPrintout());
			break;

		case Const.MENU_CONTINUE:
			System.out.println(createContinueMenuPrintout());
			break;

		case Const.MENU_SETTINGS:
			System.out.println(createSettingsMenuPrintout());
			break;
			
		case Const.MENU_DOUBLE_DOWN:
			System.out.println(createdoubleDownMenuPrintout());
			break;
			
		case Const.MENU_SETTINGS_SUBMENU_MONEY:
			System.out.println(createSettingsSubmenuMoneyPrintout());
			break;

		case Const.MENU_SETTINGS_SUBMENU_PLAYER:
			System.out.println(createSettingsSubmenuPlayerPrintout());
			break;
			
		case Const.MENU_SETTINGS_SUBMENU_PRINTOOUT:
			System.out.println(createSettingsSubmenuPrintout());
			
		default:
			break;
		}
	}

	@Override
	public void createMenu(int menuType, int score) {
		switch (menuType) {
		case Const.MENU_END:
			System.out.println(createEndScreenPrintout(score));
			break;

		case Const.MENU_WIN:
			System.out.println(createWinScreenPrintout(score));
			break;

		case Const.MENU_LOST:
			System.out.println(createLostScreenPrintout(score));
			break;

		case Const.MENU_RETURN:
			System.out.println(createReturnToMenuPrintout(score));
			break;

		case Const.MENU_Bet:
			System.out.println(createBetInputScreen(score));
			break;

		default:
			break;
		}
	}

	@Override
	public void createMenu(int menuType, Player player, Player computer,
			int playerHandValue, int computerHandValue, boolean playerWon) {
		switch (menuType) {
		case Const.MENU_WIN_ROUND:
			if (playerWon) {
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

	@Override
	public void createMenu(int menuType, int playerHandValue, int playerBank,
			int ComputerBank) {
		switch (menuType) {
		case Const.MENU_STATUS:
			System.out.println(
					createStatusMenuPrintout(playerHandValue, playerBank, ComputerBank));
			break;

		default:
			break;
		}
	}

	@Override
	public void createMenu(int menuType, Player player, int playerHandValue) {
		switch (menuType) {
		case Const.MENU_OVERFLOW:
			System.out.println(createOverflowPrintout(player.getName(), playerHandValue));
			break;

		default:
			break;
		}

	}

	@Override
	public void createMenu(int menuType, String data) {
		switch (menuType) {
			case Const.MENU_SCOREBOARD:
				System.out.println(createScoreBoardPrintout(data));
				break;

			default:
				break;
			}
	}
}
