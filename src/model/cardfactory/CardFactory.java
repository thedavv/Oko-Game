package model.cardfactory;

import model.cardproperty.Color;
import model.cardproperty.Value;

public class CardFactory {
	public Card getCard(Color color, Value value){
		return new PlayerCard(color, value);	
	};
}
