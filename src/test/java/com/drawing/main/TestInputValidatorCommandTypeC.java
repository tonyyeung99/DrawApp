package com.drawing.main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.drawing.command.Command;
import com.drawing.command.CommandType;
import com.drawing.command.DrawLineCommand;
import com.drawing.command.DrawRectCommand;
import com.drawing.command.VanillaCommandValidator;
import com.drawing.main.DrawPrecheckException;
import com.drawing.testdata.TestDataUtil;
import com.drawing.visual.ConsoleCanvas;
import com.drawing.visual.ConsoleDrawEngine;
import com.drawing.visual.DrawEngine;

public class TestInputValidatorCommandTypeC{
	
	private InputValidator inputValidator;
	
	@Before
	public void onBeforeExecute(){

		inputValidator = new VanillaInputValidator(); 
	}
	
	@After
	public void onAfterExecute(){
		inputValidator = null;
	}		

	@Test
	public void testValidateTypeCCommandSuccess() throws InvalidInputLineException {		
		/*
		inputValidator.reset();
		inputValidator.setProcessingStr("C 20 4");
		inputValidator.validate();
		CommandType cmd =  inputValidator.getCommandType();
		assertTrue(cmd==CommandType.C);
		String[] words = inputValidator.getCommandWords();
		String[] expWords = new String[]{"C","20","4"};
		assertArrayEquals(expWords, words);*/
		String[] expWords = new String[]{"C","20","4"};
		inputValidator.validate(expWords);
		
	}

	@Test(expected = InvalidInputLineException.class)
	public void testValidateCommandNotRecogonize() throws InvalidInputLineException {	
		/*
		inputValidator.reset();
		inputValidator.setProcessingStr("Z 20 4");
		inputValidator.validate();
		*/
		String[] expWords = new String[]{"Z","20","4"};
		inputValidator.validate(expWords);
	}	
	
	@Test(expected = InvalidInputLineException.class)
	public void testValidateBlankInput() throws InvalidInputLineException {	
		/*
		inputValidator.reset();
		inputValidator.setProcessingStr("");
		inputValidator.validate();*/
		String[] expWords = new String[]{""};
		inputValidator.validate(expWords);
	}	
	
	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeCCommandNotEnoughParameters() throws InvalidInputLineException {	
		/*
		inputValidator.reset();
		inputValidator.setProcessingStr("C 4");
		inputValidator.validate();*/
		String[] expWords = new String[]{"C", "4"};
		inputValidator.validate(expWords);
	}
	
	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeCCommandTooManyParameters() throws InvalidInputLineException {
		/*
		inputValidator.reset();
		inputValidator.setProcessingStr("C 4 8 11");
		inputValidator.validate();*/
		
		String[] expWords = new String[]{"C","4","8","11"};
		inputValidator.validate(expWords);		
	}	
	
	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeCCommandHasZeroParameter1() throws InvalidInputLineException {		
		/*
		inputValidator.reset();
		inputValidator.setProcessingStr("C 0 8");
		inputValidator.validate();*/
		
		String[] expWords = new String[]{"C","0","8"};
		inputValidator.validate(expWords);		
	}

	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeCCommandHasZeroParameter2() throws InvalidInputLineException {
		/*
		inputValidator.reset();
		inputValidator.setProcessingStr("C 8 0");
		inputValidator.validate();*/
		
		String[] expWords = new String[]{"C","8","0"};
		inputValidator.validate(expWords);
	}
	
	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeCCommandHasNegativeParameter1() throws InvalidInputLineException {
		/*
		inputValidator.reset();
		inputValidator.setProcessingStr("C -1 8");
		inputValidator.validate();*/
		
		String[] expWords = new String[]{"C","-1","8"};
		inputValidator.validate(expWords);
	}

	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeCCommandHasNegativeParameter2() throws InvalidInputLineException {	
		/*
		inputValidator.reset();
		inputValidator.setProcessingStr("C 8 -32");
		inputValidator.validate();*/
		
		String[] expWords = new String[]{"C","8","-32"};
		inputValidator.validate(expWords);
	}
}
