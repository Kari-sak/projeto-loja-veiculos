package aplicacao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import domain.Veiculo;

public class JPQL01_VeiculoAnoFabricacao2019 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja-veiculos");
		EntityManager em = emf.createEntityManager();
		
		/*Query query = em.createQuery(
				"select v from Veiculo v where anoFabricacao = 2019");
				//from Veiculo where anoFabricacao = 2019 (só para o Hibernate: cláusula simplificada)
		
		@SuppressWarnings("rawtypes")
		List veiculos = query.getResultList();
		 */
		
		Query query = em.createQuery(
				//passa o nome do atributo
				"select v from Veiculo v where anoFabricacao >:ano" +
				" and valor <= :preco");
		
		query.setParameter("ano", 2018);
		query.setParameter("preco", new BigDecimal(107_000));
		
		@SuppressWarnings("rawtypes")
		List veiculos = query.getResultList();
		
		for (Object obj : veiculos) {
			Veiculo veiculo = (Veiculo) obj;
		
			System.out.println(veiculo.getModelo() + " " + veiculo.getFabricante()
			+ ": " + veiculo.getAnoFabricacao());
			
		}
				
		System.out.println("pronto!");
		
		em.close();
		emf.close();
		
	}

}
