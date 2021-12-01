package Classes;

import java.util.List;

import org.junit.Test;

public class Methode_01 {
	
	 // tag::IDao[]
    interface IDao {
        List<Person> findAll();
        
    
        // TODO cr�er une m�thode int sumAge()
     default int sumAge() {
    	 int sum = 0;
    	 for (Person p : findAll()) {
        	 sum += p.getAge();
    	 } return sum;
          // TODO Cette m�thode retourne le r�sultat de l'addition des ages des personnes
    }
    // end::IDao[]

    class DaoA implements IDao {

        List<Person> people = Data.buildPersonList(20);

        @Override
        public List<Person> findAll() {
            return people;
        }

		public void test_daoA_sumAge() throws Exception {
			// TODO Auto-generated method stub
			
		}

		public void test_daoB_sumAge() throws Exception {
			// TODO Auto-generated method stub
			
		}
    }

    class DaoB implements IDao {

        List<Person> people = Data.buildPersonList(100);

        @Override
        public List<Person> findAll() {
            return people;
        }

		public void test_daoA_sumAge() throws Exception {
			// TODO Auto-generated method stub
			
		}

		public void test_daoB_sumAge() throws Exception {
			// TODO Auto-generated method stub
			
		}
    }

    @Test
    public static void test_daoA_sumAge() throws Exception {

        DaoA daoA = new DaoA();

        // TODO invoquer la m�thode sumAge pour que le test soit passant
        int result = daoA.sumAge();

        assert result == 210;
    }

    @Test
    public static void test_daoB_sumAge() throws Exception {

        DaoB daoB = new DaoB();

        // TODO invoquer la m�thode sumAge pour que le test soit passant
        int result = daoB.sumAge();

        assert result == 5050;

    }
    }
}

