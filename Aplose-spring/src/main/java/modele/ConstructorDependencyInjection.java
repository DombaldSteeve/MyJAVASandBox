package modele;

public class ConstructorDependencyInjection {
	
	private Dependency dependency;

	public ConstructorDependencyInjection() {
		// TODO Auto-generated constructor stub
	}

	public Dependency getDependency() {
		return dependency;
	}
	
	

	public ConstructorDependencyInjection(Dependency dependency) {
		super();
		this.dependency = dependency;
	}

	public void setDependency(Dependency dependency) {
		this.dependency = dependency;
	}
	
	

}
