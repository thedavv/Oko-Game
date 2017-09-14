package handler.print.menu;

/**
 *	This class is used for printig out String representations of created menus that, implement MenuCreation and MenuIO
 */
public class PrintoutMenu implements Printout{

	@Override
	public void printOutMenu(MenuCreation menu) {
		System.out.println(menu.createMenu());
	}

	@Override
	public void printOutIOMenu(MenuIO menu, String data) {
		System.out.println(menu.createMenu(data));
	}
}
