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

public class TestConsoleDrawEngineDrawRectangle {

	public static final String FILE_CANVAS_RECT1_10_4 = "canvas_rect1_10_4.txt";
	public static final String FILE_CANVAS_RECT2_10_4 = "canvas_rect2_10_4.txt";
	public static final String FILE_CANVAS_RECT3_10_4 = "canvas_rect3_10_4.txt";
	public static final String FILE_CANVAS_RECT4_10_4 = "canvas_rect4_10_4.txt";
	public static final String FILE_CANVAS_RECT5_6_8 = "canvas_rect5_6_8.txt";
	public static final String FILE_CANVAS_RECT6_6_8 = "canvas_rect6_6_8.txt";
	
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	private DrawEngine engine;
	
	@Before
	public void onBeforeExecute(){
		engine = new ConsoleDrawEngine();
	}	

	@Test
	public void testDrawRectangleTopLeft() throws FileNotFoundException{
		 char[][] expecRect1Canvas = CanvasLoader.load(FILE_CANVAS_RECT1_10_4);
		 char[][] testRect1Canvas ;
		 engine.createCanvas(4, 10);
		 engine.renderRectangle(1, 1 , 3, 3);
		 testRect1Canvas = engine.getCanvas().exportPixels();
		 /*
		 for(int i=0; i<testRect1Canvas.length;i++){
			 System.out.println(testRect1Canvas[i]);
		 }
		 
		 System.out.println("row = " + testRect1Canvas.length);
		 System.out.println("col = " + testRect1Canvas[0].length);
		 System.out.println((int) testRect1Canvas[0][0]);
		 System.out.println("********");
		 for(int i=0; i<expecRect1Canvas.length;i++){
			 System.out.println(expecRect1Canvas[i]);
		 }	
		 System.out.println("row = " + expecRect1Canvas.length);
		 System.out.println("col = " + expecRect1Canvas[0].length);
		 
		 System.out.println((int) expecRect1Canvas[0][0]);
		 */		 
		 assertArrayEquals(testRect1Canvas, expecRect1Canvas);
		 assertEquals(testRect1Canvas.length, 10);
		 assertEquals(testRect1Canvas[0].length, 4);
	}
	
	@Test
	public void testDrawRectangleTopRight() throws FileNotFoundException{
		 char[][] expecRect2Canvas = CanvasLoader.load(FILE_CANVAS_RECT2_10_4);
		 char[][] testRect2Canvas ;
		 engine.createCanvas(4, 10);
		 engine.renderRectangle(2, 1 , 4, 3);
		 testRect2Canvas = engine.getCanvas().exportPixels();		 
		 assertArrayEquals(testRect2Canvas, expecRect2Canvas);
		 assertEquals(testRect2Canvas.length, 10);
		 assertEquals(testRect2Canvas[0].length, 4);
	}
	
	@Test
	public void testDrawRectangleBottomLeft() throws FileNotFoundException{
		 char[][] expecRect3Canvas = CanvasLoader.load(FILE_CANVAS_RECT3_10_4);
		 char[][] testRect3Canvas ;
		 engine.createCanvas(4, 10);
		 engine.renderRectangle(1, 8 , 3, 10);
		 testRect3Canvas = engine.getCanvas().exportPixels();		 
		 assertArrayEquals(testRect3Canvas, expecRect3Canvas);
		 assertEquals(testRect3Canvas.length, 10);
		 assertEquals(testRect3Canvas[0].length, 4);
	}
	
	@Test
	public void testDrawRectangleBottomRight() throws FileNotFoundException{
		 char[][] expecRect4Canvas = CanvasLoader.load(FILE_CANVAS_RECT4_10_4);
		 char[][] testRect4Canvas ;
		 engine.createCanvas(4, 10);
		 engine.renderRectangle(2, 8 , 4, 10);
		 testRect4Canvas = engine.getCanvas().exportPixels();		 
		 assertArrayEquals(testRect4Canvas, expecRect4Canvas);
		 assertEquals(testRect4Canvas.length, 10);
		 assertEquals(testRect4Canvas[0].length, 4);
	}

	@Test
	public void testDrawRectangleFourEdge() throws FileNotFoundException{
		 char[][] expecRect5Canvas = CanvasLoader.load(FILE_CANVAS_RECT5_6_8);
		 char[][] testRect5Canvas ;
		 engine.createCanvas(8, 6);
		 engine.renderRectangle(1, 1 , 8, 6);
		 testRect5Canvas = engine.getCanvas().exportPixels();
		 assertArrayEquals(testRect5Canvas, expecRect5Canvas);
		 assertEquals(testRect5Canvas.length, 6);
		 assertEquals(testRect5Canvas[0].length, 8);
	}
	
	@Test
	public void testDrawRectangleCenter() throws FileNotFoundException{
		 char[][] expecRect6Canvas = CanvasLoader.load(FILE_CANVAS_RECT6_6_8);
		 char[][] testRect6Canvas ;
		 engine.createCanvas(8, 6);
		 engine.renderRectangle(2, 2 , 7, 5);
		 testRect6Canvas = engine.getCanvas().exportPixels();
		 assertArrayEquals(testRect6Canvas, expecRect6Canvas);
		 assertEquals(testRect6Canvas.length, 6);
		 assertEquals(testRect6Canvas[0].length, 8);
	}	
	
	@After
	public void onAfterExecute(){
		engine = null;
	}
	
}
