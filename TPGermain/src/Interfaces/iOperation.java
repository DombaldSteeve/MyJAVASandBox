package Interfaces;


@FunctionalInterface
public interface iOperation {
	
	/**
	 * une m�thode � surcharger et elle se fera par les lambdas Expressions () -> 
	 * @param a
	 * @param b
	 * @return
	 */
	public Double calcul( Double a, Double b);

}
