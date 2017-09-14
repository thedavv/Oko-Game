package handler.print.menu;

import util.Const;
/**
 * Creates the SettingsMenu menu. Use it to create SettingsMenu
 */
public class SettingsMenu extends LineCreation implements MenuCreation {

	@Override
	public String createMenu() {
		StringBuilder sb = new StringBuilder();

		sb.append(drawLine(settings.getMenuLenght(), Const.TLC, Const.TRC, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, "SETTINGS"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, "1. PRINTOUT SETUP"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, "2. PLAYER SETUP"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, "3. BANK RULES SETUP"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, "4. BACK TO MAIN MENU"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.BLC, Const.BRC, Const.HL, null));

		return sb.toString();
	}

}
