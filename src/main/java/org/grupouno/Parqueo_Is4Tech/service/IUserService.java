package org.grupouno.Parqueo_Is4Tech.service;
import org.grupouno.Parqueo_Is4Tech.model.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> findByEmail(String email);

    Optional<User> findById(String id);

    User save(User user);

    void delete(User user);

}
