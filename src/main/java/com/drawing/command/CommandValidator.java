package com.drawing.command;

import com.drawing.main.DrawPrecheckException;

public interface CommandValidator {
	
	public void validate(Command command) throws DrawPrecheckException;	
	
}
