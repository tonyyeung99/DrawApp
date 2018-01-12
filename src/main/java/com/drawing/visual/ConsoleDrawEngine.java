package com.drawing.visual;

public class ConsoleDrawEngine implements DrawEngine {

	private Canvas canvas;

	// Engine process the buffer than update it to the Canvas
	private char[][] processingBuffer;

	@Override
	public Canvas createCanvas(int w, int h) {
		this.canvas = new ConsoleCanvas(w, h);
		return canvas;
	}

	@Override
	public void renderLine(Point point1, Point point2) {
		cloneCanvasBufferToProcessingBuffer();
		drawLineAlgorithm(point1, point2);
		updateCanvasBuffer();
	}

	private void drawLineAlgorithm(Point point1, Point point2) {
		int zeroBaseX1 = point1.getX() - 1, zeroBaseY1 = point1.getY() - 1, zeroBaseX2 = point2.getX() - 1,
				zeroBaseY2 = point2.getY() - 1;
		for (int i = zeroBaseX1; i <= zeroBaseX2; i++)
			for (int j = zeroBaseY1; j <= zeroBaseY2; j++)
				processingBuffer[j][i] = 'X';
	}

	@Override
	public void renderRectangle(Point point1, Point point2) {
		cloneCanvasBufferToProcessingBuffer();
		drawRectangleAlgorithm(point1, point2);
		updateCanvasBuffer();
	}

	private void drawRectangleAlgorithm(Point point1, Point point2) {
		Point pointTopLeft = point1;
		Point pointTopRight = new Point(point2.getX(), point1.getY());
		Point pointBottomLeft = new Point(point1.getX(), point2.getY());
		Point pointBottomRight = point2;
		// draw top line
		drawLineAlgorithm(pointTopLeft, pointTopRight);
		// draw bottom line
		drawLineAlgorithm(pointBottomLeft, pointBottomRight);
		// draw left line
		drawLineAlgorithm(pointTopLeft, pointBottomLeft);
		// draw right line
		drawLineAlgorithm(pointTopRight, pointBottomRight);
	}

	@Override
	public void renderBucketFill(Point point, char c) {
		// char[][] buffers = canvas.exportPixels();
		cloneCanvasBufferToProcessingBuffer();
		bucketFillAlgoirthm(point, c);
		updateCanvasBuffer();
	}

	private void bucketFillAlgoirthm(Point point, char c) {
		int zeroBaseX = getZeroBaseX(point), zeroBaseY = getZeroBaseY(point);
		if (!isWithinCanvas(point))
			return;
		if (isHitLinePixel(point))
			return;
		if (isHitSameColorPixel(point, c))
			return;
		processingBuffer[zeroBaseY][zeroBaseX] = c;
		Point upperPoint = new Point(point.getX(), point.getY() + 1);
		Point bottomPoint = new Point(point.getX(), point.getY() - 1);
		Point leftPoint = new Point(point.getX() - 1, point.getY());
		Point rightPoint = new Point(point.getX() + 1, point.getY());
		bucketFillAlgoirthm(leftPoint, c);
		bucketFillAlgoirthm(rightPoint, c);
		bucketFillAlgoirthm(upperPoint, c);
		bucketFillAlgoirthm(bottomPoint, c);
	}

	private int getZeroBaseX(Point point) {
		return point.getX() - 1;
	}

	private int getZeroBaseY(Point point) {
		return point.getY() - 1;
	}

	private boolean isWithinCanvas(Point point) {
		char[][] buffers = processingBuffer;
		if (buffers.length < point.getY() || point.getY() < 1 || buffers[0].length < point.getX() || point.getX() < 1)
			return false;
		return true;
	}

	private boolean isHitLinePixel(Point point) {
		char[][] buffers = processingBuffer;
		boolean isHit = ('X' == buffers[getZeroBaseY(point)][getZeroBaseX(point)]) ? true : false;
		return isHit;
	}

	private boolean isHitSameColorPixel(Point point, char c) {
		char[][] buffers = processingBuffer;
		boolean isHit = (c == buffers[getZeroBaseY(point)][getZeroBaseX(point)]) ? true : false;
		return isHit;
	}

	/*
	 * @Override public void quitProgram() {
	 * 
	 * }
	 */

	private void updateCanvasBuffer() {
		canvas.updateBuffer(processingBuffer);
	}

	private void cloneCanvasBufferToProcessingBuffer() {
		char[][] sourceBuffer = canvas.exportPixels();
		processingBuffer = new char[sourceBuffer.length][];
		for (int i = 0; i < sourceBuffer.length; i++)
			processingBuffer[i] = sourceBuffer[i].clone();
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
		if (canvas != null)
			canvas.paint();
	}

}
