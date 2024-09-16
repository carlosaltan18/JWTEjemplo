package org.grupouno.Parqueo_Is4Tech.repository;

import org.grupouno.Parqueo_Is4Tech.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    @Query("SELECT r FROM Role r WHERE r.id IN (SELECT d.idRole FROM DetailRoleProfile d WHERE d.idProfile = :profileId)")
    List<Role> findRolesByProfileId(@Param("profileId") Long profileId);
}
