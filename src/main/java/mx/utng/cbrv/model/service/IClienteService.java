package mx.utng.cbrv.model.service;

import java.util.List;

import mx.utng.cbrv.model.entity.Cliente;


public interface IClienteService {
    List<Cliente> list();
    void save(Cliente cliente);
    Cliente getById(Long id);
    void delete(Long id);
}

