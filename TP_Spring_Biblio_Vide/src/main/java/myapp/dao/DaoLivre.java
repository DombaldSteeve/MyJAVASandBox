package myapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import myapp.entities.Livre;
import myapp.services.ICrud;

@Service
@Repository
@Transactional
public class DaoLivre implements ICrud<Object>
{
	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	EntityManager em;

	public Livre addLivre(Livre l)
	{
		em.persist(l);
		System.err.println("addLivre avec l\'id= " + l.getId());
		return l;
	}

	@Override
	public void add(Object o)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void update(Object o)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Object o)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public List<Object> selectAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object selectOne(int id)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
