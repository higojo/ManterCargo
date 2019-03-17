package br.com.higojo.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.com.higojo.enumeration.CBOEnum;
import br.com.higojo.enumeration.SituacaoEnum;
import br.com.higojo.model.Cargo;
import br.com.higojo.model.Categoria;
import br.com.higojo.model.Subcategoria;
import br.com.higojo.resource.SubcategoriaResource;
import br.com.higojo.util.StringUtil;

/**
 * 
 * @author higojo
 * Classe camada para input e output do banco de dados
 *
 */
public class ManterCargoRepository extends GenericRepository<Cargo> {
	
	private static final String TEXTO_SELECIONE = "Selecione...";
	
	/**
	 * Retorna todas as Categorias cadastradas
	 * @return List<Categoria>
	 */
	@SuppressWarnings("unchecked")
	public List<Categoria> buscarTodasCategorias() {
		StringBuilder sb = new StringBuilder("SELECT c FROM "+ Categoria.class.getName()).append(" c");
		Query query = getEntityManager().createQuery(sb.toString());
		return query.getResultList();
	}
	
	/**
	 * Retorna as Subcategorias de uma Categoria
	 * @param idCategoria
	 * @return List<SubcategoriaResource>
	 */
	@SuppressWarnings("unchecked")
	public List<SubcategoriaResource> buscarSubcategoriasPorIdCategoria(Integer idCategoria) {
		StringBuilder sb = new StringBuilder("SELECT sc FROM "+ Subcategoria.class.getName()).append(" sc WHERE sc.categoria.id= :idCategoria");
		Query query = getEntityManager().createQuery(sb.toString());
		query.setParameter("idCategoria", idCategoria);
		List<Subcategoria> retornoConsulta = query.getResultList();
		List<SubcategoriaResource> subcategorias = new ArrayList<>(); 
		for(Subcategoria item : retornoConsulta) {
			SubcategoriaResource subCat = new SubcategoriaResource();
			subCat.setId(item.getId());
			subCat.setDescricao(item.getDescricao());
			subcategorias.add(subCat);
		}
		return subcategorias;
	}
	
	/**
	 * Método dinâmico para retornar Cargos
	 * de acordo com filtros escolhidos
	 * @param nome
	 * @param cbo
	 * @param codFolha
	 * @param opcao
	 * @return List<Cargo>
	 */
	@SuppressWarnings("unchecked")
	public List<Cargo> pesquisarCargos(String nome, String cbo, String codFolha, String opcao) {
		StringBuilder sb = new StringBuilder("SELECT c FROM "+ Cargo.class.getName()).append(" c WHERE c.id not in(0) ");
		if(StringUtil.ok(nome)) {
			sb.append("AND c.nome= :nomeCargo ");
		}
		if(StringUtil.ok(cbo) && !(cbo.equals(TEXTO_SELECIONE))) {
			sb.append("AND c.cbo= :cboCargo ");
		}
		if(StringUtil.ok(codFolha)) {
			sb.append("AND c.codFolha= :codFolhaCargo ");
		}
		if(StringUtil.ok(opcao) && opcao.equalsIgnoreCase(SituacaoEnum.ATIVO.getDescricao())) {
			sb.append("AND c.situacao= :sitAtivo ");
		}
		if(StringUtil.ok(opcao) && opcao.equalsIgnoreCase(SituacaoEnum.INATIVO.getDescricao())) {
			sb.append("AND c.situacao= :sitInativo ");
		}
		Query query = getEntityManager().createQuery(sb.toString());
		if(StringUtil.ok(nome)) {
			query.setParameter("nomeCargo", nome);
		}
		if(StringUtil.ok(cbo) && !(cbo.equals(TEXTO_SELECIONE))) {
			CBOEnum cboaux = null;
			for(CBOEnum item : CBOEnum.values()) {
				if(item.toString().equals(cbo)) {
					cboaux = item;
					break;
				}
			}
			query.setParameter("cboCargo", cboaux);
		}
		if(StringUtil.ok(codFolha)) {
			query.setParameter("codFolhaCargo", Long.parseLong(codFolha));
		}
		if(StringUtil.ok(opcao) && opcao.equalsIgnoreCase(SituacaoEnum.ATIVO.getDescricao())) {
			query.setParameter("sitAtivo", SituacaoEnum.ATIVO);
		}
		if(StringUtil.ok(opcao) && opcao.equalsIgnoreCase(SituacaoEnum.INATIVO.getDescricao())) {
			query.setParameter("sitInativo", SituacaoEnum.INATIVO);
		}
		return query.getResultList();
	}
}
