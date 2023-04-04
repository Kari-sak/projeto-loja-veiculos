package aplicacao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Veiculo;

public class AtualizandoVeiculo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja-veiculos");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		//Há necessidade de se fazer uma transição ao inserir algo no bd
		
		Veiculo veiculo = em.find(Veiculo.class, 1L);
		
		System.out.println("Valor atual: " + veiculo.getValor());
		veiculo.setValor(veiculo.getValor().add(new BigDecimal(500)));
		System.out.println("Novo valor: " + veiculo.getValor());
		
		
		em.getTransaction().commit();
		
		System.out.println("pronto!");
		em.close();
		emf.close();
	
	}

}
