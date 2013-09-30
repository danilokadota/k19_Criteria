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

public class CalculaMediaDosPrecosDosLivros {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("k19_criteria_banco");
		EntityManager manager = factory.createEntityManager();
		
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Double> c = cb.createQuery(Double.class);
		Root<Livros> l = c.from(Livros.class);
		c.select(cb.avg(l.<Double>get("preco")));
		
		TypedQuery<Double> query = manager.createQuery(c);
		Double media = query.getSingleResult();

		System.out.println("Media: " + media);

		manager.close();
		factory.close();
	}

}