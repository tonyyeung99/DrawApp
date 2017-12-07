package com.drawing.command;

import com.drawing.visual.DrawEngine;

public class BucketFillCommand implements Command{

	private DrawEngine engine;
	private int x, y; 
	private char c;

	public BucketFillCommand(DrawEngine engine, int x, int y, char c) {
		super();
		this.engine = engine;
		this.x = x;
		this.y = y;
		this.c = c;
	}

	@Override
	public void execute() {
		engine.renderBucketFill(x, y, c);
		engine.paintCanvas();
	}

	public DrawEngine getEngine() {
		return engine;
	}

	public void setEngine(DrawEngine engine) {
		this.engine = engine;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public char getC() {
		return c;
	}

	public void setC(char c) {
		this.c = c;
	}
	
}