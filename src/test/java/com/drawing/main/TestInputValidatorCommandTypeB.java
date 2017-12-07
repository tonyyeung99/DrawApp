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

public class TestInputValidatorCommandTypeB{
	
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
	public void testValidateTypeBCommandSuccess() throws InvalidInputLineException {		
		inputValidator.reset();
		inputValidator.setProcessingStr("B 10 3 o");
		inputValidator.validate();
		CommandType cmd =  inputValidator.getCommandType();
		assertTrue(cmd==CommandType.B);
		String[] words = inputValidator.getCommandWords();
		String[] expWords = new String[]{"B","10","3", "o"};
		assertArrayEquals(expWords, words);
	}
	
	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeBCommandNotEnoughParameters() throws InvalidInputLineException {		
		inputValidator.reset();
		inputValidator.setProcessingStr("B 10 3");
		inputValidator.validate();
	}
	
	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeBCommandTooManyParameters() throws InvalidInputLineException {		
		inputValidator.reset();
		inputValidator.setProcessingStr("B 10 3 o d");
		inputValidator.validate();
	}	
	
	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeBCommandReserveWord() throws InvalidInputLineException {		
		inputValidator.reset();
		inputValidator.setProcessingStr("B 10 3 ;");
		inputValidator.validate();
	}	
	
	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeBCommandHasZeroParameter1() throws InvalidInputLineException {		
		inputValidator.reset();
		inputValidator.setProcessingStr("B 0 3 o");
		inputValidator.validate();
	}
	
	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeBCommandHasZeroParameter2() throws InvalidInputLineException {		
		inputValidator.reset();
		inputValidator.setProcessingStr("B 10 0 o");
		inputValidator.validate();
	}	
	
	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeBCommandInvalidColor() throws InvalidInputLineException {		
		inputValidator.reset();
		inputValidator.setProcessingStr("B 10 4 om");
		inputValidator.validate();
	}
}
