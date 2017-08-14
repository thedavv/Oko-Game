package handler.printout;

import model.Player;
import util.Const;
import util.Settings;

/**
 * @author David Racek
 * 
 * Class handling the printing out game board. It contains clases that will printout gameboard with different styles
 *
 */
public class CardPrintOut {//TODO ad constructor for settings, make settings change printouts 
	private static Settings settings = Settings.getInstance();

	//TODO refactor draw player methods
	@Deprecated
	public void drawPlayer(Player player){
		System.out.println(drawTopLine(player));
		System.out.println(drawNumberLine(player));
		System.out.println(drawColorLine(player));
		for (int i = 0; i < Const.CARD_SIZE_Y - 6; i++) {
			System.out.println(drawEmptyLine(player));
		}
		System.out.println(drawColorLine(player));
		System.out.println(drawNumberLine(player));
		System.out.println(drawBottomLine(player));
	}

	/**
	 * Method for printing out gameboard to console.<br><br> 
	 *
	 *For selecting the <code>drawingStyle</code> use these constants.
	 *<ul>
	 *<li><code>Const.DRAW_PLAYERS_CARDS_SAME_WAY</code> for printing out second player cards with same direction</li>
	 *<li><code>Const.DRAW_PLAYERS_CARDS_MIRROR_WAY</code> for printing out second player cards with mirror direction</li>
	 *<li><code>Const.DRAW_PLAYERS_CARDS_OPOSITE_WAY</code> for printing out second player cards with opposite direction</li>
	 *</ul>
	 * @param player is human player type Player
	 * @param computer is your opponent. in this version computer type Player
	 * @param drawingStyle is drawing style 
	 * 
	 */
	public void drawGameBoard(Player player, Player computer, int drawingStyle){
		if(drawingStyle == Const.DRAW_PLAYERS_CARDS_SAME_WAY){
			drawBothPlayers( player,  computer);
		} else if(drawingStyle == Const.DRAW_PLAYERS_CARDS_MIRROR_WAY){
			drawBothPlayersSecondStyle( player,  computer);
		} else{
			drawBothPlayersThirdStyle( player,  computer);
		}
	}

	/**
	 * private methods for printing out gameboard styles
	 * */
	private void drawBothPlayers(Player player, Player computer){
		System.out.println(drawPlayerNames(player, computer));
		System.out.println(drawTopLine(player) + setSpaceBetweenPlayers() + drawTopLine(computer));
		System.out.println(drawNumberLine(player) + setSpaceBetweenPlayers() + drawNumberLine(computer));
		System.out.println(drawColorLine(player) + setSpaceBetweenPlayers() + drawColorLine(computer));
		for (int i = 0; i < Const.CARD_SIZE_Y-6; i++) {
			System.out.println(drawEmptyLine(player) + setSpaceBetweenPlayers()  + drawEmptyLine(computer));
		}
		System.out.println(drawNumberLine(player) + setSpaceBetweenPlayers() + drawNumberLine(computer));
		System.out.println(drawColorLine(player) + setSpaceBetweenPlayers() + drawColorLine(computer));
		System.out.println(drawBottomLine(player) + setSpaceBetweenPlayers() + drawBottomLine(computer));
	}

	private void drawBothPlayersSecondStyle(Player player, Player computer){
		System.out.println(drawPlayerNames(player, computer));
		System.out.println(drawTopLine(player) + setSpaceBetweenPlayers() + drawTopLineSecondStyle(computer));
		System.out.println(drawNumberLine(player) + setSpaceBetweenPlayers() + drawNumberLineSecondStyle(computer));
		System.out.println(drawColorLine(player) + setSpaceBetweenPlayers() + drawColorLineSecondStyle(computer));
		for (int i = 0; i < Const.CARD_SIZE_Y-6; i++) {
			System.out.println(drawEmptyLine(player) + setSpaceBetweenPlayers()  + drawEmptyLineSecondStyle(computer));
		}
		System.out.println(drawColorLine(player) + setSpaceBetweenPlayers() + drawColorLineSecondStyle(computer));
		System.out.println(drawNumberLine(player) + setSpaceBetweenPlayers() + drawNumberLineSecondStyle(computer));
		System.out.println(drawBottomLine(player) + setSpaceBetweenPlayers() + drawBottomLineSecondStyle(computer));
	}

