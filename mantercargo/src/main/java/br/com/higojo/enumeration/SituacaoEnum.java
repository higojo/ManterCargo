package br.com.higojo.enumeration;

/**
 * 
 * @author higojo
 * Enum de situação do cargo
 *
 */
public enum SituacaoEnum {
	ATIVO(1 ,"Ativo"),    
    INATIVO(2 ,"Inativo");
    
    private int codigo;
    private String descricao;
    
    // Construtor com código e descrição
    SituacaoEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    // Sobrescrevendo o toString
    // Retornando a descrição do Enum do toString
    @Override
    public String toString() {
    	return this.descricao;
    }
}
