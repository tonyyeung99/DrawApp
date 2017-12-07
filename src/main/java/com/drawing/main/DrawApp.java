package com.drawing.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.drawing.command.Command;
import com.drawing.command.CommandParser;
import com.drawing.command.CommandValidator;
import com.drawing.command.VanillaCommandParser;
import com.drawing.command.VanillaCommandValidator;
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
			String input = readUserInput();
			initInputValidator(input);
			Command cmd;
			try{inputValidator.validate();} catch (InvalidInputLineException e){System.out.println(e.getMessage()); continue;}
			try{
				cmd = cmdParser.Parse( inputValidator.getCommandWords(), inputValidator.getCommandType());
				cmdParser.validate(cmd);
			} catch (DrawPrecheckException e){
				System.out.println(e.getMessage());
				continue;
			} catch (InvalidInputLineException e){System.out.println(e.getMessage()); continue;}
			invoker.storeAndExecute(cmd);
		}
	}
	
	public void gracefulExit(){
		System.out.println("Exit the applicaiton now.");
		System.exit(0);
	}
	
	private void initInputValidator(String input){
		inputValidator.reset();
		inputValidator.setProcessingStr(input);
	}
	
	private String readUserInput(){
		Scanner userInput = new Scanner(System.in);
		String inputLine = userInput.nextLine();
		return inputLine;
	}
}
