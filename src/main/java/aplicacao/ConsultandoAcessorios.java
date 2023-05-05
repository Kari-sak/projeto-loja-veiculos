package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Acessorio;
import domain.Veiculo;

public class ConsultandoAcessorios {

	public static void main(String[] args) {
		
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja-veiculos");
	EntityManager em = emf.createEntityManager();

	Veiculo veiculo = em.find(Veiculo.class, 1L);
	System.out.println("Veículo: " + veiculo.getModelo());
	
	for (Acessorio acessorio : veiculo.getAcessorios()) {
	System.out.println("Acessório: " + acessorio.getDescricao());
	}

	System.out.println("pronto!");
	em.close(); 
	emf.close();

	}

}