	private void drawBothPlayersThirdStyle(Player player, Player computer){
		System.out.println(drawPlayerNames(player, computer));
		System.out.println(drawTopLineSecondStyle(player) + setSpaceBetweenPlayers() + drawTopLine(computer));
		System.out.println(drawNumberLineSecondStyle(player) + setSpaceBetweenPlayers() + drawNumberLine(computer));
		System.out.println(drawColorLineSecondStyle(player) + setSpaceBetweenPlayers() + drawColorLine(computer));
		for (int i = 0; i < Const.CARD_SIZE_Y-6; i++) {
			System.out.println(drawEmptyLineSecondStyle(player) + setSpaceBetweenPlayers()  + drawEmptyLine(computer));
		}
		System.out.println(drawColorLineSecondStyle(player) + setSpaceBetweenPlayers() + drawColorLine(computer));
		System.out.println(drawNumberLineSecondStyle(player) + setSpaceBetweenPlayers() + drawNumberLine(computer));
		System.out.println(drawBottomLineSecondStyle(player) + setSpaceBetweenPlayers() + drawBottomLine(computer));
	}

	//TODO refactor draw line methods
	/**
	 * private methods for drawing card lines 
	 * */
	private static String drawTopLine(Player player){
		StringBuilder line = new StringBuilder();
		int cardCount = player.getCards().size();

		line.append(Const.TLC);
		for(int i = 0; i < cardCount; i++){
			if(i < cardCount - 1){
				line.append(Const.HL).append(Const.HL).append(Const.TJ);
			} else{
				for (int j = 0; j < Const.CARD_SIZE_X - 2; j++) {
					line.append(Const.HL);
				}
			}
		}
		line.append(Const.TRC);

		return line.toString();
	}

	private static String drawBottomLine(Player player){
		StringBuilder line = new StringBuilder();
		int cardCount = player.getCards().size();

		line.append(Const.BLC);
		for(int i = 0; i < cardCount; i++){
			if(i < cardCount - 1){
				line.append(Const.HL).append(Const.HL).append(Const.BJ);
			} else{
				for (int j = 0; j < Const.CARD_SIZE_X - 2; j++) {
					line.append(Const.HL);
				}
			}
		}
		line.append(Const.BRC);

		return line.toString();
	}

	private static String drawNumberLine(Player player){
		StringBuilder line = new StringBuilder();
		int cardCount = player.getCards().size();

		line.append(Const.VL);
		for (int i = 0; i < cardCount; i++) {
			String cardLabel = player.getCards().get(i).getValue().getLabel();
			int cardLabelLenght = cardLabel.length();
			line.append(cardLabel);

			for(int j = 0; j < 2 - cardLabelLenght; j++){
				line.append(Const.SP);
			}
			if(i == cardCount -1){
				for(int j = 0; j < Const.CARD_SIZE_X - 2 * ( 1 + cardLabelLenght) - 1; j++){
					line.append(Const.SP);
				}
				if(cardLabelLenght > 1){
					line.append(Const.SP);
				}
				line.append(cardLabel);
			}
			line.append(Const.VL);
		}

		return line.toString();
	}

	private static String drawColorLine(Player player){
		StringBuilder line = new StringBuilder();
		int cardCount = player.getCards().size();

		line.append(Const.VL);
		for(int i = 0; i < cardCount; i++){
			char cardColor = player.getCards().get(i).getColor().getColor();

			if ( i < cardCount -1){
				line.append(Const.SP).append(cardColor).append(Const.VL);
			} else{
				line.append(Const.SP).append(cardColor);
				for (int j = 0; j < Const.CARD_SIZE_X - 6; j++) {
					line.append(Const.SP);
				}
				line.append(cardColor);
			}
		}
		line.append(Const.SP);
		line.append(Const.VL);

		return line.toString();
	}

	private static String drawEmptyLine(Player player){
		StringBuilder line = new StringBuilder();
		int cardCount = player.getCards().size();

		line.append(Const.VL);
		for(int i = 0; i < cardCount; i++){
			if( i < cardCount -1){
				line.append(Const.SP).append(Const.SP).append(Const.VL);
			} else{
				for (int j = 0; j < Const.CARD_SIZE_X - 2; j++) {
					line.append(Const.SP);
				}
			}
		}
		line.append(Const.VL);

		return line.toString();
	}

