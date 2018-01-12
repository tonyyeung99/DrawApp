package com.drawing.util;

import com.drawing.command.CommandType;
import com.drawing.main.InvalidInputLineException;

public class ParserUtil {

    public static boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }  
    
	public static CommandType parseToCommandType(String commandWord) throws InvalidInputLineException {
		if(commandWord.matches("[c|C]"))
			return CommandType.C;
		else if(commandWord.matches("[l|L]"))
			return CommandType.L;
		else if(commandWord.matches("[r|R]"))
			return CommandType.R;
		else if(commandWord.matches("[b|B]"))
			return CommandType.B;
		else if(commandWord.matches("[q|Q]"))
			return CommandType.Q;
		throw new InvalidInputLineException("Input Error: ");
	}    
	
	public static void checkNotBlank(String line) throws InvalidInputLineException {
		if (line.length() <= 0)
			throw new InvalidInputLineException("Input Error: Blank Input.");
	}
    
}
