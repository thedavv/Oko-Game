package handler.print.player;

import java.util.ArrayList;
import java.util.List;

import model.Player;
import model.cardfactory.Card;
import util.Const;

/**
 * Use this to select what gameboard you want to be printed out use constants:
 * Const.DRAW_PLAYERS_CARDS_SAME_WAY_TOP_CARD_LEFT,
 * Const.DRAW_PLAYERS_CARDS_SAME_WAY_TOP_CARD_RIGHT,
 * Const.DRAW_PLAYERS_CARDS_MIRROR_WAY,
 * Const.DRAW_PLAYERS_CARDS_REVERSE_MIRROR_WAY </br>for drawGameBoard for only one
 * player use </br> Const.DRAW_PLAYERS_CARDS_SAME_WAY_TOP_CARD_LEFT
 * Const.DRAW_PLAYERS_CARDS_SAME_WAY_TOP_CARD_RIGHT
 * Const.DRAW_PLAYERS_CARDS_MIRROR_WAY
 * Const.DRAW_PLAYERS_CARDS_REVERSE_MIRROR_WAY
 */
public class GameBoardPrintOut extends PlayerCreation implements GameBoard {

	/*
	 * (non-Javadoc)
	 * 
	 * @see handler.print.player.GameBoard#drawGameBoard(int, model.Player,
	 * model.Player)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see handler.print.player.GameBoard#drawGameBoard(int, model.Player)
	 */
	public void drawGameBoard(int style, Player player) {
		List<Card> playerHand = new ArrayList<>();
		playerHand.addAll(player.getCards());
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
