package org.grupouno.parking.it4.service;
import org.grupouno.parking.it4.model.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> findByEmail(String email);

    Optional<User> findById(String id);

    User save(User user);

    void delete(User user);

}
