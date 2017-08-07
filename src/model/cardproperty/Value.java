package model.cardproperty;

import util.Const;

public enum Value {
	SEVEN(Const.SEVEN), EIGHT(Const.EIGHT), NINE(Const.NINE), TEN(Const.TEN), JACK(Const.JACK), QUEEN(Const.QUEEN), KING(Const.KING), ACE(Const.ACE);

	private final String label;

	Value(String label){
		this.label = label;
	}

	public String getLabel(){
		return this.label;
	}

}
