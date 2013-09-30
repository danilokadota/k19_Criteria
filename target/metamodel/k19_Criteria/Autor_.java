package k19_Criteria;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Autor.class)
public abstract class Autor_ {

	public static volatile SingularAttribute<Autor, Long> id;
	public static volatile CollectionAttribute<Autor, Livros> livros;
	public static volatile SingularAttribute<Autor, String> nome;

}

