package com.drawing.main;

public class DrawPrecheckException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8344702806643648978L;
	public static final String MSG_TEMPLATE_NO_CANVAS = "Drawing error : There is no canvas created before.";
	public static final String MSG_TEMPLATE_OUTSIDE_CANVAS = "Drawing error : There is(are) point(s) of co-ordination outside the canvas.";
	
	public DrawPrecheckException(String message){
		super(message);
	}
	
}
