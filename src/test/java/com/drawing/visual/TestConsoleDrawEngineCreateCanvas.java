package com.drawing.visual;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.drawing.main.DrawPrecheckException;
import com.drawing.testdata.CanvasLoader;

public class TestConsoleDrawEngineCreateCanvas {
	public static final String FILE_CANVAS_EMPTY_4_10 = "canvas_empty_4_10.txt";
	public static final String FILE_CANVAS_Line1_4_10 = "canvas_line1_4_10.txt";
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	private DrawEngine engine;
	
	@Before
	public void onBeforeExecute(){
		engine = new ConsoleDrawEngine();
	}
	
	@After
	public void onAfterExecute(){
		engine = null;
	}	
	
	@Test
	public void testCreateCanvasSuccess() throws FileNotFoundException {
		 char[][] expectEmptyCanvas = CanvasLoader.load(FILE_CANVAS_EMPTY_4_10);
		 char[][] testEmptyCanvas = engine.createCanvas(10, 4).exportPixels();
		 /*
		 for(int i=0; i<testEmptyCanvas.length;i++){
			 System.out.println(testEmptyCanvas[i]);
		 }	
		 System.out.println("row = " + testEmptyCanvas.length);
		 System.out.println("col = " + testEmptyCanvas[0].length);
		 System.out.println((int) testEmptyCanvas[0][0]);
		 System.out.println("********");
		 for(int i=0; i<expectEmptyCanvas.length;i++){
			 System.out.println(expectEmptyCanvas[i]);
		 }	
		 System.out.println("row = " + expectEmptyCanvas.length);
		 System.out.println("col = " + expectEmptyCanvas[0].length);
		 
		 System.out.println((int) expectEmptyCanvas[0][0]);	
		 */
		 assertArrayEquals(expectEmptyCanvas, testEmptyCanvas);
		 assertEquals(testEmptyCanvas.length, 4);
		 assertEquals(testEmptyCanvas[0].length, 10);
		 assertNotNull(engine.getCanvas());		 
	}
	
	@Test(expected = NegativeArraySizeException.class) 
	public void testCreateCanvasWithInvalidWidth() {
			engine.createCanvas(-10, 4);
	}
	

	
}
