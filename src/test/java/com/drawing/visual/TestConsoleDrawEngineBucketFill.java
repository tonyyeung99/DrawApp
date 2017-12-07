package com.drawing.visual;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.drawing.testdata.CanvasLoader;

public class TestConsoleDrawEngineBucketFill {

	public static final String FILE_CANVAS_FILL1_4_20 = "canvas_fill1_4_20.txt";
	public static final String FILE_CANVAS_FILL2_6_10 = "canvas_fill2_6_10.txt";
	public static final String FILE_CANVAS_FILL3_6_10 = "canvas_fill3_6_10.txt";
	public static final String FILE_CANVAS_FILL4_6_10 = "canvas_fill4_6_10.txt";
	public static final String FILE_CANVAS_FILL5_6_10 = "canvas_fill5_6_10.txt";
	
	public static final String FILE_CANVAS_NOFILL1_4_20 = "canvas_nofill1_4_20.txt";
	public static final String FILE_CANVAS_NOFILL2_6_10 = "canvas_nofill2_6_10.txt";
	public static final String FILE_CANVAS_NOFILL3_6_10 = "canvas_nofill3_6_10.txt";
	public static final String FILE_CANVAS_NOFILL4_6_10 = "canvas_nofill4_6_10.txt";
	public static final String FILE_CANVAS_NOFILL5_6_10 = "canvas_nofill5_6_10.txt";
	
	public static final String FILE_CANVAS_AGAIN_FILL1_4_20 = "canvas_again_fill1_4_20.txt";
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	private DrawEngine engine;
	
	@Before
	public void onBeforeExecute(){
		engine = new ConsoleDrawEngine();
	}	

	@Test
	public void testFillPolygonCenter() throws FileNotFoundException{
		 char[][] expectFill1Canvas = CanvasLoader.load(FILE_CANVAS_FILL1_4_20);
		 char[][] testFill1Canvas = CanvasLoader.load(FILE_CANVAS_NOFILL1_4_20);
		 engine.setCanvas(new ConsoleCanvas(testFill1Canvas));
		 //engine.createCanvas(20, 4).setBuffer(testFill1Canvas);		 
		 engine.renderBucketFill(10, 3, 'o');
		 testFill1Canvas = engine.getCanvas().exportPixels();
		 
		 /*
		 for(int i=0; i<testFill1Canvas.length;i++){
			 System.out.println(testFill1Canvas[i]);
		 }
		 
		 System.out.println("row = " + testFill1Canvas.length);
		 System.out.println("col = " + testFill1Canvas[0].length);
		 System.out.println((int) testFill1Canvas[0][0]);
		 System.out.println("********");
		 for(int i=0; i<expecFill1Canvas.length;i++){
			 System.out.println(expecFill1Canvas[i]);
		 }	
		 System.out.println("row = " + expecFill1Canvas.length);
		 System.out.println("col = " + expecFill1Canvas[0].length);		 
		 System.out.println((int) expecFill1Canvas[0][0]);
		 */		 
		 assertArrayEquals(expectFill1Canvas, testFill1Canvas);
		 assertEquals(testFill1Canvas.length, 4);
		 assertEquals(testFill1Canvas[0].length, 20);
		 
		 engine.renderBucketFill(10, 3, 'm');
		 expectFill1Canvas = CanvasLoader.load(FILE_CANVAS_AGAIN_FILL1_4_20);
		 assertArrayEquals(expectFill1Canvas, testFill1Canvas);		 
	}
	
	@Test
	public void testFillCollideWithLine() throws FileNotFoundException{
		 char[][] expectFill1Canvas = CanvasLoader.load(FILE_CANVAS_NOFILL1_4_20);
		 char[][] testFill1Canvas = CanvasLoader.load(FILE_CANVAS_NOFILL1_4_20);
		 //engine.createCanvas(20, 4).setBuffer(testFill1Canvas);
		 engine.setCanvas(new ConsoleCanvas(testFill1Canvas));
		 engine.renderBucketFill(3, 2, 'o');
		 testFill1Canvas = engine.getCanvas().exportPixels();
		 assertArrayEquals(expectFill1Canvas, testFill1Canvas);
		 assertEquals(testFill1Canvas.length, 4);
		 assertEquals(testFill1Canvas[0].length, 20);
	}	
	
	@Test
	public void testFillPolygonCornerBottomLeft() throws FileNotFoundException{
		 char[][] expectFill2Canvas = CanvasLoader.load(FILE_CANVAS_FILL2_6_10);
		 char[][] testFill2Canvas = CanvasLoader.load(FILE_CANVAS_NOFILL2_6_10);
		 //engine.createCanvas(10, 6).setBuffer(testFill2Canvas);
		 engine.setCanvas(new ConsoleCanvas(testFill2Canvas));
		 engine.renderBucketFill(1, 6, 'o');
		 testFill2Canvas = engine.getCanvas().exportPixels();
		 assertArrayEquals(expectFill2Canvas, testFill2Canvas);
	}
	
	@Test
	public void testFillPolygonCornerTopRight() throws FileNotFoundException{
		 char[][] expectFill3Canvas = CanvasLoader.load(FILE_CANVAS_FILL3_6_10);
		 char[][] testFill3Canvas = CanvasLoader.load(FILE_CANVAS_NOFILL3_6_10);
		 //engine.createCanvas(10, 6).setBuffer(testFill3Canvas);
		 engine.setCanvas(new ConsoleCanvas(testFill3Canvas));
		 engine.renderBucketFill(9, 4, 'o');
		 testFill3Canvas = engine.getCanvas().exportPixels();
		 assertArrayEquals(expectFill3Canvas, testFill3Canvas);
	}
	
	@Test
	public void testFillEdgeTop() throws FileNotFoundException{
		 char[][] expectFill4Canvas = CanvasLoader.load(FILE_CANVAS_FILL4_6_10);
		 char[][] testFill4Canvas = CanvasLoader.load(FILE_CANVAS_NOFILL4_6_10);
		 //engine.createCanvas(10, 6).setBuffer(testFill4Canvas);
		 engine.setCanvas(new ConsoleCanvas(testFill4Canvas));
		 engine.renderBucketFill(5, 2, 'o');
		 testFill4Canvas = engine.getCanvas().exportPixels();
		 assertArrayEquals(expectFill4Canvas, testFill4Canvas);		
	}
	
	@Test
	public void testFillEdgeRight() throws FileNotFoundException{
		 char[][] expectFill5Canvas = CanvasLoader.load(FILE_CANVAS_FILL5_6_10);
		 char[][] testFill5Canvas = CanvasLoader.load(FILE_CANVAS_NOFILL5_6_10);
		 //engine.createCanvas(10, 6).setBuffer(testFill5Canvas);
		 engine.setCanvas(new ConsoleCanvas(testFill5Canvas));
		 engine.renderBucketFill(10, 5, 'o');
		 testFill5Canvas = engine.getCanvas().exportPixels();
		 assertArrayEquals(expectFill5Canvas, testFill5Canvas);
	}
	

}
