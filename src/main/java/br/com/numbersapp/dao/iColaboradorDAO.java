package br.com.numbersapp.dao;

import br.com.numbersapp.model.Colaborador;
import java.util.List;
import java.util.Optional;

public interface iColaboradorDAO {
    Colaborador save(Colaborador colaborador);
    Colaborador update(Colaborador colaborador);
    void deleteColaborador(int id);
    Optional<Colaborador> findById(int id);
    Optional<Colaborador> findByTel(String tel);
    Optional<Colaborador> findByEmail(String email);
    List<Colaborador> findAll();

}
