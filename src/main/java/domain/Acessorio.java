package domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "acessorio")
public class Acessorio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(length = 60, nullable = false)
	private String descricao;
	
	@ManyToMany
	private Set<Veiculo> veiculos = new HashSet<>();
	
	public Acessorio() {
	}

	public Acessorio(Long codigo, String descricao, Set<Veiculo> veiculos) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.veiculos = veiculos;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(Set<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	@Override
	public String toString() {
		return "Acessorio [codigo=" + codigo + ", descricao=" + descricao + ", veiculos=" + veiculos + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, descricao, veiculos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acessorio other = (Acessorio) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(veiculos, other.veiculos);
	}
	
}
