package modele;

public class SetterDependencyInjection {
	
	private Dependency dependency;

	public SetterDependencyInjection() {
		// TODO Auto-generated constructor stub
	}
	
	

	public SetterDependencyInjection(Dependency dependency) {
		super();
		this.dependency = dependency;
	}



	public Dependency getDependency() {
		return dependency;
	}

	public void setDependency(Dependency dependency) {
		this.dependency = dependency;
	}
	
	

}
