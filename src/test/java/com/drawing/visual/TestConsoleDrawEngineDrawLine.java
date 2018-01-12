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

public class TestConsoleDrawEngineDrawLine {

	public static final String FILE_CANVAS_Line1_4_10 = "canvas_line1_4_10.txt";
	public static final String FILE_CANVAS_Line2_4_10 = "canvas_line2_4_10.txt";
	public static final String FILE_CANVAS_Line3_4_10 = "canvas_line3_4_10.txt";
	public static final String FILE_CANVAS_Line4_4_10 = "canvas_line4_4_10.txt";
	public static final String FILE_CANVAS_Line5_6_8 = "canvas_line5_6_8.txt";

	@Rule
	public ExpectedException exception = ExpectedException.none();

	private DrawEngine engine;

	@Before
	public void onBeforeExecute() {
		engine = new ConsoleDrawEngine();
	}

	@Test
	public void testDrawLineEdgeLeft() throws FileNotFoundException {
		char[][] expectLine1Canvas = CanvasLoader.load(FILE_CANVAS_Line1_4_10);
		char[][] testLine1Canvas;
		engine.createCanvas(10, 4);
		engine.renderLine(new Point(1, 1), new Point(1, 4));
		testLine1Canvas = engine.getCanvas().exportPixels();
		assertArrayEquals(testLine1Canvas, expectLine1Canvas);
		assertEquals(testLine1Canvas.length, 4);
		assertEquals(testLine1Canvas[0].length, 10);
	}

	@Test
	public void testDrawLineEdgeRight() throws FileNotFoundException {
		char[][] expectLine2Canvas = CanvasLoader.load(FILE_CANVAS_Line2_4_10);
		char[][] testLine2Canvas;
		engine.createCanvas(10, 4);
		engine.renderLine(new Point(10, 1), new Point(10, 4));
		testLine2Canvas = engine.getCanvas().exportPixels();
		assertArrayEquals(testLine2Canvas, expectLine2Canvas);
		assertEquals(testLine2Canvas.length, 4);
		assertEquals(testLine2Canvas[0].length, 10);
	}

	@Test
	public void testDrawLineEdgeTop() throws FileNotFoundException {
		char[][] expectLine3Canvas = CanvasLoader.load(FILE_CANVAS_Line3_4_10);
		char[][] testLine3Canvas;
		engine.createCanvas(10, 4);
		engine.renderLine(new Point(1, 1), new Point(10, 1));
		testLine3Canvas = engine.getCanvas().exportPixels();
		assertArrayEquals(testLine3Canvas, expectLine3Canvas);
		assertEquals(testLine3Canvas.length, 4);
		assertEquals(testLine3Canvas[0].length, 10);
	}

	@Test
	public void testDrawLineEdgeBottom() throws FileNotFoundException {
		char[][] expectLine4Canvas = CanvasLoader.load(FILE_CANVAS_Line4_4_10);
		char[][] testLine4Canvas;
		engine.createCanvas(10, 4);
		engine.renderLine(new Point(1, 4), new Point(10, 4));
		testLine4Canvas = engine.getCanvas().exportPixels();
		assertArrayEquals(testLine4Canvas, expectLine4Canvas);
		assertEquals(testLine4Canvas.length, 4);
		assertEquals(testLine4Canvas[0].length, 10);
	}

	@Test
	public void testDrawLineEdgeCenter() throws FileNotFoundException {
		char[][] expectLine5Canvas = CanvasLoader.load(FILE_CANVAS_Line5_6_8);
		char[][] testLine5Canvas;
		engine.createCanvas(8, 6);
		engine.renderLine(new Point(2, 3), new Point(6, 3));
		testLine5Canvas = engine.getCanvas().exportPixels();
		assertArrayEquals(testLine5Canvas, expectLine5Canvas);
		assertEquals(testLine5Canvas.length, 6);
		assertEquals(testLine5Canvas[0].length, 8);
	}

	@After
	public void onAfterExecute() {
		engine = null;
	}

}
