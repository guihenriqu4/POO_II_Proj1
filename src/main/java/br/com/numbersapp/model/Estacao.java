package br.com.numbersapp.model;

public class Estacao {
    private int id;
    private String nome;

    public Estacao (int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Estacao (String nome) {
        this.nome = nome;
    }

    public Estacao () {
        this.nome = null;
    }

    public void setId (int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setNome (String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void printEstacao(){
        System.out.println(" ID: " + this.id);
        System.out.println(" Nome: " + this.nome);
    }
}
