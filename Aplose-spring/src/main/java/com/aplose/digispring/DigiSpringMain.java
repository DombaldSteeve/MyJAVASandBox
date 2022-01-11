package com.aplose.digispring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modele.AnnotationDependencyInjection;
import modele.AutowireDependencyInjection;
import modele.ConstructorDependencyInjection;
import modele.SetterDependencyInjection;
import modele.User;
import services.UserManager;

public class DigiSpringMain {

	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("Ca y est, l'application context est configurée ... ");
		
		User admin = context.getBean("admin", User.class);
		System.out.println("Bonjour" + " " + admin.getFirstName());
		
		UserManager userManager = context.getBean("userManager", UserManager.class);
		if(admin == userManager.getUsers().get(0)) {
			System.out.println("Admin est bien un singleton.");
		} else {
			System.out.println("Admin n'est pas un singleton.");
		}
		
		ConstructorDependencyInjection cdi = context.getBean("constructorDependencyInjection", ConstructorDependencyInjection.class);
		SetterDependencyInjection sdi = context.getBean("setterDependencyInjection", SetterDependencyInjection.class);
		
		if(cdi.getDependency() != sdi.getDependency()) {
			System.out.println("Les dependencies ne sont pas des singletons.");
		}else {
			System.out.println("Dependency est un singleton...");
			
		}
		
		AutowireDependencyInjection adi = context.getBean("autowireDependencyInjection", AutowireDependencyInjection.class);
		if(adi.getDependency() != null) {
			System.out.println("La dépendance a bient été injectée automatiquement par Spring." + " " + adi.getDependency().toString());
		} else {
			System.out.println("il y a un pb");
		}
		
		AnnotationDependencyInjection anndi = context.getBean("annotationDependencyInjection", AnnotationDependencyInjection.class);
        if (anndi.getDependency() != null){
            System.out.println("-> La dépendance à bien était injectée automatiquement par annotation (par Spring) : " + anndi.getDependency());
        }
	}
	
	
}
