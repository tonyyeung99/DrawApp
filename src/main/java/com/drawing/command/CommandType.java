package com.drawing.command;

public enum CommandType {
	C("c|C"),
	L("l|L"),
	R("r|R"),
	B("b|B"),
	Q("q|Q");
	
	private String commandString;
	
	CommandType(String commandString){
		this.commandString = commandString;
	}
	
	public String commandString(){
		return commandString;
	}
}
