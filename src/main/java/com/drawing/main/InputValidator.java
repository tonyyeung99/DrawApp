package com.drawing.main;

import com.drawing.command.CommandType;


public interface InputValidator {

	public void validate(String[] commandWords) throws InvalidInputLineException;

}
