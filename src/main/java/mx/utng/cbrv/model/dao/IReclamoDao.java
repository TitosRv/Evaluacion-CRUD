package mx.utng.cbrv.model.dao;

import java.util.List;

import mx.utng.cbrv.model.entity.Reclamo;



public interface IReclamoDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar usuarios
    List<Reclamo>list();

    //Guardar un usuario
    void save(Reclamo reclamo);

    //Obterner un usuario en especifico a partir del id
    Reclamo getById(Long id);

    //Eliminar un usuario por el id
    void delete(Long id);
}
