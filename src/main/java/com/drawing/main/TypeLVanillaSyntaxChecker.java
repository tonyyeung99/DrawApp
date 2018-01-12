package com.drawing.main;

import com.drawing.util.ParserUtil;

public class TypeLVanillaSyntaxChecker implements SyntaxChecker{
	@Override
	public void validate(String[] commandWords) throws InvalidInputLineException {
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
}
