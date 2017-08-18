package handler.printhandler;

import java.util.ArrayList;
import java.util.List;

import model.Player;
import model.cardfactory.Card;
import util.Const;
import util.Settings;

/**
 * @author David Racek
 *
 *         Class handling the printing out game board. It contains clases that
 *         will printout gameboard with different styles
 *
 */
public class CardPrintOutOld {// TODO ad constructor for settings, make settings
	// change printouts
	private static Settings settings = Settings.getInstance();

	@Deprecated
	public void drawPlayer(Player player) {
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
	 * Method for printing out gameboard to console.<br>
	 * <br>
	 *
	 * For selecting the <code>drawingStyle</code> use these constants.
	 * <ul>
	 * <li><code>Const.DRAW_PLAYERS_CARDS_SAME_WAY</code> for printing out
	 * second player cards with same direction</li>
	 * <li><code>Const.DRAW_PLAYERS_CARDS_MIRROR_WAY</code> for printing out
	 * second player cards with mirror direction</li>
	 * <li><code>Const.DRAW_PLAYERS_CARDS_OPOSITE_WAY</code> for printing out
	 * second player cards with opposite direction</li>
	 * </ul>
	 * 
	 * @param player
	 *            - is human player type Player
	 * @param computer
	 *            - is your opponent.
	 * @param drawingStyle
	 *            - is drawing style
	 *
	 */
	@Deprecated
	public void drawGameBoard(Player player, Player computer, int drawingStyle) {
		if (drawingStyle == Const.DRAW_PLAYERS_CARDS_SAME_WAY_TOP_CARD_LEFT) {
			drawBothPlayers(player, computer);
		} else if (drawingStyle == Const.DRAW_PLAYERS_CARDS_MIRROR_WAY) {
			drawBothPlayersSecondStyle(player, computer);
		} else {
			drawBothPlayersThirdStyle(player, computer);
		}
	}

	/**
	 * private methods for printing out gameboard styles
	 */
	@Deprecated
	private void drawBothPlayers(Player player, Player computer) {
		System.out.println(drawPlayerNames(player, computer));
		System.out.println(
				drawTopLine(player) + setSpaceBetweenPlayers() + drawTopLine(computer));
		System.out.println(drawNumberLine(player) + setSpaceBetweenPlayers()
				+ drawNumberLine(computer));
		System.out.println(drawColorLine(player) + setSpaceBetweenPlayers()
				+ drawColorLine(computer));
		for (int i = 0; i < Const.CARD_SIZE_Y - 6; i++) {
			System.out.println(drawEmptyLine(player) + setSpaceBetweenPlayers()
					+ drawEmptyLine(computer));
		}
		System.out.println(drawNumberLine(player) + setSpaceBetweenPlayers()
				+ drawNumberLine(computer));
		System.out.println(drawColorLine(player) + setSpaceBetweenPlayers()
				+ drawColorLine(computer));
		System.out.println(drawBottomLine(player) + setSpaceBetweenPlayers()
				+ drawBottomLine(computer));
	}

	@Deprecated
	private void drawBothPlayersSecondStyle(Player player, Player computer) {
		System.out.println(drawPlayerNames(player, computer));
		System.out.println(drawTopLine(player) + setSpaceBetweenPlayers()
				+ drawTopLineSecondStyle(computer));
		System.out.println(drawNumberLine(player) + setSpaceBetweenPlayers()
				+ drawNumberLineSecondStyle(computer));
		System.out.println(drawColorLine(player) + setSpaceBetweenPlayers()
				+ drawColorLineSecondStyle(computer));
		for (int i = 0; i < Const.CARD_SIZE_Y - 6; i++) {
			System.out.println(drawEmptyLine(player) + setSpaceBetweenPlayers()
					+ drawEmptyLineSecondStyle(computer));
		}
		System.out.println(drawColorLine(player) + setSpaceBetweenPlayers()
				+ drawColorLineSecondStyle(computer));
		System.out.println(drawNumberLine(player) + setSpaceBetweenPlayers()
				+ drawNumberLineSecondStyle(computer));
		System.out.println(drawBottomLine(player) + setSpaceBetweenPlayers()
				+ drawBottomLineSecondStyle(computer));
	}

	@Deprecated
	private void drawBothPlayersThirdStyle(Player player, Player computer) {
		System.out.println(drawPlayerNames(player, computer));
		System.out.println(drawTopLineSecondStyle(player) + setSpaceBetweenPlayers()
				+ drawTopLine(computer));
		System.out.println(drawNumberLineSecondStyle(player) + setSpaceBetweenPlayers()
				+ drawNumberLine(computer));
		System.out.println(drawColorLineSecondStyle(player) + setSpaceBetweenPlayers()
				+ drawColorLine(computer));
		for (int i = 0; i < Const.CARD_SIZE_Y - 6; i++) {
			System.out.println(drawEmptyLineSecondStyle(player) + setSpaceBetweenPlayers()
					+ drawEmptyLine(computer));
		}
		System.out.println(drawColorLineSecondStyle(player) + setSpaceBetweenPlayers()
				+ drawColorLine(computer));
		System.out.println(drawNumberLineSecondStyle(player) + setSpaceBetweenPlayers()
				+ drawNumberLine(computer));
		System.out.println(drawBottomLineSecondStyle(player) + setSpaceBetweenPlayers()
				+ drawBottomLine(computer));
	}

	/**
	 * private methods for drawing card lines
	 */
	@Deprecated
	private static String drawTopLine(Player player) {
		StringBuilder line = new StringBuilder();
		int cardCount = player.getCards().size();

		line.append(Const.TLC);
		for (int i = 0; i < cardCount; i++) {
			if (i < cardCount - 1) {
				line.append(Const.HL).append(Const.HL).append(Const.TJ);
			} else {
				for (int j = 0; j < Const.CARD_SIZE_X - 2; j++) {
					line.append(Const.HL);
				}
			}
		}
		line.append(Const.TRC);

		return line.toString();
	}

	@Deprecated
	private static String drawBottomLine(Player player) {
		StringBuilder line = new StringBuilder();
		int cardCount = player.getCards().size();

		line.append(Const.BLC);
		for (int i = 0; i < cardCount; i++) {
			if (i < cardCount - 1) {
				line.append(Const.HL).append(Const.HL).append(Const.BJ);
			} else {
				for (int j = 0; j < Const.CARD_SIZE_X - 2; j++) {
					line.append(Const.HL);
				}
			}
		}
		line.append(Const.BRC);

		return line.toString();
	}

	@Deprecated
	private static String drawNumberLine(Player player) {
		StringBuilder line = new StringBuilder();
		int cardCount = player.getCards().size();

		line.append(Const.VL);
		for (int i = 0; i < cardCount; i++) {
			String cardLabel = player.getCards().get(i).getValue().getLabel();
			int cardLabelLenght = cardLabel.length();
			line.append(cardLabel);

			for (int j = 0; j < 2 - cardLabelLenght; j++) {
				line.append(Const.SP);
			}
			if (i == cardCount - 1) {
				for (int j = 0; j < Const.CARD_SIZE_X - 2 * (1 + cardLabelLenght)
						- 1; j++) {
					line.append(Const.SP);
				}
				if (cardLabelLenght > 1) {
					line.append(Const.SP);
				}
				line.append(cardLabel);
			}
			line.append(Const.VL);
		}

		return line.toString();
	}

	@Deprecated
	private static String drawColorLine(Player player) {
		StringBuilder line = new StringBuilder();
		int cardCount = player.getCards().size();

		line.append(Const.VL);
		for (int i = 0; i < cardCount; i++) {
			char cardColor = player.getCards().get(i).getColor().getColor();

			if (i < cardCount - 1) {
				line.append(Const.SP).append(cardColor).append(Const.VL);
			} else {
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

	@Deprecated
	private static String drawEmptyLine(Player player) {
		StringBuilder line = new StringBuilder();
		int cardCount = player.getCards().size();

		line.append(Const.VL);
		for (int i = 0; i < cardCount; i++) {
			if (i < cardCount - 1) {
				line.append(Const.SP).append(Const.SP).append(Const.VL);
			} else {
				for (int j = 0; j < Const.CARD_SIZE_X - 2; j++) {
					line.append(Const.SP);
				}
			}
		}
		line.append(Const.VL);

		return line.toString();
	}

	@Deprecated
	private static String drawTopLineSecondStyle(Player player) {
		StringBuilder line = new StringBuilder();
		int cardCount = player.getCards().size();

		line.append(Const.TLC);
		for (int i = 0; i < cardCount; i++) {
			if (i == 0) {
				for (int j = 0; j < Const.CARD_SIZE_X - 2; j++) {
					line.append(Const.HL);
				}
			} else {
				line.append(Const.TJ).append(Const.HL).append(Const.HL);
			}
		}
		line.append(Const.TRC);

		return line.toString();
	}

	@Deprecated
	private static String drawBottomLineSecondStyle(Player player) {
		StringBuilder line = new StringBuilder();
		int cardCount = player.getCards().size();

		line.append(Const.BLC);
		for (int i = 0; i < cardCount; i++) {
			if (i == 0) {
				for (int j = 0; j < Const.CARD_SIZE_X - 2; j++) {
					line.append(Const.HL);
				}
			} else {

				line.append(Const.BJ).append(Const.HL).append(Const.HL);
			}
		}
		line.append(Const.BRC);

		return line.toString();
	}

	@Deprecated
	private static String drawNumberLineSecondStyle(Player player) {
		StringBuilder line = new StringBuilder();
		int cardCount = player.getCards().size();

		line.append(Const.VL);
		for (int i = 0; i < cardCount; i++) {
			String cardLabel = player.getCards().get(i).getValue().getLabel();
			int cardLabelLenght = cardLabel.length();

			if (i == 0) {
				line.append(cardLabel);
				for (int j = 0; j < 2 - cardLabelLenght; j++) {
					line.append(Const.SP);
				}
			} else {
				for (int j = 0; j < 2 - cardLabelLenght; j++) {
					line.append(Const.SP);
				}
				line.append(cardLabel);
			}

			if (i == 0) {
				for (int j = 0; j < Const.CARD_SIZE_X - 2 * (1 + cardLabelLenght)
						- 1; j++) {
					line.append(Const.SP);

				}
				if (cardLabelLenght > 1) {
					line.append(Const.SP);
				}
				line.append(cardLabel);
			}
			line.append(Const.VL);
		}

		return line.toString();
	}

	@Deprecated
	private static String drawColorLineSecondStyle(Player player) {
		StringBuilder line = new StringBuilder();
		int cardCount = player.getCards().size();

		line.append(Const.VL);
		for (int i = 0; i < cardCount; i++) {
			char cardColor = player.getCards().get(i).getColor().getColor();

			if (i == 0) {
				line.append(Const.SP).append(cardColor);
				for (int j = 0; j < Const.CARD_SIZE_X - 6; j++) {
					line.append(Const.SP);
				}
				line.append(cardColor).append(Const.SP);
			} else {
				line.append(Const.VL).append(cardColor).append(Const.SP);
			}
		}
		line.append(Const.VL);

		return line.toString();
	}

	@Deprecated
	private static String drawEmptyLineSecondStyle(Player player) {
		StringBuilder line = new StringBuilder();
		int cardCount = player.getCards().size();

		line.append(Const.VL);
		for (int i = 0; i < cardCount; i++) {
			if (i == 0) {
				for (int j = 0; j < Const.CARD_SIZE_X - 2; j++) {
					line.append(Const.SP);
				}
			} else {
				line.append(Const.VL).append(Const.SP).append(Const.SP);
			}
		}
		line.append(Const.VL);

		return line.toString();
	}

	public static void printOutPlayersSameStyleLR(Player player, Player computer) {
		StringBuilder sb = new StringBuilder();
		List<String> playerValueStrings = new ArrayList<>();
		List<String> playerColorStrings = new ArrayList<>();
		List<String> computerValueStrings = new ArrayList<>();
		List<String> computerColorStrings = new ArrayList<>();
		int playerHandSize = player.getCards().size();
		int computerHandSize = computer.getCards().size();

		for (Card c : player.getCards()) {
			playerColorStrings.add(String.valueOf(c.getColor().getColor()));
			playerValueStrings.add(String.valueOf(c.getValue().getLabel()));
		}
		for (Card c : computer.getCards()) {
			computerColorStrings.add(String.valueOf(c.getColor().getColor()));
			computerValueStrings.add(String.valueOf(c.getValue().getLabel()));
		}

		// append top line
		sb.append(createCompleteLineLR(playerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.TLC),
				String.valueOf(Const.TRC), String.valueOf(Const.TJ),
				String.valueOf(Const.HL), null));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineLR(computerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.TLC),
				String.valueOf(Const.TRC), String.valueOf(Const.TJ),
				String.valueOf(Const.HL), null));
		sb.append("\n");
		// append number Line
		sb.append(createCompleteLineLR(playerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), playerValueStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineLR(computerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), computerValueStrings));
		sb.append("\n");
		// append color line
		sb.append(createCompleteLineLR(playerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), playerColorStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineLR(computerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), computerColorStrings));
		sb.append("\n");
		// append middle line
		for (int i = 0; i < settings.getCardSizeY() - 6; i++) {
			sb.append(createCompleteLineLR(playerHandSize, settings.getCardSizeX(),
					settings.getCardPartialSizeX(), String.valueOf(Const.VL),
					String.valueOf(Const.VL), String.valueOf(Const.VL),
					String.valueOf(Const.SP), null));
			sb.append(setSpaceBetweenPlayers());
			sb.append(createCompleteLineLR(computerHandSize, settings.getCardSizeX(),
					settings.getCardPartialSizeX(), String.valueOf(Const.VL),
					String.valueOf(Const.VL), String.valueOf(Const.VL),
					String.valueOf(Const.SP), null));
			sb.append("\n");
		}
		// append color line
		sb.append(createCompleteLineLR(playerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), playerColorStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineLR(computerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), computerColorStrings));
		sb.append("\n");
		// append number Line
		sb.append(createCompleteLineLR(playerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), playerValueStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineLR(computerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), computerValueStrings));
		sb.append("\n");
		// append Bot Line
		sb.append(createCompleteLineLR(playerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.BLC),
				String.valueOf(Const.BRC), String.valueOf(Const.BJ),
				String.valueOf(Const.HL), null));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineLR(computerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.BLC),
				String.valueOf(Const.BRC), String.valueOf(Const.BJ),
				String.valueOf(Const.HL), null));
		sb.append("\n");

		System.out.println(sb);
	}

	public static void printOutPlayersSameStyleRL(Player player, Player computer) {
		StringBuilder sb = new StringBuilder();
		List<String> playerValueStrings = new ArrayList<>();
		List<String> playerColorStrings = new ArrayList<>();
		List<String> computerValueStrings = new ArrayList<>();
		List<String> computerColorStrings = new ArrayList<>();
		int playerHandSize = player.getCards().size();
		int computerHandSize = computer.getCards().size();

		for (Card c : player.getCards()) {
			playerColorStrings.add(String.valueOf(c.getColor().getColor()));
			playerValueStrings.add(String.valueOf(c.getValue().getLabel()));
		}
		for (Card c : computer.getCards()) {
			computerColorStrings.add(String.valueOf(c.getColor().getColor()));
			computerValueStrings.add(String.valueOf(c.getValue().getLabel()));
		}

		// append top line
		sb.append(createCompleteLineRL(playerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.TLC),
				String.valueOf(Const.TRC), String.valueOf(Const.TJ),
				String.valueOf(Const.HL), null));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineRL(computerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.TLC),
				String.valueOf(Const.TRC), String.valueOf(Const.TJ),
				String.valueOf(Const.HL), null));
		sb.append("\n");
		// append number Line
		sb.append(createCompleteLineRL(playerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), playerValueStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineRL(computerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), computerValueStrings));
		sb.append("\n");
		// append color line
		sb.append(createCompleteLineRL(playerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), playerColorStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineRL(computerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), computerColorStrings));
		sb.append("\n");
		// append middle line
		for (int i = 0; i < settings.getCardSizeY() - 6; i++) {
			sb.append(createCompleteLineRL(playerHandSize, settings.getCardSizeX(),
					settings.getCardPartialSizeX(), String.valueOf(Const.VL),
					String.valueOf(Const.VL), String.valueOf(Const.VL),
					String.valueOf(Const.SP), null));
			sb.append(setSpaceBetweenPlayers());
			sb.append(createCompleteLineRL(computerHandSize, settings.getCardSizeX(),
					settings.getCardPartialSizeX(), String.valueOf(Const.VL),
					String.valueOf(Const.VL), String.valueOf(Const.VL),
					String.valueOf(Const.SP), null));
			sb.append("\n");
		}
		// append color line
		sb.append(createCompleteLineRL(playerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), playerColorStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineRL(computerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), computerColorStrings));
		sb.append("\n");
		// append number Line
		sb.append(createCompleteLineRL(playerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), playerValueStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineRL(computerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), computerValueStrings));
		sb.append("\n");
		// append Bot Line
		sb.append(createCompleteLineRL(playerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.BLC),
				String.valueOf(Const.BRC), String.valueOf(Const.BJ),
				String.valueOf(Const.HL), null));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineRL(computerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.BLC),
				String.valueOf(Const.BRC), String.valueOf(Const.BJ),
				String.valueOf(Const.HL), null));
		sb.append("\n");

		System.out.println(sb);
	}

	public static void printOutPlayersStyleMirror(Player player, Player computer) {
		StringBuilder sb = new StringBuilder();
		List<String> playerValueStrings = new ArrayList<>();
		List<String> playerColorStrings = new ArrayList<>();
		List<String> computerValueStrings = new ArrayList<>();
		List<String> computerColorStrings = new ArrayList<>();
		int playerHandSize = player.getCards().size();
		int computerHandSize = computer.getCards().size();

		for (Card c : player.getCards()) {
			playerColorStrings.add(String.valueOf(c.getColor().getColor()));
			playerValueStrings.add(String.valueOf(c.getValue().getLabel()));
		}
		for (Card c : computer.getCards()) {
			computerColorStrings.add(String.valueOf(c.getColor().getColor()));
			computerValueStrings.add(String.valueOf(c.getValue().getLabel()));
		}

		// append top line
		sb.append(createCompleteLineRL(playerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.TLC),
				String.valueOf(Const.TRC), String.valueOf(Const.TJ),
				String.valueOf(Const.HL), null));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineLR(computerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.TLC),
				String.valueOf(Const.TRC), String.valueOf(Const.TJ),
				String.valueOf(Const.HL), null));
		sb.append("\n");
		// append number Line
		sb.append(createCompleteLineRL(playerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), playerValueStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineLR(computerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), computerValueStrings));
		sb.append("\n");
		// append color line
		sb.append(createCompleteLineRL(playerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), playerColorStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineLR(computerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), computerColorStrings));
		sb.append("\n");
		// append middle line
		for (int i = 0; i < settings.getCardSizeY() - 6; i++) {
			sb.append(createCompleteLineRL(playerHandSize, settings.getCardSizeX(),
					settings.getCardPartialSizeX(), String.valueOf(Const.VL),
					String.valueOf(Const.VL), String.valueOf(Const.VL),
					String.valueOf(Const.SP), null));
			sb.append(setSpaceBetweenPlayers());
			sb.append(createCompleteLineLR(computerHandSize, settings.getCardSizeX(),
					settings.getCardPartialSizeX(), String.valueOf(Const.VL),
					String.valueOf(Const.VL), String.valueOf(Const.VL),
					String.valueOf(Const.SP), null));
			sb.append("\n");
		}
		// append color line
		sb.append(createCompleteLineRL(playerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), playerColorStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineLR(computerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), computerColorStrings));
		sb.append("\n");
		// append number Line
		sb.append(createCompleteLineRL(playerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), playerValueStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineLR(computerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), computerValueStrings));
		sb.append("\n");
		// append Bot Line
		sb.append(createCompleteLineRL(playerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.BLC),
				String.valueOf(Const.BRC), String.valueOf(Const.BJ),
				String.valueOf(Const.HL), null));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineLR(computerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.BLC),
				String.valueOf(Const.BRC), String.valueOf(Const.BJ),
				String.valueOf(Const.HL), null));
		sb.append("\n");

		System.out.println(sb);
	}

	public static void printOutPlayersStyleReverseMirror(Player player, Player computer) {
		StringBuilder sb = new StringBuilder();
		List<String> playerValueStrings = new ArrayList<>();
		List<String> playerColorStrings = new ArrayList<>();
		List<String> computerValueStrings = new ArrayList<>();
		List<String> computerColorStrings = new ArrayList<>();
		int playerHandSize = player.getCards().size();
		int computerHandSize = computer.getCards().size();

		for (Card c : player.getCards()) {
			playerColorStrings.add(String.valueOf(c.getColor().getColor()));
			playerValueStrings.add(String.valueOf(c.getValue().getLabel()));
		}
		for (Card c : computer.getCards()) {
			computerColorStrings.add(String.valueOf(c.getColor().getColor()));
			computerValueStrings.add(String.valueOf(c.getValue().getLabel()));
		}

		// append top line
		sb.append(createCompleteLineLR(playerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.TLC),
				String.valueOf(Const.TRC), String.valueOf(Const.TJ),
				String.valueOf(Const.HL), null));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineRL(computerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.TLC),
				String.valueOf(Const.TRC), String.valueOf(Const.TJ),
				String.valueOf(Const.HL), null));
		sb.append("\n");
		// append number Line
		sb.append(createCompleteLineLR(playerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), playerValueStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineRL(computerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), computerValueStrings));
		sb.append("\n");
		// append color line
		sb.append(createCompleteLineLR(playerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), playerColorStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineRL(computerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), computerColorStrings));
		sb.append("\n");
		// append middle line
		for (int i = 0; i < settings.getCardSizeY() - 6; i++) {
			sb.append(createCompleteLineLR(playerHandSize, settings.getCardSizeX(),
					settings.getCardPartialSizeX(), String.valueOf(Const.VL),
					String.valueOf(Const.VL), String.valueOf(Const.VL),
					String.valueOf(Const.SP), null));
			sb.append(setSpaceBetweenPlayers());
			sb.append(createCompleteLineRL(computerHandSize, settings.getCardSizeX(),
					settings.getCardPartialSizeX(), String.valueOf(Const.VL),
					String.valueOf(Const.VL), String.valueOf(Const.VL),
					String.valueOf(Const.SP), null));
			sb.append("\n");
		}
		// append color line
		sb.append(createCompleteLineLR(playerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), playerColorStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineRL(computerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), computerColorStrings));
		sb.append("\n");
		// append number Line
		sb.append(createCompleteLineLR(playerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), playerValueStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineRL(computerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), computerValueStrings));
		sb.append("\n");
		// append Bot Line
		sb.append(createCompleteLineLR(playerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.BLC),
				String.valueOf(Const.BRC), String.valueOf(Const.BJ),
				String.valueOf(Const.HL), null));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineRL(computerHandSize, settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.BLC),
				String.valueOf(Const.BRC), String.valueOf(Const.BJ),
				String.valueOf(Const.HL), null));
		sb.append("\n");

		System.out.println(sb);
	}

	public static String createStringRepresentationOfPlayersHand(List<Card> playerHand) {
		StringBuilder sb = new StringBuilder();
		List<String> valueStrings = new ArrayList<>();
		List<String> colorStrings = new ArrayList<>();

		for (Card c : playerHand) {
			colorStrings.add(String.valueOf(c.getColor().getColor()));
			valueStrings.add(String.valueOf(c.getValue().getLabel()));
		}
		// append top line
		sb.append(createCompleteLineLR(playerHand.size(), settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.TLC),
				String.valueOf(Const.TRC), String.valueOf(Const.TJ),
				String.valueOf(Const.HL), null));
		sb.append("\n");
		// append number Line
		sb.append(createCompleteLineLR(playerHand.size(), settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), valueStrings));
		sb.append("\n");
		// append color line
		sb.append(createCompleteLineLR(playerHand.size(), settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), colorStrings));
		sb.append("\n");
		// append middle line
		for (int i = 0; i < settings.getCardSizeY() - 6; i++) {
			sb.append(createCompleteLineLR(playerHand.size(), settings.getCardSizeX(),
					settings.getCardPartialSizeX(), String.valueOf(Const.VL),
					String.valueOf(Const.VL), String.valueOf(Const.VL),
					String.valueOf(Const.SP), null));
			sb.append("\n");
		}
		// append color line
		sb.append(createCompleteLineLR(playerHand.size(), settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), colorStrings));
		sb.append("\n");
		// append number Line
		sb.append(createCompleteLineLR(playerHand.size(), settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), valueStrings));
		sb.append("\n");
		// append Bot Line
		sb.append(createCompleteLineLR(playerHand.size(), settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.BLC),
				String.valueOf(Const.BRC), String.valueOf(Const.BJ),
				String.valueOf(Const.HL), null));
		sb.append("\n");

		return sb.toString();
	}

	public static String createStringRepresentationOfOfPlayersHandSecondStyle(
			List<Card> playerHand) {
		StringBuilder sb = new StringBuilder();
		List<String> valueStrings = new ArrayList<>();
		List<String> colorStrings = new ArrayList<>();

		for (Card c : playerHand) {
			colorStrings.add(String.valueOf(c.getColor().getColor()));
			valueStrings.add(String.valueOf(c.getValue().getLabel()));
		}
		// append top line
		sb.append(createCompleteLineRL(playerHand.size(), settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.TLC),
				String.valueOf(Const.TRC), String.valueOf(Const.TJ),
				String.valueOf(Const.HL), null));
		sb.append("\n");
		// append number Line
		sb.append(createCompleteLineRL(playerHand.size(), settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), valueStrings));
		sb.append("\n");
		// append color line
		sb.append(createCompleteLineRL(playerHand.size(), settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), colorStrings));
		sb.append("\n");
		// append middle line
		for (int i = 0; i < settings.getCardSizeY() - 6; i++) {
			sb.append(createCompleteLineRL(playerHand.size(), settings.getCardSizeX(),
					settings.getCardPartialSizeX(), String.valueOf(Const.VL),
					String.valueOf(Const.VL), String.valueOf(Const.VL),
					String.valueOf(Const.SP), null));
			sb.append("\n");
		}
		// append color line
		sb.append(createCompleteLineRL(playerHand.size(), settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), colorStrings));
		sb.append("\n");
		// append number Line
		sb.append(createCompleteLineRL(playerHand.size(), settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.VL),
				String.valueOf(Const.VL), String.valueOf(Const.VL),
				String.valueOf(Const.SP), valueStrings));
		sb.append("\n");
		// append Bot Line
		sb.append(createCompleteLineRL(playerHand.size(), settings.getCardSizeX(),
				settings.getCardPartialSizeX(), String.valueOf(Const.BLC),
				String.valueOf(Const.BRC), String.valueOf(Const.BJ),
				String.valueOf(Const.HL), null));
		sb.append("\n");

		return sb.toString();
	}

	public static String createCompleteLineLR(int handSize, int sizeX, int sizePartial,
			String leftBorder, String rightBorder, String join, String middleSection,
			List<String> middleSectionText) {
		StringBuilder sb = new StringBuilder();

		// if null
		if (middleSectionText == null) {
			sb.append(createLeftSideOfLine(sizeX / 2, leftBorder, middleSection, null));

			// hand size - first card - last card
			for (int i = 1; i < handSize - 1; i++) {
				sb.append(createRightSideOfLine(sizePartial, join, middleSection, null));
			}
			// has hand one card?
			if (handSize > 1) {
				sb.append(createRightSideOfLine(sizePartial, rightBorder, middleSection,
						null));
				// append after first left side
				sb.insert(sizeX / 2,
						createRightSideOfLine(sizeX / 2, join, middleSection, null));
			} else {
				sb.append(createRightSideOfLine(sizeX / 2, rightBorder, middleSection,
						null));
			}
			// not null
		} else {
			sb.append(createLeftSideOfLine(sizeX / 2, leftBorder, middleSection,
					middleSectionText.get(0)));
			// hand size - first card - last card
			for (int i = 1; i < handSize - 1; i++) {
				sb.append(createRightSideOfLine(sizePartial, join, middleSection,
						middleSectionText.get(i)));
			}
			// if hand size is one skip
			if (handSize > 1) {
				sb.append(createRightSideOfLine(sizePartial, rightBorder, middleSection,
						middleSectionText.get(handSize - 1)));
				// append fitst right side
				sb.insert(sizeX / 2, createRightSideOfLine(sizeX / 2, join, middleSection,
						middleSectionText.get(0)));
			} else {
				sb.append(createRightSideOfLine(sizeX / 2, rightBorder, middleSection,
						middleSectionText.get(0)));
			}
		}
		return sb.toString();
	}

	public static String createCompleteLineRL(int handSize, int sizeX, int sizePartial,
			String leftBorder, String rightBorder, String join, String middleSection,
			List<String> middleSectionText) {
		StringBuilder sb = new StringBuilder();

		// if null
		if (middleSectionText == null) {
			// append right side
			sb.append(createRightSideOfLine(sizeX / 2, rightBorder, middleSection, null));
			// hand size - first card - last card
			for (int i = 1; i < handSize - 1; i++) {
				sb.insert(0,
						createLeftSideOfLine(sizePartial, join, middleSection, null));
			}
			// has hand one card?
			if (handSize > 1) {
				sb.insert(0, createLeftSideOfLine(sizePartial, leftBorder, middleSection,
						null));
				// append after first left side
				sb.insert(sb.length() - sizeX / 2,
						createLeftSideOfLine(sizeX / 2, join, middleSection, null));
			} else {
				sb.insert(0,
						createLeftSideOfLine(sizeX / 2, leftBorder, middleSection, null));
			}
			// not null
		} else {
			// append right side
			sb.append(createRightSideOfLine(sizeX / 2, rightBorder, middleSection,
					middleSectionText.get(0)));
			// hand size - first card - last card
			for (int i = 1; i < handSize - 1; i++) {
				sb.insert(0, createLeftSideOfLine(sizePartial, join, middleSection,
						middleSectionText.get(i)));
			}
			// has hand one card?
			if (handSize > 1) {
				sb.insert(0, createLeftSideOfLine(sizePartial, leftBorder, middleSection,
						middleSectionText.get(handSize - 1)));
				// append after first left side
				sb.insert(sb.length() - sizeX / 2, createLeftSideOfLine(sizeX / 2, join,
						middleSection, middleSectionText.get(0)));
			} else {
				sb.insert(0, createLeftSideOfLine(sizeX / 2, leftBorder, middleSection,
						middleSectionText.get(0)));
			}
		}
		return sb.toString();
	}

	public static String createRightSideOfLine(int cardLenght, String rightBorder,
			String middleSection, String middleSectionText) {
		StringBuilder sb = new StringBuilder();
		// no text
		if (middleSectionText == "" || middleSectionText == null) {
			for (int i = 0; i < cardLenght - 1; i++) {
				sb.append(middleSection);
			}
			// with text
		} else {
			// is number
			if (middleSectionText.matches("[A-Z]|\\d+")) {
				for (int i = 0; i < cardLenght - 1 - middleSectionText.length(); i++) {
					sb.append(middleSection);
				}
				// check for 10
				sb.append(middleSectionText);
				// is color
			} else {
				for (int i = 0; i < cardLenght - 2 - middleSectionText.length(); i++) {
					sb.append(middleSection);
				}
				sb.append(middleSectionText).append(middleSection);
			}
		}
		sb.append(rightBorder);

		return sb.toString();
	}

	public static String createLeftSideOfLine(int cardLenght, String leftBorder,
			String middleSection, String middleSectionText) {
		StringBuilder sb = new StringBuilder();

		sb.append(leftBorder);
		// no text
		if (middleSectionText == "" || middleSectionText == null) {
			for (int i = 0; i < cardLenght - 1; i++) {
				sb.append(middleSection);
			}
			// with text
		} else {
			// is value
			if (middleSectionText.matches("[A-Z]|\\d+")) {
				// check for 10
				sb.append(middleSectionText);
				for (int i = 0; i < cardLenght - 1 - middleSectionText.length(); i++) {
					sb.append(middleSection);
				}
				// is color
			} else {
				sb.append(middleSection).append(middleSectionText);
				for (int i = 0; i < cardLenght - 2 - middleSectionText.length(); i++) {
					sb.append(middleSection);
				}
			}
		}

		return sb.toString();
	}

	// TODO rework methods below for non changing space between players
	/**
	 * Private methods for adjusting board printout with settings
	 */
	private static String setSpaceBetweenPlayers() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < settings.getSpaceBetweenPlayers(); i++) {
			sb.append(Const.SP);
		}

		return sb.toString();
	}

	private static String drawPlayerNames(Player player, Player computer) {
		int cardSize = player.getCards().size() * 3 + Const.CARD_SIZE_X - 3 - 13 + 7;
		StringBuilder sb = new StringBuilder();
		sb.append(player.getName().toUpperCase() + " CARDS:");
		for (int i = 0; i < cardSize; i++) {
			sb.append(Const.SP);
		}
		sb.append(computer.getName().toUpperCase() + " CARDS:");

		return sb.toString();
	}

}