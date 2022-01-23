package fr.diginamic.composite;

import java.util.ArrayList;
import java.util.List;

public class Departement implements IEntite
{
	private String nom;
	private int id;
	private List<IEntite> entites;

	public Departement()
	{
	}

	public Departement(String nom,int id)
	{
		super();
		this.nom = nom;
		this.id = id;
		this.entites = new ArrayList<IEntite>();
	}

	public void add(IEntite e)
	{
		this.entites.add(e);
	}

	public void remove(IEntite e)
	{
		this.entites.remove(e);
	}

	public void execute()
	{
		System.out.println("Je suis le département " + this.nom);
		for(IEntite iEntite:entites) {
			iEntite.execute();
		}
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public List<IEntite> getEntites()
	{
		return entites;
	}

	public void setEntites(List<IEntite> entites)
	{
		this.entites = entites;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	@Override
	public String toString()
	{
		return "Departement [nom=" + nom + ", entites=" + entites + "\n]";
	}

	public IEntite appendDepartement(String nomDep)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public Departement getElements()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
