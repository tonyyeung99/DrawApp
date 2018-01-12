package com.drawing.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.drawing.command.Command;
import com.drawing.command.CommandParser;
import com.drawing.command.CommandType;
import com.drawing.command.CommandValidator;
import com.drawing.command.VanillaCommandParser;
import com.drawing.command.VanillaCommandValidator;
import com.drawing.util.ParserUtil;
import com.drawing.visual.ConsoleDrawEngine;
import com.drawing.visual.DrawEngine;

public class DrawApp {

	private DrawEngine engine;
	private CommandParser cmdParser;
	private Invoker invoker;
	private CommandValidator cmdValidator;
	private InputValidator inputValidator;

	public static void main(String[] args){
		DrawApp app = new DrawApp();
		app.init();
		app.runProcess();
	}
	
	public void init(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		engine = (ConsoleDrawEngine) context.getBean("consoleDrawEngine");
		cmdValidator = (VanillaCommandValidator) context.getBean("vanillaCommandValidator");
		cmdParser = new VanillaCommandParser(cmdValidator, engine, this);
		inputValidator = (VanillaInputValidator) context.getBean("vanillaInputValidator");
		invoker = (VanillaInvoker) context.getBean("vanillaInvoker");
	}
	
	public void runProcess(){
		System.out.println("Weclome to the Drawing Application!");
		process();

	}
	
	public void process() {
		while(true){
			System.out.println("Please enter the command:");
			String userInput = readUserInput();
			InputlineTokenizer tokenizer = new InputlineTokenizer();
			Command cmd;
			try{
				String[] commandWords = tokenizer.process(userInput);
				inputValidator.validate(commandWords);				
				cmd = cmdParser.Parse( commandWords);
				cmdParser.validateDrawLogic(cmd);
				invoker.storeAndExecute(cmd);
			}catch(InvalidInputLineException inputExceptoin){
				System.out.println(inputExceptoin.getMessage()); 
				continue;
			}catch(DrawPrecheckException drawException){
				System.out.println(drawException.getMessage()); 
				continue;
			}		
		}
	}
	
	public void gracefulExit(){
		System.out.println("Exit the applicaiton now.");
		System.exit(0);
	}
	
	private String readUserInput(){
		Scanner userInput = new Scanner(System.in);
		String inputLine = userInput.nextLine();
		return inputLine;
	}
}
