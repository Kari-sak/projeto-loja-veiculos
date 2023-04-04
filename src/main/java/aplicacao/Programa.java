package aplicacao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Veiculo;
import domain.VeiculoId;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja-veiculos");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Veiculo v1 = new Veiculo();
		v1.setCodigo(new VeiculoId("ABC-1234", "Uberlândia"));
		v1.setFabricante("Honda");
		v1.setModelo("Civic");
		v1.setAnoFabricacao(2020);
		v1.setAnoModelo(2020);
		v1.setValor(new BigDecimal(90500));
		v1.setDescricaoCompleta("Descrição completa...");
		
		em.persist(v1);
		em.getTransaction().commit();
		
		System.out.println("pronto!");
		em.close();
		emf.close();
	}

}
