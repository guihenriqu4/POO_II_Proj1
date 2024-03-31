package br.com.numbersapp.model;

import java.time.LocalDate;

public class Pessoa {
    private int id;
    private String nome;
    private String sobrenome;
    private String tel;
    private String email;
    private String cargo;
    private LocalDate dataintegracao;
    private Tabela tabela;

    public Pessoa(int id, String nome, String sobrenome, String tel, String email, String cargo, LocalDate dataintegracao, Tabela tabela) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tel = tel;
        this.email = email;
        this.cargo = cargo;
        this.dataintegracao = dataintegracao;
        this.tabela = tabela;
    }

    public Pessoa(int id, String nome, String sobrenome, String tel, LocalDate dataintegracao, Tabela tabela) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tel = tel;
        this.email = null;
        this.cargo = null;
        this.dataintegracao = dataintegracao;
        this.tabela = tabela;
    }

    public Pessoa(String nome, String sobrenome, String tel, String email, String cargo, LocalDate dataintegracao, Tabela tabela) {
        this.id = Integer.parseInt(null);
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tel = tel;
        this.email = email;
        this.cargo = cargo;
        this.dataintegracao = dataintegracao;
        this.tabela = tabela;
    }

    public Pessoa(String nome, String sobrenome, String tel, LocalDate dataintegracao, Tabela tabela) {
        this.id = Integer.parseInt(null);
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tel = tel;
        this.email = null;
        this.cargo = null;
        this.dataintegracao = dataintegracao;
        this.tabela = tabela;
    }

    public Pessoa() {
        this.id = Integer.parseInt(null);
        this.nome = null;
        this.sobrenome = null;
        this.tel = null;
        this.email = null;
        this.dataintegracao = null;
        this.tabela = null;
    }

    public int getId(){
        return this.id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome(){
        return this.sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTel(){
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDate getDataIntegracao(){
        return this.dataintegracao;
    }

    public void setDataintegracao(LocalDate dataintegracao) {
        this.dataintegracao = dataintegracao;
    }

    public Tabela getTabela(){
        return this.tabela;
    }

    public void setTabela(Tabela tabela) {
        this.tabela = tabela;
    }

    public void printPessoa() {
        System.out.print("ID: " + this.id);
        System.out.print(" Nome: " + this.nome);
        System.out.print(" Sobrenome: " + this.sobrenome);
        System.out.print(" Telefone: " + this.tel);
        System.out.print(" Email: " + this.email);
        System.out.print(" Data de Integração: " + this.dataintegracao);
        System.out.println(" Posição: " + this.tabela);
    }
}
