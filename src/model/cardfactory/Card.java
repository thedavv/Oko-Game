package model.cardfactory;

import model.cardproperty.Color;
import model.cardproperty.Value;

public interface Card {
	//public void draw(CardHandler ch);
	//public void setColor(Color color);
	//public void setValue(Value value);
	public Value getValue();
	public Color getColor();
	
}
