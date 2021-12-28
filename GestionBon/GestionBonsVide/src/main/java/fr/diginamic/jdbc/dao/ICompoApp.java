package fr.diginamic.jdbc.dao;

import java.sql.SQLException;

import fr.diginamic.jdbc.entites.CompoApp;

public interface ICompoApp {
	
	void insert (CompoApp compoApp) throws SQLException;

}
