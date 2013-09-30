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
import k19_Criteria.Livros_;

public class ConsultaLivroMaisCaro {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("k19_criteria_banco");
		EntityManager manager = factory.createEntityManager();
		
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Double> c = cb.createQuery(Double.class);
		Root<Livros> l = c.from(Livros.class);
		c.select(cb.max(l.get(Livros_.preco)));
		
		TypedQuery<Double> query = manager.createQuery(c);
		Double maiorPreco = query.getSingleResult();
		
		System.out.println("Maior Preço: " + maiorPreco);
		
		manager.close();
		factory.close();
	}

}
