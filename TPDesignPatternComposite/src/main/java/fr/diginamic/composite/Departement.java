package fr.diginamic.composite;

import java.util.ArrayList;
import java.util.List;

public class Departement implements IEntite {
	
    private String nom;
    private List<IEntite> entites ;
    
    public Departement () {
    	
    }

    public Departement(String nom) {
        super();
        this.nom = nom;
        this.entites = new ArrayList<IEntite>();
    }

    public void add(IEntite e) {
        this.entites.add(e);
    }

    public void remove(IEntite e) {
        this.entites.remove(e);
    }


    public void execute() {
        System.out.println("je suis un d�partement !");
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<IEntite> getEntites() {
        return entites;
    }

    public void setEntites(List<IEntite> entites) {
        this.entites = entites;
    }

    @Override
    public String toString() {
        return "Departement [nom=" + nom + ", entites=" + entites + "\n]";
    }

    public IEntite appendDepartement(String nomDep) {
        // TODO Auto-generated method stub
        return null;
    }

	public Departement getElements() {
		// TODO Auto-generated method stub
		return null;
	}
}