	private static String drawTopLineSecondStyle(Player player){
		StringBuilder line = new StringBuilder();
		int cardCount = player.getCards().size();

		line.append(Const.TLC);
		for(int i = 0; i < cardCount; i++){
			if(i == 0){
				for (int j = 0; j < Const.CARD_SIZE_X - 2; j++) {
					line.append(Const.HL);
				}
			} else{
				line.append(Const.TJ).append(Const.HL).append(Const.HL);
			}
		}
		line.append(Const.TRC);

		return line.toString();
	}

	private static String drawBottomLineSecondStyle(Player player){
		StringBuilder line = new StringBuilder();
		int cardCount = player.getCards().size();

		line.append(Const.BLC);
		for(int i = 0; i < cardCount; i++){
			if(i == 0){
				for (int j = 0; j < Const.CARD_SIZE_X - 2; j++) {
					line.append(Const.HL);
				}
			} else{

				line.append(Const.BJ).append(Const.HL).append(Const.HL);
			}
		}
		line.append(Const.BRC);

		return line.toString();
	}

	private static String drawNumberLineSecondStyle(Player player){
		StringBuilder line = new StringBuilder();
		int cardCount = player.getCards().size();

		line.append(Const.VL);
		for (int i = 0; i < cardCount; i++) {
			String cardLabel = player.getCards().get(i).getValue().getLabel();
			int cardLabelLenght = cardLabel.length();
			
			if(i == 0){
				line.append(cardLabel);
				for(int j = 0; j < 2 - cardLabelLenght; j++){
					line.append(Const.SP);
				}
			} else{
				for(int j = 0; j < 2 - cardLabelLenght; j++){
					line.append(Const.SP);
				}
				line.append(cardLabel);
			}
			
			
			if(i == 0){
				for(int j = 0; j < Const.CARD_SIZE_X - 2 * ( 1 + cardLabelLenght)-1; j++){
					line.append(Const.SP);

				}
				if(cardLabelLenght > 1){
					line.append(Const.SP);
				}
				line.append(cardLabel);
			}
			line.append(Const.VL);
		}

		return line.toString();
	}

	private static String drawColorLineSecondStyle(Player player){
		StringBuilder line = new StringBuilder();
		int cardCount = player.getCards().size();

		line.append(Const.VL);
		for(int i = 0; i < cardCount; i++){
			char cardColor = player.getCards().get(i).getColor().getColor();

			if ( i == 0){
				line.append(Const.SP).append(cardColor);
				for (int j = 0; j < Const.CARD_SIZE_X - 6; j++) {
					line.append(Const.SP);
				}
				line.append(cardColor).append(Const.SP);
			} else{
				line.append(Const.VL).append(cardColor).append(Const.SP);
			}
		}
		line.append(Const.VL);

		return line.toString();
	}

	private static String drawEmptyLineSecondStyle(Player player){
		StringBuilder line = new StringBuilder();
		int cardCount = player.getCards().size();

		line.append(Const.VL);
		for(int i = 0; i < cardCount; i++){
			if( i == 0){
				for (int j = 0; j < Const.CARD_SIZE_X - 2; j++) {
					line.append(Const.SP);
				}
			} else{
				line.append(Const.VL).append(Const.SP).append(Const.SP);
			}
		}
		line.append(Const.VL);

		return line.toString();
	}

	//TODO rework methods below for static space between players
	/**
	 * Private methods for adjusting board printout with settings
	 * */
	private static String setSpaceBetweenPlayers(){
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < settings.getSpaceBetweenPlayers(); i++) {
			sb.append(Const.SP);
		}

		return sb.toString();
	}

	private static String drawPlayerNames(Player player, Player computer){
		int cardSize = player.getCards().size() * 3 + Const.CARD_SIZE_X - 3 - 13 + 7;
		StringBuilder sb = new StringBuilder();
		sb.append(player.getName().toUpperCase() + " CARDS:");
		for (int i = 0; i < cardSize; i++) {
			sb.append(Const.SP);
		}
		sb.append(computer.getName().toUpperCase() +" CARDS:");

		return sb.toString();
	}


}