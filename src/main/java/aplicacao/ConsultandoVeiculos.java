package aplicacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Proprietario;
import domain.Veiculo;

public class ConsultandoVeiculos {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja-veiculos");
		EntityManager em = emf.createEntityManager();
		
		//List<Veiculo> veiculos = em.createQuery("select v from Veiculo v", Veiculo.class).getResultList();
		//for (Veiculo veiculo : veiculos) {
		//	System.out.println(veiculo.getModelo() + " - " + veiculo.getProprietario().getNome());
		//}
		
		Proprietario proprietario = em.find(Proprietario.class, 1L);
		System.out.println("Proprietario: " + proprietario.getNome());
					
		for (Veiculo veiculo : proprietario.getVeiculos()) {
			System.out.println("Veículo: " + veiculo.getModelo());
		//}
		
		//Veiculo veiculo = em.find(Veiculo.class, 1L);
		//System.out.println(veiculo.getModelo() + " - " + veiculo.getProprietario().getNome());
		
		//Proprietario proprietario = em.find(Proprietario.class, 1L);
		//System.out.println(proprietario.getVeiculo().getModelo() + " - " + proprietario.getNome());
			
		System.out.println("pronto!");
		em.close(); 
		emf.close();

		}
	}
}
