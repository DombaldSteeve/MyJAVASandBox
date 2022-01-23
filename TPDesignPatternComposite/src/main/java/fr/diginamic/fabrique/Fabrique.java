package fr.diginamic.fabrique;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.diginamic.composite.Departement;
import fr.diginamic.composite.FabriqueDepartement;
import fr.diginamic.composite.FabriquePersonne;
import fr.diginamic.composite.IEntite;
import fr.diginamic.composite.Personne;

public abstract class Fabrique
{
	public abstract IEntite createEntite(int Id);

	private static int IdDep = 0;
	private static List<Departement> listDep = new ArrayList<Departement>();

	public static Departement findDepartement(int id)
	{
		for(Departement departement:listDep)
		{
			if(id == departement.getId())
			{
				return departement;
			}
		}
		return null;
	}

	public static void addToDepartement(IEntite entity)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("A quel departement voulez-vous l'attribuer ?");
		int sousDepId = scan.nextInt();
		Departement departementMere = Fabrique.findDepartement(sousDepId);
		if(departementMere == null)
		{
			System.out.println("Le departement demandé n'existe pas.");
		}
		else
		{
			departementMere.add(entity);
			if(entity instanceof Personne)
			{
				Personne personne = (Personne) entity;
				personne.setAffectationDep(departementMere);
			}
		}
	}

	public static IEntite getEntity(int num)
	{
		if(num == 1)
		{
			return new FabriquePersonne().createEntite(IdDep);
		}
		else if(num == 2)
		{
			IEntite departementEntite = new FabriqueDepartement().createEntite(++IdDep);
			listDep.add((Departement) departementEntite);
			return departementEntite;
		}
		return null;
	}
}
