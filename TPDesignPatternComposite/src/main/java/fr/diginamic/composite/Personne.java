package fr.diginamic.composite;

public class Personne implements IEntite
{
	private String nom;
	private String prenom;
	private Departement affectationDep;

	public void execute()
	{
		System.out.println(
				"Je suis : " + getPrenom() + " et je suis dans le département : " + this.affectationDep.getNom());
	}

	public Personne()
	{
	}

	public Personne(String nom,String prenom)
	{
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	public Departement getAffectationDep()
	{
		return affectationDep;
	}

	public void setAffectationDep(Departement affectationDep)
	{
		this.affectationDep = affectationDep;
	}

	@Override
	public String toString()
	{
		return "Personne [nom=" + nom + ", prenom=" + prenom + "\n]";
	}
}
