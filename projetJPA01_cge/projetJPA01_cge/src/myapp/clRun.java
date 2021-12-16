package myapp;

import java.util.Date;
import java.util.Random;

import myapp.dao.Dao;
import myapp.model.Person;

public class clRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Dao monservice = new Dao();
			monservice.init();
			
			monservice.close();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

}
