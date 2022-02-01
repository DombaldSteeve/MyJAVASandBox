package fr.diginamic.webmvc01.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CLIENT")
public class Client
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	@NotNull
	@NotBlank
	private String nom;
	@NotNull
	@NotBlank
	private String prenom;
	@Transient
	private Client clientE;

	public Client()
	{
		super();
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
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

	public Client getClientE()
	{
		return clientE;
	}

	public void setClientE(Client clientE)
	{
		this.clientE = clientE;
	}

	@Override
	public String toString()
	{
		return "Id client: " + id + " / Nom= " + nom + " / Prenom = " + prenom + "";
	}

	public void forEach(Object object)
	{
		// TODO Auto-generated method stub
	}
}