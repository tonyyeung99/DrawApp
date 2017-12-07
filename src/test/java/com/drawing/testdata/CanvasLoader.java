package com.drawing.testdata;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CanvasLoader {

	public static char [][] load(String filename) throws FileNotFoundException{
		ClassLoader classLoader = CanvasLoader.class.getClassLoader();
		File file = new File(classLoader.getResource(filename).getFile());
		Scanner inputFile = new Scanner(file);
		inputFile.useDelimiter(";");	
		int x = Integer.parseInt(inputFile.next().replaceAll("\\r|\\n", ""));
		int y = Integer.parseInt(inputFile.next().replaceAll("\\r|\\n", "")); 
		//inputFile.nextLine();
		char [][] array = new char [x][y];
		int row = 0;
		while (inputFile.hasNext())
		{
			//System.out.println("row="+row);
			String words = inputFile.next().replaceAll("\\r|\\n", "");
            for (int col=0; col<words.length(); col++){
            	array[row][col]=nullToWhiteSpace(words.charAt(col));
            }
            row ++;
            if(row>=array.length)
            	break;
		}
		return array;
	}
	
	private static char nullToWhiteSpace(char from){
		char to ;
		to = ((int) from==0)? (char) 32 : from;
		return to;
	}
}
