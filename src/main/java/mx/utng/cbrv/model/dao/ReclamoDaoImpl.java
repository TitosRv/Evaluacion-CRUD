package mx.utng.cbrv.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.cbrv.model.entity.Reclamo;

@Repository
public class ReclamoDaoImpl implements IReclamoDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Reclamo> list() {
        return em.createQuery("from Reclamo").getResultList();
    }

    @Override
    public void save(Reclamo reclamo) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(reclamo.getId() != null && reclamo.getId()>0){
            em.merge(reclamo);
        }else{
            //Registro nuevo al usar persist
            em.persist(reclamo);
        }
    }

    @Override
    public Reclamo getById(Long id) {
        return em.find(Reclamo.class, id);
    }

    @Override
    public void delete(Long id) {
      Reclamo reclamo = getById(id);
      em.remove(reclamo);
    }
    

}