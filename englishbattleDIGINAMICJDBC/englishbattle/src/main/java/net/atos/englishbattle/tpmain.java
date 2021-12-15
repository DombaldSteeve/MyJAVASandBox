package net.atos.englishbattle;

import net.atos.englishbattle.service.JoueurService;
import net.atos.englishbattle.service.impl.JoueurServiceImpl;

public class tpmain {

	public static void main(String[] args) {
		// TODO Auto-generated method 
		JoueurService jo = new JoueurServiceImpl();
		
		try {
			jo.recupererJoueurs().stream().forEach(j->System.out.println(
					j.getId()+"-"+j.getEmail()));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
