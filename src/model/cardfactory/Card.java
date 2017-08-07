package model.cardfactory;

import model.card.Color;
import model.card.Value;

public interface Card {
	//public void draw(CardHandler ch);
	//public void setColor(Color color);
	//public void setValue(Value value);
	public Value getValue();
	public Color getColor();
	
}
