package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import fr.diginamic.jdbc.entites.Bon;

public interface IBon {
	
	List<Bon> extraire() throws SQLException;
	void insert(Bon bon) throws SQLException;
	int updateNumero(int id, int numero) throws SQLException;
	int updateDate_Cmde(Bon id, Date date_cmde) throws SQLException;
	int updateDelai(int id, int delai) throws SQLException;
	int updateIdFou(Bon id, int id_fou) throws SQLException;
	boolean delete(Bon article) throws SQLException;
	Bon fiche(int id_fou) throws SQLException;

}
