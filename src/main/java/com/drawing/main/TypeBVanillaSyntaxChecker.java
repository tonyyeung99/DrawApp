package com.drawing.main;

public class TypeBVanillaSyntaxChecker implements SyntaxChecker {

	@Override
	public void validate(String[] commandWords) throws InvalidInputLineException {

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

}