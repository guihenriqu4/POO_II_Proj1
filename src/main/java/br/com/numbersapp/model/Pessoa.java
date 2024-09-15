package br.com.numbersapp.model;

import java.time.LocalDate;

public class Pessoa {
    private int id;
    private String nome;
    private String sobrenome;
    private String tel;
    private String senha;
    private LocalDate dataintegracao;

    public Pessoa(int id, String nome, String sobrenome, String tel, String senha, LocalDate dataintegracao) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tel = tel;
        this.dataintegracao = dataintegracao;
    }

    public Pessoa(String nome, String sobrenome, String tel, String senha, LocalDate dataintegracao) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tel = tel;
        this.dataintegracao = dataintegracao;
    }

    public Pessoa() {
        this.nome = null;
        this.sobrenome = null;
        this.tel = null;
        this.dataintegracao = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataintegracao() {
        return dataintegracao;
    }

    public void setDataintegracao(LocalDate dataintegracao) {
        this.dataintegracao = dataintegracao;
    }

    public void printPessoa() {
        System.out.println(" ID: " + this.id);
        System.out.println(" Nome: " + this.nome);
        System.out.println(" Sobrenome: " + this.sobrenome);
        System.out.println(" Telefone: " + this.tel);
        System.out.println(" Data de Integração: " + this.dataintegracao);
    }
}