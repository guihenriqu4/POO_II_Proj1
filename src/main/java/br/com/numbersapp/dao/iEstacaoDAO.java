package br.com.numbersapp.dao;

import br.com.numbersapp.model.Estacao;
import java.util.List;
import java.util.Optional;

public interface iEstacaoDAO {
    Estacao save(Estacao estacao);
    Estacao update(Estacao estacao);
    void deleteEstacao(int id);
    Optional<Estacao> findById(int id);
    List<Estacao> findAll();
}
