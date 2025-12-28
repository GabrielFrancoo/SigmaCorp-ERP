package main.model;

public class Produto {

    private int id;
    private String produto;
    private String descricao;
    private String nomeCientifico;
    private String armazem;
    private double custoUnitario;
    private String tipo;

    // getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getProduto() { return produto; }
    public void setProduto(String produto) { this.produto = produto; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getNomeCientifico() { return nomeCientifico; }
    public void setNomeCientifico(String nomeCientifico) { this.nomeCientifico = nomeCientifico; }

    public String getArmazem() { return armazem; }
    public void setArmazem(String armazem) { this.armazem = armazem; }

    public double getCustoUnitario() { return custoUnitario; }
    public void setCustoUnitario(double custoUnitario) { this.custoUnitario = custoUnitario; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
