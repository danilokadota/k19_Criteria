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

public class ListaNomesDosLivros {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("k19_criteria_banco");
		EntityManager manager = factory.createEntityManager();
		
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<String> c = cb.createQuery(String.class);
		Root<Livros> livro = c.from(Livros.class);
		c.select(livro.<String>get("nome"));
		
		TypedQuery<String> query = manager.createQuery(c);
		List<String> nomes = query.getResultList();
		
		for(String nome : nomes){
			System.out.println("Livro: " + nome);
		}
		manager.close();
		factory.close();
	}

}
