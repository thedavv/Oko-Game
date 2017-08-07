package handler;

import model.Player;
import model.cardfactory.Card;
import util.Const;

public class CardFactoryHandler {
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

	public void drawBothPlayers(Player player, Player computer){
		int cardSize = player.getCards().size() * 3 + Const.CARD_SIZE_X - 3 - 13 + 7;
		StringBuilder sb = new StringBuilder();
		sb.append("PLAYER CARDS:");
		for (int i = 0; i < cardSize; i++) {
			sb.append(Const.SP);
		}
		sb.append("COMPUTER CARDS:");
		
		System.out.println(sb);
		System.out.println(drawTopLine(player) + "       " + drawTopLine(computer));
		System.out.println(drawNumberLine(player) + "       " + drawNumberLine(computer));
		System.out.println(drawColorLine(player) + "       " + drawColorLine(computer));
		for (int i = 0; i < Const.CARD_SIZE_Y-6; i++) {
			System.out.println(drawEmptyLine(player) + "       "  + drawEmptyLine(computer));
		}
		System.out.println(drawNumberLine(player) + "       " + drawNumberLine(computer));
		System.out.println(drawColorLine(player) + "       " + drawColorLine(computer));
		System.out.println(drawBottomLine(player) + "       " + drawBottomLine(computer));
	}

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

}