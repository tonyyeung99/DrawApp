Description:

A simple console version of a drawing program. 
At this time, the functionality of the program is quite limited but this might change in the future. 

The program works as follows:
 1. Create a new canvas
 2. Start drawing on the canvas by issuing various commands
 3. Quit

Command 		Description
C w h           Should create a new canvas of width w and height h.
L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only
                horizontal or vertical lines are supported. Horizontal and vertical lines
                will be drawn using the 'x' character.
R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and
                lower right corner is (x2,y2). Horizontal and vertical lines will be drawn
                using the 'x' character.
B x y c         Should fill the entire area connected to (x,y) with "colour" c. The
                behaviour of this is the same as that of the "bucket fill" tool in paint
                programs.
Q               Should quit the program.

__Sample I/O__

Below is a sample run of the program. User input is prefixed with enter command:

enter command: C 20 4
----------------------
|                    |
|                    |
|                    |
|                    |
----------------------

enter command: L 1 2 6 2
----------------------
|                    |
|xxxxxx              |
|                    |
|                    |
----------------------

enter command: L 6 3 6 4
----------------------
|                    |
|xxxxxx              |
|     x              |
|     x              |
----------------------

enter command: R 14 1 18 3
----------------------
|             xxxxx  |
|xxxxxx       x   x  |
|     x       xxxxx  |
|     x              |
----------------------

enter command: B 10 3 o
----------------------
|oooooooooooooxxxxxoo|
|xxxxxxooooooox   xoo|
|     xoooooooxxxxxoo|
|     xoooooooooooooo|
----------------------

enter command: Q


******************************************************************************************

I. Running Instruction

1. Download the project to your computer
2. It's a Maven project. 
	i. Compile the code, run the script:
		- mvn compile
	ii.	Running the main Program, run the script:
		- mvn exec:java -Dexec.mainClass="com.drawing.main.DrawApp"
	iii. Running the Junit Test, run the script:
		- mvn test
	iv. Build the JAR, run the script:
		- mvn package
		
******************************************************************************************
II. Dependency

1. Spring Framework - already included in the Maven POM file.
2. Junit - already included in the Maven POM file.
3. Maven - need for the dependency management.
4. Eclipse(optional) - easy for both development and build management.
5. M2Eclipse(optional) - easy for execute Maven function in the Eclipse environment.
6. EclEmma(optional) - for checking the coverage ratio of unit test. The current coverage ratio is 88.9% with all the test is green.
******************************************************************************************
III. Assumption

1. For Drawing Rectangle - I have assumed the smallest width/height of a rectangle is 1.
2. For all the drawing function, I haven't limit how big the width/x, height/y available for user to input.
3. I have limited user not able to input width/x, height/y for zero or negative value.
4. I have reserved the character ';', therefore the bucket fill function could not use this character as colour.
5. Users are allow to input the command in both Capital or non-Capital character.