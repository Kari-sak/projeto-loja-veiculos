package domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tab_veiculo")
public class Veiculo {
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private long codigo;
	
	@EmbeddedId
	private VeiculoId codigo;
	
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
	
	public Veiculo() {
		
	}

	public Veiculo(VeiculoId codigo, String fabricante, String modelo, int anoFabricacao, int anoModelo,
			BigDecimal valor, String descricaoCompleta) {
		super();
		this.codigo = codigo;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.valor = valor;
		this.descricaoCompleta = descricaoCompleta;
	}
	
	public VeiculoId getCodigo() {
		return codigo;
	}

	public void setCodigo(VeiculoId codigo) {
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

	
	@Override
	public String toString() {
		return "Veiculo [codigo=" + codigo + ", fabricante=" + fabricante + ", modelo=" + modelo + ", anoFabricacao="
				+ anoFabricacao + ", anoModelo=" + anoModelo + ", valor=" + valor + ", descricaoCompleta="
				+ descricaoCompleta + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anoFabricacao;
		result = prime * result + anoModelo;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((descricaoCompleta == null) ? 0 : descricaoCompleta.hashCode());
		result = prime * result + ((fabricante == null) ? 0 : fabricante.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
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
		if (anoFabricacao != other.anoFabricacao)
			return false;
		if (anoModelo != other.anoModelo)
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descricaoCompleta == null) {
			if (other.descricaoCompleta != null)
				return false;
		} else if (!descricaoCompleta.equals(other.descricaoCompleta))
			return false;
		if (fabricante == null) {
			if (other.fabricante != null)
				return false;
		} else if (!fabricante.equals(other.fabricante))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

}
