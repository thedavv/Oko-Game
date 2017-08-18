package handler.printhandler.card;

import java.util.ArrayList;
import java.util.List;

import model.Player;
import model.cardfactory.Card;
import util.Const;

public class GameBoardPrintout extends PlayerPrintout {

	public void drawGameBoard(int style, Player player, Player computer) {
		switch (style) {
		case Const.DRAW_PLAYERS_CARDS_SAME_WAY_TOP_CARD_LEFT:
			System.out.println(createBothPlayersStringRepresentationSameStyleLR(player, computer));
			break;

		case Const.DRAW_PLAYERS_CARDS_SAME_WAY_TOP_CARD_RIGHT:
			System.out.println(createBothPlayersStringRepresentationSameStyleRL(player, computer));
			break;

		case Const.DRAW_PLAYERS_CARDS_MIRROR_WAY:
			System.out.println(createBothPlayersStringRepresentationStyleMirror(player, computer));
			break;

		case Const.DRAW_PLAYERS_CARDS_REVERSE_MIRROR_WAY:
			System.out.println(createBothPlayersStringRepresentationStyleReverseMirror(player, computer));
			break;

		default:
			break;
		}
	}

	public void drawGameBoard(int style, Player player) {
		List<Card> playerHand = new ArrayList<>();
		String playerName = player.getName();

		switch (style) {
		case Const.DRAW_PLAYERS_CARDS_SAME_WAY_TOP_CARD_LEFT:
			System.out.println(createStringRepresentationOfPlayersHand(playerHand, playerName));
			break;

		case Const.DRAW_PLAYERS_CARDS_SAME_WAY_TOP_CARD_RIGHT:
			System.out.println(createStringRepresentationOfOfPlayersHandSecondStyle(playerHand, playerName));
			break;

		case Const.DRAW_PLAYERS_CARDS_MIRROR_WAY:
			System.out.println(createStringRepresentationOfOfPlayersHandSecondStyle(playerHand, playerName));
			break;

		case Const.DRAW_PLAYERS_CARDS_REVERSE_MIRROR_WAY:
			System.out.println(createStringRepresentationOfPlayersHand(playerHand, playerName));
			break;

		default:
			break;
		}
	}
}
