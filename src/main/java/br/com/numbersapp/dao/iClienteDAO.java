package br.com.numbersapp.dao;

import br.com.numbersapp.model.Cliente;
import java.util.List;
import java.util.Optional;

public interface iClienteDAO {
    Cliente save(Cliente cliente);
    Cliente update(Cliente cliente);
    void deleteCliente(int id);
    Optional<Cliente> findById(int id);
    Optional<Cliente> findByTel(String tel);
    List<Cliente> findAll();
}
