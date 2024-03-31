package br.com.numbersapp.dao;

import br.com.numbersapp.model.Pessoa;
import br.com.numbersapp.model.Tabela;
import sun.tools.jconsole.Tab;

import java.util.List;
import java.util.Optional;

public interface iPessoaDAO {
    Pessoa save(Pessoa pessoa);
    Pessoa update(Pessoa pessoa);
    void deletePessoa(int id, Tabela tabela);
    void deleteProduto(int id);
    Optional<Pessoa> findById(int id, Tabela tabela);
    Optional<Pessoa> findByTel(String tel, Tabela tabela);
    Optional<Pessoa> findByEmail(String email);
    List<Pessoa> findAll(Tabela tabela);

}
