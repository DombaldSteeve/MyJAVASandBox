package entites;

import interfaces.ICalcul;

public class CalculerBenef implements ICalcul
{
	double cout = 75.32;
	double prix = 589.33;

	public CalculerBenef()
	{
		Double benef = prix - cout;
		return;
	}

	public Double Calcul()
	{
		Double benef = prix - cout;
		return benef;
	}
}
