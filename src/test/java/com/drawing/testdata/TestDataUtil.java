package com.drawing.testdata;

public class TestDataUtil {
	
	public static char[][] createBuffers(int width, int height){
		char[][] buffers = new char[height][width];
		for(int i=0; i<height; i++)
			for(int j=0; j<width; j++)
				buffers[i][j] = 32;
		return buffers;
	}
}
