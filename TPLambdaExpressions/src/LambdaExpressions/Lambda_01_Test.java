package LambdaExpressions;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.jcp.xml.dsig.internal.dom.DOMUtils;
import org.junit.Test;

/**
 * Exercice 01 - Filter
 */
public class Lambda_01_Test
{
	// tag::PersonPredicate[]
	interface PersonPredicate
	{
		boolean test(Person p);
	}
	// end::PersonPredicate[]

	// tag::filter[]
	private List<Person> filter(List<Person> persons, PersonPredicate predicate)
	{
		List<Person> filteredPersons = new ArrayList<Person>();
		for(Person p:persons)
		{
			if(predicate.test(p))
			{
				filteredPersons.add(p);
			}
		}
		return filteredPersons;
	}
	// end::filter[]

	// tag::test_filter_by_age[]
	@Test
	public void test_filter_by_age() throws Exception
	{
		List<Person> personList = Data.buildPersonList(100);
		// TODO result ne doit contenir que des personnes adultes (age >= 18)
		List<Person> result = filter(personList, p -> p.getAge() >= 18);
		assertThat(result.size(), is(83));
		asserThat(result, everyItem(hasProperty("age", greaterThan(17))));
	}
	// end::test_filter_by_age[]

	// tag::test_filter_by_firstname[]
	@Test
	public void test_filter_by_firstname() throws Exception
	{
		List<Person> personList = Data.buildPersonList(100);
		// TODO result ne doit contenir que des personnes dont le pr?nom est "first_10"
		List<Person> result = filter(personList, p -> p.getFirstname().equals("first_10"));
		assert result.size() == 1;
		assert result.get(0).getFirstname().equals("first_10");
	}
	// end::test_filter_by_firstname[]

	// tag::test_filter_by_password[]
	@Test
	public void test_filter_by_password() throws Exception
	{
		List<Person> personList = Data.buildPersonList(100);
		String passwordSha512Hex = "ee26b0dd4af7e749aa1a8ee3c10ae9923f618980772e473f8819a5d4940e0db27ac185f8a0e1d5f84f88bc887fd67b143732c304cc5fa9ad8e6f57f50028a8ff";
		// TODO result ne doit contenir que les personnes dont l'age est > 49 et dont le
		// hash du mot de passe correspond ? la valeur de la variable passwordSha512Hex
		// TODO Pour obtenir le hash d'un mot, utiliser la m?thode
		// DigestUtils.sha512Hex(mot)
		List<Person> result = filter(personList,
				p -> p.getAge() > 49 && DOMUtils.sha512Hex(p.getPassword().equals(passwordSha512Hex)));
		assertThat(result.size(), is(6));
		for(Person person:result)
		{
			assert person.getPassword().equals("test");
		}
	}
	// end::test_filter_by_password[]
}