package modele;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnnotationDependencyInjection {
	
	@Autowired
	private Dependency dependency;

	public AnnotationDependencyInjection() {
		// TODO Auto-generated constructor stub
	}

	public Dependency getDependency() {
		return dependency;
	}

	public void setDependency(Dependency dependency) {
		this.dependency = dependency;
	}
	
	

}
