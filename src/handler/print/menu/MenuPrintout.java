package handler.print.menu;

public class MenuPrintout implements Printout{

	@Override
	public void printOutMenu(MenuCreation menu) {
		System.out.println(menu.createMenu());
	}

	@Override
	public void printOutIOMenu(MenuIO menu, String data) {
		System.out.println(menu.createMenu(data));
	}
}
