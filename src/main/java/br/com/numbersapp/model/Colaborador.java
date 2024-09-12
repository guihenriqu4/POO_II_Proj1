package br.com.numbersapp.model;

import java.time.LocalDate;

public class Colaborador extends Pessoa{
    private String email;
    private String cargo;
    public Colaborador(int id, String nome, String sobrenome, String tel, String email, String senha, String cargo, LocalDate dataintegracao) {
        super(id, nome, sobrenome, tel, senha, dataintegracao);
        this.email = email;
        this.cargo = cargo;
    }
    public Colaborador(String nome, String sobrenome, String tel, String email, String senha, String funcao, LocalDate dataintegracao) {
        super(nome, sobrenome, tel, senha, dataintegracao);
        this.email = email;
        this.cargo = funcao;
    }
    public Colaborador() {
        super();
        this.email = null;
        this.cargo = null;
    }

    public String getEmail() {
        return email;
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

    public void printColaborador() {
        super.printPessoa();
        System.out.println(" Email: " + this.email);
        System.out.println(" Cargo: " + this.cargo);
    }
}
