package mx.utng.cbrv.model.dao;

import java.util.List;

import mx.utng.cbrv.model.entity.Cliente;



public interface IClienteDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar usuarios
    List<Cliente>list();

    //Guardar un usuario
    void save(Cliente cliente);

    //Obterner un usuario en especifico a partir del id
    Cliente getById(Long id);

    //Eliminar un usuario por el id
    void delete(Long id);
}
