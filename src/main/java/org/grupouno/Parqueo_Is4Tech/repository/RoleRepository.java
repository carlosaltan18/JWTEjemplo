package org.grupouno.Parqueo_Is4Tech.repository;

import org.grupouno.Parqueo_Is4Tech.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
   /* @Query("SELECT r FROM Role r WHERE r.profile.id = :profileId")
    List<Role> findRolesByProfileId(@Param("profileId") Long profileId);*/
}
