package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import k19_Criteria.Autor;
import k19_Criteria.Livros;


public class PopulaBanco {

		 public static void main ( String [] args ) {
		 EntityManagerFactory factory = Persistence.createEntityManagerFactory ("k19_criteria_banco");
		 EntityManager manager = factory . createEntityManager ();
		 manager . getTransaction (). begin ();
		
		 Livros livro1 = new Livros ();
		 livro1 . setNome("The Battle for Your Mind");
		 livro1 . setPreco (20.6) ;
		 manager . persist ( livro1 );
		
		 Livros livro2 = new Livros ();
		 livro2 . setNome (" Differentiate or Die ");
		 livro2 . setPreco (15.8) ;
		 manager . persist ( livro2 );
		
		 Livros livro3 = new Livros ();
		 livro3 . setNome (" How to Transform Your Ideas ");
		 livro3 . setPreco (32.7) ;
		 manager . persist ( livro3 );
		
		 Livros livro4 = new Livros ();
		 livro4 . setNome (" Digital Fortress ");
		 livro4 . setPreco (12.9) ;
		 manager . persist ( livro4 );
		
		 Livros livro5 = new Livros ();
		 livro5 . setNome (" Marketing in an Era of Competition , Change and Crisis ");
		 livro5 . setPreco (26.8) ;
		 manager . persist ( livro5 );
		 
		 Autor autor1 = new Autor ();
		 autor1 . setNome (" Patrick Cullen ");
		 autor1 . getLivros (). add ( livro2 );
		 autor1 . getLivros (). add ( livro4 );
		 manager . persist ( autor1 );
		 
		 Autor autor2 = new Autor ();
		 autor2 . setNome (" Fraser Seitel ");
		 autor2 . getLivros (). add ( livro3 );
		 manager . persist ( autor2 );
		 
		 Autor autor3 = new Autor ();
		 autor3 . setNome ("Al Ries ");
		 autor3 . getLivros (). add ( livro1 );
		 manager . persist ( autor3 );
		
		 Autor autor4 = new Autor ();
		 autor4 . setNome (" Jack Trout ");
		 autor4 . getLivros (). add ( livro1 );
		 autor4 . getLivros (). add ( livro2 );
		 autor4 . getLivros (). add ( livro5 );
		 manager . persist ( autor4 );
		
		 Autor autor5 = new Autor ();
		 autor5 . setNome (" Steve Rivkin ");
		 autor5 . getLivros (). add ( livro2 );
		 autor5 . getLivros (). add ( livro3 );
		 autor5 . getLivros (). add ( livro5 );
		 manager . persist ( autor5 );
		 
		 manager . getTransaction (). commit ();
		 
		 manager . close ();
		 factory . close ();
	  }
	}

