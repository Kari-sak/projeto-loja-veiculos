package aplicacao;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Proprietario;
import domain.ProprietarioEmbedded;
import domain.TipoCombustivel;
import domain.Veiculo;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja-veiculos");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//Veiculo v1 = new Veiculo();
		//v1.setCodigo(new VeiculoId("ABC-1234", "Uberlândia"));
		//v1.setFabricante("Honda");
		//v1.setModelo("Civic");
		//v1.setAnoFabricacao(2020);
		//v1.setAnoModelo(2020);
		//v1.setValor(new BigDecimal(90500));
		//v1.setDescricaoCompleta("Descrição completa...");
		//v1.setTipoCombustivel(TipoCombustivel.BIOCOMBUSTIVEL);
		//v1.setDataCadastro(LocalDate.of(2021,02,23));
		
		//StringBuilder especificacoes = new StringBuilder();
		//especificacoes.append("Carro em excelente estado.\n");
		//especificacoes.append("Completo, menos ar.\n");
		//especificacoes.append("Primeiro dono, com manual de instrução \n");
		//especificacoes.append("e todas as revisões feitas.\n");
		//especificacoes.append("IPVA pago, aceita financiamento.");
		
		//Veiculo veiculo = new Veiculo();
		//veiculo.setFabricante("VW");
		//veiculo.setModelo("Gol");
		//veiculo.setAnoFabricacao(2018);
		//veiculo.setAnoModelo(2019);
		//veiculo.setValor(new BigDecimal(17_200));
		//veiculo.setTipoCombustivel(TipoCombustivel.BIOCOMBUSTIVEL);
		//veiculo.setDataCadastro(LocalDate.now());
		//veiculo.setEspecificacoes(especificacoes.toString());
		
		//em.persist(veiculo);
		
		//ProprietarioEmbedded proprietario = new ProprietarioEmbedded();
		//proprietario.setNome("João das Couves");
		//proprietario.setTelefone("(34) 1234-5678");
		//proprietario.setEmail("joaodascoves@gmail.com");
		
		//Veiculo veiculo = new Veiculo();
		//veiculo.setFabricante("VW");
		//veiculo.setModelo("Gol");
		//veiculo.setAnoFabricacao(2018);
		//veiculo.setAnoModelo(2019);
		//veiculo.setValor(new BigDecimal(17_200));
		//veiculo.setTipoCombustivel(TipoCombustivel.BIOCOMBUSTIVEL);
		//veiculo.setDataCadastro(LocalDate.now());
		//veiculo.setProprietario(proprietario);
		
		
		//Proprietario proprietario = new Proprietario();
		//proprietario.setNome("João das Couves");
		//proprietario.setTelefone("(34) 1234-5678");
		
		// Basta incluir essa linha abaixo para persistir o proprietário.
		//em.persist(proprietario);
		
		//Veiculo veiculo = new Veiculo();
		//veiculo.setFabricante("VW");
		//veiculo.setModelo("Gol");
		//veiculo.setAnoFabricacao(2018);
		//veiculo.setAnoModelo(2018);
		//veiculo.setValor(new BigDecimal(17_200));
		//veiculo.setTipoCombustivel(TipoCombustivel.BIOCOMBUSTIVEL);
		//veiculo.setDataCadastro(LocalDate.now());
		//veiculo.setProprietario(proprietario);
		
		//em.persist(veiculo);

		Proprietario proprietario = new Proprietario();
		proprietario.setNome("João das Couves");
		proprietario.setTelefone("(34) 1234-5678");
		
		// Basta incluir essa linha abaixo para persistir o proprietário.
		em.persist(proprietario);
		Veiculo veiculo1 = new Veiculo();
		veiculo1.setFabricante("GM");
		veiculo1.setModelo("Celta");
		veiculo1.setAnoFabricacao(2015);
		veiculo1.setAnoModelo(2015);
		veiculo1.setValor(new BigDecimal(11_000));
		veiculo1.setTipoCombustivel(TipoCombustivel.GASOLINA);
		veiculo1.setDataCadastro(LocalDate.now());
		veiculo1.setProprietario(proprietario);
		em.persist(veiculo1);		
		
		Veiculo veiculo2 = new Veiculo();
		veiculo2.setFabricante("VW");
		veiculo2.setModelo("Gol");
		veiculo2.setAnoFabricacao(2018);
		veiculo2.setAnoModelo(2018);
		veiculo2.setValor(new BigDecimal(17_200));
		veiculo2.setTipoCombustivel(TipoCombustivel.BIOCOMBUSTIVEL);
		veiculo2.setDataCadastro(LocalDate.now());
		veiculo2.setProprietario(proprietario);
		
		em.persist(veiculo2);		
		
		em.getTransaction().commit();
		
		//em.detach(veiculo);
		//Veiculo veiculo2 = em.find(Veiculo.class, veiculo.getCodigo());
		//System.out.println("Veículo: " + veiculo2.getModelo());
		//System.out.println("-------");
		//System.out.println(veiculo2.getEspecificacoes());
		
		System.out.println("pronto!");
		em.close();
		emf.close();
	}

}
