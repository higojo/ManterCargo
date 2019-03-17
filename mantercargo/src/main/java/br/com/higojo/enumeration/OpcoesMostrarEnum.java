package br.com.higojo.enumeration;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author higojo
 * Enum de opções para listagem no filtro de pesquisa
 *
 */
public enum OpcoesMostrarEnum {
	TODOS("Todos"),
	SOMENTE_ATIVOS("Ativo"),
	SOMENTE_INATIVOS("Inativo");
	
    private String descricao;
    
    // Construtor do Enum com descrição
    OpcoesMostrarEnum(String descricao) {
        this.setDescricao(descricao);
    }
    
    /**
     * Adiciona descrições do Enum numa lista e retorna
     * @return List<String>
     */
    public static List<String> listaOpcoes() {
		List<String> valores = new ArrayList<>();
		for(OpcoesMostrarEnum item : OpcoesMostrarEnum.values()) {
			valores.add(item.getDescricao());
		}
		return valores;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
