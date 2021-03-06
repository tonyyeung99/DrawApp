package com.drawing.command;

import com.drawing.main.DrawApp;
import com.drawing.main.DrawPrecheckException;
import com.drawing.main.InvalidInputLineException;
import com.drawing.visual.DrawEngine;

public class VanillaCommandParser implements CommandParser {
	private CommandValidator validator;
	private DrawEngine engine;
	private DrawApp app;
	
	public VanillaCommandParser(CommandValidator validator, DrawEngine engine, DrawApp app) {
		super();
		this.validator = validator;
		this.engine = engine;
		this.app = app;
	}

	@Override
	public void validateDrawLogic(Command command) throws DrawPrecheckException {
		validator.validate(command);
	}	
	
	@Override
	public Command Parse(String[] splitedInputLine)  throws DrawPrecheckException, InvalidInputLineException {
		Command command = buildCommand(splitedInputLine );		
		return command;
	}
	
	public Command buildCommand(String[] splitedInputLine)  throws DrawPrecheckException, InvalidInputLineException {
		CommandType type = parseCommand(splitedInputLine);
		Command parsedCmd=null;
		switch(type){
			case C:
				parsedCmd=handleCreateCanvasCommand(splitedInputLine);
				break;
			case L:
				parsedCmd=handleDrawLineCommand(splitedInputLine);
				break;
			case R:
				parsedCmd=handleDrawRectangleCommand(splitedInputLine);
				break;
			case B:
				parsedCmd=handleBucketFillCommand(splitedInputLine);
				break;
			case Q:
				parsedCmd=handleQuitCommand();
				break;				
			default: 
				break;
		}		
		return parsedCmd;
	}

	private Command handleCreateCanvasCommand(String[] splitedInputLine){
		Command parsedCmd;
		int width = Integer.parseInt(splitedInputLine[1]);
		int height = Integer.parseInt(splitedInputLine[2]);
		parsedCmd = new CreateCanvasCommand(this.engine, width, height);
		return parsedCmd;		
	}
	
	private Command handleDrawLineCommand(String[] splitedInputLine){
		Command parsedCmd;
		int x1 = Integer.parseInt(splitedInputLine[1]);
		int y1 = Integer.parseInt(splitedInputLine[2]);
		int x2 = Integer.parseInt(splitedInputLine[3]);
		int y2 = Integer.parseInt(splitedInputLine[4]);		
		parsedCmd = new DrawLineCommand(this.engine, x1, y1, x2, y2);
		return parsedCmd;
	}
	
	private Command handleDrawRectangleCommand(String[] splitedInputLine){
		Command parsedCmd;
		int x1 = Integer.parseInt(splitedInputLine[1]);
		int y1 = Integer.parseInt(splitedInputLine[2]);
		int x2 = Integer.parseInt(splitedInputLine[3]);
		int y2 = Integer.parseInt(splitedInputLine[4]);	
		parsedCmd = new DrawRectCommand(this.engine, x1, y1, x2, y2);
		return parsedCmd;		
	}
	
	private Command handleBucketFillCommand(String[] splitedInputLine){
		Command parsedCmd;
		int x = Integer.parseInt(splitedInputLine[1]);
		int y = Integer.parseInt(splitedInputLine[2]);
		char c = splitedInputLine[3].charAt(0);
		parsedCmd = new BucketFillCommand(this.engine, x, y, c);
		return parsedCmd;		
	}
	
	private Command handleQuitCommand(){
		return new QuitCommand(app);		
	}	
	
	private CommandType parseCommand(String[] commandWords) throws InvalidInputLineException {
		if(commandWords[0].matches("[c|C]"))
			return CommandType.C;
		else if(commandWords[0].matches("[l|L]"))
			return CommandType.L;
		else if(commandWords[0].matches("[r|R]"))
			return CommandType.R;
		else if(commandWords[0].matches("[b|B]"))
			return CommandType.B;
		else if(commandWords[0].matches("[q|Q]"))
			return CommandType.Q;
		throw new InvalidInputLineException("Input Error: ");
	}	
}
