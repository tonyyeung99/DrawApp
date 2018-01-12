package com.drawing.main;

import com.drawing.util.ParserUtil;

public class TypeCVanillaSyntaxChecker implements SyntaxChecker{

	@Override
	public void validate(String[] commandWords) throws InvalidInputLineException {
		if(commandWords.length!=3)
			throw new InvalidInputLineException("Input Error: Command \"C\" takes 2 parameter for the input.");
		if(!ParserUtil.isInteger(commandWords[1]) || !ParserUtil.isInteger(commandWords[2]))
			throw new InvalidInputLineException("Input Error: Command \"C\" takes 2 parameters, and they have to be intger.");
		int width = Integer.parseInt(commandWords[1]);
		int height = Integer.parseInt(commandWords[2]);
		if(width<=0 || height<=0)
			throw new InvalidInputLineException("Input Error: Command \"C\" takes 2 parameters, and they have to be greater than 0");
	}

}
