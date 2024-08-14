package br.com.numbersapp.dao;

import br.com.numbersapp.model.Produto;
import java.util.List;
import java.util.Optional;

public interface iProdutoDAO {
    Produto save(Produto produto);
    Produto update(Produto produto);
    void deleteProduto(Long id);
    Optional<Produto> findById(Long id);
    Optional<Produto> findByNome(String nome);
    List<Produto> findAll();
}
