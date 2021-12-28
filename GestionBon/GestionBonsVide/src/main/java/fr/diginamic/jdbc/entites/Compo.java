package fr.diginamic.jdbc.entites;



public class Compo {
	
	private int id;
	private int id_art;
	private int id_bon;
	private int qte;
	
	

	public Compo() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Compo(int id, int id_art, int id_bon, int qte) {
		super();
		this.id = id;
		this.id_art = id_art;
		this.id_bon = id_bon;
		this.qte = qte;
	}



	@Override
	public String toString() {
		return "Compo [id=" + id + ", id_art=" + id_art + ", id_bon=" + id_bon + ", qte=" + qte + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_art() {
		return id_art;
	}

	public void setId_art(int id_art) {
		this.id_art = id_art;
	}

	public int getId_bon() {
		return id_bon;
	}

	public void setId_bon(int id_bon) {
		this.id_bon = id_bon;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
