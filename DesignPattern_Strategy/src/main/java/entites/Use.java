package entites;

public class Use
{
	ClassA objet;

	public Use(ClassA param)
	{
		objet = param;
	}

	public void AfficherClass()
	{
		System.out.println(objet.getClass() + " coucou ! ");
	}
}
