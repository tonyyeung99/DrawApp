package com.drawing.main;

import com.drawing.command.CommandType;
import com.drawing.util.ParserUtil;

public class VanillaInputValidator implements InputValidator{

	@Override
	public void validate(String[] commandWords) throws InvalidInputLineException {
    	checkIsValidCommand(commandWords);
    	CommandType type = ParserUtil.parseToCommandType(commandWords[0]);
    	SyntaxChecker checker = SyntaxCheckerFactory.createVanillaSyntaxChecker(type);
    	checker.validate(commandWords);   
	}

	private void checkIsValidCommand(String[] commandWords) throws InvalidInputLineException {
		if(!commandWords[0].matches("[c|C|l|L|r|R|b|B|q|Q]"))
			throw new InvalidInputLineException("Input Error: Cannot recognize Input Command.");
	}
}
