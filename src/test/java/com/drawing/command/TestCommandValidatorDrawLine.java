package com.drawing.command;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.drawing.command.Command;
import com.drawing.command.DrawLineCommand;
import com.drawing.command.VanillaCommandValidator;
import com.drawing.main.DrawPrecheckException;
import com.drawing.testdata.TestDataUtil;
import com.drawing.visual.ConsoleCanvas;
import com.drawing.visual.ConsoleDrawEngine;
import com.drawing.visual.DrawEngine;

public class TestCommandValidatorDrawLine {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	private DrawEngine engine;
	private VanillaCommandValidator validator;
	
	@Before
	public void onBeforeExecute(){
		engine = new ConsoleDrawEngine();
		validator = new VanillaCommandValidator(engine);
	}
	
	@After
	public void onAfterExecute(){
		engine = null;
		validator  = null;
	}		

	@Test(expected = DrawPrecheckException.class)
	public void testDrawLineCanvusNull() throws DrawPrecheckException{
		Command cmd = new DrawLineCommand(engine, 10,1,10 ,4);
		validator.validate(cmd);
	}

	@Test(expected = DrawPrecheckException.class)	
	public void testDrawLineOutSide() throws DrawPrecheckException{
		char[][] buffers = TestDataUtil.createBuffers(10, 4);
		engine.setCanvas(new ConsoleCanvas(buffers));
		Command cmd = new DrawLineCommand(engine, 10, 1, 10 , 5);
		validator.validate(cmd);
	}
	
	@Test	
	public void testDrawLineInSide() throws DrawPrecheckException{
		char[][] buffers = TestDataUtil.createBuffers(10, 4);
		engine.setCanvas(new ConsoleCanvas(buffers));
		Command cmd = new DrawLineCommand(engine, 10, 1, 10 , 4);
		validator.validate(cmd);
		
		cmd = new DrawLineCommand(engine, 8, 1, 8 , 4);
		validator.validate(cmd);
		
		cmd = new DrawLineCommand(engine, 1, 4, 10 , 4);
		validator.validate(cmd);	
	}
}
