package mx.utng.cbrv.model.service;

import java.util.List;

import mx.utng.cbrv.model.entity.Reclamo;


public interface IReclamoService {
    List<Reclamo> list();
    void save(Reclamo reclamo);
    Reclamo getById(Long id);
    void delete(Long id);
}

