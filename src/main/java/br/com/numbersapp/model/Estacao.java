package br.com.numbersapp.model;

public class Estacao {
    private int id;
    private String nome;

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
        System.out.print("ID: " + this.id);
        System.out.print(" Nome: " + this.nome);
    }
}
