package br.com.numbersapp.model;

import java.time.LocalDate;

public class Colaborador extends Pessoa{
    private String email;
    private String funcao;

    public Colaborador(String nome, String sobrenome, String tel, String email, String funcao, LocalDate dataintegracao) {
        super(nome, sobrenome, tel, dataintegracao);
        this.email = email;
        this.funcao = funcao;
    }

    public Colaborador() {
        super();
        this.email = null;
        this.funcao = null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void printColaborador() {
        super.printPessoa();
        System.out.println(" Email: " + this.email);
        System.out.println(" Função: " + this.funcao);
    }
}
