package Classes;


import java.util.List;

import org.junit.Test;

public class Methode_02 {
	
	// tag::IDao[]
    interface IDao {
        List<Person> findAll();
       
        // TODO cr�er une m�thode String format()
        // TODO la m�thode retourne une cha�ne de la forme [<nb_personnes> persons]
        // TODO exemple de r�sultat : "[14 persons]", "[30 persons]"
        
        default String format() {
        	return "["+findAll().size()+" persons]";
        	
        }

    }
    // end::IDao[]

    // tag::DaoA[]
    class DaoA implements IDao {

        List<Person> people = Data.buildPersonList(20);

        @Override
        public List<Person> findAll() {
            return people;
        }

        // TODO red�finir la m�thode String format()
        // TODO la m�thode retourne une cha�ne de la forme DaoA[<nb_personnes> persons]
        // TODO exemple de r�sultat : "DaoA[14 persons]", "DaoA[30 persons]"
        // TODO l'impl�mentation r�utilise la m�thode format() de l'interface
        
        public String format() {
        	return "DaoA"+IDao.super.format();
        }

    }
    // end::DaoA[]

    @Test
    public void test_daoA_format() throws Exception {

        DaoA daoA = new DaoA();

        // TODO invoquer la m�thode format() pour que le test soit passant
        String result = daoA.format();

        assert "DaoA[20 persons]".equals(result);
    }

}
