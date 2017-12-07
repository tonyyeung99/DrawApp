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

public class TestInputValidatorCommandTypeL{
	
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
	public void testValidateTypeLCommandSuccess() throws InvalidInputLineException {		
		inputValidator.reset();
		inputValidator.setProcessingStr("L 1 2 6 2");
		inputValidator.validate();
		CommandType cmd =  inputValidator.getCommandType();
		assertTrue(cmd==CommandType.L);
		String[] words = inputValidator.getCommandWords();
		String[] expWords = new String[]{"L","1","2", "6", "2"};
		assertArrayEquals(expWords, words);
	}
	
	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeLCommandNotEnoughParameters() throws InvalidInputLineException {		
		inputValidator.reset();
		inputValidator.setProcessingStr("L 4 3");
		inputValidator.validate();
	}	
	
	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeLCommandTooManyParameters() throws InvalidInputLineException {		
		inputValidator.reset();
		inputValidator.setProcessingStr("L 1 2 6 2 5");
		inputValidator.validate();
	}	

	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeLCommandHasZeroParameter1() throws InvalidInputLineException {		
		inputValidator.reset();
		inputValidator.setProcessingStr("L 0 2 6 2");
		inputValidator.validate();
	}
	
	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeLCommandHasZeroParameter2() throws InvalidInputLineException {		
		inputValidator.reset();
		inputValidator.setProcessingStr("L 1 2 6 0");
		inputValidator.validate();
	}	
	
	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeLCommandHasNegativeParameter1() throws InvalidInputLineException {		
		inputValidator.reset();
		inputValidator.setProcessingStr("L -3 2 6 2");
		inputValidator.validate();
	}
	
	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeLCommandHasNegativeParameter2() throws InvalidInputLineException {		
		inputValidator.reset();
		inputValidator.setProcessingStr("L 1 2 -5 2");
		inputValidator.validate();
	}
	
	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeLCommandPointsSwap1() throws InvalidInputLineException {		
		inputValidator.reset();
		inputValidator.setProcessingStr("L 6 2 1 2");
		inputValidator.validate();
	}
	
	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeLCommandPointsSwap2() throws InvalidInputLineException {		
		inputValidator.reset();
		inputValidator.setProcessingStr("L 6 4 6 3");
		inputValidator.validate();
	}	

}
