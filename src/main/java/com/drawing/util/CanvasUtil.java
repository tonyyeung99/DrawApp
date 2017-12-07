package com.drawing.util;

import com.drawing.visual.Canvas;

public class CanvasUtil {
	public static boolean isWithinCanvas(Canvas canvas, int x, int y){
		char[][] buffers = canvas.exportPixels();
		if(buffers.length<y||y<1||buffers[0].length<x||x<1) return false;
		return true;
	}
}
