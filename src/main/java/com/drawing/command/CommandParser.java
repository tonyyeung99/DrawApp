package com.drawing.command;

import com.drawing.main.DrawPrecheckException;
import com.drawing.main.InvalidInputLineException;

public interface CommandParser {	
	
	public void validateDrawLogic(Command command) throws DrawPrecheckException;
	
	public Command Parse(String[] splitedInputLine) throws DrawPrecheckException, InvalidInputLineException;	
	
}
