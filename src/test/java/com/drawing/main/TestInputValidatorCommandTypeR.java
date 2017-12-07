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

public class TestInputValidatorCommandTypeR{
	
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
	public void testValidateTypeRCommandSuccess() throws InvalidInputLineException {		
		inputValidator.reset();
		inputValidator.setProcessingStr("R 14 1 18 3");
		inputValidator.validate();
		CommandType cmd =  inputValidator.getCommandType();
		assertTrue(cmd==CommandType.R);
		String[] words = inputValidator.getCommandWords();
		String[] expWords = new String[]{"R","14","1", "18", "3"};
		assertArrayEquals(expWords, words);
	}
	
	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeRCommandNotEnoughParameters() throws InvalidInputLineException {		
		inputValidator.reset();
		inputValidator.setProcessingStr("R 4 3 3");
		inputValidator.validate();
	}	
	
	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeRCommandTooManyParameters() throws InvalidInputLineException {		
		inputValidator.reset();
		inputValidator.setProcessingStr("R 14 1 18 3 7");
		inputValidator.validate();
	}
	
	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeRCommandHasZeroParameter1() throws InvalidInputLineException {		
		inputValidator.reset();
		inputValidator.setProcessingStr("R 0 2 6 2");
		inputValidator.validate();
	}
	
	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeRCommandHasZeroParameter2() throws InvalidInputLineException {		
		inputValidator.reset();
		inputValidator.setProcessingStr("R 14 1 18 0");
		inputValidator.validate();
	}
	
	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeRCommandHasNegativeParameter1() throws InvalidInputLineException {		
		inputValidator.reset();
		inputValidator.setProcessingStr("R 14 -1 18 0");
		inputValidator.validate();
	}
	
	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeRCommandHasNegativeParameter2() throws InvalidInputLineException {		
		inputValidator.reset();
		inputValidator.setProcessingStr("R 14 1 18 -3");
		inputValidator.validate();
	}	
	
	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeRCommandPointsSwap1() throws InvalidInputLineException {		
		inputValidator.reset();
		inputValidator.setProcessingStr("R 6 2 1 2");
		inputValidator.validate();
	}
	
	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeRCommandPointsSwap2() throws InvalidInputLineException {		
		inputValidator.reset();
		inputValidator.setProcessingStr("R 18 3 14 1");
		inputValidator.validate();
	}
}
