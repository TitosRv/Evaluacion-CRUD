package mx.utng.cbrv.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.cbrv.model.dao.IReclamoDao;
import mx.utng.cbrv.model.entity.Reclamo;


/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class ReclamoServiceImpl implements IReclamoService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IReclamoDao reclamoDao;

    @Transactional(readOnly = true)
    @Override
    public List<Reclamo> list() {
        return reclamoDao.list();
    }

    @Transactional
    @Override
    public void save(Reclamo reclamo) {
        reclamoDao.save(reclamo);
    }

    @Transactional(readOnly = true)
    @Override
    public Reclamo getById(Long id) {
        return reclamoDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        reclamoDao.delete(id);
    }
    
}


