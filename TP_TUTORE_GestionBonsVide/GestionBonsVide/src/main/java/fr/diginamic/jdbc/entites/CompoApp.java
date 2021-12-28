package fr.diginamic.jdbc.entites;

public class CompoApp  {
	
	private String design;
	private int num;
	private int qte;
	
	
	public CompoApp(String design, int num, int qte) {
		this.design = design;
		this.num = num;
		this.qte = qte;
	}

	@Override
	public String toString() {
		return "CompoApp [design=" + design + ", num=" + num + ", qte=" + qte + "]";
	}

	public String getDesign() {
		return design;
	}

	public void setDesign(String design) {
		this.design = design;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public CompoApp() {
	}

	public static void main(String[] args) {

	}

}
