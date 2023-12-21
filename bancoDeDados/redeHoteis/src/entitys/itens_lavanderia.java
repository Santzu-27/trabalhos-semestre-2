package entitys;
public class itens_lavanderia {
    private String descricao;
    private int codigo;
    private int unidade;
    private double valor_unitario;

    public int getCodigo(){
        return codigo;
    }
    public int getUnidade(){
        return unidade;
    }
    public double getValor(){
        return valor_unitario;
    }
    public String getDescricao(){
        return descricao;
    }


    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    public void setUnidade(int unidade){
        this.unidade = unidade;
    }
    public void setValor(double valor_unitario){
        this.valor_unitario = valor_unitario;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    
}
