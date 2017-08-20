package handler.print.player;

import java.util.ArrayList;
import java.util.List;

import model.Player;
import model.cardfactory.Card;
import util.Const;
import util.Settings;

public class PlayerCreation extends LineCreation {
	private static Settings settings = Settings.getInstance();

	/**
	 * private methods for printing out players
	 */
	public String createBothPlayersStringRepresentationSameStyleLR(Player player,
			Player computer) {
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

		return sb.toString();
	}

	public String createBothPlayersStringRepresentationSameStyleRL(Player player,
			Player computer) {
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

		return sb.toString();
	}

	public String createBothPlayersStringRepresentationStyleMirror(Player player,
			Player computer) {
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

		return sb.toString();
	}

	public String createBothPlayersStringRepresentationStyleReverseMirror(Player player,
			Player computer) {
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

		return sb.toString();
	}

	public String createStringRepresentationOfPlayersHand(List<Card> playerHand,
			String playerName) {
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

	public String createStringRepresentationOfOfPlayersHandSecondStyle(
			List<Card> playerHand, String playerName) {
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

	/**
	 *
	 * /** Private methods for adjusting board printout with settings
	 */
	public String setSpaceBetweenPlayers() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < settings.getSpaceBetweenPlayers(); i++) {
			sb.append(Const.SP);
		}

		return sb.toString();
	}

	public String drawPlayerName(String playerName) {
		return playerName;
	}

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
