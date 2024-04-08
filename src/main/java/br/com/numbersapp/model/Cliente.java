package br.com.numbersapp.model;

import java.time.LocalDate;

public class Cliente extends Pessoa{
    public Cliente(String nome, String sobrenome, String tel, LocalDate dataintegracao){
        super(nome, sobrenome, tel, dataintegracao);
    }

    public Cliente() {
        super();
    }
}
