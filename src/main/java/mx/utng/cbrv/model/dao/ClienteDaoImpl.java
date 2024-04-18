package mx.utng.cbrv.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.cbrv.model.entity.Cliente;

@Repository
public class ClienteDaoImpl implements IClienteDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Cliente> list() {
        return em.createQuery("from Cliente").getResultList();
    }

    @Override
    public void save(Cliente cliente) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(cliente.getId() != null && cliente.getId()>0){
            em.merge(cliente);
        }else{
            //Registro nuevo al usar persist
            em.persist(cliente);
        }
    }

    @Override
    public Cliente getById(Long id) {
        return em.find(Cliente.class, id);
    }

    @Override
    public void delete(Long id) {
      Cliente cliente = getById(id);
      em.remove(cliente);
    }
    

}