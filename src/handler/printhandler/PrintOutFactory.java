package handler.printhandler;

public class PrintOutFactory implements PrintOutMenu{

	@Override
	public MenuPrintOut createMenuPrintout() {
		return new MenuPrintOut();
	}

	@Override
	public CardPrintOut createCardPrintout() {
		return new CardPrintOut();
	}
	
}
