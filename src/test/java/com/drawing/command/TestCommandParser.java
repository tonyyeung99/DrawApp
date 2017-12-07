package com.drawing.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.drawing.main.DrawApp;
import com.drawing.main.DrawPrecheckException;
import com.drawing.visual.ConsoleDrawEngine;
import com.drawing.visual.DrawEngine;

public class TestCommandParser {
	
	private DrawEngine engine;
	private VanillaCommandValidator validator;
	private DrawApp app;
	
	@Before
	public void onBeforeExecute(){
		engine = new ConsoleDrawEngine();
		validator = new VanillaCommandValidator(engine);
		app = new DrawApp();
	}
	
	@After
	public void onAfterExecute(){
		engine = null;
		validator = null;
	}
	
	@Test
	public void testParseCreateCanvasCommand() throws DrawPrecheckException{
		String[] splitedStrings = {"C","20", "4"};
		CommandParser parser = new VanillaCommandParser(validator, engine, app);
		Command testCmd = parser.Parse(splitedStrings, CommandType.C);
		assertTrue(testCmd instanceof CreateCanvasCommand);		
		assertEquals(((CreateCanvasCommand) testCmd).getWidth(), 20);
		assertEquals(((CreateCanvasCommand) testCmd).getHeight(), 4);
	}
	
	@Test
	public void testParseDrawLineCommand() throws DrawPrecheckException{
		String[] splitedStrings = {"L","1", "2", "6", "2"};
		CommandParser parser = new VanillaCommandParser(validator, engine, app);
		Command testCmd = parser.Parse(splitedStrings, CommandType.L);
		assertTrue(testCmd instanceof DrawLineCommand);
		assertEquals(((DrawLineCommand) testCmd).getX1(), 1);
		assertEquals(((DrawLineCommand) testCmd).getY1(), 2);
		assertEquals(((DrawLineCommand) testCmd).getX2(), 6);
		assertEquals(((DrawLineCommand) testCmd).getY2(), 2);		
	}
	
	@Test
	public void testParseDrawRectCommand() throws DrawPrecheckException{
		String[] splitedStrings = {"R","14", "1", "8", "3"};
		CommandParser parser = new VanillaCommandParser(validator, engine, app);
		Command testCmd = parser.Parse(splitedStrings, CommandType.R);
		assertTrue(testCmd instanceof DrawRectCommand);
		assertEquals(((DrawRectCommand) testCmd).getX1(), 14);
		assertEquals(((DrawRectCommand) testCmd).getY1(), 1);
		assertEquals(((DrawRectCommand) testCmd).getX2(), 8);
		assertEquals(((DrawRectCommand) testCmd).getY2(), 3);		
	}
	
	@Test
	public void testParseBuckFillCommand() throws DrawPrecheckException{
		String[] splitedStrings = {"B","10", "3", "o"};
		CommandParser parser = new VanillaCommandParser(validator, engine, app);
		Command testCmd = parser.Parse(splitedStrings, CommandType.B);
		assertTrue(testCmd instanceof BucketFillCommand);
		assertEquals(((BucketFillCommand) testCmd).getX(), 10);
		assertEquals(((BucketFillCommand) testCmd).getY(), 3);
		assertEquals(((BucketFillCommand) testCmd).getC(), 'o');		
	}
	
	@Test
	public void testParseQuitCommand() throws DrawPrecheckException{
		String[] splitedStrings = {"Q"};
		CommandParser parser = new VanillaCommandParser(validator, engine, app);
		Command testCmd = parser.Parse(splitedStrings, CommandType.Q);
		assertTrue(testCmd instanceof QuitCommand);	
	}		
}
