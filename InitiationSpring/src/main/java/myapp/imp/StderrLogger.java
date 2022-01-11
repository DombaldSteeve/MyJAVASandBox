package myapp.imp;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import myapp.services.ILogger;

@Service
@Qualifier("test")
public class StderrLogger implements ILogger {
	
	@PostConstruct
	public void start() {
		System.out.println("Start " + this);
	}
	
	@PreDestroy
	public void stop() {
		System.out.println("Stop " + this);
	}
	
	@Override
	public void log(String message) {
		System.out.printf("%tF %1$tR | %s\n", new Date(), message);
	}

	public StderrLogger() {
		// TODO Auto-generated constructor stub
	}

}
