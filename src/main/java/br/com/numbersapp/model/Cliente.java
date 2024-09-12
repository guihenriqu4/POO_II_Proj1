package br.com.numbersapp.model;

import java.time.LocalDate;

public class Cliente extends Pessoa{
    public Cliente(int id, String nome, String sobrenome, String tel, String senha, LocalDate dataintegracao){
        super(id, nome, sobrenome, tel, senha, dataintegracao);
    }
    public Cliente(String nome, String sobrenome, String tel, String senha, LocalDate dataintegracao){
        super(nome, sobrenome, tel, senha, dataintegracao);
    }

    public Cliente() {
        super();
    }

    public void printCliente() {
        super.printPessoa();
    }
}
