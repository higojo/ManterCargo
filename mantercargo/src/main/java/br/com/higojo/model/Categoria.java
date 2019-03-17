package br.com.higojo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author higojo
 * Classe referente à tabela de Categoria
 * 
 *
 */
@Entity
@Table(name="categoria", schema = "public")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cdcategoria")
	private Integer id;
	
	@Column(name="descricao", length=100)
	private String descricao;
	
	@OneToMany(mappedBy="categoria", targetEntity = Subcategoria.class, cascade=CascadeType.ALL)
	private List<Subcategoria> subcategorias;
	
	@OneToMany(mappedBy="categoria", targetEntity = Cargo.class, cascade=CascadeType.ALL)
	private List<Cargo> cargos;

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

	public List<Subcategoria> getSubcategorias() {
		return subcategorias;
	}

	public void setSubcategorias(List<Subcategoria> subcategorias) {
		this.subcategorias = subcategorias;
	}
}
