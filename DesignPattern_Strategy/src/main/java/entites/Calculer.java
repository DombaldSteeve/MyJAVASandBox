package entites;

import interfaces.ICalcul;

public class Calculer
{
	ICalcul calcul;

	public Calculer(ICalcul c)
	{
		calcul = c;
	}

	public void setICalcul(ICalcul c)
	{
		calcul = c;
	}

	public Double Calcul()
	{
		return calcul.Calcul();
	}
}
