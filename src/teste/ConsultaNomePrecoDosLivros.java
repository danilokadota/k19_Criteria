package teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import k19_Criteria.Livros;

public class ConsultaNomePrecoDosLivros {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("k19_criteria_banco");
		EntityManager manager = factory.createEntityManager();
		
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Tuple> c = cb.createQuery(Tuple.class);
		Root<Livros> l = c.from(Livros.class);
		c.multiselect(l.<String>get("nome").alias("livro.nome"), l.<Double>get("preco").alias("livro.preco"));
		
		TypedQuery<Tuple> query = manager.createQuery(c);
		List<Tuple> resultado = query.getResultList();
		
		for(Tuple registro : resultado){
			System.out.println("Livro: " + registro.get("livro.nome"));
			System.out.println("Preco: " + registro.get("livro.preco"));
		}
		
	manager.close();
	factory.close();

	}

}
