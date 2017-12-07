package com.drawing.main;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.drawing.command.Command;
import com.drawing.command.CommandParser;
import com.drawing.command.CommandType;
import com.drawing.command.VanillaCommandParser;
import com.drawing.command.VanillaCommandValidator;
import com.drawing.testdata.CanvasLoader;
import com.drawing.visual.ConsoleDrawEngine;
import com.drawing.visual.DrawEngine;

public class TestInvoker{
	
	public static final String FILE_INV_4_20 = "canvas_invoker_4_20.txt";
	public static final String FILE_INV2_4_20 = "canvas_invoker2_4_20.txt";
	public static final String FILE_INV3_4_20 = "canvas_invoker3_4_20.txt";
	
	private DrawEngine engine;
	private VanillaCommandValidator validator;
	private DrawApp app;
	private Invoker invoker;
	
	@Before
	public void onBeforeExecute(){
		invoker = new VanillaInvoker();
		engine = new ConsoleDrawEngine();
		validator = new VanillaCommandValidator(engine);
		app = new DrawApp();		
	}
	
	@After
	public void onAfterExecute(){
		invoker = null;
		engine = null;
		validator = null;
		app = null;
	}		

	@Test
	public void testInvokeCreateCanvasCommand() throws DrawPrecheckException, FileNotFoundException {
		char[][] expectEmptyCanvas = CanvasLoader.load(FILE_INV_4_20);		 
		String[] splitedStrings = {"C","20", "4"};
		CommandParser parser = new VanillaCommandParser(validator, engine, app);
		Command testCmd = parser.Parse(splitedStrings, CommandType.C);
		invoker.storeAndExecute(testCmd);
		char[][] testEmptyCanvas = engine.getCanvas().exportPixels();
		assertArrayEquals(expectEmptyCanvas, testEmptyCanvas);
		assertEquals(4, testEmptyCanvas.length);
		assertEquals(20, testEmptyCanvas[0].length);
		assertNotNull(engine.getCanvas());		 
		List<Command> logger =  invoker.exportCommand();
		assertEquals(1, logger.size());	
	}	
	
	@Test
	public void testInvokdCombineTogether() throws DrawPrecheckException, FileNotFoundException {
		char[][] expectEmptyCanvas = CanvasLoader.load(FILE_INV3_4_20);		 
		String[] splitedStrings1 = {"C","20","4"};
		String[] splitedStrings2 = {"L","1","2","6","2"};
		String[] splitedStrings3 = {"L","6", "3", "6", "4"};
		String[] splitedStrings4 = {"R","14", "1", "18", "3"};
		String[] splitedStrings5 = {"B","10", "3", "o"};
		
		CommandParser parser = new VanillaCommandParser(validator, engine, app);
		Command testCmd1 = parser.Parse(splitedStrings1, CommandType.C);
		Command testCmd2 = parser.Parse(splitedStrings2, CommandType.L);
		Command testCmd3 = parser.Parse(splitedStrings3, CommandType.L);
		Command testCmd4 = parser.Parse(splitedStrings4, CommandType.R);
		Command testCmd5 = parser.Parse(splitedStrings5, CommandType.B);		
		engine.createCanvas(20, 4);
		invoker.storeAndExecute(testCmd1);
		invoker.storeAndExecute(testCmd2);
		invoker.storeAndExecute(testCmd3);
		invoker.storeAndExecute(testCmd4);
		invoker.storeAndExecute(testCmd5);		
		char[][] testEmptyCanvas = engine.getCanvas().exportPixels();
		assertArrayEquals(expectEmptyCanvas, testEmptyCanvas);		 
		List<Command> logger =  invoker.exportCommand();
		assertEquals(5, logger.size());	
	}	

}
