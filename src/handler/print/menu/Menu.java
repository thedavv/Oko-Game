package handler.print.menu;

import model.Player;

/**
 * Interface that is used for creating Game menus see
 * <Code>util.Constants for viable menus</Code>
 *
 * @author hubulubu
 */
public interface Menu {
	/**
	 * This method creates Menus that dont require any parameters. Example of
	 * menus:
	 * <ul>
	 * <li>Const.MENU_MAIN</li>
	 * <li>Const.MENU_SETTINGS</li>
	 * <li>Const.MENU_DOUBLE_DOWN</li>
	 * <li>Const.MENU_SETTINGS_SUBMENU_MONEY</li>
	 * <li>Const.MENU_SETTINGS_SUBMENU_PLAYER</li>
	 * <li>Const.MENU_SETTINGS_SUBMENU_PRINTOOUT</li>
	 * </ul>
	 *
	 * @param menuType
	 *            - is the type of menu you want to create use Constants.
	 */
	void createMenu(int menuType);

	/**
	 * This method creates Menus that require Data in String format. Example of
	 * menus:
	 * <ul>
	 * <li>Const.MENU_SCOREBOARD</li>
	 * </ul>
	 *
	 * @param menuType
	 *            - is the type of menu you want to create use Constants.
	 */
	void createMenu(int menuType, String data);

	/**
	 * This method creates Menus that require one numeric variable. Example of
	 * menus:
	 * <ul>
	 * <li>Const.MENU_END</li>
	 * <li>Const.MENU_WIN</li>
	 * <li>Const.MENU_LOST</li>
	 * <li>Const.MENU_RETURN</li>
	 * <li>Const.MENU_Bet</li>
	 * </ul>
	 *
	 * @param menuType
	 *            - is the type of menu you want to create use Constants.
	 * @param value
	 *            - is the int argument that we want to pass
	 */
	void createMenu(int menuType, int value);

	/**
	 * This method creates Menus that handle player and his hand value. Example
	 * of menus:
	 * <ul>
	 * <li>Const.MENU_OVERFLOW</li>
	 * </ul>
	 *
	 * @param menuType
	 *            - is the type of menu you want to create use Constants.
	 * @param player
	 *            - is the player
	 * @param playerHandValue
	 *            - is the valuer of cards in players hand
	 */
	void createMenu(int menuType, Player player, int playerHandValue);

	/**
	 * This method creates Menus that handle player and computers hand values.
	 * Example of menus:
	 * <ul>
	 * <li>Const.MENU_STATUS</li>
	 * </ul>
	 *
	 * @param menuType
	 *            - is the type of menu you want to create use Constants.
	 * @param playerHandValue
	 *            - is the player cards value in hand
	 * @param playerBank
	 *            - is the players bank
	 * @param ComputerBank
	 *            - is the computers bank
	 */
	void createMenu(int menuType, int playerHandValue, int playerBank, int ComputerBank);

	/**
	 * This method creates Menus that handle player and computer. Example of
	 * menus:
	 * <ul>
	 * <li>Const.MENU_WIN_ROUND</li>
	 * </ul>
	 *
	 * @param menuType
	 *            - is the type of menu you want to create use Constants.
	 *
	 * @param player
	 *            - is the player
	 * @param computer
	 *            - is the computer
	 * @param playerHandValue
	 *            - is the players card hand value
	 * @param computerHandValue
	 *            - is the computers hand value;
	 * @param playerWon
	 *            - is the check if the player won
	 */
	void createMenu(int menuType, Player player, Player computer, int playerHandValue,
			int computerHandValue, boolean playerWon);

}
