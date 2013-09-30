package teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import k19_Criteria.Livros;

public class TesteCriteria {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("k19_criteria_banco");
		EntityManager manager = factory.createEntityManager();
		
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Livros> c = cb.createQuery(Livros.class);
		Root<Livros> l = c.from(Livros.class);
		c.select(l);
		
		TypedQuery<Livros> query = manager.createQuery(c);
		List<Livros>livros = query.getResultList();
		
		for (Livros livro : livros){
			System.out.println(livro.getNome());
		}

	}

}
