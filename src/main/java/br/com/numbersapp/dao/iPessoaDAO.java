package br.com.numbersapp.dao;

import br.com.numbersapp.model.Pessoa;
import java.util.List;
import java.util.Optional;

public interface iPessoaDAO<T extends Pessoa> {
    T save(T pessoa);
    T update(T pessoa);
    void delete(int id);
    Optional<T> findById(int id);
    Optional<T> findByTel(String tel);
    List<T> findAll();
}
