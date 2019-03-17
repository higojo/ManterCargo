package br.com.higojo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author higojo
 * Classe referente à tabela de Subcategoria
 *
 */
@Entity
@Table(name="subcategoria", schema = "public")
public class Subcategoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cdsubcategoria")
	private Integer id;
	
	@Column(name="descricao", length=100)
	private String descricao;
	
	@ManyToOne(targetEntity = Categoria.class)
	@JoinColumn(name = "cdcategoria", referencedColumnName = "cdcategoria")
	private Categoria categoria;

	public Subcategoria() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
