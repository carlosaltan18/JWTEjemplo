package org.grupouno.Parqueo_Is4Tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.grupouno.Parqueo_Is4Tech.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);

}
