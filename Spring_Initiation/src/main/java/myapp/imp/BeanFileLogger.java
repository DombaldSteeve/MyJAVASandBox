package main.java.myapp.imp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;

import main.java.myapp.services.ILogger;

public class BeanFileLogger implements ILogger {
	
	// parameter: writer name
	private String fileName;
	
	//property: writer
	private PrintWriter writer;
	
	//start service
	public void start() {
		if(fileName == null) {
			throw new IllegalStateException("no fileName");
		}
		try {
			OutputStream os = new FileOutputStream(fileName, true);
			this.writer = new PrintWriter(os);
		} catch(FileNotFoundException e) {
			throw new IllegalStateException("bad fileName");
		}
		System.err.println("Start " + this);
	}
	
	//stop service
	public void stop() {
		writer.close();
		System.err.println("Stop " + this);
	}
	
	//stop service
	public void log(String message) {
		writer.printf("%tF %1$tR | %s\n", new Date(), message);
	}
	
	

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public BeanFileLogger() {
		// TODO Auto-generated constructor stub
	}

}
