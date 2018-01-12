package com.drawing.visual;

public interface DrawEngine {

	public Canvas createCanvas(int width, int height);

	public void renderLine(Point point1, Point point2);

	public void renderRectangle(Point point1, Point point2);

	public void renderBucketFill(Point point1, char c);

	//delete quitProgram(), it's not used and will cause coupling with the main program
	//public void quitProgram();	

	public void setCanvas(Canvas canvas);	

	public Canvas getCanvas();

	public void paintCanvas();
}
