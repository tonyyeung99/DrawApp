package com.drawing.main;

import com.drawing.util.ParserUtil;

public interface SyntaxChecker {
	
	public void validate(String[] commandWords) throws InvalidInputLineException ;

}
