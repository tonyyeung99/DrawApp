package com.drawing.main;

import java.util.List;

import com.drawing.command.Command;

public interface Invoker {	
	
	public void storeAndExecute(Command command);
	
	public List<Command> exportCommand();	
	
}
