package br.com.higojo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.higojo.enumeration.CBOEnum;
import br.com.higojo.enumeration.SituacaoEnum;

/**
 * 
 * @author higojo
 * Classe referente à tabela de Cargo
 *
 */
@Entity
@Table(name="cargo", schema = "public")
public class Cargo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cdcargo")
	private Integer id;
	
	@Column(name="nome", length=50, nullable=false)
	private String nome;
	
	@Column(name="descricao", length=100)
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	@Column(name="cbo")
	private CBOEnum cbo;
	
	@Column(name="cod_folha", length=9, nullable=false)
	private Long codFolha;
	
	@Column(name="vl_hora")
	private Double vlHora;
	
	@Column(name="hr_semana")
	private Long hrSemana;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="situacao")
	private SituacaoEnum situacao;
	
	@ManyToOne(targetEntity = Categoria.class, optional = false)
	@JoinColumn(name="cdcategoria", referencedColumnName="cdcategoria")
	private Categoria categoria;
	
	@ManyToOne(targetEntity = Subcategoria.class, optional = false)
	@JoinColumn(name = "cdsubcategoria")
	private Subcategoria subcategoria;
	
	public Cargo() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CBOEnum getCbo() {
		return cbo;
	}

	public void setCbo(CBOEnum cbo) {
		this.cbo = cbo;
	}

	public Long getCodFolha() {
		return codFolha;
	}

	public void setCodFolha(Long codFolha) {
		this.codFolha = codFolha;
	}

	public Double getVlHora() {
		return vlHora;
	}

	public void setVlHora(Double vlHora) {
		this.vlHora = vlHora;
	}

	public Long getHrSemana() {
		return hrSemana;
	}

	public void setHrSemana(Long hrSemana) {
		this.hrSemana = hrSemana;
	}

	public SituacaoEnum getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoEnum situacao) {
		this.situacao = situacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Subcategoria getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(Subcategoria subcategoria) {
		this.subcategoria = subcategoria;
	}
}
