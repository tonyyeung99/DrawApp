package com.drawing.visual;

public class ConsoleDrawEngine implements DrawEngine {

	private Canvas canvas;
	
	@Override
	public Canvas createCanvas(int w, int h) {
		this.canvas = new ConsoleCanvas(w, h);
		return canvas;
	}	
	
	@Override
	public void renderLine(int x1, int y1, int x2, int y2) {
		//Transform the 1 base index to 0 base index
		int zeroBaseX1=x1-1, zeroBaseY1=y1-1, zeroBaseX2=x2-1, zeroBaseY2=y2-1;
		char[][] buffers = canvas.exportPixels();
		if(zeroBaseX1==zeroBaseX2){
			for(int i=zeroBaseY1; i<=zeroBaseY2; i++){
				buffers[i][zeroBaseX1]='X';
			}
		}
		if(zeroBaseY1==zeroBaseY2){
			for(int i=zeroBaseX1; i<=zeroBaseX2; i++){
				buffers[zeroBaseY1][i]='X';
			}
		}		
	}


	@Override
	public void renderRectangle(int x1, int y1, int x2, int y2) {
		//draw top line
		renderLine(x1, y1, x2, y1);
		//draw bottom line
		renderLine(x1, y2, x2, y2);
		//draw left line
		renderLine(x1, y1, x1, y2);
		//draw right line
		renderLine(x2, y1, x2, y2);
	}

	@Override
	public void renderBucketFill(int x, int y, char c) {
		char[][] buffers = canvas.exportPixels();
		int zeroBaseX=x-1, zeroBaseY=y-1;
		if(!isWithinCanvas(canvas, x, y)) return;
		if ('X'==buffers[zeroBaseY][zeroBaseX]) return;
		if (c==buffers[zeroBaseY][zeroBaseX]) return;
		buffers[zeroBaseY][zeroBaseX] = c;
		renderBucketFill(x+1, y, c);
		renderBucketFill(x-1, y, c);
		renderBucketFill(x, y+1, c);
		renderBucketFill(x, y-1, c);
	}
	
	private boolean isWithinCanvas(Canvas canvas, int x, int y){
		char[][] buffers = canvas.exportPixels();
		if(buffers.length<y||y<1||buffers[0].length<x||x<1) return false;
		return true;
	}

	@Override
	public void quitProgram() {

	}

	@Override
	public Canvas getCanvas() {
		return canvas;
	}

	@Override
	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;	
	}

	@Override
	public void paintCanvas() {
		if(canvas!=null)
			canvas.paint();	
	}
	

}
