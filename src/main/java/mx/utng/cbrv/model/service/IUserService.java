package mx.utng.cbrv.model.service;

import java.util.List;

import mx.utng.cbrv.model.entity.User;


public interface IUserService {
    List<User> list();
    void save(User user);
    User getById(Long id);
    void delete(Long id);
}

