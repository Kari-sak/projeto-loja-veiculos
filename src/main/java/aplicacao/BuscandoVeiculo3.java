package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Veiculo;

public class BuscandoVeiculo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja-veiculos");
		EntityManager em = emf.createEntityManager();
		
		//em.getTransaction().begin();
		//Não há necessidade de se fazer uma transição ao inserir algo no bd
		
		Veiculo veiculo = em.getReference(Veiculo.class, 4L);
		System.out.println("Buscou veículo. Será que já executou o SELECT?");
		System.out.println("Veiculo de código " + veiculo.getCodigo()
		+ " é um " + veiculo.getModelo());
		
		//em.getTransaction().commit();
		
		System.out.println("pronto!");
		em.close();
		emf.close();
	
	}

}
