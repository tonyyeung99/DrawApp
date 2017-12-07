package com.drawing.command;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.drawing.command.Command;
import com.drawing.command.DrawLineCommand;
import com.drawing.command.DrawRectCommand;
import com.drawing.command.VanillaCommandValidator;
import com.drawing.main.DrawPrecheckException;
import com.drawing.testdata.TestDataUtil;
import com.drawing.visual.ConsoleCanvas;
import com.drawing.visual.ConsoleDrawEngine;
import com.drawing.visual.DrawEngine;

public class TestCommandValidatorDrawRectangle {

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
	public void testDrawRectangleCanvusNull() throws DrawPrecheckException{
		Command cmd = new DrawRectCommand(engine, 10,1,10 ,4);
		validator.validate(cmd);
	}
	
	
	@Test(expected = DrawPrecheckException.class)
	public void testDrawRectangleOutSide() throws DrawPrecheckException{
		char[][] buffers = TestDataUtil.createBuffers(10, 4);
		engine.setCanvas(new ConsoleCanvas(buffers));
		Command cmd = new DrawRectCommand(engine, 1, 1, 10, 5);
		validator.validate(cmd);
	}
	
	@Test	
	public void testDrawRectangleInSide() throws DrawPrecheckException{
		char[][] buffers = TestDataUtil.createBuffers(10, 4);
		engine.setCanvas(new ConsoleCanvas(buffers));
		Command cmd = new DrawRectCommand(engine, 1, 1, 10 , 4);
		validator.validate(cmd);
		
		cmd = new DrawRectCommand(engine, 2, 2, 9, 3);
		validator.validate(cmd);
		
		cmd = new DrawRectCommand(engine, 4, 1, 10 , 4);
		validator.validate(cmd);	
	}
}
