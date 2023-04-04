package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Veiculo;
import domain.VeiculoId;

public class BuscandoVeiculoPelaPlaca {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja-veiculos");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		VeiculoId codigo = new VeiculoId("AAA", "1111");
		Veiculo veiculo = em.find(Veiculo.class, codigo);
		System.out.println("Fabricante: " + veiculo.getFabricante());
		System.out.println("Modelo: " + veiculo.getModelo());
		System.out.println("pronto!");
		
		em.close();
		emf.close();
	
	}

}
