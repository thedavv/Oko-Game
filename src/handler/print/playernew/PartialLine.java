package handler.print.playernew;

public interface PartialLine {
	public String createLeftPartialLine(int cardLenght, String leftBorder,
			String middleSection, String middleSectionText);
	public String createRightPartialLine(int cardLenght, String rightBorder,
			String middleSection, String middleSectionText);
}
