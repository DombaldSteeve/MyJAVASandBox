package modele;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringAware implements BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, InitializingBean, DisposableBean {
	
	private String beanName;
	private ClassLoader classLoader;
	private ApplicationContext applicationContext;
	
	

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public ClassLoader getClassLoader() {
		return classLoader;
	}

	public void setClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getBeanName() {
		return beanName;
	}

	public SpringAware() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() throws Exception {
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("passage dans la methode");
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	public void setBeanClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}
	
	public void destroyMethod() throws Exception {
		
	}
	
	public void initMethod() {
		
	}

}
