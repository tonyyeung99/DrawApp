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

public class TestInputValidatorCommandTypeQ{
	
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
	public void testValidateTypeQCommandSuccess() throws InvalidInputLineException {		
		inputValidator.reset();
		inputValidator.setProcessingStr("Q");
		inputValidator.validate();
		CommandType cmd =  inputValidator.getCommandType();
		assertTrue(cmd==CommandType.Q);
		String[] words = inputValidator.getCommandWords();
		String[] expWords = new String[]{"Q"};
		assertArrayEquals(expWords, words);
	}

	@Test(expected = InvalidInputLineException.class)
	public void testValidateTypeCCommandTooManyParameters() throws InvalidInputLineException {		
		inputValidator.reset();
		inputValidator.setProcessingStr("Q 4 5");
		inputValidator.validate();
	}
	
}
