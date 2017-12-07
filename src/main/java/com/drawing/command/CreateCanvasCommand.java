package com.drawing.command;

import com.drawing.visual.DrawEngine;

public class CreateCanvasCommand implements Command{

	private DrawEngine engine;
	private int width, height;
	
	public CreateCanvasCommand(DrawEngine engine, int width, int height) {
		super();
		this.engine=engine;
		this.width=width;
		this.height=height;
	}	
	
	@Override
	public void execute() {
		engine.createCanvas(width, height);
		engine.paintCanvas();
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	

}