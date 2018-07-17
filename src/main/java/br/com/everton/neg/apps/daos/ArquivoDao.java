package br.com.everton.neg.apps.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import br.com.everton.neg.apps.models.Arquivo;

@Repository
public class ArquivoDao {
	 @PersistenceContext
	   private EntityManager manager;

	   public List<Arquivo> all()
	   {
	      return manager.createQuery("select c from Arquivo c", Arquivo.class).getResultList();
	   }

	   public void save(Arquivo arquivo)
	   {
	      manager.persist(arquivo);
	   }

	   public Arquivo findById(Integer id)
	   {
	      return manager.find(Arquivo.class, id);
	   }

	   public void remove(Arquivo arquivo)
	   {
	      manager.remove(arquivo);
	   }

	   public void update(Arquivo arquivo)
	   {
	      manager.merge(arquivo);
	   }

}


 