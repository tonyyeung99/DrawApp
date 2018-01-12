package com.drawing.command;

import com.drawing.main.DrawApp;

public class QuitCommand implements Command{


	private DrawApp app; 
	
	public QuitCommand(DrawApp app) {
		super();
		this.app = app;
	}

	@Override
	public void execute() {
		app.gracefulExit();
	}

}
