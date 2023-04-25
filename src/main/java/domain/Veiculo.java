package domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tab_veiculo")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	//@EmbeddedId
	//private VeiculoId codigo;
	
	@Column(length = 60, nullable = false)
	private String fabricante;
	
	@Column(length = 60, nullable = false)
	private String modelo;
	
	@Column(name = "ano_fabricacao", nullable = false)
	private int anoFabricacao;
	
	@Column(name = "ano_modelo", nullable = false)
	private int anoModelo;
	
	@Column(precision = 10, scale = 2, nullable = true)
	private BigDecimal valor;
	
	@Transient
	private String descricaoCompleta;
	
	@Column(name="tipo_combustivel", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoCombustivel tipoCombustivel;
	
	@Column(name="data_cadastro", nullable = false)
	private LocalDate dataCadastro;
	
	//@Lob
	//private String especificacoes;
	
	//@Lob
	//private byte[] foto;
	
	//@Embedded
	//private ProprietarioEmbedded proprietario;
	
	//@OneToOne
	//@OneToOne(optional = false)
	//@JoinColumn(name = "cod_proprietario")
	
	@ManyToOne
	@JoinColumn(name = "proprietario_codigo")
	private Proprietario proprietario;
	
	public Veiculo() {
		
	}

	public Veiculo(Long codigo, String fabricante, String modelo, int anoFabricacao, int anoModelo, BigDecimal valor,
			String descricaoCompleta, TipoCombustivel tipoCombustivel, LocalDate dataCadastro,
			Proprietario proprietario) {
		super();
		this.codigo = codigo;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.valor = valor;
		this.descricaoCompleta = descricaoCompleta;
		this.tipoCombustivel = tipoCombustivel;
		this.dataCadastro = dataCadastro;
		this.proprietario = proprietario;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public int getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDescricaoCompleta() {
		return descricaoCompleta;
	}

	public void setDescricaoCompleta(String descricaoCompleta) {
		this.descricaoCompleta = descricaoCompleta;
	}

	public TipoCombustivel getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	@Override
	public String toString() {
		return "Veiculo [codigo=" + codigo + ", fabricante=" + fabricante + ", modelo=" + modelo + ", anoFabricacao="
				+ anoFabricacao + ", anoModelo=" + anoModelo + ", valor=" + valor + ", descricaoCompleta="
				+ descricaoCompleta + ", tipoCombustivel=" + tipoCombustivel + ", dataCadastro=" + dataCadastro
				+ ", proprietario=" + proprietario + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(anoFabricacao, anoModelo, codigo, dataCadastro, descricaoCompleta, fabricante, modelo,
				proprietario, tipoCombustivel, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		return anoFabricacao == other.anoFabricacao && anoModelo == other.anoModelo
				&& Objects.equals(codigo, other.codigo) && Objects.equals(dataCadastro, other.dataCadastro)
				&& Objects.equals(descricaoCompleta, other.descricaoCompleta)
				&& Objects.equals(fabricante, other.fabricante) && Objects.equals(modelo, other.modelo)
				&& Objects.equals(proprietario, other.proprietario) && tipoCombustivel == other.tipoCombustivel
				&& Objects.equals(valor, other.valor);
	}

}
