I. Running Instruction

1. Download the zip file DrawingApp.zip and unzip the files to your computer.
2. It's a Maven project. However, I have used eclipse IDE(with Maven-plugin enabled) for developing and maintaining the project. In the following sections, it will mainly base on Eclipse and Maven-plugin.
3. Import the project as a Existing Maven Project:
		-Open eclipse
		-Click File > Import
		-Type Maven in the search box under Select an import source:
		-Select Existing Maven Projects
		-Click Next
		-Click Browse and select the folder that is the root of the Maven project
		-Click Next
		-Click Finish
4. Update the Maven Project in eclipse   
5. Running the main Program
		-run the main program "com.drawing.main.DrawApp" in Eclipse
		-or mvn exec:java -Dexec.mainClass="com.drawing.main.DrawApp"
6. Running the Junit Test
		-run the junit test on the test folder in Eclipse
7. Build the project with jar
		-run the project with setting the Gaols="packages' in Eclipse
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