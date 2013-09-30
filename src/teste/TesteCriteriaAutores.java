package teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import k19_Criteria.Autor;

public class TesteCriteriaAutores {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("k19_criteria_banco");
		EntityManager manager = factory.createEntityManager();
		
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Autor> c = cb.createQuery(Autor.class);
		Root<Autor> a = c.from(Autor.class);
		c.select(a);
		
		TypedQuery<Autor> query = manager.createQuery(c);
		List<Autor> autores = query.getResultList();
		
		for(Autor autor : autores){
			System.out.println(autor.getNome());
		}

	}

}
