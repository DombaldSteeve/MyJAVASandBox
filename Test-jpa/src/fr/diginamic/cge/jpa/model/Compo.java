package fr.diginamic.cge.jpa.model;

public class Compo {
	
	private int id;
	private int id_liv;
	private int id_emp;
	
	

	public Compo(int id, int id_liv, int id_emp) {
		super();
		this.id = id;
		this.id_liv = id_liv;
		this.id_emp = id_emp;
	}

	public Compo() {
		// TODO Auto-generated constructor stub
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_liv() {
		return id_liv;
	}

	public void setId_liv(int id_liv) {
		this.id_liv = id_liv;
	}

	public int getId_emp() {
		return id_emp;
	}

	public void setId_emp(int id_emp) {
		this.id_emp = id_emp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
