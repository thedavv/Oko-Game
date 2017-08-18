package handler.printhandler.card;

import java.util.List;

public class LinePrintout {
	/**
	 * private methods for creating card lines
	 */
	public String createCompleteLineLR(int handSize, int sizeX, int sizePartial,
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

	public String createCompleteLineRL(int handSize, int sizeX, int sizePartial,
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

	public String createRightSideOfLine(int cardLenght, String rightBorder,
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

	public String createLeftSideOfLine(int cardLenght, String leftBorder,
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
}
