package com.drawing.main;

public class TypeQVanillaSyntaxChecker implements SyntaxChecker{
	@Override
	public void validate(String[] commandWords) throws InvalidInputLineException {
		//super.validate(commandWords);
    		if(commandWords.length!=1)
    			throw new InvalidInputLineException("Error : Command \"Q\" do not take any parameters.");
	}
	
}
