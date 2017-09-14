package handler.print.playernew;

import java.util.List;

public class CompleteLineLR implements CompleteLine{

	@Override
	public String createLeftPartialLine(int cardLenght, String leftBorder, String middleSection,
			String middleSectionText) {
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

	@Override
	public String createRightPartialLine(int cardLenght, String rightBorder, String middleSection,
			String middleSectionText) {
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

	@Override
	public String createCompleteLine(int handSize, int sizeX, int sizePartial, String leftBorder, String rightBorder,
			String join, String middleSection, List<String> middleSectionText) {
		StringBuilder sb = new StringBuilder();

		// if null
		if (middleSectionText == null) {
			sb.append(createLeftPartialLine(sizeX / 2, leftBorder, middleSection, null));

			// hand size - first card - last card
			for (int i = 1; i < handSize - 1; i++) {
				sb.append(createRightPartialLine(sizePartial, join, middleSection, null));
			}
			// has hand one card?
			if (handSize > 1) {
				sb.append(createRightPartialLine(sizePartial, rightBorder, middleSection,
						null));
				// append after first left side
				sb.insert(sizeX / 2,
						createRightPartialLine(sizeX / 2, join, middleSection, null));
			} else {
				sb.append(createRightPartialLine(sizeX / 2, rightBorder, middleSection,
						null));
			}
			// not null
		} else {
			sb.append(createLeftPartialLine(sizeX / 2, leftBorder, middleSection,
					middleSectionText.get(handSize - 1)));
			sb.insert(sizeX / 2, createRightPartialLine(sizeX / 2, join, middleSection,
					middleSectionText.get(handSize - 1)));
			// hand size - first card - last card
			for (int i = handSize - 2; i >= 0; i--) {
				sb.append(createRightPartialLine(sizePartial, join, middleSection,
						middleSectionText.get(i)));
			}
		}
		return sb.toString();
	}
}
