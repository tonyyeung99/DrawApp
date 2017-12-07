package com.drawing.command;

import com.drawing.main.DrawPrecheckException;

public interface CommandParser {	
	
	public void validate(Command command) throws DrawPrecheckException;
	
	public Command Parse(String[] splitedInputLine, CommandType type) throws DrawPrecheckException;	
	
}
