package com.drawing.command;

import com.drawing.main.DrawPrecheckException;
import com.drawing.util.CanvasUtil;
import com.drawing.visual.DrawEngine;

public class VanillaCommandValidator implements CommandValidator {

	DrawEngine engine;
	
	public VanillaCommandValidator(){
	}
	
	public VanillaCommandValidator(DrawEngine engine){
		this.engine = engine;
	}
	
	@Override
	public void validate(Command command) throws DrawPrecheckException {
		if(command instanceof CreateCanvasCommand ){}
		if(command instanceof DrawLineCommand ) {handleDrawLineValidate((DrawLineCommand) command); return;}
		if(command instanceof DrawRectCommand ) {handleDrawRectValidate((DrawRectCommand) command); return;}
		if(command instanceof BucketFillCommand ) {handleBuckFillValidate((BucketFillCommand) command); return;}
		if(command instanceof QuitCommand ) {}
		return;
		
	}
	
	private void handleDrawLineValidate(DrawLineCommand command) throws DrawPrecheckException {
		if(engine.getCanvas()==null)
			throw new DrawPrecheckException(DrawPrecheckException.MSG_TEMPLATE_NO_CANVAS);
		if(!CanvasUtil.isWithinCanvas(engine.getCanvas(), command.getX1(), command.getY1()) ||
			!CanvasUtil.isWithinCanvas(engine.getCanvas(), command.getX2(), command.getY2()))
			throw new DrawPrecheckException(DrawPrecheckException.MSG_TEMPLATE_OUTSIDE_CANVAS);
		return;
	}
	
	private void handleDrawRectValidate(DrawRectCommand command) throws DrawPrecheckException {
		if(engine.getCanvas()==null)
			throw new DrawPrecheckException(DrawPrecheckException.MSG_TEMPLATE_NO_CANVAS);
		if(!CanvasUtil.isWithinCanvas(engine.getCanvas(), command.getX1(), command.getY1()) ||
			!CanvasUtil.isWithinCanvas(engine.getCanvas(), command.getX2(), command.getY2()))
			throw new DrawPrecheckException(DrawPrecheckException.MSG_TEMPLATE_OUTSIDE_CANVAS);
		return;
	}	
	
	private void handleBuckFillValidate(BucketFillCommand command) throws DrawPrecheckException {
		if(engine.getCanvas()==null)
			throw new DrawPrecheckException(DrawPrecheckException.MSG_TEMPLATE_NO_CANVAS);
		if(!CanvasUtil.isWithinCanvas(engine.getCanvas(), command.getX(), command.getY()))
			throw new DrawPrecheckException(DrawPrecheckException.MSG_TEMPLATE_OUTSIDE_CANVAS);
		return;
	}

	public DrawEngine getEngine() {
		return engine;
	}

	public void setEngine(DrawEngine engine) {
		this.engine = engine;
	}
	
	

}
