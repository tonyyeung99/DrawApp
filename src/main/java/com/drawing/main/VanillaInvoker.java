package com.drawing.main;

import java.util.ArrayList;
import java.util.List;

import com.drawing.command.Command;

public class VanillaInvoker implements Invoker {

	private List<Command> logger;
	
	public VanillaInvoker() {
		super();
		this.logger = new ArrayList<Command>();
	}
	
	@Override
	public void storeAndExecute(Command command) {
		logger.add(command);
		command.execute();
	}

	@Override
	public List<Command> exportCommand() {		
		return logger;
	}	
}
