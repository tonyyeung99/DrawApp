package com.drawing.visual;

public interface DrawEngine {

	public Canvas createCanvas(int w, int h);
	
	public void renderLine(int x1, int y1, int x2, int y2);
	
	public void renderRectangle(int x1, int y1, int x2, int y2);
	
	public void renderBucketFill(int x, int y, char c);
	
	public void quitProgram();	
	
	public void setCanvas(Canvas canvas);	
	
	public Canvas getCanvas();
	
	public void paintCanvas();
}
