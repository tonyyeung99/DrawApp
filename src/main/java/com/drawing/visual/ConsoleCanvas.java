package com.drawing.visual;

public class ConsoleCanvas implements Canvas{

	private int width, height;
	private char[][] pixels;

	public ConsoleCanvas(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.pixels = new char[height][width];
		initPixele();
	}
	
	public ConsoleCanvas(char[][] pixels){
		super();
		this.pixels = pixels;
		this.width = pixels[0].length;
		this.height = pixels.length;
	}
	
	@Override
	public char[][] exportPixels() {
		return pixels;
	}
	
	@Override
	public void paint() {
		String horizontalFrame = String.format("%0" + width + "d", 0).replace("0", "-");
		StringBuilder builder = new StringBuilder();
		builder.append(horizontalFrame + "\n");
		for(int i=0; i<pixels.length; i++){
			builder.append("|").append(pixels[i]).append("|\n");
		}
		builder.append(horizontalFrame + "\n");
		System.out.println(builder.toString());		
	}
	
	private void initPixele(){
		for(int i=0;i<height;i++)
			for(int j=0;j<width;j++)
				pixels[i][j]= 32;
	}
}
