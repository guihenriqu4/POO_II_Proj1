package br.com.numbersapp.model;

public class Produto {
    private int id;
    private String nome;
    private String marca;
    private String descricao;
    private double quantidade;

    public Produto (int id, String nome, String marca, String descricao, double quantidade) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public Produto (String nome, String marca, String descricao) {
        this.nome = nome;
        this.marca = marca;
        this.descricao = descricao;
    }

    public Produto () {
        this.nome = null;
        this.marca = null;
        this.descricao = null;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public void printProduto() {
        System.out.println(" ID: " + this.id);
        System.out.println(" Nome: " + this.nome);
        System.out.println(" Marca: " + this.marca);
        System.out.println(" Descrição: " + this.descricao);
        System.out.println(" Quantidade: " + this.quantidade);
    }
}
