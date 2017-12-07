package com.drawing.main;

import com.drawing.command.CommandType;


public interface InputValidator {

	public void validate() throws InvalidInputLineException;
	
	public void setProcessingStr(String lines);
	
	public CommandType getCommandType() throws InvalidInputLineException;
	
	public String[] getCommandWords();
	
	public void reset();
	
}
