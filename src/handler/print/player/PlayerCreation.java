package handler.print.player;

import java.util.ArrayList;
import java.util.List;

import model.Player;
import model.cardfactory.Card;
import util.Const;
import util.Settings;

/**
 * Class extends LineCreation that is used to create menu lines for game board
 * printout Class has methods for game board drawing and methods for printing
 * out names of players
 */
public class PlayerCreation extends LineCreation {
	private static Settings settings = Settings.getInstance();

	/**
	 * Creates String representation of both players same style cards from Left
	 * to Right
	 * 
	 * @param player
	 *            is the human Player
	 * @param computer
	 *            is the computer Player
	 * @return string representation of both players
	 */
	public String createBothPlayersStringRepresentationSameStyleLR(Player player, Player computer) {
		StringBuilder sb = new StringBuilder();
		List<String> playerValueStrings = new ArrayList<>();
		List<String> playerColorStrings = new ArrayList<>();
		List<String> computerValueStrings = new ArrayList<>();
		List<String> computerColorStrings = new ArrayList<>();
		int playerHandSize = player.getCards().size();
		int computerHandSize = computer.getCards().size();
		String computerName = computer.getName();
		String playerName = player.getName();

		for (Card c : player.getCards()) {
			playerColorStrings.add(String.valueOf(c.getColor().getColor()));
			playerValueStrings.add(String.valueOf(c.getValue().getLabel()));
		}
		for (Card c : computer.getCards()) {
			computerColorStrings.add(String.valueOf(c.getColor().getColor()));
			computerValueStrings.add(String.valueOf(c.getValue().getLabel()));
		}
		// append top line
		sb.append(drawPlayerName(playerName, computerName, playerHandSize));
		sb.append("\n");
		sb.append(createCompleteLineLR(playerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.TLC), String.valueOf(Const.TRC), String.valueOf(Const.TJ),
				String.valueOf(Const.HL), null));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineLR(computerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.TLC), String.valueOf(Const.TRC), String.valueOf(Const.TJ),
				String.valueOf(Const.HL), null));
		sb.append("\n");
		// append number Line
		sb.append(createCompleteLineLR(playerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				playerValueStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineLR(computerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				computerValueStrings));
		sb.append("\n");
		// append color line
		sb.append(createCompleteLineLR(playerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				playerColorStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineLR(computerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				computerColorStrings));
		sb.append("\n");
		// append middle line
		for (int i = 0; i < settings.getCardSizeY() - 6; i++) {
			sb.append(createCompleteLineLR(playerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
					String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL),
					String.valueOf(Const.SP), null));
			sb.append(setSpaceBetweenPlayers());
			sb.append(createCompleteLineLR(computerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
					String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL),
					String.valueOf(Const.SP), null));
			sb.append("\n");
		}
		// append color line
		sb.append(createCompleteLineLR(playerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				playerColorStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineLR(computerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				computerColorStrings));
		sb.append("\n");
		// append number Line
		sb.append(createCompleteLineLR(playerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				playerValueStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineLR(computerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				computerValueStrings));
		sb.append("\n");
		// append Bot Line
		sb.append(createCompleteLineLR(playerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.BLC), String.valueOf(Const.BRC), String.valueOf(Const.BJ),
				String.valueOf(Const.HL), null));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineLR(computerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.BLC), String.valueOf(Const.BRC), String.valueOf(Const.BJ),
				String.valueOf(Const.HL), null));
		sb.append("\n");

		return sb.toString();
	}

	/**
	 * Creates String representation of both players same style cards from right
	 * to left
	 * 
	 * @param player
	 *            is the human Player
	 * @param computer
	 *            is the computer Player
	 * @return string representation of both players
	 */
	public String createBothPlayersStringRepresentationSameStyleRL(Player player, Player computer) {
		StringBuilder sb = new StringBuilder();
		List<String> playerValueStrings = new ArrayList<>();
		List<String> playerColorStrings = new ArrayList<>();
		List<String> computerValueStrings = new ArrayList<>();
		List<String> computerColorStrings = new ArrayList<>();
		int playerHandSize = player.getCards().size();
		int computerHandSize = computer.getCards().size();
		String computerName = computer.getName();
		String playerName = player.getName();

		for (Card c : player.getCards()) {
			playerColorStrings.add(String.valueOf(c.getColor().getColor()));
			playerValueStrings.add(String.valueOf(c.getValue().getLabel()));
		}
		for (Card c : computer.getCards()) {
			computerColorStrings.add(String.valueOf(c.getColor().getColor()));
			computerValueStrings.add(String.valueOf(c.getValue().getLabel()));
		}

		// append top line
		sb.append(drawPlayerName(playerName, computerName, playerHandSize));
		sb.append("\n");
		sb.append(createCompleteLineRL(playerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.TLC), String.valueOf(Const.TRC), String.valueOf(Const.TJ),
				String.valueOf(Const.HL), null));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineRL(computerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.TLC), String.valueOf(Const.TRC), String.valueOf(Const.TJ),
				String.valueOf(Const.HL), null));
		sb.append("\n");
		// append number Line
		sb.append(createCompleteLineRL(playerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				playerValueStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineRL(computerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				computerValueStrings));
		sb.append("\n");
		// append color line
		sb.append(createCompleteLineRL(playerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				playerColorStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineRL(computerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				computerColorStrings));
		sb.append("\n");
		// append middle line
		for (int i = 0; i < settings.getCardSizeY() - 6; i++) {
			sb.append(createCompleteLineRL(playerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
					String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL),
					String.valueOf(Const.SP), null));
			sb.append(setSpaceBetweenPlayers());
			sb.append(createCompleteLineRL(computerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
					String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL),
					String.valueOf(Const.SP), null));
			sb.append("\n");
		}
		// append color line
		sb.append(createCompleteLineRL(playerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				playerColorStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineRL(computerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				computerColorStrings));
		sb.append("\n");
		// append number Line
		sb.append(createCompleteLineRL(playerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				playerValueStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineRL(computerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				computerValueStrings));
		sb.append("\n");
		// append Bot Line
		sb.append(createCompleteLineRL(playerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.BLC), String.valueOf(Const.BRC), String.valueOf(Const.BJ),
				String.valueOf(Const.HL), null));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineRL(computerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.BLC), String.valueOf(Const.BRC), String.valueOf(Const.BJ),
				String.valueOf(Const.HL), null));
		sb.append("\n");

		return sb.toString();
	}

	/**
	 * Creates String representation of both players mirror style
	 * 
	 * @param player
	 *            is the human Player
	 * @param computer
	 *            is the computer Player
	 * @return string representation of both players
	 */
	public String createBothPlayersStringRepresentationStyleMirror(Player player, Player computer) {
		StringBuilder sb = new StringBuilder();
		List<String> playerValueStrings = new ArrayList<>();
		List<String> playerColorStrings = new ArrayList<>();
		List<String> computerValueStrings = new ArrayList<>();
		List<String> computerColorStrings = new ArrayList<>();
		int playerHandSize = player.getCards().size();
		int computerHandSize = computer.getCards().size();
		String computerName = computer.getName();
		String playerName = player.getName();

		for (Card c : player.getCards()) {
			playerColorStrings.add(String.valueOf(c.getColor().getColor()));
			playerValueStrings.add(String.valueOf(c.getValue().getLabel()));
		}
		for (Card c : computer.getCards()) {
			computerColorStrings.add(String.valueOf(c.getColor().getColor()));
			computerValueStrings.add(String.valueOf(c.getValue().getLabel()));
		}

		// append top line
		sb.append(drawPlayerName(playerName, computerName, playerHandSize));
		sb.append("\n");
		sb.append(createCompleteLineRL(playerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.TLC), String.valueOf(Const.TRC), String.valueOf(Const.TJ),
				String.valueOf(Const.HL), null));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineLR(computerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.TLC), String.valueOf(Const.TRC), String.valueOf(Const.TJ),
				String.valueOf(Const.HL), null));
		sb.append("\n");
		// append number Line
		sb.append(createCompleteLineRL(playerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				playerValueStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineLR(computerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				computerValueStrings));
		sb.append("\n");
		// append color line
		sb.append(createCompleteLineRL(playerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				playerColorStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineLR(computerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				computerColorStrings));
		sb.append("\n");
		// append middle line
		for (int i = 0; i < settings.getCardSizeY() - 6; i++) {
			sb.append(createCompleteLineRL(playerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
					String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL),
					String.valueOf(Const.SP), null));
			sb.append(setSpaceBetweenPlayers());
			sb.append(createCompleteLineLR(computerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
					String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL),
					String.valueOf(Const.SP), null));
			sb.append("\n");
		}
		// append color line
		sb.append(createCompleteLineRL(playerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				playerColorStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineLR(computerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				computerColorStrings));
		sb.append("\n");
		// append number Line
		sb.append(createCompleteLineRL(playerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				playerValueStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineLR(computerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				computerValueStrings));
		sb.append("\n");
		// append Bot Line
		sb.append(createCompleteLineRL(playerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.BLC), String.valueOf(Const.BRC), String.valueOf(Const.BJ),
				String.valueOf(Const.HL), null));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineLR(computerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.BLC), String.valueOf(Const.BRC), String.valueOf(Const.BJ),
				String.valueOf(Const.HL), null));
		sb.append("\n");

		return sb.toString();
	}

	/**
	 * Creates String representation of both players reverse mirror style
	 * 
	 * @param player
	 *            is the human Player
	 * @param computer
	 *            is the computer Player
	 * @return string representation of both players
	 */
	public String createBothPlayersStringRepresentationStyleReverseMirror(Player player, Player computer) {
		StringBuilder sb = new StringBuilder();
		List<String> playerValueStrings = new ArrayList<>();
		List<String> playerColorStrings = new ArrayList<>();
		List<String> computerValueStrings = new ArrayList<>();
		List<String> computerColorStrings = new ArrayList<>();
		int playerHandSize = player.getCards().size();
		int computerHandSize = computer.getCards().size();
		String computerName = computer.getName();
		String playerName = player.getName();

		for (Card c : player.getCards()) {
			playerColorStrings.add(String.valueOf(c.getColor().getColor()));
			playerValueStrings.add(String.valueOf(c.getValue().getLabel()));
		}
		for (Card c : computer.getCards()) {
			computerColorStrings.add(String.valueOf(c.getColor().getColor()));
			computerValueStrings.add(String.valueOf(c.getValue().getLabel()));
		}

		// append top line
		sb.append(drawPlayerName(playerName, computerName, playerHandSize));
		sb.append("\n");
		sb.append(createCompleteLineLR(playerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.TLC), String.valueOf(Const.TRC), String.valueOf(Const.TJ),
				String.valueOf(Const.HL), null));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineRL(computerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.TLC), String.valueOf(Const.TRC), String.valueOf(Const.TJ),
				String.valueOf(Const.HL), null));
		sb.append("\n");
		// append number Line
		sb.append(createCompleteLineLR(playerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				playerValueStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineRL(computerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				computerValueStrings));
		sb.append("\n");
		// append color line
		sb.append(createCompleteLineLR(playerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				playerColorStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineRL(computerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				computerColorStrings));
		sb.append("\n");
		// append middle line
		for (int i = 0; i < settings.getCardSizeY() - 6; i++) {
			sb.append(createCompleteLineLR(playerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
					String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL),
					String.valueOf(Const.SP), null));
			sb.append(setSpaceBetweenPlayers());
			sb.append(createCompleteLineRL(computerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
					String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL),
					String.valueOf(Const.SP), null));
			sb.append("\n");
		}
		// append color line
		sb.append(createCompleteLineLR(playerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				playerColorStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineRL(computerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				computerColorStrings));
		sb.append("\n");
		// append number Line
		sb.append(createCompleteLineLR(playerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				playerValueStrings));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineRL(computerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				computerValueStrings));
		sb.append("\n");
		// append Bot Line
		sb.append(createCompleteLineLR(playerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.BLC), String.valueOf(Const.BRC), String.valueOf(Const.BJ),
				String.valueOf(Const.HL), null));
		sb.append(setSpaceBetweenPlayers());
		sb.append(createCompleteLineRL(computerHandSize, settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.BLC), String.valueOf(Const.BRC), String.valueOf(Const.BJ),
				String.valueOf(Const.HL), null));
		sb.append("\n");

		return sb.toString();
	}

	/**
	 * Creates String representation of single player LR style
	 * 
	 * @param playerHand
	 *            are the cards in players hand
	 * @param playerName
	 *            is the name of the player
	 * @return String representation of player
	 */
	public String createStringRepresentationOfPlayersHand(List<Card> playerHand, String playerName) {
		StringBuilder sb = new StringBuilder();
		List<String> valueStrings = new ArrayList<>();
		List<String> colorStrings = new ArrayList<>();

		for (Card c : playerHand) {
			colorStrings.add(String.valueOf(c.getColor().getColor()));
			valueStrings.add(String.valueOf(c.getValue().getLabel()));
		}
		// append top line
		sb.append(drawPlayerName(playerName));
		sb.append("\n");
		sb.append(createCompleteLineLR(playerHand.size(), settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.TLC), String.valueOf(Const.TRC), String.valueOf(Const.TJ),
				String.valueOf(Const.HL), null));
		sb.append("\n");
		// append number Line
		sb.append(createCompleteLineLR(playerHand.size(), settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				valueStrings));
		sb.append("\n");
		// append color line
		sb.append(createCompleteLineLR(playerHand.size(), settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				colorStrings));
		sb.append("\n");
		// append middle line
		for (int i = 0; i < settings.getCardSizeY() - 6; i++) {
			sb.append(createCompleteLineLR(playerHand.size(), settings.getCardSizeX(), settings.getCardPartialSizeX(),
					String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL),
					String.valueOf(Const.SP), null));
			sb.append("\n");
		}
		// append color line
		sb.append(createCompleteLineLR(playerHand.size(), settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				colorStrings));
		sb.append("\n");
		// append number Line
		sb.append(createCompleteLineLR(playerHand.size(), settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				valueStrings));
		sb.append("\n");
		// append Bot Line
		sb.append(createCompleteLineLR(playerHand.size(), settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.BLC), String.valueOf(Const.BRC), String.valueOf(Const.BJ),
				String.valueOf(Const.HL), null));
		sb.append("\n");

		return sb.toString();
	}

	/**
	 * Creates String representation of single player RL style
	 * 
	 * @param playerHand
	 *            are the cards in players hand
	 * @param playerName
	 *            is the name of the player
	 * @return String representation of player
	 */
	public String createStringRepresentationOfOfPlayersHandSecondStyle(List<Card> playerHand, String playerName) {
		StringBuilder sb = new StringBuilder();
		List<String> valueStrings = new ArrayList<>();
		List<String> colorStrings = new ArrayList<>();

		for (Card c : playerHand) {
			colorStrings.add(String.valueOf(c.getColor().getColor()));
			valueStrings.add(String.valueOf(c.getValue().getLabel()));
		}
		// append top line
		sb.append(drawPlayerName(playerName));
		sb.append("\n");
		sb.append(createCompleteLineRL(playerHand.size(), settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.TLC), String.valueOf(Const.TRC), String.valueOf(Const.TJ),
				String.valueOf(Const.HL), null));
		sb.append("\n");
		// append number Line
		sb.append(createCompleteLineRL(playerHand.size(), settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				valueStrings));
		sb.append("\n");
		// append color line
		sb.append(createCompleteLineRL(playerHand.size(), settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				colorStrings));
		sb.append("\n");
		// append middle line
		for (int i = 0; i < settings.getCardSizeY() - 6; i++) {
			sb.append(createCompleteLineRL(playerHand.size(), settings.getCardSizeX(), settings.getCardPartialSizeX(),
					String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL),
					String.valueOf(Const.SP), null));
			sb.append("\n");
		}
		// append color line
		sb.append(createCompleteLineRL(playerHand.size(), settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				colorStrings));
		sb.append("\n");
		// append number Line
		sb.append(createCompleteLineRL(playerHand.size(), settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.VL), String.valueOf(Const.SP),
				valueStrings));
		sb.append("\n");
		// append Bot Line
		sb.append(createCompleteLineRL(playerHand.size(), settings.getCardSizeX(), settings.getCardPartialSizeX(),
				String.valueOf(Const.BLC), String.valueOf(Const.BRC), String.valueOf(Const.BJ),
				String.valueOf(Const.HL), null));
		sb.append("\n");

		return sb.toString();
	}

	/**
	 * Method creates a space between players
	 * 
	 * @return String of empty spaces between players
	 */
	public String setSpaceBetweenPlayers() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < settings.getSpaceBetweenPlayers(); i++) {
			sb.append(Const.SP);
		}

		return sb.toString();
	}

	/**
	 * Returns the string representation of player
	 * 
	 * @param playerName is the name of the player
	 * @return
	 */
	public String drawPlayerName(String playerName) {
		return playerName;
	}

	// TODO remove magic cosntants
	/**
	 * Creates name of players and puts space between them
	 * 
	 * @param playerName is the name of the human Player
	 * @param computerName is the name of the computer Player
	 * @param handSize is the hand size
	 * @return String representation of player names
	 */
	public String drawPlayerName(String playerName, String computerName, int handSize) {
		int cardSize = handSize * 3 + settings.getCardSizeX() - 3 - 13 + 7;
		StringBuilder sb = new StringBuilder();
		sb.append(playerName.toUpperCase() + " CARDS:");
		for (int i = 0; i < cardSize; i++) {
			sb.append(Const.SP);
		}
		sb.append(computerName.toUpperCase() + " CARDS:");

		return sb.toString();
	}
}
