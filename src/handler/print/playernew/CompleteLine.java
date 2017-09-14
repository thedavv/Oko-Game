package handler.print.playernew;

import java.util.List;

public interface CompleteLine extends PartialLine{
		
	String createCompleteLine(int handSize, int sizeX, int sizePartial,
			String leftBorder, String rightBorder, String join, String middleSection,
			List<String> middleSectionText);
}
