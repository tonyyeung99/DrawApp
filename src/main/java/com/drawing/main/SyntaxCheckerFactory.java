package com.drawing.main;

import com.drawing.command.CommandType;

public class SyntaxCheckerFactory  {

	public static SyntaxChecker createVanillaSyntaxChecker(CommandType type) {
		switch(type){
			case C:
				return new TypeCVanillaSyntaxChecker();
			case L:
				return new TypeLVanillaSyntaxChecker();
			case R:
				return new TypeRVanillaSyntaxChecker();
			case B:
				return new TypeBVanillaSyntaxChecker();
			case Q:
				return new TypeQVanillaSyntaxChecker();				
			default: 
				return new DefaultVanillaSyntaxChecker();
		}
	}
}
