package com.drawing.main;

import com.drawing.command.CommandType;
import com.drawing.util.ParserUtil;

public class VanillaInputValidator implements InputValidator{

	private String processingStr;
	
	@Override
	public void validate() throws InvalidInputLineException {
		String trimString = processingStr.trim();
		checkNotBlank(trimString);		
    	String[] commandWords = trimString.split("[ ]+");
    	checkIsValidCommand(commandWords);
    	CommandType type = parseCommand(commandWords);
		switch(type){
		case C:
			handleCheckCTypeParas(commandWords);
			break;
		case L:
			handleCheckLTypeParas(commandWords);
			break;
		case R:
			handleCheckRTypeParas(commandWords);
			break;
		case B:
			handleCheckBTypeParas(commandWords);
			break;
		case Q:
			handleCheckQTypeParas(commandWords);
			break;
		default: 
			break;
		}
	}
	
	private void checkNotBlank(String line) throws InvalidInputLineException {
		if(line.length()<=0)
			throw new InvalidInputLineException("Input Error: Blank Input.");
	}

	private void checkIsValidCommand(String[] commandWords) throws InvalidInputLineException {
		if(!commandWords[0].matches("[c|C|l|L|r|R|b|B|q|Q]"))
			throw new InvalidInputLineException("Input Error: Cannot recognize Input Command.");
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
	
	private void handleCheckCTypeParas(String[] commandWords) throws InvalidInputLineException {
		if(commandWords.length!=3)
			throw new InvalidInputLineException("Input Error: Command \"C\" takes 2 parameter for the input.");
		if(!ParserUtil.isInteger(commandWords[1]) || !ParserUtil.isInteger(commandWords[2]))
			throw new InvalidInputLineException("Input Error: Command \"C\" takes 2 parameters, and they have to be intger.");
		int width = Integer.parseInt(commandWords[1]);
		int height = Integer.parseInt(commandWords[2]);
		if(width<=0 || height<=0)
			throw new InvalidInputLineException("Input Error: Command \"C\" takes 2 parameters, and they have to be greater than 0");
	}
	
	private void handleCheckLTypeParas(String[] commandWords) throws InvalidInputLineException {
		if(commandWords.length!=5)
			throw new InvalidInputLineException("Input Error: Command \"L\" takes 4 parameter for the input.");		
		int x1, x2, y1, y2;
	    try{
    		x1 = Integer.parseInt(commandWords[1]);
    	    y1 = Integer.parseInt(commandWords[2]);
    	    x2 = Integer.parseInt(commandWords[3]);
    	    y2 = Integer.parseInt(commandWords[4]);
	    }catch(NumberFormatException e){
	    	throw new InvalidInputLineException("Input Error: Command \"L\" takes 4 parameters, and they all have to be intger.");
	    }
	    
		if(x1<=0||x2<=0||y1<=0||y2<=0)
			throw new InvalidInputLineException("Input Error: Command \"L\" takes 4 parameters, and they have to be greater than 0");
		
		if(!(x1<=x2) || !(y1<=y2))
			throw new InvalidInputLineException("Input Error: Command \"L\" takes 2 points(represented by 4 parametes), and the 2nd point could not be left or upper of the 1st point.");
		
	    if((x1!=x2) && (y1!=y2)){
	    	throw new InvalidInputLineException("Input Error: Command \"L\" only support Horizontal and Vertical line now.");
	    }	    
	
	}
	
	private void handleCheckRTypeParas(String[] commandWords) throws InvalidInputLineException {
		if(commandWords.length!=5)
			throw new InvalidInputLineException("Input Error: Command \"R\" takes 4 parameter for the input.");		
		int x1, x2, y1, y2;
	    try{
    		x1 = Integer.parseInt(commandWords[1]);
    	    y1 = Integer.parseInt(commandWords[2]);
    	    x2 = Integer.parseInt(commandWords[3]);
    	    y2 = Integer.parseInt(commandWords[4]);
	    }catch(NumberFormatException e){
	    	throw new InvalidInputLineException("Input Error: Command \"R\" takes 4 parameters, and they all have to be intger.");
	    }
	    
		if(x1<=0||x2<=0||y1<=0||y2<=0)
			throw new InvalidInputLineException("Input Error: Command \"R\" takes 4 parameters, and they have to be greater than 0");
		
		if(!(x1<=x2) || !(y1<=y2))
			throw new InvalidInputLineException("Input Error: Command \"R\" takes 2 points(represented by 4 parametes), 1st point should be the top left and 2nd point shoud be the bottom right.");
	    	  		
	}
	
	private void handleCheckBTypeParas(String[] commandWords) throws InvalidInputLineException {
		if(commandWords.length!=4)
			throw new InvalidInputLineException("Input Error: Command \"B\" takes 3 parameter for the input.");
		
		int x, y;
	    try{
    		x = Integer.parseInt(commandWords[1]);
    	    y = Integer.parseInt(commandWords[2]);
	    }catch(NumberFormatException e){
	    	throw new InvalidInputLineException("Input Error: Command \"B\" takes 3 parameters, and the first 2 parameters have to be intger.");
	    }
	    
	    if(x<=0||y<=0){
	    	throw new InvalidInputLineException("Input Error: Command \"B\" takes 3 parameters, and the first 2 parameters have to be intger greater than 0.");
	    }
	    
	    if(commandWords[3].trim().length()!=1)
	    	throw new InvalidInputLineException("Input Error: Command \"B\" takes 3 parameters, and the third parameters have to a character.");
	    
	    char c = commandWords[3].trim().charAt(0);
	    if(c==';')
			throw new InvalidInputLineException("Input Error: Command \"B\" takes 3 parameters, and the third parameters cannot be the special charcter= [;].");
	}
	
	private void handleCheckQTypeParas(String[] commandWords) throws InvalidInputLineException {
		
    	if(commandWords[0].matches("[q|Q]")){
    		if(commandWords.length!=1)
    			throw new InvalidInputLineException("Error : Command \"Q\" do not take any parameters.");
    	}    	
	}

	@Override
	public void setProcessingStr(String lines) {
		processingStr = lines;		
	}
	
	@Override
	public CommandType getCommandType() throws InvalidInputLineException {
		String trimString = processingStr.trim();
    	String[] commandWords = trimString.split("[ ]+");    	
    	return parseCommand(commandWords);
	}	

	
	
	@Override
	public String[] getCommandWords() {
		String trimString = processingStr.trim();	
    	String[] commandWords = trimString.split("[ ]+");
		return commandWords;
	}

	@Override
	public void reset() {
		processingStr="";		
	}
	

}
