package com.drawing.visual;

public interface Canvas {
	
	public char[][] exportPixels();
	public void updateBuffer(char[][] buffer);
	public void paint();
	
}
