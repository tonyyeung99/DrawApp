package com.drawing.main;

import com.drawing.util.ParserUtil;

public class InputlineTokenizer {

	public String[] process(String line) throws InvalidInputLineException {
		String trimString = line.trim();
		ParserUtil.checkNotBlank(trimString);
		return trimString.split("[ ]+");
	}
	
}
