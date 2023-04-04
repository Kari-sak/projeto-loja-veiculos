package aplicacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import domain.Veiculo;

public class ListandoVeiculos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja-veiculos");
		EntityManager em = emf.createEntityManager();
		
		//em.getTransaction().begin();
		//Não há necessidade de se fazer uma transição ao inserir algo no bd
		
		Query query = em.createQuery("select v from Veiculo v");
				
		@SuppressWarnings("unchecked")
		List<Veiculo> veiculos = query.getResultList();
		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo.getCodigo() + " - "
					+ veiculo.getFabricante() + " - "
					+ veiculo.getModelo() + ", ano "
					+ veiculo.getAnoFabricacao() + " / "
					+ veiculo.getAnoModelo() + " por "
					+ "R$ "+ veiculo.getValor());
		}
		
		//em.getTransaction().commit();
		
		System.out.println("pronto!");
		em.close();
		emf.close();
	
	}

}
