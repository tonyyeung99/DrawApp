package com.drawing.command;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.drawing.command.BucketFillCommand;
import com.drawing.command.Command;
import com.drawing.command.VanillaCommandValidator;
import com.drawing.main.DrawPrecheckException;
import com.drawing.testdata.TestDataUtil;
import com.drawing.visual.ConsoleCanvas;
import com.drawing.visual.ConsoleDrawEngine;
import com.drawing.visual.DrawEngine;

public class TestCommandValidatorBucketFill {

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
	public void testBuckFillCanvusNull() throws DrawPrecheckException{
		Command cmd = new BucketFillCommand(engine, 10, 1, 'o');
		validator.validate(cmd);
	}
	
	@Test(expected = DrawPrecheckException.class)
	public void testBuckFillOutSide() throws DrawPrecheckException{
		char[][] buffers = TestDataUtil.createBuffers(20, 10);
		engine.setCanvas(new ConsoleCanvas(buffers));
		Command cmd = new BucketFillCommand(engine, 20, 11, 'm');
		validator.validate(cmd);
	}

	@Test	
	public void testBuckFillleInSide() throws DrawPrecheckException{
		char[][] buffers = TestDataUtil.createBuffers(10, 4);
		engine.setCanvas(new ConsoleCanvas(buffers));
		Command cmd = new BucketFillCommand(engine, 1, 1, 'c');
		validator.validate(cmd);
		
		cmd = new BucketFillCommand(engine, 10, 4, 'c');
		validator.validate(cmd);
		
		cmd = new BucketFillCommand(engine, 1, 4, 'o');
		validator.validate(cmd);
	}
}
